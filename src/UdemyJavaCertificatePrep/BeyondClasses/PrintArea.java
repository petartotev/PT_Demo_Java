package BeyondClasses;

public class PrintArea {
    private int a = 10;

    public void calculateArea() {
        final int b = 15;

        class Computer {
            // Note that class Computer can access both a and b:
            public void multiply() {
                System.out.println(a * b);
            }
        }
        var computer = new Computer();
        computer.multiply();
    }

    public static void main(String[] args) {
        var printArea = new PrintArea();
        printArea.calculateArea(); /* 150 */
    }
}
