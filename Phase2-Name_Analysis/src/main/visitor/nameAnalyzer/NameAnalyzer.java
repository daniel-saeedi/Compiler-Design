package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.classDec.ClassDeclaration;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.*;
import main.symbolTable.items.*;
import main.symbolTable.items.*;

import main.symbolTable.utils.graph.Graph;
import main.symbolTable.utils.graph.exceptions.*;
import main.visitor.Visitor;

import java.lang.invoke.MethodType;
import java.util.ArrayList;

public class NameAnalyzer{

    private Program program;
    private Graph<String> classHierarchy = new Graph<>();

    public NameAnalyzer(Program program) {
        this.program = program;
    }
    public void analyze() {
        NameCollector nameCollector = new NameCollector();
        this.program.accept(nameCollector);
        this.linkParentSymbolTables();
        NameChecker nameChecker = new NameChecker(classHierarchy);
        this.program.accept(nameChecker);
    }

    private void linkParentSymbolTables() {
        Graph<String> classHierarchy = new Graph<>();
        for (ClassDeclaration classDec : this.program.getClasses()) {
            String className = classDec.getClassName().getName();
            try {
                classHierarchy.addNode(className);
            } catch (NodeAlreadyExistsException ignored) { }
            if (classDec.getParentClassName() != null) {
                String parentName = classDec.getParentClassName().getName();
                try {
                    classHierarchy.addNodeAsParentOf(className, parentName);
                    ClassSymbolTableItem parentSTI = (ClassSymbolTableItem)SymbolTable.root.
                            getItem(ClassSymbolTableItem.START_KEY + parentName, true);
                    ClassSymbolTableItem curClassSTI = (ClassSymbolTableItem)SymbolTable.root.
                            getItem(ClassSymbolTableItem.START_KEY + className, true);
                    curClassSTI.getClassSymbolTable().pre = parentSTI.getClassSymbolTable();
                } catch (ItemNotFoundException |GraphDoesNotContainNodeException ignore) {}
            }
        }
        this.classHierarchy = classHierarchy;
    }

    public Graph<String> getClassHierarchy() {
        return classHierarchy;
    }
}