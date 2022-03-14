package il.ac.hac.cs.calc;

/**
 * A representation of a simple real number, wrapped in an implementation
 *
 * A record is an immutable data type. In a way it is simply a class where all the fields are final
 * and have getters.
 *
 * View <a href="https://www.baeldung.com/java-record-keyword">this page</a> for more about records.
 */
public record Scalar(double value) implements Statement {

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Scalar valueOf(double d) {
        return new Scalar(d);
    }
}
