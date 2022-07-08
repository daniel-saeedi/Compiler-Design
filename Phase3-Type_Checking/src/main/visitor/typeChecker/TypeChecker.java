package main.visitor.typeChecker;

import com.sun.tools.javac.Main;
import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.*;
import main.ast.types.NoType;
import main.ast.types.NullType;
import main.ast.types.Type;
import main.ast.types.array.ArrayType;
import main.ast.types.primitives.BoolType;
import main.ast.types.primitives.ClassType;
import main.ast.types.primitives.IntType;
import main.ast.types.primitives.VoidType;
import main.ast.types.set.SetType;
import main.compileError.typeError.*;
import main.symbolTable.utils.graph.Graph;
import main.visitor.*;
import main.util.ArgPair;

import javax.print.attribute.standard.NumberUp;
import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.Set;

public class TypeChecker extends Visitor<Void> {
    private Graph<String> classHierarchy;
    private ExpressionTypeChecker expressionTypeChecker;
    private ClassDeclaration curr_class;
    private MethodDeclaration curr_method;
    private boolean mainDeclared;
    private boolean hasReturn = false;

    public TypeChecker(Graph<String> classHierarchy){
        this.classHierarchy = classHierarchy;
        this.expressionTypeChecker = new ExpressionTypeChecker(classHierarchy);
    }

