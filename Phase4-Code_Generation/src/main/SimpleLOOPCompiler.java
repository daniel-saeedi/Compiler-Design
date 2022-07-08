package main;

import main.visitor.codeGenerator.CodeGenerator;
import main.visitor.nameAnalyzer.*;
import main.visitor.typeChecker.*;
import main.visitor.utils.*;
import parsers.*;
import main.ast.nodes.Program;
import org.antlr.v4.runtime.*;

import java.io.*;

public class SimpleLOOPCompiler {
    public void compile(CharStream textStream) {
        System.out.println("\n--------------------------Compiling--------------------------");
        SimpleLOOPLexer cmmLexer = new SimpleLOOPLexer(textStream);
        CommonTokenStream tokenStream = new CommonTokenStream(cmmLexer);
        SimpleLOOPParser cmmParser = new SimpleLOOPParser(tokenStream);
        Program program = cmmParser.simpleLOOP().simpleLOOPProgram;
        ErrorReporter errorReporter = new ErrorReporter();

        NameAnalyzer nameAnalyser = new NameAnalyzer(program);
        nameAnalyser.analyze();

        TypeChecker typeChecker = new TypeChecker(nameAnalyser.getClassHierarchy());
        program.accept(typeChecker);


        CodeGenerator codeGenerator = new CodeGenerator(nameAnalyser.getClassHierarchy());
        program.accept(codeGenerator);

        int numberOfErrors = program.accept(errorReporter);

        if(numberOfErrors == 0)
            System.out.println("Compilation Successful");
        else
            System.exit(1);


        runJasminFiles();

    }

    private void runJasminFiles() {
        try {
            System.out.println("\n-------------------Generating Class Files-------------------");
            File dir = new File("./output");
            Process process = Runtime.getRuntime().exec("java -jar jasmin.jar *.j", null, dir);
            printResults(process.getInputStream());
            printResults(process.getErrorStream());
            System.out.println("\n---------------------------Output---------------------------");
            process = Runtime.getRuntime().exec("java Main", null, dir);
            printResults(process.getInputStream());
            printResults(process.getErrorStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printResults(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        try {
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
