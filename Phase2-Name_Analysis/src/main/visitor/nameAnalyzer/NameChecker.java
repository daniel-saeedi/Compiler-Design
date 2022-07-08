package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.classDec.*;
import main.ast.nodes.declaration.classDec.classMembersDec.*;
import main.ast.nodes.declaration.variableDec.*;
import main.compileError.*;
import main.compileError.nameError.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.items.*;
import main.symbolTable.exceptions.*;
import main.symbolTable.utils.graph.Graph;
import main.visitor.Visitor;

public class NameChecker extends Visitor<Void> {
    private String curClassName;
    private Graph<String> classHierachy;
    Program root;

    public NameChecker(Graph<String> classHierachy) {
        this.classHierachy = classHierachy;
    }

    private SymbolTable getCurrentClassST() {
        try {
            ClassSymbolTableItem classSTI = (ClassSymbolTableItem) SymbolTable.root.
                    getItem(ClassSymbolTableItem.START_KEY + this.curClassName, true);
            return classSTI.getClassSymbolTable();
        } catch (ItemNotFoundException e) {}
        return null;
    }

    @Override
    public Void visit(Program program) {
        this.root = program;

        for (VariableDeclaration varDec : program.getGlobalVariables()) {
            varDec.accept(this);
        }

        for (ClassDeclaration classDec : program.getClasses()) {
            this.curClassName = classDec.getClassName().getName();
            classDec.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDec) {
        if (classDec.getParentClassName() != null) {
            String parentClassName = classDec.getParentClassName().getName();
            String className = classDec.getClassName().getName();
            if (this.classHierachy.isSecondNodeAncestorOf(parentClassName, className)) {
                ClassInCyclicInheritance exception = new ClassInCyclicInheritance(classDec.getLine(), className);
                classDec.addError(exception);
            }
        }

        for (FieldDeclaration fieldDec : classDec.getFields()) {
            fieldDec.accept(this);
        }

        if (classDec.getConstructor() != null) {
            classDec.getConstructor().accept(this);
        }

        for (MethodDeclaration methodDec : classDec.getMethods()) {
            methodDec.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDec) {
        String methodName = methodDec.getMethodName().getName();

        // handling method redefinition in parent class
        if (!methodDec.hasError()) {
            try {
                getCurrentClassST().getItem(MethodSymbolTableItem.START_KEY + methodName, false);
                MethodRedefinition exception = new MethodRedefinition(methodDec.getLine(), methodName);
                methodDec.addError(exception);
            } catch (ItemNotFoundException e) { }
        }

        // handling method conflict with field name in class
        try {
            getCurrentClassST().getItem(FieldSymbolTableItem.START_KEY + methodName, true);
            MethodNameConflictWithField exception = new MethodNameConflictWithField(methodDec.getLine(), methodName);
            methodDec.addError(exception);
        } catch (ItemNotFoundException e) {}

        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDec) {
        if(!fieldDec.hasError()) {
            try {
                String fieldName = fieldDec.getVarDeclaration().getVarName().getName();
                getCurrentClassST().getItem(FieldSymbolTableItem.START_KEY + fieldName, false);
                FieldRedefinition exception = new FieldRedefinition(fieldDec.getLine(), fieldName);
                fieldDec.addError(exception);
            } catch (ItemNotFoundException e) {}
        }

        return null;
    }


}
