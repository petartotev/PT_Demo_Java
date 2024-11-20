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
        /*
        Arithmetic Binary Operators
        1. addition, a + b
        2. subtraction, a - b
        3. multiplication, a * b
        4. division, a / b
        5. modulo operator, a % b
         */

        int aa = 11 / 4; /* 2 - floor value */
        int bb = 11 % 4; /* 3 - reminder of division */

        short a = 17;
        float b = 15;
        double c = 35;
        System.out.println(a * b / c);
        // a and b are promoted to double, result is double.

        /*
        Rules of Numeric Promotion
        1. If operands have different data types, Java automatically promotes one of the operands to a larger of two data types.
        2. If one value is integer and another is decimal - Java promotes int to decimal.
        3. 💡 FACT: Byte, Short, Char are always first promoted to int before the operation is done!
        4. The resulting value has the same data type as the promoted operands.
         */

        short x = 5;
        short y = 7;
        System.out.println(x + y); /* x and y are promoted to int, result is int */
        //short z = x + y; 🔴 ERROR: Does not compile! You try to put int into short!
    }

    public void playWithAssignmentOperators() {
        /*
        Assignment operator ( = ) has the lowest precedence!
        Auto-casting: Java automatically promotes smaller to larger data types!
         */

        short x = 5;
        int y;
        y = x; // OK (x is cast to int)
        System.out.println(y);

        //int a = 1.0; /* 🔴 ERROR */
        //int b = 123L; /* 🔴 ERROR */
        long z = 5;
        long w = (byte) 7; /* explicit casting */
        //float k = 2.3; /* 🔴 ERROR */
        float l = 2.3f;
        double m = 2.3f; /* float is smaller than double */
        double n = 3.14;
        //float pi = n; /* 🔴 ERROR */

        short aa = 7;
        short bb = 5;
        //short cc = aa + bb; /* 🔴 ERROR: Provided - int! */
        short c = (short)(aa + bb);

        int xx = 5;
        int yy = (xx = 3) * 2; /* (x = 3) returns 3 */
        System.out.println(yy);

        boolean isOk = false;
        if (isOk = true) { /* assigns isOk to true and returns true */
            System.out.println("True!");
        }

        boolean isReallyOk = false;
        if (isReallyOk == true) {
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

        /*
        Relational operators: <, >, <=, >=, instanceOf
         */

        System.out.println((isInteger(1)));  /* true */
        System.out.println((isInteger(3.14))); /* false */

        // null instanceof Object; => always returns null
        // null instanceOf null; => does not compile!

        /*
        Logical Operators:
        logical AND: a & b => true if at least one of the operands is true
        logical inclusive OR: a | b => true if at least one is true
        logical exclusive OR (XOR): a ^ b => true only if one value is true, another is false

        Conditional Operators:
        conditional AND: a && b => true if at least one of the operands is true
        conditional OR: a || b => true if at least one is true

        💡 FACT: Conditional evaluation stops once the result can be determined!
         */

        int abc = 5;
        int bcd = 10;
        int cde = 15;
        if ((abc < bcd) || (++cde > 10)) { /* right side will NOT be evaluated */
            System.out.println("We are in!");
        }
        System.out.println("cde = " + cde);

        int mno = 5;
        int nop = 10;
        int opq = 15;
        if ((mno < nop) | (++opq > 10)) { /* right side will be evaluated */
            System.out.println("We are in!");
        }
        System.out.println("opq = " + opq);
    }

    private boolean isInteger(Number number) {
        if (number instanceof Integer) {
            return true;
        }
        return false;
    }
}
