package ClassDesign;

public interface Drivable {
    int distanceWithFullTank (int tankVolume);
    int MAXIMUM_WEIGHT = 2000;

    default void refuel() {
        System.out.println("This is default implementation in order to not make all child classes implement this explicitly!");
    }

    default void playWithElements() {
        System.out.println("Paintable plays with elements!");
    }

    // Default and private non-static methods can call abstract methods!
    default void printDrivableFeatures() {
        System.out.println("distanceWithFullTank with 100 is " + distanceWithFullTank(100));
    }

    static int getSomethingFromStaticMethod() {
        return getSomethingFromPrivateStaticMethod();
    }

    private static int getSomethingFromPrivateStaticMethod() {
        return 100;
    }
}

// Implicit keywords automatically added like below:
/*
public ABSTRACT interface Drivable {
    PUBLIC ABSTRACT int distanceWithFullTank (int tankVolume);
    PUBLIC STATIC FINAL int MAXIMUM_WEIGHT = 2000;
}
 */
