package main.visitor.codeGenerator;

import jas.Var;
import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.EachStmt;
import main.ast.types.NullType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.ClassSymbolTableItem;
import main.symbolTable.items.FieldSymbolTableItem;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.Visitor;
import main.visitor.typeChecker.ExpressionTypeChecker;
import org.w3c.dom.ranges.Range;
import org.w3c.dom.ranges.RangeException;

import java.awt.font.NumericShaper;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CodeGenerator extends Visitor<String> {
    ExpressionTypeChecker expressionTypeChecker;
    Graph<String> classHierarchy;
    private String outputPath;
    private FileWriter currentFile;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private Set<String> globalVariables = new HashSet<String>();
    private ClassDeclaration globalClass;
    private int labelCount;
    private int tempCount;
    String last_after;

    Program current_program;


    public CodeGenerator(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
        this.prepareOutputFolder();
        this.labelCount = 0;
        this.tempCount  = 0;
    }

    private void prepareOutputFolder() {
        this.outputPath = "output/";
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String arrayClassPath = "utilities/codeGenerationUtilityClasses/Array.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
            directory.mkdir();
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(arrayClassPath, this.outputPath + "Array.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");
    }

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile(String name) {
        try {
            String path = this.outputPath + name + ".j";
            File file = new File(path);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(path);
            this.currentFile = fileWriter;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addCommand(String command) {
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                this.currentFile.write("\t" + command + "\n");
            else if(command.startsWith("."))
                this.currentFile.write(command + "\n");
            else
                this.currentFile.write("\t\t" + command + "\n");
            this.currentFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addStaticMainMethod() {
        addCommand(".method public static main([Ljava/lang/String;)V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("new Main");
        addCommand("invokespecial Main/<init>()V");
        addCommand("return");
        addCommand(".end method");
    }

    private int getSlotOf(String identifier) {
        int cnt = 1;
        for(ArgPair argument : currentMethod.getArgs()){
            if(argument.getVariableDeclaration().getVarName().getName().equals(identifier))
                return cnt;
            cnt++;
        }
        for(VariableDeclaration var : currentMethod.getLocalVars())
        {
            if(var.getVarName().getName().equals(identifier))
                return cnt;
            cnt++;
        }
        if (identifier.equals("")){
            int temp = this.tempCount;
            this.tempCount += 1;
            return cnt + temp;
        }
        return 0;
    }


    @Override
    public String visit(Program program) {
        //todo
        //generate new class for global variables

        //using .field, add global variables as static fields to the class

        if (program.getGlobalVariables().size() > 0) {
            ClassDeclaration globalClass = new ClassDeclaration(new Identifier("Global"));
            for (VariableDeclaration varDec : program.getGlobalVariables()) {
                this.globalVariables.add(varDec.getVarName().getName());
                globalClass.addField(new FieldDeclaration(varDec, true));
            }
            this.expressionTypeChecker.setCurrentClass(globalClass);
            this.currentClass = globalClass;
            globalClass.accept(this);
        }
        for(ClassDeclaration classDeclaration : program.getClasses()) {
            this.expressionTypeChecker.setCurrentClass(classDeclaration);
            this.currentClass = classDeclaration;
            classDeclaration.accept(this);
        }


        return null;
    }

    @Override
    public String visit(ClassDeclaration classDeclaration) {
        String name = classDeclaration.getClassName().getName();
        createFile(name);
        //todo: done

        this.currentClass = classDeclaration;

        addCommand(".class "+name);

        if (classDeclaration.getParentClassName() == null)
        {
            addCommand(".super java/lang/Object");
        }
        else
        {
            String class_name_parent = classDeclaration.getParentClassName().getName();
            addCommand(".super " + class_name_parent);
        }

        for(FieldDeclaration field : classDeclaration.getFields())
        {
            field.accept(this);
        }

        if(classDeclaration.getConstructor() != null)
        {
            this.currentMethod = classDeclaration.getConstructor();
            this.expressionTypeChecker.setCurrentMethod(classDeclaration.getConstructor());
            classDeclaration.getConstructor().accept(this);
        }
        else if (classDeclaration.getClassName().getName().equals("Global"))
            initializeGlobal();
        else
            defaultConstructorDecl();

        for(MethodDeclaration m : classDeclaration.getMethods())
        {
            this.currentMethod = m;
            this.expressionTypeChecker.setCurrentMethod(m);
            m.accept(this);
        }

        return null;
    }
    
    private void initializeGlobal() {
        addCommand(".method public <init>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("aload_0");
        addCommand("invokespecial java/lang/Object/<init>()V");
        addCommand("return");
        addCommand(".end method");

        addCommand(".method static <clinit>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");

        String class_name = currentClass.getClassName().getName();
        for(FieldDeclaration field : currentClass.getFields()) {
            String field_name = field.getVarDeclaration().getVarName().getName();
            Type feild_type = field.getVarDeclaration().getType();

            if(feild_type instanceof IntType || feild_type instanceof BoolType) {
//                addCommand("aload 0");
//                addCommand("ldc 0");
                addCommand("iconst_0");
                if(feild_type instanceof BoolType)
                    addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
                else if(feild_type instanceof IntType)
                    addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");

                addCommand("putstatic " + class_name + "/" + field_name + " L" + makeTypeFlag(feild_type) + ";\n");
            }
            else if(feild_type instanceof FptrType || feild_type instanceof ClassType)
            {
                addCommand("aload 0");
                addCommand("aconst_null");
                addCommand("putstatic " + class_name + "/" + field_name + " L" + makeTypeFlag(feild_type) + ";\n");
            }
            else{
                addCommand("aload 0");
                this.array_size = 1000;
                init_array((ArrayType) feild_type);
                addCommand("putstatic " + class_name + "/" + field_name + " L" + makeTypeFlag(feild_type) + ";\n");
            }
        }

        addCommand("return");
        addCommand(".end method");

    }

    // Not Done
    private void defaultConstructorDecl() {
        String class_name = currentClass.getClassName().getName();
        addCommand(".method public <init>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("aload_0");

        if (currentClass.getParentClassName() != null)
            addCommand("invokespecial " + currentClass.getParentClassName().getName() + "/<init>()V");
        else
            addCommand("invokespecial java/lang/Object/<init>()V");


        for(FieldDeclaration field : currentClass.getFields()){
            String field_name = field.getVarDeclaration().getVarName().getName();
            Type feild_type = field.getVarDeclaration().getType();

            if(feild_type instanceof IntType || feild_type instanceof BoolType){
                addCommand("aload 0");
                addCommand("ldc 0");
                if(feild_type instanceof BoolType)
                    addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
                else if(feild_type instanceof IntType)
                    addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");

                addCommand("putfield " + class_name + "/" + field_name + " L" + makeTypeFlag(feild_type) + ";\n");
            }
            else if(feild_type instanceof FptrType || feild_type instanceof ClassType)
            {
                addCommand("aload 0");
                addCommand("aconst_null");
                addCommand("putfield " + class_name + "/" + field_name + " L" + makeTypeFlag(feild_type) + ";\n");
            }
            else{
                addCommand("aload 0");
                this.array_size = 1000;
                init_array((ArrayType) feild_type);
                addCommand("putfield " + class_name + "/" + field_name + " L" + makeTypeFlag(feild_type) + ";\n");
            }
        }
        addCommand("return");
        addCommand(".end method");
    }

    private void init_array(ArrayType arrayType) {
        addCommand("new Array");
        addCommand("dup");
        addCommand("new java/util/ArrayList");
        addCommand("dup");
        addCommand("invokespecial java/util/ArrayList/<init>()V");


        for (int i = 0; i < this.array_size; i++) {
            addCommand("dup");
            if(arrayType.getType() instanceof ClassType || arrayType.getType() instanceof FptrType){
                addCommand("aconst_null");
                addCommand("invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z");
            }
            else if(arrayType.getType() instanceof IntType || arrayType.getType() instanceof BoolType){
                addCommand("ldc 0");
                if(arrayType.getType() instanceof IntType)
                    addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
                if(arrayType.getType() instanceof BoolType)
                    addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
                addCommand("invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z");
            }
            else{
                init_array((ArrayType) arrayType.getType());
                addCommand("invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z");
            }

            addCommand("pop");
        }

        addCommand("invokespecial Array/<init>(Ljava/util/ArrayList;)V");
    }

    // Not done yet
    private String makeTypeFlag(Type t)
    {
        if (t instanceof IntType)
            return "java/lang/Integer";
        if (t instanceof BoolType)
            return "java/lang/Boolean";
        if (t instanceof ArrayType)
            return "Array";
        if (t instanceof FptrType)
            return "Fptr";
        if (t instanceof ClassType)
            return ((ClassType)t).getClassName().getName();
        return null;
    }

    @Override
    public String visit(ConstructorDeclaration constructorDeclaration) {
        //todo: done
        if (constructorDeclaration.getArgs().size() > 0)
            defaultConstructorDecl();

        String class_name = this.currentClass.getClassName().getName();

        if (class_name.equals("Main"))
            addStaticMainMethod();

        this.visit((MethodDeclaration) constructorDeclaration);

        return null;
    }

    @Override
    public String visit(MethodDeclaration methodDeclaration) {
        //todo
        String class_name = currentClass.getClassName().getName();
        String method_decl_header = "";
        if (methodDeclaration instanceof ConstructorDeclaration){
            method_decl_header += ".method public <init>(";
            for(ArgPair arg : methodDeclaration.getArgs()){
                method_decl_header += "L" + makeTypeFlag(arg.getVariableDeclaration().getType()) + ";";
            }
            method_decl_header += ")V";
        }
        else{
            method_decl_header += ".method public " + methodDeclaration.getMethodName().getName() + "(";
            for(ArgPair arg : methodDeclaration.getArgs()){
                method_decl_header += "L" + makeTypeFlag(arg.getVariableDeclaration().getType()) + ";";
            }
            if (methodDeclaration.getReturnType() instanceof VoidType)
                method_decl_header += ")V";
            else
                method_decl_header += ")L"  + makeTypeFlag(methodDeclaration.getReturnType()) + ";";
        }

        addCommand(method_decl_header);
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");

        if(methodDeclaration instanceof ConstructorDeclaration) {

            if (currentClass.getParentClassName() == null){
                addCommand("aload 0");
                addCommand("invokespecial java/lang/Object/<init>()V");
            }
            else{
                addCommand("aload 0");
                addCommand("invokespecial " + currentClass.getParentClassName().getName() + "/<init>()V");
            }

            for(FieldDeclaration field : currentClass.getFields()){
                String fieldName = field.getVarDeclaration().getVarName().getName();
                Type fieldType = field.getVarDeclaration().getType();

                if(fieldType instanceof ClassType || fieldType instanceof FptrType){
                    addCommand("aload 0");
                    addCommand("aconst_null");
                    addCommand("putfield " + class_name + "/" + fieldName + " L" + makeTypeFlag(fieldType) + ";\n");
                }
                else if(fieldType instanceof IntType || fieldType instanceof BoolType){
                    addCommand("aload 0");
                    addCommand("ldc 0");
                    if(fieldType instanceof IntType)
                        addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
                    if(fieldType instanceof BoolType)
                        addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
                    addCommand("putfield " + class_name + "/" + fieldName + " L" + makeTypeFlag(fieldType) + ";\n");
                }
                else{
                    addCommand("aload 0");
                    addCommand("putfield " + class_name + "/" + fieldName + " L" + makeTypeFlag(fieldType) + ";\n");
                }
            }

        }

        for(VariableDeclaration var : methodDeclaration.getLocalVars()){
            var.accept(this);
        }

        for(Statement stmt : methodDeclaration.getBody()){
            stmt.accept(this);
        }
        if(!methodDeclaration.getDoesReturn())
            addCommand("return");
        this.tempCount = 0;
        addCommand(".end method");
        return null;
    }

    @Override
    public String visit(FieldDeclaration fieldDeclaration) {
        //todo: done
        String field_name = fieldDeclaration.getVarDeclaration().getVarName().getName();
        Type feild_type = fieldDeclaration.getVarDeclaration().getType();
        String flag = makeTypeFlag(feild_type);
        if (this.currentClass.getClassName().getName().equals("Global"))
            addCommand(".field " + "static " + field_name + " L" + flag + ";");
        else
            addCommand(".field " + field_name + " L" + flag + ";");
        return null;
    }

    @Override
    public String visit(VariableDeclaration variableDeclaration) {
        //todo : done
        int slot_number = getSlotOf(variableDeclaration.getVarName().getName());
        Type type = variableDeclaration.getType();

        if(type instanceof IntType || type instanceof BoolType){
            addCommand("ldc 0");
            if(type instanceof IntType)
                addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
            else if(type instanceof BoolType)
                addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
            addCommand("astore " + slot_number);
        }
        else if(type instanceof ClassType || type instanceof FptrType){
            addCommand("aconst_null");
            addCommand("astore " + slot_number);
        }
        else {
            this.array_size = 1000;
            init_array((ArrayType) type);
            addCommand("astore " + slot_number);
        }


        return null;
    }

    @Override
    public String visit(AssignmentStmt assignmentStmt) {
        //todo: done
        BinaryExpression assign_expression = new BinaryExpression(assignmentStmt.getlValue(), assignmentStmt.getrValue(), BinaryOperator.assign);
        addCommand(assign_expression.accept(this));
//        addCommand("pop");

        return null;
    }

    @Override
    public String visit(BlockStmt blockStmt) {
        //todo: done
        for (Statement stmt: blockStmt.getStatements())
            stmt.accept(this);
        return null;
    }

    private String getNewLabel(){
        String l = "Label_";
        l += this.labelCount;
        this.labelCount += 1;
        return l;
    }

    @Override
    public String visit(ConditionalStmt conditionalStmt) {
        //todo: done
        String false_label = getNewLabel();
        String after = getNewLabel();
        last_after = after;
        addCommand(conditionalStmt.getCondition().accept(this));
        addCommand("ifeq " + false_label);
        conditionalStmt.getThenBody().accept(this);
        addCommand("goto " + after);
        addCommand(false_label + ":");

        for (ElsifStmt elsif_stmt : conditionalStmt.getElsif())
        {
            elsif_stmt.accept(this);
        }

        if (conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);
        addCommand(after + ":");
        return null;
    }

    @Override
    public String visit(ElsifStmt elsifStmt) {
        //todo: done
        String false_label = getNewLabel();
        addCommand(elsifStmt.getCondition().accept(this));
        addCommand("ifeq " + false_label);
        elsifStmt.getThenBody().accept(this);
        addCommand("goto " + this.last_after);
        addCommand(false_label + ":");
        return null;
    }

    @Override
    public String visit(MethodCallStmt methodCallStmt) {
        //todo: done
        this.expressionTypeChecker.setIsInMethodCallStmt(true);
        addCommand(methodCallStmt.getMethodCall().accept(this));
        addCommand("pop");
        this.expressionTypeChecker.setIsInMethodCallStmt(false);
        return null;
    }

    @Override
    public String visit(PrintStmt print) {
        //todo: done
        addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
        Type argument_type = print.getArg().accept(expressionTypeChecker);
        addCommand(print.getArg().accept(this));
        if (argument_type instanceof IntType)
            addCommand("invokevirtual java/io/PrintStream/println(I)V");
        if (argument_type instanceof BoolType)
            addCommand("invokevirtual java/io/PrintStream/println(Z)V");
        return null;
    }

    @Override
    public String visit(ReturnStmt returnStmt) {
        //todo: done
        Type return_type = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        if(return_type instanceof NullType) {
            addCommand("return");
            return null;
        }

        addCommand( returnStmt.getReturnedExpr().accept(this) );
        if(return_type instanceof IntType)
            addCommand("invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;");
        if(return_type instanceof BoolType)
            addCommand("invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;");
        addCommand("areturn");
        return null;
    }

    @Override
    public String visit(EachStmt eachStmt) {
        //todo

        int temp_index = getSlotOf("");
        int iter_slot = getSlotOf(eachStmt.getVariable().getName());
        Type iter_type = eachStmt.getVariable().accept(expressionTypeChecker);

        ArrayType arrayType = (ArrayType) eachStmt.getList().accept(expressionTypeChecker);
        int array_size = arrayType.getDimensions().size();

        String start_label = getNewLabel();
        String after_label = getNewLabel();
        String update_label = getNewLabel();


        addCommand(eachStmt.getList().accept(this));

        addCommand("ldc 0");
        addCommand("istore " + temp_index);

        addCommand(start_label + ":");

        addCommand("iload " + temp_index);
        addCommand("ldc " + array_size);
        addCommand("if_icmpge " + after_label);

        addCommand("iload " + temp_index);
        addCommand("invokevirtual Array/getElement(I)Ljava/lang/Object;\n");
        addCommand("checkcast " + makeTypeFlag(iter_type) + "\n");
        addCommand("astore " + iter_slot);

        eachStmt.getBody().accept(this);


        addCommand(update_label + ":");
        addCommand("iload " + temp_index);
        addCommand("ldc 1");
        addCommand("iadd");
        addCommand("istore " + temp_index);

        addCommand("goto " + start_label);
        addCommand(after_label + ":");

        return null;
    }

    @Override
    public String visit(RangeExpression rangeExpression) {
        //todo
        return null;
    }

    @Override
    public String visit(TernaryExpression ternaryExpression) {
        //todo : done
        String cmds = "";
        String false_label = getNewLabel();
        String after = getNewLabel();
        addCommand(ternaryExpression.getCondition().accept(this));
        cmds += "ifeq " + false_label + "\n";
        cmds += ternaryExpression.getTrueExpression().accept(this) + "\n";
        cmds += "goto " + after + "\n";
        cmds += false_label + ":" + "\n";
        cmds += ternaryExpression.getFalseExpression().accept(this) + "\n";
        cmds += after + ":"+ "\n";
        return cmds;
    }


    @Override
    public String visit(BinaryExpression binaryExpression) {
        BinaryOperator op = binaryExpression.getBinaryOperator();
        Type operand_type = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
        String cmds = "";
        
        if (op == BinaryOperator.sub) {
            cmds += binaryExpression.getFirstOperand().accept(this);
            cmds += binaryExpression.getSecondOperand().accept(this);
            cmds += "isub\n";
        }
        else if (op == BinaryOperator.mult) {
            cmds += binaryExpression.getFirstOperand().accept(this);
            cmds += binaryExpression.getSecondOperand().accept(this);
            cmds += "imul\n";
        }
        else if (op == BinaryOperator.add) {
            cmds += binaryExpression.getFirstOperand().accept(this);
            cmds += binaryExpression.getSecondOperand().accept(this);
            cmds += "iadd\n";
        }
        else if (op == BinaryOperator.div) {
            cmds += binaryExpression.getFirstOperand().accept(this);
            cmds += binaryExpression.getSecondOperand().accept(this);
            cmds += "idiv\n";
        }
        else if(op == BinaryOperator.lt || op == BinaryOperator.gt) {
            cmds += binaryExpression.getFirstOperand().accept(this);
            cmds += binaryExpression.getSecondOperand().accept(this);
            String false_label = getNewLabel();
            String after_label = getNewLabel();
            if(op == BinaryOperator.gt)
                cmds += "if_icmple " + false_label + "\n";
            else
                cmds += "if_icmpge " + false_label + "\n";
            cmds += "ldc " + "1\n";
            cmds += "goto " + after_label + "\n";
            cmds += false_label + ":\n";
            cmds += "ldc " + "0\n";
            cmds += after_label + ":\n";
        }
        
        
        else if(op == BinaryOperator.or) {
            String true_label = getNewLabel();
            String after_label = getNewLabel();
            cmds += binaryExpression.getFirstOperand().accept(this);
            cmds += "ifne " + true_label + "\n";
            cmds += binaryExpression.getSecondOperand().accept(this);
            cmds += "ifne " + true_label + "\n";
            cmds += "ldc " + "0\n";
            cmds += "goto " + after_label + "\n";
            cmds += true_label + ":\n";
            cmds += "ldc " + "1\n";
            cmds += after_label + ":\n";
        }
        else if(op == BinaryOperator.eq) {
            cmds += binaryExpression.getFirstOperand().accept(this);
            cmds += binaryExpression.getSecondOperand().accept(this);
            String false_label = getNewLabel();
            String after_label = getNewLabel();
            if(op != BinaryOperator.eq){
            	if ((operand_type instanceof IntType) == false && (operand_type instanceof BoolType) == false)
                    cmds += "if_acmpeq " + false_label + "\n";
                else
                    cmds += "if_icmpeq " + false_label + "\n";
                
            }
            else{
                if ((operand_type instanceof IntType) == false && (operand_type instanceof BoolType) == false)
                    cmds += "if_acmpne " + false_label + "\n";
                else
                    cmds += "if_icmpne " + false_label + "\n";
            }
            cmds += "ldc " + "1\n";
            cmds += "goto " + after_label + "\n";
            cmds += false_label + ":\n";
            cmds += "ldc " + "0\n";
            cmds += after_label + ":\n";
        }
        else if(op == BinaryOperator.and) {
            String false_label = getNewLabel();
            String after_label = getNewLabel();
            cmds += binaryExpression.getFirstOperand().accept(this);
            cmds += "ifeq " + false_label + "\n";
            cmds += binaryExpression.getSecondOperand().accept(this);
            cmds += "ifeq " + false_label + "\n";
            cmds += "ldc 1\n";
            cmds += "goto " + after_label + "\n";
            cmds += false_label + ":\n";
            cmds += "ldc 0\n";
            cmds += after_label + ":\n";
        }
        else if(op == BinaryOperator.assign) {
            Type type_first = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
            Type type_second = binaryExpression.getSecondOperand().accept(expressionTypeChecker);
            String second_op_cmds = binaryExpression.getSecondOperand().accept(this);
            if(type_first instanceof ArrayType) {
                second_op_cmds = "new Array\ndup\n" + second_op_cmds + "invokespecial Array/<init>(LList;)V\n";
            }

            if(type_second instanceof IntType)
                second_op_cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
            if(type_second instanceof BoolType)
                second_op_cmds += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";


            if(binaryExpression.getFirstOperand() instanceof Identifier) {
                Identifier identifier = (Identifier)binaryExpression.getFirstOperand();
                if(this.globalVariables.contains(identifier.getName())) {
                    cmds += second_op_cmds;
                    cmds += "putstatic  Global/" + identifier.getName()+ " L" + makeTypeFlag(type_second) + ";\n";
//                    cmds += "getstatic  Global/" + identifier.getName()+ " L" + makeTypeFlag(type_second) + ";\n";
                }
                else {
                    int slot = getSlotOf(identifier.getName());
                    cmds += second_op_cmds;
                    cmds += "astore " + slot + "\n";
                }
            }
            else if(binaryExpression.getFirstOperand() instanceof ArrayAccessByIndex) {
                Expression instance = ((ArrayAccessByIndex) binaryExpression.getFirstOperand()).getInstance();
                Expression index = ((ArrayAccessByIndex) binaryExpression.getFirstOperand()).getIndex();
                cmds += instance.accept(this);
                cmds += index.accept(this);
                cmds += second_op_cmds;
                cmds += "invokevirtual Array/setElement(ILjava/lang/Object;)V\n";

                cmds += instance.accept(this);
                cmds += index.accept(this);
                cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                cmds += "checkcast " + makeTypeFlag(type_second) + "\n";
                if (type_second instanceof IntType)
                    cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                if (type_second instanceof BoolType)
                    cmds += "invokevirtual java/lang/Boolean/booleanValue()Z\n";


            }
            else if(binaryExpression.getFirstOperand() instanceof ObjectMemberAccess) {
                Expression instance = ((ObjectMemberAccess) binaryExpression.getFirstOperand()).getInstance();
                Type member_access_type = binaryExpression.getFirstOperand().accept(expressionTypeChecker);
                String member_access_name = ((ObjectMemberAccess) binaryExpression.getFirstOperand()).getMemberName().getName();
                Type instance_type = instance.accept(expressionTypeChecker);
                if(instance_type instanceof ArrayType) {
                    int index = 0;
                    cmds += instance.accept(this);
                    cmds += "ldc " + index + "\n";
                    cmds += second_op_cmds;
                    cmds += "invokevirtual Array/setElement(ILjava/lang/Object;)V\n";

                    cmds += "checkcast " + makeTypeFlag(type_second) + "\n";
                    if (type_second instanceof IntType)
                        cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                    if (type_second instanceof BoolType)
                        cmds += "invokevirtual java/lang/Boolean/booleanValue()Z\n";

                }
                else if(instance_type instanceof ClassType) {
                    String class_name = ((ClassType)instance_type).getClassName().getName();
                    cmds += instance.accept(this);
                    cmds += second_op_cmds;
                    cmds += "putfield " + class_name + "/" + member_access_name + " L" + makeTypeFlag(member_access_type) + ";\n";
                }
            }
        }
        return cmds;
    }

    // Maybe Done - Needs a lot of changes
    @Override
    public String visit(UnaryExpression unaryExpression) {
        UnaryOperator op = unaryExpression.getOperator();
        String cmds = "";
        if(op == UnaryOperator.minus) {
            cmds += unaryExpression.getOperand().accept(this);
            cmds += "ineg\n";
        }
        else if(op == UnaryOperator.not) {
            String true_label = getNewLabel();
            String after_label = getNewLabel();
            cmds += unaryExpression.getOperand().accept(this);
            cmds +=  "ifne " + true_label + "\n";
            cmds += "ldc 1\n";
            cmds += "goto " + after_label + "\n";
            cmds += true_label + ":\n";
            cmds += "ldc 0\n";
            cmds += after_label + ":\n";
        }
        else if((op == UnaryOperator.postinc) || (op == UnaryOperator.postdec)) {
            if(unaryExpression.getOperand() instanceof Identifier) {
                Identifier id = (Identifier)unaryExpression.getOperand();
                int slot = getSlotOf(id.getName());

                cmds += "aload " + slot + "\n";
                cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                cmds += "ldc 1\n";

                cmds += (op == UnaryOperator.postinc) ? "iadd\n" : "isub\n";
                cmds += "dup\n";
                cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                cmds += "astore " + slot + "\n";
            }
            else if(unaryExpression.getOperand() instanceof ArrayAccessByIndex) {
                Expression instance = ((ArrayAccessByIndex) unaryExpression.getOperand()).getInstance();
                Expression index = ((ArrayAccessByIndex) unaryExpression.getOperand()).getIndex();
                Type member_access_type = unaryExpression.getOperand().accept(expressionTypeChecker);

                cmds += instance.accept(this);
                cmds += index.accept(this);

                cmds += instance.accept(this);
                cmds += index.accept(this);

                cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                cmds += "checkcast " + makeTypeFlag(member_access_type) + "\n";
                cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                cmds += "ldc 1\n";

                cmds += (op == UnaryOperator.postinc) ? "iadd\n" : "isub\n";


                cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";

                cmds += "invokevirtual Array/setElement(ILjava/lang/Object;)V\n";

                cmds += instance.accept(this);
                cmds += index.accept(this);

                cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                cmds += "checkcast " + makeTypeFlag(member_access_type) + "\n";
                cmds += "invokevirtual java/lang/Integer/intValue()I\n";
            }
            else if(unaryExpression.getOperand() instanceof ObjectMemberAccess) {
                Expression instance = ((ObjectMemberAccess) unaryExpression.getOperand()).getInstance();
                Type member_access_type = unaryExpression.getOperand().accept(expressionTypeChecker);
                String member_access_name = ((ObjectMemberAccess) unaryExpression.getOperand()).getMemberName().getName();
                Type instance_type = instance.accept(expressionTypeChecker);
                if(instance_type instanceof ArrayType) {
                    int index = 0;
                    cmds += instance.accept(this);
                    cmds += "ldc " + index + "\n";

                    cmds += instance.accept(this);
                    cmds += "ldc " + index + "\n";

                    cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                    cmds += "checkcast " + makeTypeFlag(member_access_type) + "\n";
                    cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                    cmds += "ldc 1\n";

                    cmds += (op == UnaryOperator.postinc) ? "iadd\n" : "isub\n";


                    cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                    cmds += "invokevirtual Array/setElement(ILjava/lang/Object;)V\n";
                    cmds += instance.accept(this);
                    cmds += "ldc " + index + "\n";
                    cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                    cmds += "checkcast " + makeTypeFlag(member_access_type) + "\n";
                    cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                }
                else if(instance_type instanceof ClassType) {
                    String class_name = ((ClassType)instance_type).getClassName().getName();
                    cmds += instance.accept(this);
                    cmds += "dup\n";
                    cmds += "getfield " + class_name + "/" + member_access_name + " L" + makeTypeFlag(member_access_type) + ";\n";
                    cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                    cmds += "ldc 1\n";

                    cmds += (op == UnaryOperator.postinc) ? "iadd\n" : "isub\n";

                    cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                    cmds += "putfield " + class_name + "/" + member_access_name + " L" + makeTypeFlag(member_access_type) + ";\n";

                    cmds += instance.accept(this);
                    cmds += "getfield " + class_name + "/" + member_access_name + " L" + makeTypeFlag(member_access_type) + ";\n";
                    cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                }
            }
        }
        else if(op == UnaryOperator.postdec || op == UnaryOperator.postinc) {
            if(unaryExpression.getOperand() instanceof Identifier) {
                Identifier id = (Identifier)unaryExpression.getOperand();
                int slot = getSlotOf(id.getName());

                cmds += "aload " + slot + "\n";
                cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                cmds += "dup\n";
                cmds += "ldc 1\n";

                cmds += (op == UnaryOperator.postinc) ? "iadd\n" : "isub\n";

                cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                cmds += "astore " + slot + "\n";
            }
            else if(unaryExpression.getOperand() instanceof ArrayAccessByIndex) {
                Expression instance = ((ArrayAccessByIndex) unaryExpression.getOperand()).getInstance();
                Expression index = ((ArrayAccessByIndex) unaryExpression.getOperand()).getIndex();
                Type member_access_type = unaryExpression.getOperand().accept(expressionTypeChecker);

                cmds += instance.accept(this);
                cmds += index.accept(this);

                cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                cmds += "checkcast " + makeTypeFlag(member_access_type) + "\n";
                cmds += "invokevirtual java/lang/Integer/intValue()I\n";

                cmds += instance.accept(this);
                cmds += index.accept(this);

                cmds += instance.accept(this);
                cmds += index.accept(this);

                cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                cmds += "checkcast " + makeTypeFlag(member_access_type) + "\n";
                cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                cmds += "ldc 1\n";

                cmds += (op == UnaryOperator.postinc) ? "iadd\n" : "isub\n";

                cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";

                cmds += "invokevirtual Array/setElement(ILjava/lang/Object;)V\n";
            }
            else if(unaryExpression.getOperand() instanceof ObjectMemberAccess) {
                Expression instance = ((ObjectMemberAccess) unaryExpression.getOperand()).getInstance();
                Type member_access_type = unaryExpression.getOperand().accept(expressionTypeChecker);
                String member_access_name = ((ObjectMemberAccess) unaryExpression.getOperand()).getMemberName().getName();
                Type instance_type = instance.accept(expressionTypeChecker);
                if(instance_type instanceof ArrayType) {
                    int index = 0;
                    ArrayType arrayType = (ArrayType)instance_type;

                    cmds += instance.accept(this);
                    cmds += "ldc " + index + "\n";
                    cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                    cmds += "checkcast " + makeTypeFlag(member_access_type) + "\n";
                    cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                    cmds += instance.accept(this);
                    cmds += "ldc " + index + "\n";
                    cmds += instance.accept(this);
                    cmds += "ldc " + index + "\n";
                    cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
                    cmds += "checkcast " + makeTypeFlag(member_access_type) + "\n";
                    cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                    cmds += "ldc 1\n";
                    cmds += (op == UnaryOperator.postinc) ? "iadd\n" : "isub\n"; 
                    cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                    cmds += "invokevirtual Array/setElement(ILjava/lang/Object;)V\n";
                }
                else if(instance_type instanceof ClassType) {
                    String class_name = ((ClassType)instance_type).getClassName().getName();
                    cmds += instance.accept(this);
                    cmds += "getfield " + class_name + "/" + member_access_name + " L" + makeTypeFlag(member_access_type) + ";\n";
                    cmds += "invokevirtual java/lang/Integer/intValue()I\n";

                    cmds += instance.accept(this);
                    cmds += "dup\n";
                    cmds += "getfield " + class_name + "/" + member_access_name + " L" + makeTypeFlag(member_access_type) + ";\n";
                    cmds += "invokevirtual java/lang/Integer/intValue()I\n";

                    cmds += "ldc 1\n";

                    cmds += (op == UnaryOperator.postinc) ? "iadd\n" : "isub\n";

                    cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
                    cmds += "putfield " + class_name + "/" + member_access_name + " L" + makeTypeFlag(member_access_type) + ";\n";
                }
            }
        }
        return cmds;
    }

    @Override
    public String visit(ObjectMemberAccess objectMemberAccess) {
        //todo : done
        Type obj_type = objectMemberAccess.accept(expressionTypeChecker);
        Type instance_type = objectMemberAccess.getInstance().accept(expressionTypeChecker);
        String obj_name = objectMemberAccess.getMemberName().getName();
        String cmds = "";
        if(instance_type instanceof ClassType) {
            String class_name = ((ClassType) instance_type).getClassName().getName();
            try {
                SymbolTable classSymbolTable = ((ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + class_name, true)).getClassSymbolTable();
                try {
                    classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + obj_name, true);
                    cmds += objectMemberAccess.getInstance().accept(this);
                    cmds += "getfield " + class_name + "/" + obj_name + " L" + makeTypeFlag(obj_type) + ";\n";
                    if (obj_type instanceof IntType)
                        cmds += "invokevirtual java/lang/Integer/intValue()I\n";
                    if (obj_type instanceof BoolType)
                        cmds += "invokevirtual java/lang/Boolean/booleanValue()Z\n";

                } 
                // Member is a method:
                catch (ItemNotFoundException i) {
                    cmds += "new Fptr\n";
                    cmds += "dup\n";
                    cmds += objectMemberAccess.getInstance().accept(this);
                    cmds += "ldc \"" + obj_name + "\"\n";
                    cmds += "invokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V\n";
                }
            } catch (ItemNotFoundException ignored) {

            }
        }
        else if(instance_type instanceof ArrayType) {
            int index = 0;
            cmds += objectMemberAccess.getInstance().accept(this);
            cmds += "ldc " + index + "\n";
            cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";

            cmds += "checkcast " + makeTypeFlag(obj_type) + "\n";

            if (obj_type instanceof BoolType)
                cmds += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
            else if (obj_type instanceof IntType)
                cmds += "invokevirtual java/lang/Integer/intValue()I\n";

        }
        return cmds;
    }

    @Override
    public String visit(Identifier identifier) {
        //todo : Done
        String cmds = "";
        String name = identifier.getName();
        Type type = identifier.accept(expressionTypeChecker);
        if (this.globalVariables.contains(name)) {
            cmds += "getstatic  Global/" + identifier.getName()+ " L" + makeTypeFlag(type) + ";\n";
        }
        else {
            int slot_number = getSlotOf(name);
            cmds += "aload " + slot_number + "\n";
        }
        if(type instanceof BoolType)
            cmds += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        else if(type instanceof IntType)
            cmds += "invokevirtual java/lang/Integer/intValue()I\n";

        return cmds;
    }

    @Override
    public String visit(ArrayAccessByIndex arrayAccessByIndex) {
        //todo : done
        String cmds = "";
        Type type = arrayAccessByIndex.accept(expressionTypeChecker);
        cmds += arrayAccessByIndex.getInstance().accept(this);
        cmds += arrayAccessByIndex.getIndex().accept(this);
        cmds += "invokevirtual Array/getElement(I)Ljava/lang/Object;\n";
        cmds += "checkcast " + makeTypeFlag(type) + "\n";

        if (type instanceof BoolType)
            cmds += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        else if (type instanceof IntType)
            cmds += "invokevirtual java/lang/Integer/intValue()I\n";

        return cmds;
    }

    private int array_size;

    @Override
    public String visit(MethodCall methodCall)
    {
        //todo : done
        ArrayList<Expression> args = methodCall.getArgs();
        Type return_type = ((FptrType) methodCall.getInstance().accept(expressionTypeChecker)).getReturnType();
        String cmds = "";
        cmds += methodCall.getInstance().accept(this);
        cmds += "new java/util/ArrayList\n";
        cmds += "dup\n";
        cmds += "invokespecial java/util/ArrayList/<init>()V\n";
        int temporary_index = getSlotOf("");
        cmds += "astore " + temporary_index + "\n";

        for(Expression arg : args){
            cmds += "aload " + temporary_index + "\n";

            Type arg_type = arg.accept(expressionTypeChecker);

            if(arg_type instanceof ArrayType) {
                cmds += "new Array\n";
                cmds += "dup\n";
            }

            cmds += arg.accept(this);

            if(arg_type instanceof IntType)
                cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";

            else if(arg_type instanceof ArrayType)
                cmds += "invokespecial Array/<init>(LList;)V\n";

            else if(arg_type instanceof BoolType)
                cmds += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";

            cmds += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n";
            cmds += "pop\n";
        }

        cmds += "aload " + temporary_index + "\n";
        cmds += "invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;\n";

        if((return_type instanceof NullType) == false)
            cmds += "checkcast " + makeTypeFlag(return_type) + "\n";

        if (return_type instanceof IntType)
            cmds += "invokevirtual java/lang/Integer/intValue()I\n";
        if (return_type instanceof BoolType)
            cmds += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return cmds;
    }

    @Override
    public String visit(NewClassInstance newClassInstance) {
        //todo : done
        String cmds = "";
        String new_class_name = newClassInstance.getClassType().getClassName().getName();
        String arguments_flags = "";
        ArrayList<Expression> arguments = newClassInstance.getArgs();
        cmds += "new " + new_class_name + "\n";
        cmds += "dup\n";
        for(Expression arg : arguments)
        {
            cmds += arg.accept(this);
            Type arg_type = arg.accept(expressionTypeChecker);
            arguments_flags += "L" + makeTypeFlag(arg_type) + ";";
            if(arg_type instanceof BoolType)
                cmds += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
            else if(arg_type instanceof IntType)
                cmds += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
        }
        cmds += "invokespecial " + new_class_name + "/<init>(" + arguments_flags + ")V\n";
        return cmds;
    }

    @Override
    public String visit(SelfClass selfClass) {
        //todo : done
        String cmds = "aload 0\n";
        return cmds;
    }

    @Override
    public String visit(NullValue nullValue) {
        //todo : done
        String cmds = "aconst_null\n";
        return cmds;
    }

    @Override
    public String visit(IntValue intValue) {
        //todo : done
        return "ldc " + intValue.getConstant() + "\n";
    }

    @Override
    public String visit(BoolValue boolValue) {
        //todo : done
        int bool_val = (boolValue.getConstant()) ? 1 : 0;
        return "ldc " + bool_val + "\n";
    }

}