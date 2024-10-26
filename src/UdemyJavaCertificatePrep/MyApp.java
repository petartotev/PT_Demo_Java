// import java.util.*.*  /* does not compile like this */
import DataTypes.*;

public class MyApp {
    public static void main(String[] args) {
        System.out.println("First name: " + args[0]);
        System.out.println("Last name: " + args[1]);

        Randomizer myRandomizer = new Randomizer();
        System.out.println(myRandomizer.getRandomNumber());

        Student myStudent = new Student();
        myStudent.setName("Petar");
        System.out.println((myStudent.getName()));

        Dog myDog = new Dog();
        System.out.println((myDog.name)); /* java: name has private access in Dog */

        // Data Types
        Numberinho myNumberinho = new Numberinho();
        myNumberinho.PlayWithNumbersAndUnderscores();
        StringDogg myStringDogg = new StringDogg();
        myStringDogg.PlayWithTextBlocks();
        System.out.println((myStringDogg.GREATEST_RAPPER));

        // Garbage Collector
        System.gc(); // Invoke Garbage collector, but not guaranteed to do anything!

        // Operators
    }
}