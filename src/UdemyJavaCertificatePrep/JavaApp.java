// import java.util.Random; /* OK */
// import java.util.*       /* OK */
// import java.util.*.*     /* ⚠️ NOK - Does not compile like this with 2 wildcards */
import ClassDesign.*;       /* .* is 'wildcard' */
import DataTypes.*;
import FlowControl.FlowController;
import Operators.SmoothOperator;

// 💡 Class JavaApp is initialized automatically, as main() method is inside the class.
public class JavaApp {
    public static void main(String[] args) {
        System.out.println("=============== UDEMY.COM Java Certificate Prep: OCA (1Z0-808) & OCP (1Z0-829, 1Z0-830) by Luka Popov ===============");

        System.out.println("==================== S1: Introduction ===============");

        System.out.println("First name: " + args[0]);
        System.out.println("Last name: " + args[1]);

        Student myStudent = new Student();
        myStudent.setName("Petar");
        System.out.println((myStudent.getName()));

        Doggy myDoggy = new Doggy();
        System.out.println((myDoggy.name)); /* java: name has private access in Dog */

        System.out.println("=============== S2: Building Blocks [OCA, OCP] ===============");

        System.out.println("========== S2: Data Types [OCA]  ==========");

        Randomizer myRandomizer = new Randomizer();
        System.out.println(myRandomizer.getRandomNumber());
        Numberinho myNumberinho = new Numberinho();
        myNumberinho.playWithNumbersAndUnderscores();

        System.out.println("========== S2: Garbage Collection [OCA]  ==========");

        System.gc(); /* ⚠️ Invokes GC, but not guaranteed to do anything! */

        System.out.println("=============== S3: Operators [OCA, OCP] ===============");

        var myOperator = new SmoothOperator();

        myOperator.playWithUnaryOperators();
        myOperator.playWithBinaryOperators();
        myOperator.playWithAssignmentOperators();
        myOperator.playWithComparisonOperators();

        System.out.println("=============== S4: Flow Control [OCA, OCP] ===============");

        // Switch => ⚠️ Boolean, Long, Float, Double are not allowed!

        var myFlowController = new FlowController();

        myFlowController.switchItLikeInJava17(3);
        myFlowController.switchExpressionWithJava17(100);
        myFlowController.playWithNamedLoops();
        // myFlowController.playWithInfiniteForLoop();
        myFlowController.playWithForeachLoop();

        System.out.println("=============== S5: Strings [OCA, OCP] ===============");

        StringDogg myStringDogg = new StringDogg();

        myStringDogg.playWithTextBlocks();
        System.out.println((myStringDogg.GREATEST_RAPPER));
        myStringDogg.playWithConcatenation();
        myStringDogg.playWithStringMethods();
        myStringDogg.playWithStringBuilder();

        System.out.println("=============== S6: Arrays [OCA, OCP] ===============");

        var myArrayCharles = new ArrayCharles();

        myArrayCharles.playWithArrays();
        myArrayCharles.playWithMultidimensionalArrays();

        System.out.println("=============== S7: Date and Time [OCA, OCP] ===============");

        DateTimmy myDateTimmy = new DateTimmy();

        myDateTimmy.playWithDatesAndTimes();
        myDateTimmy.playWithDateAndTimeMethods();
        myDateTimmy.playWithDateTimePeriodsDurationsAndInstants();

        System.out.println("=============== S8: Methods [OCA, OCP] ===============");

        MethodMan myMethodMan = new MethodMan();

        try {
            myMethodMan.playWithMethodSignature("test");
        } catch (InterruptedException iex) {
            System.out.println(iex.getMessage());
        } finally {
            System.out.println("myMethodMan.playWithMethodSignature was executed!");
        }

        myMethodMan.playWithVarArgsVariableArguments("test1", "test2", "test3");

        String[] myArgs = new String[] { "test333", "test666" };
        myMethodMan.playWithVarArgsVariableArguments("test111", myArgs); // but not anonymous array!

        System.out.println("========== S8: Access Modifiers [OCA]  ==========");

        /*
        Access Modifiers:
        - private - can be accessed only within the class they are declared
        - default - can be accessed only within the same package
        - protected - can be accessed within the same package and outside package from child classes
        - public - can be accessed from everywhere
         */

        MethodMan myMethodMan1 = new MethodMan();
        System.out.println(myMethodMan1.getPrice(100));

        MethodMan myMethodMan2 = new MethodMan();
        myMethodMan2.tax = 0.1;
        System.out.println(myMethodMan1.getPrice(100)); /* ⚠️ Tax also changed for myMethodMan1! */
        System.out.println(myMethodMan2.getPrice(100));

        System.out.println("=============== S9: Class Design [OCA, OCP] ===============");

        Classy myCLassy = new Classy();

        /*
        Class Modifiers:
        - final
        - abstract
        - static
        - sealed (Java 17)
        - non-sealed (Java 17)
         */

        /*
        All Java classes inherit from java.lang.Object class.
        Object has access to:
        - toString()
        - equals()
        - hashCode()
         */

        Cat myCat = new Cat();
        myCat.setNameAndAge("Rex", 5);
        myCat.meow();
        // If one of the classes is not public, you can have both files in the same file.

        Dog myDog1 = new Dog();
        Dog myDog2 = new Dog("Max");

        // If class has no defined constructors => default constructor created automatically.

        /*
        Constructors access modifiers:
        - public
        - protected
        - default
        - private - if you don't want public no-argument constructor generated automatically.
         */

        Elephant myElephant = new Elephant();

        /*
        this() Rules:
        1. Can be called in the first line of the constructor.
        2. Can be called only once.
        3. ⚠️ Can create a cycle - constructors calling each other infinitely!
         */

        /*
        super() Rules:
        1. Must be called in the fist line of the constructor.
        2. Can be called only once.
        3. If no explicit this() or super() in the first line of the constructor the compiler adds super() at the beginning of every constructor.
         */

        /*
        Order of initialization:
        1. If superclass => initialized first
        2. All static variables are processed (in order of appearance)
        3. All static initializers are processed (in order of appearance)
         */

        // Order of initialization of Instance

        // Inheriting Methods
        // Cat speak() @Override-s Mammal speak():
        myCat.speak();
        myCat.eat();

        /*
        Method Overriding Rules:
        1. Overridden method must have the same signature
        2. Overridden method must be as accessible
        ...
         */

        myMethodMan.playWithExceptions();

        System.out.println("=============== S10: Abstract Classes & Interfaces [OCA, OCP] ===============");


        System.out.println("=============== S11: Lambdas & Functional Programming [OCA, OCP] ===============");


        System.out.println("=============== S12: Collections [OCA, OCP] ===============");


        System.out.println("=============== S13: Exceptions [OCA, OCP] ===============");


        System.out.println("=============== S14: Math APIs [OCP] ===============");


        System.out.println("=============== S15: Beyond Classes [OCP] ===============");


        System.out.println("=============== S16: Streams [OCP] ===============");


        System.out.println("=============== S17: Localization [OCP] ===============");


        System.out.println("=============== S18: Modules [OCP] ===============");


        System.out.println("=============== S19: Concurrency [OCP] ===============");


        System.out.println("=============== S20: I/O [OCP] ===============");


        System.out.println("=============== S21: JBDC [OCP] ===============");


        System.out.println("=============== S22: Java 21 (1Z0-830 exam) ===============");
    }
}