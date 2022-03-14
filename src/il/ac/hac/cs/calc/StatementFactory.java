package il.ac.hac.cs.calc;

import java.util.HashMap;
import java.util.function.BinaryOperator;

/**
 * An application which uses this calc library may need to be able to choose a character or a phrase that will be
 * used by an end user to indicate which {@link Statement} they want to use.
 *
 * For example, such implementation may need to use the '+' sign in order to use {@link Addition}, but it may also
 * need to use the word "plus" or some other thing. This can be achieved by using the factory design pattern.
 * If, for example, the implementation needs to use the 'plus' word as an indicator for creation of an
 * {@link Addition}, it can call {@code OperationFactory.register("plus", (left, right) -> new Addition(left, right))}
 *
 * Also, an implementation may need to implement a compound {@link Statement} (one that is a combination of several
 * existing ones) or a totally new one, for example if it needs a logic operation or a bitwise operation. In these
 * cases, in order to use a combination of these new implementations with the existing ones, the factory can be used.
 *
 * In all of these cases an {@code if} statement or a {@code switch} statement can be used to choose between the
 * {@link Statement}'s, but that would mean any new implementation would have to re-write the entire {@code if} or
 * {@code switch}, and create new cases for already existing implementations. Using this factory, along with default
 * registrations for the built-in {@link Statement}'s, this boilerplate code is reduced to merely defining and
 * registering new {@link Statement}s.
 */
public final class StatementFactory {

    public static final String DEFAULT_OP_STR_ADDITION = "+";
    public static final String DEFAULT_OP_STR_SUBTRACTION = "-";
    public static final String DEFAULT_OP_STR_MULTIPLICATION = "*";
    public static final String DEFAULT_OP_STR_DIVISION = "/";

    private StatementFactory(){}

    private static final HashMap<String, BinaryOperator<Statement>> creators = new HashMap<>();

    // This is a static initializer. It is a block of code that will be executed if and when this class
    // is loaded into memory. This way we are sure that if the factory is used in a project, it will have
    // default registrations for our build-in operations.
    // Deleting the default
    static {
        // Default registrations. Can be deleted or overwritten by any code using this library.
        registerDefaults();
    }

    /**
     * Allows a user to register the default {@link BinaryOperation} implementations into the factory in a single method call.
     */
    public static void registerDefaults() {
        register(DEFAULT_OP_STR_ADDITION, Addition::new);
        register(DEFAULT_OP_STR_SUBTRACTION, Subtraction::new);
        register(DEFAULT_OP_STR_MULTIPLICATION, Multiplication::new);
        register(DEFAULT_OP_STR_DIVISION, Division::new);
    }

    public static void unRegisterDefaults() {
        unRegister(DEFAULT_OP_STR_ADDITION);
        unRegister(DEFAULT_OP_STR_SUBTRACTION);
        unRegister(DEFAULT_OP_STR_MULTIPLICATION);
        unRegister(DEFAULT_OP_STR_DIVISION);
    }

    public static void register(String opString, BinaryOperator<Statement> creator) {
        creators.put(opString, creator);
    }

    public static void unRegister(String opString) {
        creators.remove(opString);
    }

    public static Statement create(String opString, Statement left, Statement right) throws StatementNotRegisteredException {
        if (!creators.containsKey(opString)) {
            throw new StatementNotRegisteredException(opString);
        }
        return creators.get(opString).apply(left, right);
    }

}
