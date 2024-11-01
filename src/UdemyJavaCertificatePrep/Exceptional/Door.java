package Exceptional;

public class Door implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Door does not close!");
    }
}
