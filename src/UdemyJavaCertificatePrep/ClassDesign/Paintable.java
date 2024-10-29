package ClassDesign;

public interface Paintable extends Colorable {
    void paint();
    default void playWithElements() {
        System.out.println("Paintable plays with elements!");
    }
}
