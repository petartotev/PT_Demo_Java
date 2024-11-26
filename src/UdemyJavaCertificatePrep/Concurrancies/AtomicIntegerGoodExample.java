package Concurrancies;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerGoodExample {
    //private static int counter = 0;
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                //counter++;
                counter.incrementAndGet();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                //counter++;
                counter.incrementAndGet();
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

        System.out.println(counter);        /* SUCCESS: 2_000_000! */
        System.out.println(counter.get());  /* SUCCESS: 2_000_000! */
    }
}
