package Exceptional;

/* Interface AutoClosable with abstract method close() which has to be implemented. */
public class MyFileClass implements AutoCloseable {
    private final int num;

    public MyFileClass(int num) {
        this.num = num;
    }

    @Override
    public void close() {
        System.out.println("Close MyFileClass #" + num);
    }
}
