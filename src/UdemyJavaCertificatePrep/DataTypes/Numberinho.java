package DataTypes;

public class Numberinho {
    public void PlayWithNumbersAndUnderscores() {
        int a = 1_000_000;
        int b = 1_2;
        int c = 1_____2;
        int m = Integer.parseInt("101");

        Integer z = Integer.valueOf(5); // unnecessary boxing!
        System.out.println("z.byteValue is " + z.byteValue());
        System.out.println("z.shortValue is " + z.shortValue());
        System.out.println("z.intValue is " + z.intValue());
        System.out.println("z.floatValue is " + z.floatValue());
        System.out.println("z.doubleValue is " + z.doubleValue());
        // System.out.println(z.booleanValue()); // cannot resolve method in 'integer'!
        // System.out.println(z.charValue()); // cannot resolve method in 'integer'!

        var test = 5; // Local Variable Type Interface = var
    }
}