package main.visitor.typeChecker;

import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.Expression;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.*;
import main.ast.types.NoType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.ast.types.set.SetType;
import main.compileError.typeError.*;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.*;

public class TypeChecker extends Visitor<Void> {
    private Graph<String> classHierarchy;
    ExpressionTypeChecker expressionTypeChecker;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private boolean hasReturn = false;
    private boolean hasReturnError = false;

    public TypeChecker(Graph<String> classHierarchy){
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
    }

    @Override
    public Void visit(Program program) {
        boolean mainCheck = false;
        for (VariableDeclaration variableDeclaration : program.getGlobalVariables()) {
            variableDeclaration.accept(this);
        }
        for (ClassDeclaration classDeclaration : program.getClasses()) {
            this.expressionTypeChecker.setCurrentClass(classDeclaration);
            this.currentClass = classDeclaration;
            classDeclaration.accept(this);
            if(classDeclaration.getClassName().getName().equals("Main"))
                mainCheck = true;
        }
        if(!mainCheck) {
            NoMainClass exception = new NoMainClass();
            program.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        if(classDeclaration.getParentClassName() != null) {
            this.expressionTypeChecker.checkTypeValidation(new ClassType(classDeclaration.getParentClassName()), classDeclaration);
            if(classDeclaration.getClassName().getName().equals("Main")) {
                MainClassCantInherit exception = new MainClassCantInherit(classDeclaration.getLine());
                classDeclaration.addError(exception);
            }
            if(classDeclaration.getParentClassName().getName().equals("Main")) {
                CannotExtendFromMainClass exception = new CannotExtendFromMainClass(classDeclaration.getLine());
                classDeclaration.addError(exception);
            }
        }
        for(FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            fieldDeclaration.accept(this);
        }
        if(classDeclaration.getConstructor() != null) {
            this.expressionTypeChecker.setCurrentMethod(classDeclaration.getConstructor());
            this.currentMethod = classDeclaration.getConstructor();
            classDeclaration.getConstructor().accept(this);
        }
        else if(classDeclaration.getClassName().getName().equals("Main")) {
            NoConstructorInMainClass exception = new NoConstructorInMainClass(classDeclaration);
            classDeclaration.addError(exception);
        }
        for(MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
            this.expressionTypeChecker.setCurrentMethod(methodDeclaration);
            this.currentMethod = methodDeclaration;
            methodDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        if(this.currentClass.getClassName().getName().equals("Main")) {
            if(constructorDeclaration.getArgs().size() != 0) {
                MainConstructorCantHaveArgs exception = new MainConstructorCantHaveArgs(constructorDeclaration.getLine());
                constructorDeclaration.addError(exception);
            }
        }
        for (VariableDeclaration variableDeclaration : constructorDeclaration.getLocalVars()){
            variableDeclaration.accept(this);
        }
        for (Statement statement : constructorDeclaration.getBody()){
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        hasReturn = false;
        this.expressionTypeChecker.checkTypeValidation(methodDeclaration.getReturnType(), methodDeclaration);
        for(ArgPair argPair : methodDeclaration.getArgs()) {
            //todo
            argPair.getVariableDeclaration().accept(this);
        }
        for(VariableDeclaration varDeclaration : methodDeclaration.getLocalVars()) {
            varDeclaration.accept(this);
        }
        for(Statement statement : methodDeclaration.getBody()) {
            if (hasReturn && !hasReturnError){
                UnreachableStatements exception = new UnreachableStatements(statement);
                statement.addError(exception);
                break;
            }
            statement.accept(this);
        }
        if(!hasReturn && !(methodDeclaration.getReturnType() instanceof VoidType)){
            MissingReturnStatement exception = new MissingReturnStatement(methodDeclaration);
            methodDeclaration.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        fieldDeclaration.getVarDeclaration().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {
        this.expressionTypeChecker.checkTypeValidation(varDeclaration.getType(), varDeclaration);
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        Type firstType = assignmentStmt.getlValue().accept(expressionTypeChecker);
        Type secondType = assignmentStmt.getrValue().accept(expressionTypeChecker);
        boolean isFirstLvalue = expressionTypeChecker.isLvalue(assignmentStmt.getlValue());
        if(!isFirstLvalue) {
            LeftSideNotLvalue exception = new LeftSideNotLvalue(assignmentStmt.getLine());
            assignmentStmt.addError(exception);
        }
        if(firstType instanceof NoType || secondType instanceof NoType) {
            return null;
        }
        boolean isSubtype = expressionTypeChecker.isFirstSubTypeOfSecond(secondType, firstType);
        if(!isSubtype) {
            UnsupportedOperandType exception = new UnsupportedOperandType(assignmentStmt.getLine(), BinaryOperator.assign.name());
            assignmentStmt.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        for(Statement statement : blockStmt.getStatements()) {
            if(hasReturn && !hasReturnError) {
                hasReturnError = true;
                UnreachableStatements exception = new UnreachableStatements(statement);
                statement.addError(exception);
                return null;
            }
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        boolean hasReturnIf, hasReturnElse = false, hasReturnCur;
        hasReturnCur = hasReturn;
        Type condType = conditionalStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(conditionalStmt.getLine());
            conditionalStmt.addError(exception);
        }
        hasReturn = false;
        conditionalStmt.getThenBody().accept(this);
        hasReturnIf = hasReturn;
        for (ElsifStmt elsifStmt : conditionalStmt.getElsif()) {
            hasReturn = false;
            elsifStmt.accept(this);
            hasReturnElse = hasReturn;
        }
        if(conditionalStmt.getElseBody() != null) {
            hasReturn = false;
            conditionalStmt.getElseBody().accept(this);
            hasReturnElse = hasReturn;
        }
        if(hasReturnCur){
            hasReturn = true;
        }
        else {
            hasReturn = hasReturnIf && hasReturnElse;
        }
        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        Type condType = elsifStmt.getCondition().accept(expressionTypeChecker);
        if(!(condType instanceof BoolType || condType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(elsifStmt.getLine());
            elsifStmt.addError(exception);
        }
        elsifStmt.getThenBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        expressionTypeChecker.setIsInMethodCallStmt(true);
        methodCallStmt.getMethodCall().accept(expressionTypeChecker);
        expressionTypeChecker.setIsInMethodCallStmt(false);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        Type argType = print.getArg().accept(expressionTypeChecker);
        if(!(argType instanceof IntType || argType instanceof SetType ||
                argType instanceof BoolType || argType instanceof NoType)) {
            UnsupportedTypeForPrint exception = new UnsupportedTypeForPrint(print.getLine());
            print.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        hasReturn = true;
        Type retType = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        Type actualRetType = this.currentMethod.getReturnType();
        if (actualRetType instanceof VoidType){
            VoidMethodHasReturn voidMethodHasReturn = new VoidMethodHasReturn(this.currentMethod);
            this.currentMethod.addError(voidMethodHasReturn);
            return null;
        }
        if(!expressionTypeChecker.isFirstSubTypeOfSecond(retType, actualRetType)) {
            ReturnValueNotMatchMethodReturnType exception = new ReturnValueNotMatchMethodReturnType(returnStmt);
            returnStmt.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        Type listType = eachStmt.getList().accept(expressionTypeChecker);
        Type varType = eachStmt.getVariable().accept(expressionTypeChecker);
        if (!(listType instanceof ArrayType || listType instanceof NoType)) {
            EachCantIterateNoneArray exception = new EachCantIterateNoneArray(eachStmt.getLine());
            eachStmt.addError(exception);
            listType = new NoType();
        }
        if (!(listType instanceof NoType || expressionTypeChecker.isFirstSubTypeOfSecond(varType, ((ArrayType) listType).getType()))) {
            EachVarNotMatchList exception = new EachVarNotMatchList(eachStmt);
            eachStmt.addError(exception);
        }
        eachStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(SetDelete setDelete) {
        Type argType = setDelete.getSetArg().accept(expressionTypeChecker);
        Type setAddElementType = setDelete.getElementArg().accept(expressionTypeChecker);
        if (!(setAddElementType instanceof IntType || setAddElementType instanceof NoType)) {
            AddInputNotInt exception = new AddInputNotInt(setDelete.getLine());
            setDelete.addError(exception);
            return null;
        }
        return null;
    }

    @Override
    public Void visit(SetMerge setMerge) {
        Type argType = setMerge.getSetArg().accept(expressionTypeChecker);
        for (Expression element : setMerge.getElementArgs()) {
            Type setMergeElementType = element.accept(expressionTypeChecker);
            if (!(setMergeElementType instanceof SetType || setMergeElementType instanceof NoType ||
                    setMergeElementType instanceof IntType)) {
                MergeInputNotSet exception = new MergeInputNotSet(setMerge.getLine());
                setMerge.addError(exception);
                return null;
            }
        }
        return null;
    }

    @Override
    public Void visit(SetAdd setAdd) {
        Type argType = setAdd.getSetArg().accept(expressionTypeChecker);
        Type setAddElementType = setAdd.getElementArg().accept(expressionTypeChecker);
        if (!(setAddElementType instanceof IntType || setAddElementType instanceof NoType)) {
            AddInputNotInt exception = new AddInputNotInt(setAdd.getLine());
            setAdd.addError(exception);
            return null;
        }
        return null;
    }

}
