package il.ac.hac.cs.calc;

public class Multiplication extends BinaryOperation {
    public Multiplication(Statement left, Statement right) {
        super(left, right);
    }

    @Override
    protected double innerEvaluate(Statement left, Statement right) {
        return left.evaluate() * right.evaluate();
    }
}
