package Concurrancies;

// Option 1: Extend Thread class
public class MyThreadClass extends Thread {
    @Override
    public void run() {
        System.out.println("Thread '" + getName() + "' is being executed...");
    }
}
