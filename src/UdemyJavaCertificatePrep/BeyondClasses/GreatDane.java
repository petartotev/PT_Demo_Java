package BeyondClasses;

public class GreatDane extends Doggy {
    @Override
    public int getSpeed() { return 35; }

    // Hiding the method, not overriding it!
    public static int getHeight() { return 55; }
}
