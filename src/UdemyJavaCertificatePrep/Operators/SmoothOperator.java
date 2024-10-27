package Operators;

public class SmoothOperator {
    public void playWithUnaryOperators() {
        int a = 5;
        int b = a++;
        System.out.println("a equals " + a); // 6
        System.out.println("b equals " + b); // 5

        int c = 5;
        int d = ++c;
        System.out.println("c equals " + c); // 6
        System.out.println("d equals " + d); // 6

        int e = 5;
        e = e++;
        System.out.println("e equals " + e); // 5
    }

    public void playWithBinaryOperators() {
        short a = 17;
        float b = 15;
        double c = 35;
        System.out.println(a * b / c);
        // a and b are promoted to double, result is double.

        short x = 5;
        short y = 7;
        System.out.println(x + y);
        // x and y are promoted to int, result is int
        // short, char and byte are always promoted to int!!!!!!!!!!

        // short z = x + y;
        // DOES NOT COMPILE (you try to put int into short)
    }

    public void playWithAssignmentOperators() {
        // auto-casting: Java automatically promotes smaller to larger data types
        short x = 5;
        int y;
        y = x; // OK (x is cast to int)
        System.out.println(y);

        //int a = 1.0; /* NOT OK */
        //int b = 123L; /* NOT OK */
        long z = 5;
        long w = (byte) 7;
        //float k = 2.3; /* NOT OK */
        float l = 2.3f;
        double m = 2.3f;
        double n = 3.14;
        //float pi = n; /* NOT OK */
        short aa = 7;
        short bb = 5;
        short c = (short)(aa + bb);

        int xx = 5;
        int yy = (xx = 3) * 2; /* (x = 3) returns 3! */
        System.out.println(yy);

        boolean isOk = false;
        if (isOk = true) { /* assigns isOk to true and returns true */
            System.out.println("True!");
        }
    }

    public void playWithComparisonOperators() {
        // a == b
        // a != b
        String name1 = new String("John Wayne");
        String name2 = new String("John Wayne");
        String name3 = name1;
        System.out.println(name1 == name2); /* false */
        System.out.println(name1 == name3); /* true */

        System.out.println((isInteger(1)));  /* true */
        System.out.println((isInteger(3.14))); /* false */

        // null instanceof Object; => always returns null
    }

    private boolean isInteger(Number number) {
        if (number instanceof Integer) {
            return true;
        }
        return false;
    }
}

// z = a + b is operation, where:
// z is result
// a and b are operands
// + is operator
// = is assignment operator.

// Unary operator: a++;
// Binary operator: a = b + c;
// Ternary operator: a = (b > 0) ? 3 : 2;