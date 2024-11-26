package Concurrancies;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Synchronizer {
    public void playWithLocking() {
        // Synchronized Block (syntax)
        var lock = new Object();
        synchronized (lock) {
            // code which needs to be executed.
            // one thread at a time!
        }

        // Synchronized Methods
        synchronizedMethodFirstWay();
        doSomething();

        // Using ReentrantLock
        Lock myLock = new ReentrantLock();
        try {
            myLock.lock();
            // Work to be executed one thread at a time.
        } finally {
            myLock.unlock();
        }
        // ^ This is equivalent to using synchronized block, but it gives you more control over the access.
    }

    // First way:
    void synchronizedMethodFirstWay() {
        synchronized (this) { /* current class (this) is used as a lock */
            // Work to be executed one thread at a time.
        }
    }

    // Second way:
    synchronized void doSomething() {
        // Work to be executed one thread at a time.
    }
}
