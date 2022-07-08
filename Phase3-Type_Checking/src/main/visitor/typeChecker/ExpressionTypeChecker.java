package main.visitor.typeChecker;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.TernaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.BoolValue;
import main.ast.nodes.expression.values.primitive.IntValue;
import main.ast.types.NoType;
import main.ast.types.NullType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.ast.types.set.SetType;
import main.compileError.typeError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.*;
import main.symbolTable.utils.graph.Graph;
import main.symbolTable.utils.graph.exceptions.GraphDoesNotContainNodeException;
import main.util.ArgPair;
import main.visitor.Visitor;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;

import java.util.ArrayList;

public class ExpressionTypeChecker extends Visitor<Type> {
    private Graph<String> classHierarchy;
    private boolean isInMethodCallStmnt = false;
    private MethodDeclaration curr_method;
    private ClassDeclaration curr_class;
    private boolean noneLeftValueSeen = false;
    private String current_class;

    private MethodSymbolTableItem current_method_symbol_table;

    public ExpressionTypeChecker(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
    }

    public void setCurrClass(ClassDeclaration classDeclaration) {
        this.curr_class = classDeclaration;
    }

    // Done
    public boolean isLeftVal(Expression expression) {
        boolean oldIsCatchErrorsActive = Node.isCatchErrorsActive;
        boolean oldNoneLeftValueSeen = this.noneLeftValueSeen;
        Node.isCatchErrorsActive = false;
        this.noneLeftValueSeen = false;
        expression.accept(this);
        boolean isLeftVal = !this.noneLeftValueSeen;
        Node.isCatchErrorsActive = oldIsCatchErrorsActive;
        this.noneLeftValueSeen = oldNoneLeftValueSeen;
        return isLeftVal;
    }

    // Checks if Type List A and b are the same
    //Done
    public boolean isAllSameType(ArrayList<Type> A, ArrayList<Type> B) {
        if (A.size() != B.size())
            return false;
        for (int i = 0; i < A.size(); i++) {
            if (!isAllSameType(A.get(i), B.get(i)))
                return false;
        }
        return true;
    }

    // Done
    public boolean isAllSameType(Type first, Type second) {
        if (first instanceof NoType)
            return true;
        else if (first instanceof BoolType && second instanceof BoolType)
            return true;
        else if (first instanceof IntType && second instanceof IntType)
            return true;
        else if (first instanceof SetType && second instanceof SetType)
            return true;
        else if (first instanceof VoidType && second instanceof VoidType)
            return true;
        else if (first instanceof ClassType) {
            if ((second instanceof ClassType) == false)
                return false;
            String s1 = ((ClassType) first).getClassName().getName();
            String s2 = ((ClassType) second).getClassName().getName();
            return classHierarchy.isSecondNodeAncestorOf(s1, s2);
        }
        else if (first instanceof ArrayType) {
            if ((second instanceof ArrayType) == false)
                return false;

            Type t1 = ((ArrayType) first).getType();
            Type t2 = ((ArrayType) second).getType();
            return isAllSameType(t1, t2);
        }
        else if (first instanceof FptrType) {
            if ((second instanceof FptrType) == false)
                return false;
            Type fptr1 = ((FptrType) first).getReturnType();
            Type fptr2 = ((FptrType) second).getReturnType();
            if (isAllSameType(fptr1, fptr2) == false)
                return false;
            ArrayList<Type> arg2 = ((FptrType) second).getArgumentsTypes();
            ArrayList<Type> arg1 = ((FptrType) first).getArgumentsTypes();
            return isAllSameType(arg1, arg2);
        }
        return false;
    }

    // Done
    public void checkNode(Node node, Type type) {
        if (type instanceof ClassType) {
            String class_name = ((ClassType) type).getClassName().getName();
            if (!this.classHierarchy.doesGraphContainNode(class_name)) {
                ClassNotDeclared exception = new ClassNotDeclared(node.getLine(), class_name);
                node.addError(exception);
            }
        }
        else if (type instanceof ArrayType) {
            for( Expression dimension : ((ArrayType) type).getDimensions())
                if (((IntValue)dimension).getConstant() == 0)
                    node.addError(new CannotHaveEmptyArray(node.getLine()));
        }

        else if (type instanceof FptrType) {
            Type returnType = ((FptrType) type).getReturnType();
            ArrayList<Type> argTypes = ((FptrType) type).getArgumentsTypes();
            this.checkNode(node, returnType);
            for (Type argType : argTypes)
                this.checkNode(node, argType);
        }
    }


