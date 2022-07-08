package main.symbolTable.items;


import main.ast.nodes.declaration.classDec.classMembersDec.MethodDeclaration;
import main.ast.types.Type;
import main.symbolTable.SymbolTable;
import main.util.ArgPair;

import java.util.ArrayList;

public class MethodSymbolTableItem extends SymbolTableItem {
    public static final String START_KEY = "Method_";
    private MethodDeclaration methodDeclaration;
    private Type returnType;
    private ArrayList<Type> argTypes = new ArrayList<>();
    public int non_default_args = 0;
    private SymbolTable methodSymbolTable;

    public MethodSymbolTableItem(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
        this.returnType = methodDeclaration.getReturnType();
        for(ArgPair argPair : methodDeclaration.getArgs()) {
            this.argTypes.add(argPair.getVariableDeclaration().getType());

            if (argPair.getDefaultValue() == null) {
                this.non_default_args += 1;
            }

        }
        this.name = methodDeclaration.getMethodName().getName();
    }

    public MethodDeclaration getMethodDeclaration() {
        return methodDeclaration;
    }

    public void setMethodDeclaration(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public ArrayList<Type> getArgTypes() {
        return argTypes;
    }

    public void setArgTypes(ArrayList<Type> argTypes) {
        this.argTypes = argTypes;
    }

    public SymbolTable getMethodSymbolTable() {
        return methodSymbolTable;
    }

    public void setMethodSymbolTable(SymbolTable methodSymbolTable) {
        this.methodSymbolTable = methodSymbolTable;
    }

    @Override
    public String getKey() {
        return START_KEY + this.name;
    }

}
