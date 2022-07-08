package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.*;
import main.ast.nodes.declaration.classDec.*;
import main.ast.nodes.declaration.classDec.classMembersDec.*;
import main.ast.nodes.declaration.variableDec.VariableDeclaration;
import main.ast.nodes.expression.Identifier;
import main.symbolTable.SymbolTable;
import main.symbolTable.items.*;
import main.symbolTable.exceptions.*;
import main.compileError.*;
import main.compileError.nameError.*;
import main.visitor.Visitor;

import java.lang.invoke.MethodType;
import java.util.ArrayList;

public class NameCollector extends Visitor<Void> {

    private int newId = 1;
    private boolean isGlobal = false;

    private ArrayList<VariableDeclaration> globalVars = new ArrayList<>();

    @Override
    public Void visit(Program program) {
        SymbolTable.push(new SymbolTable());
        SymbolTable.root = SymbolTable.top;
        for (VariableDeclaration varDec : program.getGlobalVariables()) {
            isGlobal = true;
            varDec.accept(this);
            isGlobal = false;
        }
        for (ClassDeclaration classDec : program.getClasses()) {
            classDec.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ClassDeclaration classDeclaration) {
        ClassSymbolTableItem classSymbolTableItem = new ClassSymbolTableItem(classDeclaration);
        SymbolTable.push(new SymbolTable(SymbolTable.top));
        classSymbolTableItem.setClassSymbolTable(SymbolTable.top);
        try {
            SymbolTable.root.put(classSymbolTableItem);
        } catch (ItemAlreadyExistsException e) {
            ClassRedefinition exception = new ClassRedefinition(classDeclaration.getLine(), classDeclaration.getClassName().getName());
            classDeclaration.addError(exception);
            String newName = newId + "@";
            newId += 1;
            classDeclaration.getClassName().setName(newName);
            ClassSymbolTableItem newClassSTI = new ClassSymbolTableItem(classDeclaration);
            newClassSTI.setClassSymbolTable(SymbolTable.top);
            try {
                SymbolTable.root.put(newClassSTI);
            } catch (ItemAlreadyExistsException ignored) { }
        }

        for (FieldDeclaration fieldDec : classDeclaration.getFields()) {
            fieldDec.accept(this);
        }

        if (classDeclaration.getConstructor() != null) {
            classDeclaration.getConstructor().accept(this);
        }

        for (MethodDeclaration methodDec : classDeclaration.getMethods()) {
            methodDec.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(ConstructorDeclaration constructorDeclaration) {
        this.visit((MethodDeclaration) constructorDeclaration);
        return null;
    }

    @Override
    public Void visit(MethodDeclaration methodDec) {
        MethodSymbolTableItem methodSTI = new MethodSymbolTableItem(methodDec);
        SymbolTable methodST = new SymbolTable(SymbolTable.top);
        methodSTI.setMethodSymbolTable(methodST);
        try {
            SymbolTable.top.put(methodSTI);
        } catch (ItemAlreadyExistsException e) {
            MethodRedefinition exception = new MethodRedefinition(methodDec.getLine(), methodDec.getMethodName().getName());
            methodDec.addError(exception);
        }
        SymbolTable.push(methodST);
        for (VariableDeclaration varDec : methodDec.getArgs()) {
            varDec.accept(this);
        }

        for (VariableDeclaration varDec : methodDec.getLocalVars()) {
            varDec.accept(this);
        }
        SymbolTable.pop();
        return null;
    }

    @Override
    public Void visit(VariableDeclaration varDec) {
        if (isGlobal) {
            GlobalVariableSymbolTableItem globalVarSTI = new GlobalVariableSymbolTableItem(varDec);
            try {
                SymbolTable.top.put(globalVarSTI);
                globalVars.add(varDec);
            } catch (ItemAlreadyExistsException e) {
                GlobalVarRedefinition exception = new GlobalVarRedefinition(varDec.getLine(), varDec.getVarName().getName());
                varDec.addError(exception);
                String newName = newId + "@";
               newId += 1;
                varDec.getVarName().setName(newName);
                GlobalVariableSymbolTableItem newGlobalSTI = new GlobalVariableSymbolTableItem(varDec);
                try {
                    SymbolTable.top.put(newGlobalSTI);
                } catch (ItemAlreadyExistsException ignored) {}
            }
            return null;
        }
        LocalVariableSymbolTableItem localVarSTI = new LocalVariableSymbolTableItem(varDec);

        for (VariableDeclaration gVar : globalVars) {
            if (gVar.getVarName().getName().equals(varDec.getVarName().getName()) ){
                LocalVarConflictWithGlobalVar exception = new LocalVarConflictWithGlobalVar(varDec.getLine(), varDec.getVarName().getName());
                varDec.addError(exception);
                return null;
            }
        }

        try {
            SymbolTable.top.put(localVarSTI);
        } catch (ItemAlreadyExistsException e) {
            LocalVarRedefinition exception = new LocalVarRedefinition(varDec.getLine(), varDec.getVarName().getName());
            varDec.addError(exception);
        }

        return null;
    }

    @Override
    public Void visit(FieldDeclaration fieldDec) {
        FieldSymbolTableItem fieldSTI = new FieldSymbolTableItem(fieldDec);
        try {
            SymbolTable.top.put(fieldSTI);
        } catch (ItemAlreadyExistsException e) {
            String fieldName = fieldDec.getVarDeclaration().getVarName().getName();
            FieldRedefinition exception = new FieldRedefinition(fieldDec.getLine(), fieldName);
            fieldDec.addError(exception);
        }
        return null;
    }

}
