package il.ac.hac.cs.calc;

public abstract class BinaryOperation implements Statement {

    private final Statement left;
    private final Statement right;

    /**
     * Creates a {@link BinaryOperation} with two {@link Statement} instances. A statement can be another
     * binary operation, or a {@link Scalar}, or any type that implements {@link Statement}.
     *
     * @param left the left operand. can be a scalar, or another {@link BinaryOperation}, or anything else that
     *             implements {@link Statement}.
     *             For non-commutative operations such as subtraction and division, this is the left operand,
     *             so for example in order to represent 0 / 1 it is mandatory to send 0 as this operand
     *             and not the right one, to avoid a division-by-zero.
     * @param right the right operand. can be a scalar, or another {@link BinaryOperation}, or anything else that
     *              implements {@link Statement}.
     *              For non-commutative operations such as subtraction and division, this is the right operand.
     *              So for division, it cannot be 0.
     */
    public BinaryOperation(Statement left, Statement right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return innerEvaluate(left, right);
    }

    protected abstract double innerEvaluate(Statement left, Statement right);

    @Override
    public String toString() {
        return String.valueOf(evaluate());
    }
}
