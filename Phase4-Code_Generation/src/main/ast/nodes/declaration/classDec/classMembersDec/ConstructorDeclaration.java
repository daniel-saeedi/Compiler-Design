package main.ast.nodes.declaration.classDec.classMembersDec;

import main.ast.nodes.expression.Identifier;
import main.ast.types.NullType;
import main.ast.types.Type;
import main.visitor.IVisitor;

//line -> INITIALIZE
public class ConstructorDeclaration extends MethodDeclaration{

    public ConstructorDeclaration() {
        super(new Identifier("initialize"), new NullType(), false);
    }

    @Override
    public Identifier getMethodName() {
        return this.methodName;
    }

    @Override
    public String toString() {
        return "ConstructorDeclaration";
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
