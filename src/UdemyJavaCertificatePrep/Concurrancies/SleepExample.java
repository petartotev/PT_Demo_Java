package Concurrancies;

public class SleepExample {
    /*
    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 11; i+=2) {
                System.out.println("Odd: " + i);
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i+=2) {
                System.out.println("Even: " + i);
            }
        });

        oddThread.start();
        evenThread.start();

        Odd: 1
        Odd: 3
        Even: 2
        Even: 4
        Odd: 5
        Odd: 7
        Even: 6
        Even: 8
        Even: 10
        Odd: 9
        Odd: 11
    }
     */

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 11; i+=2) {
                System.out.println("Odd: " + i);
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i+=2) {
                System.out.println("Even: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        });

        oddThread.start();
        evenThread.start();

        /*
        Odd: 1
        Odd: 3
        Odd: 5
        Odd: 7
        Odd: 9
        Odd: 11
        Even: 2
        Even: 4
        Even: 6
        Even: 8
        Even: 10
         */
    }
}
