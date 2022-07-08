package main.visitor.typeChecker;

import main.ast.nodes.Node;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.*;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.types.*;
import main.ast.types.array.ArrayType;
import main.ast.types.functionPointer.FptrType;
import main.ast.types.primitives.*;
import main.ast.types.set.SetType;
import main.compileError.typeError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.*;
import main.symbolTable.utils.graph.Graph;
import main.util.ArgPair;
import main.visitor.Visitor;

import javax.xml.stream.events.NotationDeclaration;
import java.util.ArrayList;
import java.util.List;

public class ExpressionTypeChecker extends Visitor<Type> {
    private Graph<String> classHierarchy;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private int typeValidationNumberOfErrors;
    private boolean seenNoneLvalue = false;
    private boolean isInMethodCallStmt = false;
    private MethodDeclaration methodDeclaration;
    private int dimLvl = 0;


    public ExpressionTypeChecker(Graph<String> classHierarchy) {
        this.classHierarchy = classHierarchy;
    }

    public void setCurrentClass(ClassDeclaration classDeclaration) {
        this.currentClass = classDeclaration;
    }

    public void setMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
    }

    public void setCurrentMethod(MethodDeclaration currentMethod) {
        this.currentMethod = currentMethod;
    }

    public void setIsInMethodCallStmt(boolean isInMethodCallStmt) {
        this.isInMethodCallStmt = isInMethodCallStmt;
    }

    private boolean isSameType(Type t1, Type t2) {
        return (t1 instanceof NoType) || (t2 instanceof NoType) || (isFirstSubTypeOfSecond(t1, t2) && isFirstSubTypeOfSecond(t2, t1));
    }

    public boolean isFirstSubTypeOfSecondMultiple(ArrayList<Type> first, ArrayList<Type> second) {
        if(first.size() != second.size())
            return false;
        for(int i = 0; i < first.size(); i++) {
            if(!isFirstSubTypeOfSecond(first.get(i), second.get(i)))
                return false;
        }
        return true;
    }

    public boolean isFirstSubTypeOfSecond(Type first, Type second) {
        if(first instanceof NoType)
            return true;
        else if(first instanceof IntType || first instanceof BoolType || first instanceof SetType)
            return first.toString().equals(second.toString());
        else if(first instanceof VoidType && second instanceof VoidType)
            return true;
        else if(first instanceof NullType)
            return second instanceof NullType || second instanceof FptrType || second instanceof ClassType;
        else if(first instanceof ClassType) {
            if(!(second instanceof ClassType))
                return false;
            return this.classHierarchy.isSecondNodeAncestorOf(((ClassType) first).getClassName().getName(), ((ClassType) second).getClassName().getName());
        }
        else if(first instanceof FptrType) {
            if(!(second instanceof FptrType))
                return false;
            Type firstRetType = ((FptrType) first).getReturnType();
            Type secondRetType = ((FptrType) second).getReturnType();
            if(!isFirstSubTypeOfSecond(firstRetType, secondRetType))
                return false;
            ArrayList<Type> firstArgsTypes = ((FptrType) first).getArgumentsTypes();
            ArrayList<Type> secondArgsTypes = ((FptrType) second).getArgumentsTypes();
            return isFirstSubTypeOfSecondMultiple(secondArgsTypes, firstArgsTypes);
        }
        else if(first instanceof ArrayType) {
            if(!(second instanceof ArrayType))
                return false;
            return ((ArrayType) first).getType().toString().equals(((ArrayType) second).getType().toString());
        }
        return false;
    }

    public Type refineType(Type type) {
        typeValidationNumberOfErrors = 0;
        this.checkTypeValidation(type, new NullValue());
        if(typeValidationNumberOfErrors > 0)
            return new NoType();
        return type;
    }

    public void checkTypeValidation(Type type, Node node) {
        if(!(type instanceof ClassType || type instanceof FptrType || type instanceof ArrayType))
            return;
        if(type instanceof ArrayType) {
            checkTypeValidation(((ArrayType)type).getType(), node);
            for (Expression dimension : ((ArrayType) type).getDimensions()) {
                if (dimension instanceof IntValue){
                    if (((IntValue) dimension).getConstant() == 0){
                        CannotHaveEmptyArray cannotHaveEmptyArray = new CannotHaveEmptyArray(node.getLine());
                        node.addError(cannotHaveEmptyArray);
                    }
                }
            }
        }
        else if(type instanceof FptrType) {
            Type retType = ((FptrType) type).getReturnType();
            ArrayList<Type> argsType = ((FptrType) type).getArgumentsTypes();
            this.checkTypeValidation(retType, node);
            for(Type argType : argsType)
                this.checkTypeValidation(argType, node);
        }
        else {
            String className = ((ClassType)type).getClassName().getName();
            if(!this.classHierarchy.doesGraphContainNode(className)) {
                ClassNotDeclared exception = new ClassNotDeclared(node.getLine(), className);
                node.addError(exception);
                typeValidationNumberOfErrors += 1;
            }
        }
    }

    public boolean isLvalue(Expression expression) {
        boolean prevIsCatchErrorsActive = Node.isCatchErrorsActive;
        boolean prevSeenNoneLvalue = this.seenNoneLvalue;
        Node.isCatchErrorsActive = false;
        this.seenNoneLvalue = false;
        expression.accept(this);
        boolean isLvalue = !this.seenNoneLvalue;
        this.seenNoneLvalue = prevSeenNoneLvalue;
        Node.isCatchErrorsActive = prevIsCatchErrorsActive;
        return isLvalue;
    }

    @Override
    public Type visit(BinaryExpression binaryExpression) {
        this.seenNoneLvalue = true;
        BinaryOperator operator = binaryExpression.getBinaryOperator();
        Type firstType = binaryExpression.getFirstOperand().accept(this);
        Type secondType = binaryExpression.getSecondOperand().accept(this);
        if(operator == BinaryOperator.eq) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && secondType instanceof ArrayType) ||
                    (secondType instanceof NoType && firstType instanceof ArrayType)) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if(firstType instanceof IntType || firstType instanceof BoolType || firstType instanceof SetType)
                if(firstType.toString().equals(secondType.toString()))
                    return new BoolType();
            if((firstType instanceof ClassType && secondType instanceof NullType) ||
                    (firstType instanceof NullType && secondType instanceof ClassType) ||
                    (firstType instanceof ClassType && secondType instanceof ClassType &&
                            ((ClassType)firstType).getClassName().getName().equals(((ClassType)secondType).getClassName().getName()))) {
                return new BoolType();
            }
            if((firstType instanceof FptrType && secondType instanceof NullType) ||
                    (firstType instanceof NullType && secondType instanceof FptrType) ||
                    (firstType instanceof FptrType && secondType instanceof FptrType)) {
                return new BoolType();
            }
            if(firstType instanceof NullType && secondType instanceof NullType)
                return new BoolType();
        }
        if((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt)) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && !(secondType instanceof IntType)) ||
                    (secondType instanceof NoType && !(firstType instanceof IntType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if((firstType instanceof IntType) && (secondType instanceof IntType))
                return new BoolType();
        }
        if((operator == BinaryOperator.add) || (operator == BinaryOperator.sub) ||
                (operator == BinaryOperator.mult) || (operator == BinaryOperator.div)) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && !(secondType instanceof IntType)) ||
                    (secondType instanceof NoType && !(firstType instanceof IntType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if((firstType instanceof IntType) && (secondType instanceof IntType))
                return new IntType();
        }

        if((operator == BinaryOperator.or) || (operator == BinaryOperator.and)) {
            if(firstType instanceof NoType && secondType instanceof NoType)
                return new NoType();
            else if((firstType instanceof NoType && !(secondType instanceof BoolType)) ||
                    (secondType instanceof NoType && !(firstType instanceof BoolType))) {
                UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
                binaryExpression.addError(exception);
                return new NoType();
            }
            else if(firstType instanceof NoType || secondType instanceof NoType)
                return new NoType();
            if((firstType instanceof BoolType) && (secondType instanceof BoolType))
                return new BoolType();
        }
        if(operator == BinaryOperator.assign) {
            boolean isFirstLvalue = this.isLvalue(binaryExpression.getFirstOperand());
            if(!isFirstLvalue) {
                LeftSideNotLvalue exception = new LeftSideNotLvalue(binaryExpression.getLine());
                binaryExpression.addError(exception);
            }
            if(firstType instanceof NoType || secondType instanceof NoType) {
                return new NoType();
            }
            boolean isSubtype = this.isFirstSubTypeOfSecond(secondType, firstType);
            if(isSubtype) {
                if(isFirstLvalue)
                    return secondType;
                return new NoType();
            }
            UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
            binaryExpression.addError(exception);
            return new NoType();
        }
        UnsupportedOperandType exception = new UnsupportedOperandType(binaryExpression.getLine(), operator.name());
        binaryExpression.addError(exception);
        return new NoType();
    }

    @Override
    public Type visit(NewClassInstance newClassInstance) {
        this.seenNoneLvalue = true;
        String className = newClassInstance.getClassType().getClassName().getName();
        ArrayList<Type> newInstanceTypes = new ArrayList<>();
        for(Expression expression : newClassInstance.getArgs())
            newInstanceTypes.add(expression.accept(this));
        if(this.classHierarchy.doesGraphContainNode(className)) {
            try {
                ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + className, true);
                MethodDeclaration constructorDeclaration = classSymbolTableItem.getClassDeclaration().getConstructor();
                if (constructorDeclaration == null){
                    if(newClassInstance.getArgs().size() != 0){
                        ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                        newClassInstance.addError(exception);
                        return new NoType();
                    }
                    else
                        return newClassInstance.getClassType();
                }
                if (constructorDeclaration.getArgs().size() == 0 && newInstanceTypes.size() > 0){
                    ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                    newClassInstance.addError(exception);
                    return new NoType();
                }
                int i = 0;
                for(ArgPair argPair : constructorDeclaration.getArgs()) {
                    Type argType = argPair.getVariableDeclaration().getType();
                    if (argPair.getDefaultValue() != null) {
                        if (newInstanceTypes.size() <= i)
                            continue;
                        if (!this.isFirstSubTypeOfSecond(newInstanceTypes.get(i), argPair.getDefaultValue().accept(this))) {
                            ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                            newClassInstance.addError(exception);
                            return new NoType();
                        }
                    }
                    else {
                        if (newInstanceTypes.size() <= i || !this.isFirstSubTypeOfSecond(newInstanceTypes.get(i), argType)) {
                            ConstructorArgsNotMatchDefinition exception = new ConstructorArgsNotMatchDefinition(newClassInstance);
                            newClassInstance.addError(exception);
                            return new NoType();
                        }
                    }
                    i += 1;
                }
                return newClassInstance.getClassType();
            } catch (ItemNotFoundException ignored) {
                if(newInstanceTypes.size() != 0) {
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
            ClassNotDeclared exception = new ClassNotDeclared(newClassInstance.getLine(), className);
            newClassInstance.addError(exception);
            return new NoType();
        }
    }

    @Override
    public Type visit(UnaryExpression unaryExpression) {
        this.seenNoneLvalue = true;
        Type operandType = unaryExpression.getOperand().accept(this);
        UnaryOperator operator = unaryExpression.getOperator();
        if(operator == UnaryOperator.not) {
            if(operandType instanceof NoType)
                return new NoType();
            if(operandType instanceof BoolType)
                return operandType;
            UnsupportedOperandType exception = new UnsupportedOperandType(unaryExpression.getLine(), operator.name());
            unaryExpression.addError(exception);
            return new NoType();
        }
        else if(operator == UnaryOperator.minus) {
            if(operandType instanceof NoType)
                return new NoType();
            if(operandType instanceof IntType)
                return operandType;
            UnsupportedOperandType exception = new UnsupportedOperandType(unaryExpression.getLine(), operator.name());
            unaryExpression.addError(exception);
            return new NoType();
        }
        else {
            boolean isOperandLvalue = this.isLvalue(unaryExpression.getOperand());
            if(!isOperandLvalue) {
                IncDecOperandNotLvalue exception = new IncDecOperandNotLvalue(unaryExpression.getLine(), operator.name());
                unaryExpression.addError(exception);
            }
            if(operandType instanceof NoType)
                return new NoType();
            if(operandType instanceof IntType) {
                if(isOperandLvalue)
                    return operandType;
                return new NoType();
            }
            UnsupportedOperandType exception = new UnsupportedOperandType(unaryExpression.getLine(), operator.name());
            unaryExpression.addError(exception);
            return new NoType();
        }
    }

    @Override
    public Type visit(MethodCall methodCall) {
        this.seenNoneLvalue = true;
        Type instanceType = methodCall.getInstance().accept(this);
        boolean prevIsInMethodCallStmt = this.isInMethodCallStmt;
        this.setIsInMethodCallStmt(false);
        ArrayList<Type> argsTypes = new ArrayList<>();
        for(Expression arg : methodCall.getArgs()) {
            argsTypes.add(arg.accept(this));
        }
        this.setIsInMethodCallStmt(prevIsInMethodCallStmt);
        if(!(instanceType instanceof FptrType || instanceType instanceof NoType)) {
            CallOnNoneCallable exception = new CallOnNoneCallable(methodCall.getLine());
            methodCall.addError(exception);
            return new NoType();
        }
        else if(instanceType instanceof NoType) {
            return new NoType();
        }
        else {
            ArrayList<Type> actualArgsTypes = ((FptrType) instanceType).getArgumentsTypes();
            Type returnType = ((FptrType) instanceType).getReturnType();

            boolean hasError = false;
            if(!isInMethodCallStmt && (returnType instanceof VoidType)) {
                CantUseValueOfVoidMethod exception = new CantUseValueOfVoidMethod(methodCall.getLine());
                methodCall.addError(exception);
                hasError = true;
            }
            if (methodDeclaration == null){
                int i = 0;
                for(Type argType : actualArgsTypes) {
                    if (argsTypes.size()==0 || !this.isFirstSubTypeOfSecond(argsTypes.get(i), argType)) {
                        MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
                        methodCall.addError(exception);
                        return new NoType();
                    }
                    i++;
                }
                return returnType;
            }
            int i = 0;
            for(ArgPair argPair : methodDeclaration.getArgs()) {
                Type argType = argPair.getVariableDeclaration().getType();
                if (argPair.getDefaultValue() != null) {
                    if (argsTypes.size() <= i)
                        continue;
                    if (!this.isFirstSubTypeOfSecond(argsTypes.get(i), argPair.getDefaultValue().accept(this))) {
                        MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
                        methodCall.addError(exception);
                        return new NoType();
                    }
                }
                else {
                    if (argsTypes.size() <= i || !this.isFirstSubTypeOfSecond(argsTypes.get(i), argType)) {
                        MethodCallNotMatchDefinition exception = new MethodCallNotMatchDefinition(methodCall.getLine());
                        methodCall.addError(exception);
                        return new NoType();
                    }
                }
                i += 1;
            }
            return methodDeclaration.getReturnType();
        }
    }

    @Override
    public Type visit(Identifier identifier) {
        try {
            ClassSymbolTableItem classSymbolTableItem = (ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + this.currentClass.getClassName().getName(), true);
            SymbolTable classSymbolTable = classSymbolTableItem.getClassSymbolTable();
            MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem) classSymbolTable.getItem(MethodSymbolTableItem.START_KEY + this.currentMethod.getMethodName().getName(), true);
            SymbolTable methodSymbolTable = methodSymbolTableItem.getMethodSymbolTable();
            try {
                FieldSymbolTableItem fieldSymbolTableItem = (FieldSymbolTableItem) methodSymbolTable.getItem(FieldSymbolTableItem.START_KEY + identifier.getName(), true);
                return this.refineType(fieldSymbolTableItem.getType());
            } catch (ItemNotFoundException ex) {
                try {
                    LocalVariableSymbolTableItem localVariableSymbolTableItem = (LocalVariableSymbolTableItem) methodSymbolTable.getItem(LocalVariableSymbolTableItem.START_KEY + identifier.getName(), true);
                    return this.refineType(localVariableSymbolTableItem.getType());
                } catch (ItemNotFoundException e) {
                    GlobalVariableSymbolTableItem globalVariableSymbolTableItem = (GlobalVariableSymbolTableItem) SymbolTable.root.getItem(GlobalVariableSymbolTableItem.START_KEY + identifier.getName(), true);
                    return refineType(globalVariableSymbolTableItem.getType());

                }
            }

        } catch (ItemNotFoundException e) {
            VarNotDeclared exception = new VarNotDeclared(identifier.getLine(), identifier.getName());
            identifier.addError(exception);
            return new NoType();
        }
    }

    @Override
    public Type visit(ArrayAccessByIndex arrayAccessByIndex) {
        dimLvl = 0;
        Type instanceType = arrayAccessByIndex.getInstance().accept(this);
        boolean prevSeenNoneLvalue = this.seenNoneLvalue;
        Type indexType = arrayAccessByIndex.getIndex().accept(this);
        this.seenNoneLvalue = prevSeenNoneLvalue;
        boolean indexErrored = false;
        if(!(indexType instanceof NoType || indexType instanceof IntType)) {
            ArrayIndexNotInt exception = new ArrayIndexNotInt(arrayAccessByIndex.getLine());
            arrayAccessByIndex.addError(exception);
            indexErrored = true;
        }
        if(instanceType instanceof ArrayType) {
            if(indexErrored)
                return new NoType();
            dimLvl++;
            if (dimLvl == ((ArrayType) instanceType).getDimensions().size())
                return ((ArrayType) instanceType).getType();
            return instanceType;
        }
        else if(!(instanceType instanceof NoType)) {
            AccessByIndexOnNoneArray exception = new AccessByIndexOnNoneArray(arrayAccessByIndex.getLine());
            arrayAccessByIndex.addError(exception);
            return new NoType();
        }
        return new NoType();
    }

    @Override
    public Type visit(ObjectMemberAccess objectMemberAccess) {
        boolean prevSeenNoneLvalue = this.seenNoneLvalue;
        Type instanceType = objectMemberAccess.getInstance().accept(this);
        if(objectMemberAccess.getInstance() instanceof SelfClass)
            this.seenNoneLvalue = prevSeenNoneLvalue;
        String memberName = objectMemberAccess.getMemberName().getName();
        if(instanceType instanceof NoType)
            return new NoType();
        else if(instanceType instanceof ClassType) {
            String className = ((ClassType) instanceType).getClassName().getName();
            SymbolTable classSymbolTable;
            try {
                classSymbolTable = ((ClassSymbolTableItem) SymbolTable.root.getItem(ClassSymbolTableItem.START_KEY + className, true)).getClassSymbolTable();
            } catch (ItemNotFoundException classNotFound) {
                return new NoType();
            }
            try {
                FieldSymbolTableItem fieldSymbolTableItem = (FieldSymbolTableItem) classSymbolTable.getItem(FieldSymbolTableItem.START_KEY + memberName, true);
                return this.refineType(fieldSymbolTableItem.getType());
            } catch (ItemNotFoundException memberNotField) {
                try {
                    MethodSymbolTableItem methodSymbolTableItem = (MethodSymbolTableItem) classSymbolTable.getItem(MethodSymbolTableItem.START_KEY + memberName, true);
                    this.seenNoneLvalue = true;
                    this.methodDeclaration = methodSymbolTableItem.getMethodDeclaration();
                    return new FptrType(methodSymbolTableItem.getArgTypes(), methodSymbolTableItem.getReturnType());
                } catch (ItemNotFoundException memberNotFound) {
                    if(memberName.equals(className)) {
                        this.seenNoneLvalue = true;
                        return new FptrType(new ArrayList<>(), new NullType());
                    }
                    MemberNotAvailableInClass exception = new MemberNotAvailableInClass(objectMemberAccess.getLine(), memberName, className);
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
        for (var arg : setNew.getArgs()) {
            Type argType = arg.accept(this);
            if (!(argType instanceof IntType || argType instanceof NoType)) {
                NewInputNotSet exception = new NewInputNotSet(setNew.getLine());
                setNew.addError(exception);
                return new NoType();
            }
        }
        return new SetType();
    }

    @Override
    public Type visit(SetInclude setInclude) {
        Type argType = setInclude.getElementArg().accept(this);
        Type instanceType = setInclude.getSetArg().accept(this);
        if (!(argType instanceof IntType || argType instanceof NoType)) {
            SetIncludeInputNotInt exception = new SetIncludeInputNotInt(setInclude.getLine());
            setInclude.addError(exception);
            return new NoType();
        }
        if (!(instanceType instanceof SetType || instanceType instanceof NoType)) {
            CallOnNoneCallable exception = new CallOnNoneCallable(setInclude.getLine());
            setInclude.addError(exception);
            return new NoType();
        }



        return new BoolType();
    }

    @Override
    public Type visit(RangeExpression rangeExpression) {
        Type leftExpressionType = rangeExpression.getLeftExpression().accept(this);
        Type rightExpressionType = rangeExpression.getRightExpression().accept(this);
        if (!(leftExpressionType instanceof IntType || leftExpressionType instanceof NoType)) {
            EachRangeNotInt exception = new EachRangeNotInt(rangeExpression.getLine());
            rangeExpression.addError(exception);
            return new NoType();
        }
        else if (!(rightExpressionType instanceof IntType || rightExpressionType instanceof NoType)) {
            EachRangeNotInt exception = new EachRangeNotInt(rangeExpression.getLine());
            rangeExpression.addError(exception);
            return new NoType();
        }

        return new ArrayType(new IntType(), new ArrayList<Expression>(List.of(new IntValue(1))));
    }

    @Override
    public Type visit(TernaryExpression ternaryExpression) {
        Type conditionType = ternaryExpression.getCondition().accept(this);
        Type trueExpressionType = ternaryExpression.getTrueExpression().accept(this);
        Type falseExpressionType = ternaryExpression.getFalseExpression().accept(this);
        boolean hasError = false;
        if (!(conditionType instanceof BoolType || conditionType instanceof NoType)) {
            ConditionNotBool exception = new ConditionNotBool(ternaryExpression.getLine());
            ternaryExpression.addError(exception);
        }
        if (!isSameType(trueExpressionType, falseExpressionType)) {
            UnsupportedOperandType exception = new UnsupportedOperandType(ternaryExpression.getLine(), TernaryOperator.ternary.name());
            ternaryExpression.addError(exception);
            hasError = true;
        }
        if (hasError)
            return new NoType();

        return trueExpressionType;
    }

    @Override
    public Type visit(IntValue intValue) {
        this.seenNoneLvalue = true;
        return new IntType();
    }

    @Override
    public Type visit(BoolValue boolValue) {
        this.seenNoneLvalue = true;
        return new BoolType();
    }

    @Override
    public Type visit(SelfClass selfClass) {
        this.seenNoneLvalue = true;
        return new ClassType(currentClass.getClassName());
    }

    @Override
    public Type visit(SetValue setValue) {
        this.seenNoneLvalue = true;
        return new SetType();
    }

    @Override
    public Type visit(NullValue nullValue) {
        this.seenNoneLvalue = true;
        return new NullType();
    }
}
