package Concurrancies;

// 1. Extending Thread class
public class MyThreadClass extends Thread {
    @Override
    public void run() {
        System.out.println("Thread '" + getName() + "' is being executed...");
    }
}
