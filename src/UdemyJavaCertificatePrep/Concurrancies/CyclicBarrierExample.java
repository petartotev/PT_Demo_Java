package Concurrancies;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3); /* parties: 3 */
        Runnable workerTask = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is performing the first part of the work!");

            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Code to follow will be performed after 3 threads finish with the execution of the code above.
            System.out.println(name + " is performing the remaining work after the barrier!");
        };

        Thread worker1 = new Thread(workerTask, "Worker 1");
        Thread worker2 = new Thread(workerTask, "Worker 2");
        Thread worker3 = new Thread(workerTask, "Worker 3");
        Thread worker4 = new Thread(workerTask, "Worker 4");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        /*
        Output without worker4 defined:
            Worker 2 is performing the first part of the work!
            Worker 1 is performing the first part of the work!
            Worker 3 is performing the first part of the work!
            Worker 3 is performing the remaining work after the barrier!
            Worker 2 is performing the remaining work after the barrier!
            Worker 1 is performing the remaining work after the barrier!

        Output without worker3 defined:
            Worker 1 is performing the first part of the work!
            Worker 2 is performing the first part of the work!
            Worker 4 is performing the first part of the work!
            Worker 4 is performing the remaining work after the barrier!
            Worker 3 is performing the first part of the work!
            Worker 1 is performing the remaining work after the barrier!
            Worker 2 is performing the remaining work after the barrier!
         */
    }
}
