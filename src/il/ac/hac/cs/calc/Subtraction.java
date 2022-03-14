package il.ac.hac.cs.calc;

public class Subtraction extends BinaryOperation {

    public Subtraction(Statement left, Statement right) {
        super(left, right);
    }

    @Override
    protected double innerEvaluate(Statement left, Statement right) {
        return left.evaluate() - right.evaluate();
    }
}
