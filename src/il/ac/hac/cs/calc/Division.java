package il.ac.hac.cs.calc;

public class Division extends BinaryOperation {
    /**
     * A division operation: dividend / divisor
     * Notice the name-change of the operands from the original 'left' and 'right'.
     *
     * @param dividend renamed from left
     * @param divisor renamed from right
     */
    public Division(Statement dividend, Statement divisor) {
        super(dividend, divisor);
    }

    @Override
    protected double innerEvaluate(Statement dividend, Statement divisor) {
        return dividend.evaluate() / divisor.evaluate();
    }
}
