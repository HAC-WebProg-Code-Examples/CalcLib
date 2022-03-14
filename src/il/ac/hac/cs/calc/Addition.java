package il.ac.hac.cs.calc;

public class Addition extends BinaryOperation {

    public Addition(Statement left, Statement right) {
        super(left, right);
    }

    @Override
    protected double innerEvaluate(Statement left, Statement right) {
        return left.evaluate() + right.evaluate();
    }
}
