import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
// use pow(2,5) instead of Math.pow every time:
import static java.lang.Math.pow;
// static import java.lang.Math.pow; // does not compile!

public class MethodMan {
    // Constants are usually marked static final and written in SNAKE_CASE:
    public static final double VALUE_ADDED_TAX = 0.25;
    // or
    public static final double TEST_CONST;
    // static blocks are useful when you need to calculate values.
    static {
        TEST_CONST = 0.25;
    }
    public static double tax = 0.2;

    // Instance variables - no need to initialize them, they have default value by type.
    public volatile String test;
    public final String Test2 = "Test";
    public transient  String Test3;

    // throws is for documentation reasons only
    public final void playWithMethodSignature(String name) throws InterruptedException, InvalidParameterException
    {
        // Local variable - you need to initialize it before you use it.
        final int num = 5;
    }

    public void playWithVarArgsVariableArguments(String input1, String... otherInputs) {
        System.out.println(input1);
        for (var input : otherInputs) {
            System.out.println(input);
        }
    }

    public double getPrice(double inputPrice) {
        double margin = 0.05;
        return inputPrice * (1 + tax) * (1 + margin);
    }

    public void printPowOfTwo(int num) {
        System.out.println(pow(2,num));
    }

    public void playWithBoxingAndUnboxing() {
    }

    public void playWithOverloadedMethods() {
        // If passing argument doesn't match the parameter type, Java picks the most similar version of the method.
        // Java looks for the first larger primitive type.
        short a = 2;
        greet(a); /* executes greet(int x) */

        execute(2.3); /* executes execute(Object o) */

        // Java looks for supertypes:
        testSupertypes(3.14); /* Number */
        testSupertypes("Luke"); /* CharSequence */
        testSupertypes(new int[] { 1, 2, 3}); /* Object */
    }

    private void greet(int x) { System.out.println("Int!");}
    private void greet(double x) { System.out.println("Double!");}
    private void greet(int x, int y) { System.out.println("Ints!");}

    private void execute(Short a) { System.out.println("Short");}
    private void execute(Integer a) { System.out.println("Integer");}
    private void execute(String str) { System.out.println("String");}
    private void execute(Object o) { System.out.println("Object");}

    private void testSupertypes(Number a) { System.out.println("Number"); }
    private void testSupertypes(CharSequence a) { System.out.println("CharSequence"); }
    private void testSupertypes(Object o) { System.out.println("Object"); }

    // ⚠️ Cannot overload array with varargs!
    // private void doSmth(int[] numbers) { }
    // private void doSmth(int... numbers) { }

    public void playWithExceptions() {
        // check class A and class B below.
    }
}

class A {
    public void greet() throws IOException { }
    public void sayHello() { }
    public void leave() throws FileNotFoundException { }
}

class B extends A {
    public void greet() throws FileNotFoundException { } // OK - subclass of IOException
    // public void sayHello() throws IOException { } // NOT OK
    // public void leave() throws IOException { } // NOT OK
}