    @Override
    public Void visit(Program program) {
        this.mainDeclared = false;
        for (ClassDeclaration classDeclaration : program.getClasses()) {
            if (classDeclaration.getClassName().getName().equals("Main"))
                this.mainDeclared = true;
            this.expressionTypeChecker.setCurrClass(classDeclaration);
            this.curr_class = classDeclaration;
            classDeclaration.accept(this);
        }
        if (!this.mainDeclared) {
            NoMainClass exception = new NoMainClass();
            program.addError(exception);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        if (classDeclaration.getParentClassName() != null) {
            this.expressionTypeChecker.checkNode(classDeclaration, new ClassType(classDeclaration.getParentClassName()));
            if (classDeclaration.getClassName().getName().equals("Main")) {
                MainClassCantInherit exception = new MainClassCantInherit(classDeclaration.getLine());
                classDeclaration.addError(exception);
            }
            if (classDeclaration.getParentClassName().getName().equals("Main")) {
                CannotExtendFromMainClass exception = new CannotExtendFromMainClass(classDeclaration.getLine());
                classDeclaration.addError(exception);
            }
        }
        for (FieldDeclaration fieldDeclaration : classDeclaration.getFields()) {
            fieldDeclaration.accept(this);
        }
        if (classDeclaration.getConstructor() != null) {
            this.expressionTypeChecker.setCurrMethod(classDeclaration.getConstructor());
            this.curr_method = classDeclaration.getConstructor();
            classDeclaration.getConstructor().accept(this);
        }
        else if (classDeclaration.getClassName().getName().equals("Main")) {
            NoConstructorInMainClass exception = new NoConstructorInMainClass(classDeclaration);
            classDeclaration.addError(exception);
        }
        for (MethodDeclaration methodDeclaration : classDeclaration.getMethods()) {
            this.expressionTypeChecker.setCurrMethod(methodDeclaration);
            this.curr_method = methodDeclaration;
            methodDeclaration.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        constructorDeclaration.setReturnType(new NullType());
        if (this.curr_class.getClassName().getName().equals("Main")) {
            if (constructorDeclaration.getArgs().size() != 0) {
                MainConstructorCantHaveArgs exception = new MainConstructorCantHaveArgs(constructorDeclaration.getLine());
                constructorDeclaration.addError(exception);
            }
        }
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        this.hasReturn = false;
        this.expressionTypeChecker.checkNode(methodDeclaration, methodDeclaration.getReturnType());
        for (ArgPair argPair : methodDeclaration.getArgs()) {
            if (argPair.getDefaultValue() != null) {
                Type valType = argPair.getDefaultValue().accept(this.expressionTypeChecker);
                if (!this.expressionTypeChecker.isAllSameType(argPair.getVariableDeclaration().getType(), valType)) {
                    UnsupportedOperandType exception = new UnsupportedOperandType(argPair.getVariableDeclaration().getLine(), BinaryOperator.assign.name());
                    argPair.getVariableDeclaration().addError(exception);
                }
            }
            else
                argPair.getVariableDeclaration().accept(this);
        }

        for (VariableDeclaration variableDeclaration : methodDeclaration.getLocalVars())
            variableDeclaration.accept(this);

        for (Statement statement : methodDeclaration.getBody()) {
            if (this.hasReturn) {
                statement.addError(new UnreachableStatements(statement));
                return null;
            }
            statement.accept(this);
        }
        if (!this.hasReturn && !(methodDeclaration.getReturnType() instanceof VoidType) &&
                !(methodDeclaration.getReturnType() instanceof NullType)) {
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
        this.expressionTypeChecker.checkNode(varDeclaration, varDeclaration.getType());
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        Type lType = assignmentStmt.getlValue().accept(this.expressionTypeChecker);
        Type rType = assignmentStmt.getrValue().accept(this.expressionTypeChecker);
        if (!this.expressionTypeChecker.isLeftVal(assignmentStmt.getlValue())) {
            assignmentStmt.addError(new LeftSideNotLvalue(assignmentStmt.getLine()));
        }

        if (lType instanceof NoType)
            return null;
        if (!this.expressionTypeChecker.isAllSameType(rType, lType)) {
            int line = assignmentStmt.getLine();
            UnsupportedOperandType exception = new UnsupportedOperandType(line, BinaryOperator.assign.toString());
            assignmentStmt.addError(exception);
        }

        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        for (Statement statement : blockStmt.getStatements()) {
            if (this.hasReturn) {
                statement.addError(new UnreachableStatements(statement));
                return null;
            }
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        boolean ifHasReturn = false, elifHasReturn = false, elseHasReturn = false, curReturnState;
        curReturnState = this.hasReturn;
        Type condType = conditionalStmt.getCondition().accept(this.expressionTypeChecker);
        if (!(condType instanceof BoolType || condType instanceof NoType)) {
            conditionalStmt.addError(new ConditionNotBool(conditionalStmt.getLine()));
        }

        if (conditionalStmt.getThenBody() != null) {
            this.hasReturn = false;
            conditionalStmt.getThenBody().accept(this);
            ifHasReturn = this.hasReturn;
        }
        for (ElsifStmt elsifStmt : conditionalStmt.getElsif()) {
            this.hasReturn = false;
            elsifStmt.accept(this);
            elifHasReturn = this.hasReturn;
        }
        if (conditionalStmt.getElseBody() != null) {
            this.hasReturn = false;
            conditionalStmt.getElseBody().accept(this);
            elseHasReturn = this.hasReturn;
        }
        if (curReturnState)
            this.hasReturn = true;
        else
            this.hasReturn = (ifHasReturn && elseHasReturn);
        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        Type condType = elsifStmt.getCondition().accept(this.expressionTypeChecker);
        if (!(condType instanceof BoolType || condType instanceof NoType)) {
            elsifStmt.addError(new ConditionNotBool(elsifStmt.getLine()));
        }
        if (elsifStmt.getThenBody() != null)
            elsifStmt.getThenBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        this.expressionTypeChecker.setIsInMethodCallStmnt(true);
        methodCallStmt.getMethodCall().accept(this.expressionTypeChecker);
        this.expressionTypeChecker.setIsInMethodCallStmnt(false);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        Type argType = print.getArg().accept(expressionTypeChecker);
        if(!(argType instanceof IntType || argType instanceof BoolType || argType instanceof NoType || argType instanceof SetType)) {
            print.addError(new UnsupportedTypeForPrint(print.getLine()));
        }
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        this.hasReturn = true;
        Type retType = returnStmt.getReturnedExpr().accept(this.expressionTypeChecker);
        Type methodRetType = this.curr_method.getReturnType();
        if ( methodRetType instanceof VoidType) {
            returnStmt.addError(new VoidMethodHasReturn(this.curr_method));
            return null;
        }
        if (!this.expressionTypeChecker.isAllSameType(retType, methodRetType))
                returnStmt.addError(new ReturnValueNotMatchMethodReturnType(returnStmt));
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        boolean nonIterable = false;
        Type varType = eachStmt.getVariable().accept(this.expressionTypeChecker);
        Type iterableType = eachStmt.getList().accept(this.expressionTypeChecker);
        if (!(iterableType instanceof ArrayType || iterableType instanceof SetType || iterableType instanceof NoType)) {
            EachCantIterateNoneArray exception = new EachCantIterateNoneArray(eachStmt.getLine());
            eachStmt.addError(exception);
            nonIterable = true;
        }
        if (!nonIterable && !this.expressionTypeChecker.isAllSameType(varType, ((ArrayType)iterableType).getType())) {
            EachVarNotMatchList exception = new EachVarNotMatchList(eachStmt);
            eachStmt.addError(exception);
//            return null;
        }
        eachStmt.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(SetMerge setMerge) {
        for (Expression expression : setMerge.getElementArgs()) {
            Type argType = expression.accept(this.expressionTypeChecker);
            if (!(argType instanceof SetType || argType instanceof IntType))
                setMerge.addError(new MergeInputNotSet(setMerge.getLine()));
        }
        return null;
    }

    @Override
    public Void visit(SetAdd setAdd) {
        this.expressionTypeChecker.setIsInMethodCallStmnt(true);
        setAdd.getElementArg().accept(this.expressionTypeChecker);
        this.expressionTypeChecker.setIsInMethodCallStmnt(false);
        return null;
    }

    @Override
    public Void visit(SetInclude setInclude) {
        this.expressionTypeChecker.setIsInMethodCallStmnt(true);
        setInclude.getElementArg().accept(this.expressionTypeChecker);
        this.expressionTypeChecker.setIsInMethodCallStmnt(false);
        return null;
    }

}
