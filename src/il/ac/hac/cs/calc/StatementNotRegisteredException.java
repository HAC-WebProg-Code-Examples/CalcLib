package il.ac.hac.cs.calc;

public class StatementNotRegisteredException extends Exception {

    public StatementNotRegisteredException(String opString) {
        super(formatMessage(opString));
    }

    public StatementNotRegisteredException(String opString, Throwable cause) {
        super(formatMessage(opString), cause);
    }

    private static String formatMessage(String opString) {
        return String.format("%s is not registered in OperatorFactory", opString);
    }
}
