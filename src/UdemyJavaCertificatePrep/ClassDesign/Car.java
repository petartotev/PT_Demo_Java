package ClassDesign;

public class Car extends Vehicle implements Drivable, Paintable {
    @Override
    public void run() {
        System.out.println("run() overridden, as Car EXTENDS Vehicle.");
    }

    @Override /* optional, but recommended keyword */
    public int distanceWithFullTank(int tankVolume) {
        System.out.println("distanceWithFullTank() overridden, as Car IMPLEMENTS Drivable.");
        return 0;
    }

    @Override
    public void paint() {
        System.out.println("paint() overridden, as Car IMPLEMENTS Paintable.!");
    }

    @Override
    public void colorize() {
        System.out.println("colorize() overridden, as Car IMPLEMENTS Paintable which EXTENDS Colorable.");
    }

    /*
    Either @Override or use the default implementation in interface Drivable.
    @Override
    public void refuel() {
        System.out.println("refuel() overridden!");
    }
     */

    // ClassDesign.Car inherits unrelated defaults for playWithElements() from types ClassDesign.Drivable and ClassDesign.Paintable.
    @Override
    public void playWithElements() {
        System.out.println("This method needed to be overridden as both Drivable and Paintable have default methods.");
    }

    public void playWithElementsCustom() {
        // Use the default methods of parent interfaces:
        Drivable.super.playWithElements();
        Paintable.super.playWithElements();
    }
}
