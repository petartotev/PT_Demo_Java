package Exceptional;

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
