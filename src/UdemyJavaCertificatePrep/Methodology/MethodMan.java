package Methodology;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import static java.lang.Math.pow;       /* 💡 SUGGESTION: Use pow(2,5) instead of Math.pow(2,5) every time! */
// static import java.lang.Math.pow;    /* 🔴 ERROR: Does not compile! */

public class MethodMan {
    // Constants are usually marked static final and written in SNAKE_CASE:
    public static final double VALUE_ADDED_TAX = 0.25;
    // or
    public static final double TEST_CONST;
    // static blocks are useful when you need to calculate values.
    static {
        TEST_CONST = 0.25;
    }
    // ❗❗❗ IMPORTANT: Get used to static blocks ^ - used when you need to calculate values!
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

    public void printPowOfTwo(int num) {
        // Can be used like this because of:
        // import static java.lang.Math.pow;
        System.out.println(pow(2,num));
    }

    public void playWithBoxingAndUnboxing() {
        // Explicit boxing:
        int a = 3;
        Integer b = Integer.valueOf(a); /* Boxing: int -> Integer */
        int c = b.intValue();           /* Unboxing: Integer -> int */

        // Implicit boxing:
        int x = 3;
        Integer y = x;                  /* Boxing: int -> Integer */
        int z = y;                      /* Unboxing: Integer -> int */

        // Java will also autocast a smaller primitive into the larger one.
        // Java will not do both automatic operations at the same time!!

        int m = 7;
        int n = m; /* autocasting, OK */
        //Long o = m; /* 🔴 ERROR: Does not compile! Autocasting and autoboxing cannot be done at once!!! */
        Long o = Long.valueOf(m);           /* explicit boxing */
        Long p = (long)m;                  /* explicit casting */
        Long q = Long.valueOf((long)m);   /* explicit everything */
    }

    public void playWithOverloadedMethods() {
        // If passing argument doesn't match the parameter type, Java picks the most similar version of the method.
        // Java looks for the first larger primitive type.
        greet(5);
        greet(3.14);
        greet(7, -11);

        short a = 2; /* short => larger type => int */
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

    // ⚠️ WARNING: Cannot overload array with varargs!
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
