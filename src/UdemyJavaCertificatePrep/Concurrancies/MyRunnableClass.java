package Concurrancies;

public class MyRunnableClass implements Runnable {
    @Override
    public void run() {
        System.out.println(
                "Thread '" +
                Thread.currentThread().getName() +
                "' is being executed from MyRunnableClass.");
    }
}
