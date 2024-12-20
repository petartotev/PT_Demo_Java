package Concurrancies;

public class AtomicIntegerBadExample {
    private static int counter = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
            }
        });

        thread1.start();
        thread2.start();

        // Wait for all threads to finish:
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter); /* WARNING: 1,190,179, nor 2,000,000 as expected! */
    }
}