    //
    @Override
    public Type visit(BinaryExpression binaryExpression) {
        //Todo: Probably Done
        this.noneLeftValueSeen = true;
        Type type1 = binaryExpression.getFirstOperand().accept(this);
        Type type2 = binaryExpression.getSecondOperand().accept(this);
        BinaryOperator op = binaryExpression.getBinaryOperator();
        if((op == BinaryOperator.eq)) {
            if((type1 instanceof NoType) && (type2 instanceof NoType))
                return new NoType();
            else if((type1 instanceof NoType && type2 instanceof ArrayType)) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), op.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if (type2 instanceof NoType && type1 instanceof ArrayType) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), op.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if( (type1 instanceof NoType) || (type2 instanceof NoType) )
                return new NoType();
            if((type1 instanceof IntType || type1 instanceof BoolType) && type1.toString().equals(type2.toString()))
                return new BoolType();

            String class_name1 = ((ClassType)type1).getClassName().getName();
            String class_name2 = ((ClassType)type2).getClassName().getName();
            if((type1 instanceof ClassType && type2 instanceof ClassType && class_name1.equals(class_name2))
                    || (type1 instanceof ClassType && type2 instanceof NullType)
                    || (type1 instanceof NullType && type2 instanceof ClassType)) {
                return new BoolType();
            }
            if((type1 instanceof FptrType && type2 instanceof NullType) ||
                    (type1 instanceof NullType && type2 instanceof FptrType) ||
                    (type1 instanceof FptrType && type2 instanceof FptrType)) {
                return new BoolType();
            }
            if(type1 instanceof NullType && type2 instanceof NullType)
                return new BoolType();
        }
        if((op == BinaryOperator.lt) || (op == BinaryOperator.gt)) {
            if(type1 instanceof NoType && type2 instanceof NoType)
                return new NoType();
            else if((type1 instanceof NoType && ((type2 instanceof IntType) == false) ) ||
                    (type2 instanceof NoType && ((type1 instanceof IntType) == false) )) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), op.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(type1 instanceof NoType || type2 instanceof NoType)
                return new NoType();
            if((type1 instanceof IntType) && (type2 instanceof IntType))
                return new BoolType();
        }
        if((op == BinaryOperator.add) || (op == BinaryOperator.sub) || (op == BinaryOperator.mult) || (op == BinaryOperator.div)) {
            if(type1 instanceof NoType && type2 instanceof NoType)
                return new NoType();
            else if((type1 instanceof NoType && ((type2 instanceof IntType) == false) ) ||
                    (type2 instanceof NoType && ((type1 instanceof IntType) == false) )) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), op.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(type1 instanceof NoType || type2 instanceof NoType)
                return new NoType();
            if((type1 instanceof IntType) && (type2 instanceof IntType))
                return new IntType();
        }

        if((op == BinaryOperator.and) || (op == BinaryOperator.or)) {
            if(type1 instanceof NoType && type2 instanceof NoType)
                return new NoType();
            else if((type1 instanceof NoType && ((type2 instanceof BoolType) == false) ) ||
                    (type2 instanceof NoType && ((type1 instanceof BoolType) == false) )) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), op.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(type1 instanceof NoType || type2 instanceof NoType)
                return new NoType();
            if((type1 instanceof BoolType) && (type2 instanceof BoolType))
                return new BoolType();
        }
        if(op == BinaryOperator.assign) {
            boolean isLeftValueFirst = this.isLeftVal(binaryExpression.getFirstOperand());
            if(isLeftValueFirst == false) {
                LeftSideNotLvalue exception = new LeftSideNotLvalue(binaryExpression.getLine());
                binaryExpression.addError(exception);
            }
            if(type1 instanceof NoType || type2 instanceof NoType) {
                return new NoType();
            }
            boolean isSubtype = this.areTypesOfFirstAndSecondTheSame(type2, type1);
            if(isSubtype) {
                if(isLeftValueFirst)
                    return type2;
                return new NoType();
            }
            UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), op.name());
            binaryExpression.addError(exception);
            return new NoType();
        }
        UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), op.name());
        binaryExpression.addError(exception);
        return new NoType();
    }

    // Done
    public boolean areTypesOfFirstAndSecondTheSame(ArrayList<Type> A, ArrayList<Type> B) {
        for(int i = 0; i < A.size(); i++)
            if(!areTypesOfFirstAndSecondTheSame(A.get(i), B.get(i)))
                return false;

        return true;
    }

    // Done
    public boolean areTypesOfFirstAndSecondTheSame(Type A, Type B) {
        if(A instanceof NoType)
            return true;
        else if(A instanceof IntType || A instanceof BoolType)
            return A.toString().equals(B.toString());
        else if(A instanceof NullType)
            return (B instanceof NullType) || (B instanceof FptrType) || (B instanceof ClassType);
        else if(A instanceof FptrType) {
            if(!(B instanceof FptrType))
                return false;
            Type fptr1_ret_type = ((FptrType) A).getReturnType();
            Type fptr2_ret_type = ((FptrType) B).getReturnType();
            if(!areTypesOfFirstAndSecondTheSame(fptr1_ret_type, fptr2_ret_type))
                return false;
            ArrayList<Type> arg_type1 = ((FptrType) A).getArgumentsTypes();
            ArrayList<Type> arg_type2 = ((FptrType) B).getArgumentsTypes();
            return areTypesOfFirstAndSecondTheSame(arg_type2, arg_type1);
        }
        else if(A instanceof ClassType) {
            if((B instanceof ClassType) == false)
                return false;
            return this.classHierarchy.isSecondNodeAncestorOf(((ClassType) A).getClassName().getName(), ((ClassType) B).getClassName().getName());
        }

        return false;
    }

    //
    @Override
    public Type visit(NewClassInstance newClassInstance) {
        //todo: done
        this.noneLeftValueSeen = true;
        String class_name = newClassInstance.getClassType().getClassName().getName();
        ArrayList<Type> newInstTypes = new ArrayList<>();
        for(Expression expression : newClassInstance.getArgs())
            newInstTypes.add(expression.accept(this));
        if(this.classHierarchy.doesGraphContainNode(class_name)) {
            try {
                ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + class_name, true);
                MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem) classSymbolTableItem.getClassSymbolTable().getItem(MethodSymbolTableItem.START_KEY + "initialize", true);
                ArrayList<Type> constructorActualTypes = methodSymbolTableItem.getArgTypes();
                int non_default_args = this.calc_non_default_args(methodSymbolTableItem);
                if (newInstTypes.size() < non_default_args || newInstTypes.size() > constructorActualTypes.size()){
                    ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                    newClassInstance.addError(exception);
                    return new NoType();
                }

//                if (newInstTypes.size() != constructorActualTypes.size()){
//                    ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
//                    newClassInstance.addError(exception);
//                    return new NoType();
//                }
                if(this.areTypesOfFirstAndSecondTheSame(newInstTypes, constructorActualTypes)) {
                    return newClassInstance.getClassType();
                }
                else {
                    ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                    newClassInstance.addError(exception);
                    return new NoType();
                }
            } catch (ItemNotFoundException ignored) {
                if(newInstTypes.size() != 0) {
                    ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                    newClassInstance.addError(exception);
                    return new NoType();
                }
                else {
                    return newClassInstance.getClassType();
                }
            }
        }
        else {
            ClassNotDeclared exception = new ClassNotDeclared(newClassInstance.getLine(), class_name);
            newClassInstance.addError(exception);
            return new NoType();
        }
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        //Todo
        this.noneLeftValueSeen = true;
        Type opType = unaryExpression.getOperand().accept(this);
        UnaryOperator op = unaryExpression.getOperator();
        if(op == UnaryOperator.not) {
            if(opType instanceof NoType)
                return new NoType();
            else if(opType instanceof BoolType)
                return opType;
            UnsupportedOperandType exception = new UnsupportedOperandType(unaryExpression.getLine(), op.name());
            unaryExpression.addError(exception);
            return new NoType();
        }
        else if(op == UnaryOperator.minus) {
            if(opType instanceof NoType)
                return new NoType();
            else if(opType instanceof IntType)
                return opType;
            UnsupportedOperandType exception = new UnsupportedOperandType(unaryExpression.getLine(), op.name());
            unaryExpression.addError(exception);
            return new NoType();
        }
        else {
            boolean isOpLeftVal = this.isLeftVal(unaryExpression.getOperand());
            if(isOpLeftVal == false) {
                IncDecOperandNotLvalue exception = new IncDecOperandNotLvalue(unaryExpression.getLine(), op.name());
                unaryExpression.addError(exception);
            }
            else if(opType instanceof NoType)
                return new NoType();
            else if(opType instanceof IntType) {
                if(isOpLeftVal)
                    return opType;
                return new NoType();
            }
            UnsupportedOperandType exception = new UnsupportedOperandType(unaryExpression.getLine(), op.name());
            unaryExpression.addError(exception);
            return new NoType();
        }
    }

    private int calc_non_default_args(MethodSymbolTableItem MSTI)
    {
        int count = 0;
        MethodDeclaration md = MSTI.getMethodDeclaration();
        for(ArgPair argPair : md.getArgs()) {
            if (argPair.getDefaultValue() == null) {
                count += 1;
            }
        }
        return count;
    }

    @Override
    public Type visit(MethodCall methodCall) {
        //Todo: done
        ArrayList<Type> argsTypeMethodCallRet = new ArrayList<>();
        boolean containsError = false;
        boolean oldInMethodCallStmt = isInMethodCallStmnt;
        isInMethodCallStmnt = false;
        Type instTypeRet = methodCall.getInstance().accept(this);

        for (Expression expression : methodCall.getArgs()) {
            Type type = expression.accept(this);
            argsTypeMethodCallRet.add(type);
        }
        isInMethodCallStmnt = oldInMethodCallStmt;
        if(instTypeRet instanceof NoType)
            return new NoType();
        if (!(instTypeRet instanceof FptrType )){
            CallOnNoneCallable exception = new CallOnNoneCallable(methodCall.getLine());
            methodCall.addError(exception);
            return new NoType();
        }
        FptrType funcPtrTypes = (FptrType) instTypeRet;
        ArrayList<Type> funcPtrParamTypes = funcPtrTypes.getArgumentsTypes();
        if (funcPtrTypes.getReturnType() instanceof VoidType && !isInMethodCallStmnt){
            containsError = true;
            CantUseValueOfVoidMethod exception = new CantUseValueOfVoidMethod(methodCall.getLine());
            methodCall.addError(exception);
        }
        isInMethodCallStmnt = false;

        int non_default_args = this.calc_non_default_args(this.current_method_symbol_table);
        if (argsTypeMethodCallRet.size() < non_default_args || argsTypeMethodCallRet.size() > funcPtrParamTypes.size()) {
            containsError = true;
            MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
            methodCall.addError(exception);

            return new NoType();
        }

//        if (argsTypeMethodCallRet.size() != funcPtrParamTypes.size()) {
//            containsError = true;
//            MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
//            methodCall.addError(exception);
//
//            return new NoType();
//        }

        else if (funcPtrParamTypes.size() != 0) {
            for(int i = 0; i < argsTypeMethodCallRet.size(); i += 1){
                if (isAllSameType(funcPtrParamTypes.get(i), argsTypeMethodCallRet.get(i)) == false) {
                    MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
                    methodCall.addError(exception);
                    containsError = true;
                    // Don't check any other errors if you found one!
                    break;
                }
            }
        }

        if (containsError)
            return new NoType();
        else
            return funcPtrTypes.getReturnType();
    }

    @Override
    public Type visit(Identifier identifier) {
        try {
            ClassSymbolTableItem classSTI = (ClassSymbolTableItem) SymbolTable.root
                    .getItem(ClassSymbolTableItem.START_KEY + this.curr_class.getClassName().getName(), true);
            SymbolTable classST = classSTI.getClassSymbolTable();
            MethodSymbolTableItem methodSTI = (MethodSymbolTableItem) classST
                    .getItem(MethodSymbolTableItem.START_KEY + this.curr_method.getMethodName().getName(), true);
            SymbolTable methodST = methodSTI.getMethodSymbolTable();
            LocalVariableSymbolTableItem localVarSTI = (LocalVariableSymbolTableItem) methodST
                    .getItem(LocalVariableSymbolTableItem.START_KEY + identifier.getName(), true);
            return localVarSTI.getType();
        } catch (ItemNotFoundException e) {
            VarNotDeclared exception = new VarNotDeclared(identifier.getLine(), identifier.getName());
            identifier.addError(exception);
            return new NoType();
        }
    }

    @Override
    public Type visit(ArrayAccessByIndex arrayAccessByIndex) {
        //Todo: maybe done

        Type instTypeRet = arrayAccessByIndex.getInstance().accept(this);
        boolean oldNoneLeftValueSeen = this.noneLeftValueSeen;
        Type indexType = arrayAccessByIndex.getIndex().accept(this);
        this.noneLeftValueSeen = oldNoneLeftValueSeen;
        boolean containsError = false;
        if(( (indexType instanceof NoType) || (indexType instanceof IntType)) == false) {
            ArrayIndexNotInt exception = new ArrayIndexNotInt(arrayAccessByIndex.getLine());
            arrayAccessByIndex.addError(exception);
            containsError = true;
        }
        if(instTypeRet instanceof ArrayType) {
            ArrayList<Type> types = new ArrayList<>();
            if(containsError)
                return new NoType();
        }
        else if((instTypeRet instanceof NoType) == false) {
            AccessByIndexOnNoneArray exception = new AccessByIndexOnNoneArray(arrayAccessByIndex.getLine());
            arrayAccessByIndex.addError(exception);
        }
        return new NoType();
    }

    @Override
    public Type visit(ObjectMemberAccess objectMemberAccess) {
        //Todo
        boolean oldNoneLeftValueSeen = this.noneLeftValueSeen;
        Type instTypeRet = objectMemberAccess.getInstance().accept(this);
        if(objectMemberAccess.getInstance() instanceof SelfClass)
            this.noneLeftValueSeen = oldNoneLeftValueSeen;
        String name_member = objectMemberAccess.getMemberName().getName();
        if(instTypeRet instanceof NoType)
            return new NoType();
        else if(instTypeRet instanceof ClassType) {
            String class_name = ((ClassType) instTypeRet).getClassName().getName();
            SymbolTable classSymbolTable;
            try {
                classSymbolTable = ((ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + class_name, true)).getClassSymbolTable();
            } catch (ItemNotFoundException ignore) {
                return new NoType();
            }
            try {
                FieldSymbolTableItem fieldSymbolTableItem = (FieldSymbolTableItem) classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + name_member, true);
                return fieldSymbolTableItem.getType();
            } catch (ItemNotFoundException memberNotField) {
                try {
                    MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem) classSymbolTable.getItem(MethodSymbolTableItem.START_KEY + name_member, true);
                    this.current_method_symbol_table = methodSymbolTableItem;
                    this.noneLeftValueSeen = true;
                    FptrType ft = new FptrType(methodSymbolTableItem.getArgTypes(), methodSymbolTableItem.getReturnType());
//                    ft.setNonDefaultArgs(methodSymbolTableItem.non_default_args);
                    return ft;
                } catch (ItemNotFoundException ignore) {
                    if(name_member.equals(class_name)) {
                        this.noneLeftValueSeen = true;
                        FptrType ft = new FptrType(new ArrayList<>(), new NullType());
                        return ft;
                    }
                    MemberNotAvailableInClass exception = new MemberNotAvailableInClass(objectMemberAccess.getLine(), name_member, class_name);
                    objectMemberAccess.addError(exception);
                    return new NoType();
                }
            }
        }
        else {
            AccessOnNonClass exception = new AccessOnNonClass(objectMemberAccess.getLine());
            objectMemberAccess.addError(exception);
            return new NoType();
        }
    }

    @Override
    public Type visit(SetNew setNew) {
        //Todo
        ArrayList<Expression> args = setNew.getArgs();
        for (Expression arg : args) {
            Type t = arg.accept(this);
            if (!(t instanceof IntType) ){
                NewInputNotSet exception = new NewInputNotSet(setNew.getLine());
                setNew.addError(exception);
                return new NoType();
            }
        }
        return new SetType();
    }

    @Override
    public Type visit(SetInclude setInclude) {
        //Todo
        Expression setArg = setInclude.getSetArg();
        Expression elementArg = setInclude.getElementArg();

        Type setArgAcc = setArg.accept(this);
        Type elementArgAcc = elementArg.accept(this);

        if (!(elementArgAcc instanceof IntType) ){
            SetIncludeInputNotInt exception = new SetIncludeInputNotInt(setInclude.getLine());
            setInclude.addError(exception);
            return new NoType();
        }

        return new BoolType();
    }

    @Override
    public Type visit(RangeExpression rangeExpression) {
        //Todo
        Expression lExpr = rangeExpression.getLeftExpression();
        Expression rExpr = rangeExpression.getRightExpression();

        Type lExprAcc = lExpr.accept(this);
        Type rExprAcc = rExpr.accept(this);

        if (!(lExprAcc instanceof IntType) || !(rExprAcc instanceof IntType)){
            EachRangeNotInt exception = new EachRangeNotInt(lExpr.getLine());
            rangeExpression.addError(exception);
            return new NoType();
        }

        // Change it to ArrayType
        return new NoType();
    }

    @Override
    public Type visit(TernaryExpression ternaryExpression) {
        //Todo
        Expression condition = ternaryExpression.getCondition();
        Expression trueExpr = ternaryExpression.getTrueExpression();
        Expression falseExpr = ternaryExpression.getFalseExpression();

        Type condAcc = condition.accept(this);
        Type trueExprAcc = trueExpr.accept(this);
        Type falseExprAcc = falseExpr.accept(this);

        Boolean hasError = false;

        if (!(condAcc instanceof BoolType))
        {
            // The first operand should be Bool!
            ConditionNotBool exception = new ConditionNotBool(condition.getLine());
            ternaryExpression.addError(exception);
            hasError = true;
        }

        if(!isAllSameType(trueExprAcc,falseExprAcc))
        {
            UnsupportedOperandType exception = new UnsupportedOperandType(condition.getLine(), TernaryOperator.ternary.name());
            ternaryExpression.addError(exception);
            hasError = true;
        }

        if (hasError) {
            return new NoType();
        }

        if(trueExprAcc instanceof BoolType)
            return new BoolType();
        else if(trueExprAcc instanceof IntType)
            return new BoolType();
            //Not sure about this
        else if(trueExprAcc instanceof NoType && falseExprAcc instanceof NoType)
            return new NoType();
        else {
            UnsupportedOperandType exception = new UnsupportedOperandType(ternaryExpression.getLine(), TernaryOperator.ternary.name());
            ternaryExpression.addError(exception);
            return new NoType();
        }
    }

    @Override
    public Type visit(IntValue intValue) {
        this.noneLeftValueSeen = true;
        return new IntType();
    }

    @Override
    public Type visit(BoolValue boolValue) {
        this.noneLeftValueSeen = true;
        return new BoolType();
    }

    @Override
    public Type visit(SelfClass selfClass) {
        this.noneLeftValueSeen = true;
        return new ClassType(curr_class.getClassName());
    }

    @Override
    public Type visit(SetValue setValue) {
        this.noneLeftValueSeen = true;
        return new SetType();
    }

    @Override
    public Type visit(NullValue nullValue) {
        this.noneLeftValueSeen = true;
        return new NullType();
    }

    public void setCurrMethod(MethodDeclaration methodDeclaration) {
        this.curr_method = methodDeclaration;
    }
    public void setIsInMethodCallStmnt(boolean isInMethodCall) {
        this.isInMethodCallStmnt = isInMethodCall;
    }
}
