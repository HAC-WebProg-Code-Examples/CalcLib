package il.ac.hac.cs;

import il.ac.hac.cs.calc.*;

public class Main {

    /**
     * A simple usage example of the library.
     * @param args ignored
     */
    public static void main(String[] args) {

        try {
            double variable = Double.parseDouble(args[0]);
            double constant = Double.parseDouble(args[1]);

            Scalar x = Scalar.valueOf(variable);

            Scalar c = Scalar.valueOf(constant);

            Statement xSquared = StatementFactory.create("*", x, x);

            Statement xSquaredPlusX = StatementFactory.create("+", xSquared, x);

            Statement xSquaredPlusXPlusC = new Addition(xSquaredPlusX, c);

            System.out.printf("%.2f^2 + %.2f + %.2f = %s", variable, variable, constant, xSquaredPlusXPlusC);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java Main <x> <c>");
        } catch (NumberFormatException e) {
            System.out.println("You have to provide a number for this program to work properly.");
        } catch (StatementNotRegisteredException e) {
            System.out.println("This operation is not registered and thus not supported. Sorry.");
        }
    }
}
