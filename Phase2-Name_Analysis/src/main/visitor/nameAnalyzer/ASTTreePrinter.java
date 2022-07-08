package main.visitor.nameAnalyzer;

import main.ast.nodes.*;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.ConstructorDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.FieldDeclaration;
import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.values.NullValue;
import main.ast.nodes.expression.values.SetValue;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.nodes.statement.set.*;
import main.visitor.*;

public class ASTTreePrinter extends Visitor<Void> {
    public void messagePrinter(int line, String message){
        System.out.println("Line " + line + ": " + message);
    }

    @Override
    public Void visit(Program program) {
        messagePrinter(program.getLine(), program.toString());
        for (VariableDeclaration variableDeclaration : program.getGlobalVariables())
            variableDeclaration.accept(this);
        for (ClassDeclaration classDeclaration: program.getClasses())
            classDeclaration.accept(this);
        return null;
    }
    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        //todo: done
        messagePrinter(classDeclaration.getLine(), classDeclaration.toString());
        classDeclaration.getClassName().accept(this);
        if(classDeclaration.getParentClassName() != null)
            classDeclaration.getParentClassName().accept(this);
        if(classDeclaration.getConstructor() != null)
            classDeclaration.getConstructor().accept(this);
        for(MethodDeclaration md : classDeclaration.getMethods()) {
            md.accept(this);
        }

