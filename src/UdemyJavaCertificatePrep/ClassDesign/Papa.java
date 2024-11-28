package ClassDesign;

public class Papa extends Grandpa {
    // This is not overriding, it is hiding (because it is static)
    //@Override /* 🔴 ERROR: Compilation error! */
    public static void greet() {
        System.out.println("Hello, son!");
    }
}
