package Methodology;

public class MethodStaticItem {
    String hi = "Good afternoon!";
    String bye = "Goodbye!";
    static MethodStaticItem myMethodStaticItem = new MethodStaticItem();

    public static void greet1() {
        System.out.println("Hello!");
    }
    public static void greet2() {
        System.out.println(myMethodStaticItem.hi);
    }
    public static void greet3() {
       //System.out.println(bye); /* 🔴 ERROR: Non-static field 'bye' cannot be referenced from a static context */
    }
}