        for(FieldDeclaration fd : classDeclaration.getFields()) {
            fd.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        //todo: done
        messagePrinter(constructorDeclaration.getLine(), constructorDeclaration.toString());

        if (constructorDeclaration.getArgs() != null)
            for(VariableDeclaration arg : constructorDeclaration.getArgs()) {
                arg.accept(this);
            }

        if (constructorDeclaration.getLocalVars() != null)
            for(VariableDeclaration localVar : constructorDeclaration.getLocalVars()) {
                localVar.accept(this);
            }

        if (constructorDeclaration.getBody() != null)
            for(Statement body : constructorDeclaration.getBody()) {
                body.accept(this);
            }
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDeclaration) {
        messagePrinter(methodDeclaration.getLine(), methodDeclaration.toString());
        methodDeclaration.getMethodName().accept(this);

        for(VariableDeclaration arg : methodDeclaration.getArgs()) {
            arg.accept(this);
        }

        for(VariableDeclaration localVar : methodDeclaration.getLocalVars()) {
            localVar.accept(this);
        }

        for(Statement body : methodDeclaration.getBody()) {
            body.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDeclaration) {
        //todo: done
        messagePrinter(fieldDeclaration.getLine(), fieldDeclaration.toString());
        fieldDeclaration.getVarDeclaration().accept(this);
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDeclaration) {
        //todo: done
        messagePrinter(varDeclaration.getLine(), varDeclaration.toString());
        varDeclaration.getVarName().accept(this);
        return null;
    }

    @Override
    public Void visit(AssignmentStmt assignmentStmt) {
        messagePrinter(assignmentStmt.getLine(), assignmentStmt.toString());

        assignmentStmt.getlValue().accept(this);
        assignmentStmt.getrValue().accept(this);

        return null;
    }

    @Override
    public Void visit(BlockStmt blockStmt) {
        //todo
        messagePrinter(blockStmt.getLine(), blockStmt.toString());
        for(Statement stmt : blockStmt.getStatements()) {
            stmt.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ConditionalStmt conditionalStmt) {
        //todo: done
        messagePrinter(conditionalStmt.getLine(), conditionalStmt.toString());
        conditionalStmt.getCondition().accept(this);
        conditionalStmt.getThenBody().accept(this);

        if (conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);

        if (conditionalStmt.getElsif() != null)
            for(ElsifStmt stmt : conditionalStmt.getElsif()) {
                stmt.accept(this);
            }
        return null;
    }

    @Override
    public Void visit(ElsifStmt elsifStmt) {
        //todo
        messagePrinter(elsifStmt.getLine(), elsifStmt.toString());
        elsifStmt.getCondition().accept(this);
        elsifStmt.getThenBody().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCallStmt methodCallStmt) {
        //todo
        String[] p = methodCallStmt.getMethodCall().getInstance().toString().split("_");
        if (!p[0].equals("NewClassInstance"))
                messagePrinter(methodCallStmt.getLine(), methodCallStmt.toString());
        methodCallStmt.getMethodCall().accept(this);
        return null;
    }

    @Override
    public Void visit(PrintStmt print) {
        //todo
        messagePrinter(print.getLine(), print.toString());
        print.getArg().accept(this);
        return null;
    }

    @Override
    public Void visit(ReturnStmt returnStmt) {
        //todo
        messagePrinter(returnStmt.getLine(), returnStmt.toString());
        returnStmt.getReturnedExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(EachStmt eachStmt) {
        //todo
        messagePrinter(eachStmt.getLine(), eachStmt.toString());
        eachStmt.getVariable().accept(this);
        eachStmt.getList().accept(this);
        eachStmt.getBody().accept(this);

        return null;
    }

    @Override
    public Void visit(BinaryExpression binaryExpression) {
        //todo
        messagePrinter(binaryExpression.getLine(), binaryExpression.toString());
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpression unaryExpression) {
        //todo
        messagePrinter(unaryExpression.getLine(), unaryExpression.toString());
        unaryExpression.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(TernaryExpression ternaryExpression) {
        //todo
        messagePrinter(ternaryExpression.getLine(), ternaryExpression.toString());
        ternaryExpression.getCondition().accept(this);
        ternaryExpression.getTrueExpression().accept(this);
        ternaryExpression.getFalseExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(ObjectMemberAccess objectOrListMemberAccess) {
        //todo
        messagePrinter(objectOrListMemberAccess.getLine(), objectOrListMemberAccess.toString());
        objectOrListMemberAccess.getInstance().accept(this);
        objectOrListMemberAccess.getMemberName().accept(this);
        return null;
    }

    @Override
    public Void visit(Identifier identifier) {
        //todo
        messagePrinter(identifier.getLine(), identifier.toString());
        return null;
    }

    @Override
    public Void visit(ArrayAccessByIndex arrayAccessByIndex) {
        //todo
        messagePrinter(arrayAccessByIndex.getLine(), arrayAccessByIndex.toString());
        arrayAccessByIndex.getInstance().accept(this);
        arrayAccessByIndex.getIndex().accept(this);
        return null;
    }

    @Override
    public Void visit(MethodCall methodCall) {
        //todo
        String[] p = methodCall.getInstance().toString().split("_");
        if (!p[0].equals("NewClassInstance"))
            messagePrinter(methodCall.getLine(), methodCall.toString());
        methodCall.getInstance().accept(this);
        for(Expression arg : methodCall.getArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(NewClassInstance newClassInstance) {
        //todo
        messagePrinter(newClassInstance.getLine(), newClassInstance.toString());
        for(Expression arg : newClassInstance.getArgs()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(SelfClass selfClass) {
        //todo
        messagePrinter(selfClass.getLine(), selfClass.toString());
        return null;
    }

    @Override
    public Void visit(NullValue nullValue) {
        //todo
        messagePrinter(nullValue.getLine(), nullValue.toString());
        return null;
    }

    @Override
    public Void visit(IntValue intValue) {
        //todo
        messagePrinter(intValue.getLine(), intValue.toString());
        return null;
    }

    @Override
    public Void visit(BoolValue boolValue) {
        //todo
        messagePrinter(boolValue.getLine(), boolValue.toString());
        return null;
    }

    @Override
    public Void visit(SetInclude setAdd) {
        //todo
        messagePrinter(setAdd.getLine(), setAdd.toString());
        setAdd.getSetArg().accept(this);
        setAdd.getElementArg().accept(this);
        return null;
    }

    @Override
    public Void visit(SetValue setValue) {
        //todo
        messagePrinter(setValue.getLine(), setValue.toString());
        return null;
    }

    @Override
    public Void visit(SetMerge setMerge) {
        //todo
        messagePrinter(setMerge.getLine(), setMerge.toString());
        setMerge.getSetArg().accept(this);
        for(Expression arg : setMerge.getElementArgs()) {
            arg.accept(this);
        }
        return null;
    }


    @Override
    public Void visit(SetDelete setDelete) {
        //todo
        messagePrinter(setDelete.getLine(), setDelete.toString());
        setDelete.getSetArg().accept(this);
        setDelete.getElementArg().accept(this);
        return null;
    }

    @Override
    public Void visit(SetAdd setAdd) {
        //todo
        messagePrinter(setAdd.getLine(), setAdd.toString());
        setAdd.getSetArg().accept(this);
        setAdd.getElementArg().accept(this);
        return null;
    }

    @Override
    public Void visit(RangeExpression rangeExpression) {
        //todo
        messagePrinter(rangeExpression.getLine(), rangeExpression.toString());
        rangeExpression.getLeftExpression().accept(this);
        rangeExpression.getRightExpression().accept(this);
        return null;
    }
}
