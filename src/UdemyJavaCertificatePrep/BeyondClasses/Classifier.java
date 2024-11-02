package BeyondClasses;

public class Classifier {
    private String str = "Hello!";

    // INNER CLASS
    protected class B {
        private static void printOut(String s) {
            System.out.println(s);
        }
        public void printHelloTwice() {
            // str is visible in the inner class, despite being private!
            printOut(str);
            printOut(str);
        }
    }

    public void printTwice() {
        var b = new B();
        b.printHelloTwice();
    }

    public static void main(String[] args) {
        B myB = new Classifier().new B();
        myB.printHelloTwice();
    }
}
