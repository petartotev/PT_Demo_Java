import java.util.Random; /* imports class Random only */
import java.util.*;      /* wildcard, imports all classes in java.util package */
// import java.util.*.*  /* does not compile like this */

public class Names {
    public static void main(String[] args) {
        System.out.println("First name: " + args[0]);
        System.out.println("Last name: " + args[1]);

        Randomizer myRandomizer = new Randomizer();
        System.out.println(myRandomizer.getRandomNumber());
    }
}