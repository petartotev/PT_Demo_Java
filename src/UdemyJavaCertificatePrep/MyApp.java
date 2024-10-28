// import java.util.*.*  /* does not compile like this */
import DataTypes.*; /* wildcard */
import FlowControl.FlowController;
import Operators.SmoothOperator;

public class MyApp {
    public static void main(String[] args) {
        System.out.println("First name: " + args[0]);
        System.out.println("Last name: " + args[1]);

        Student myStudent = new Student();
        myStudent.setName("Petar");
        System.out.println((myStudent.getName()));

        Dog myDog = new Dog();
        System.out.println((myDog.name)); /* java: name has private access in Dog */

        // Data Types
        System.out.println("==========\nData Types\n==========");
        Randomizer myRandomizer = new Randomizer();
        System.out.println(myRandomizer.getRandomNumber());
        Numberinho myNumberinho = new Numberinho();
        myNumberinho.playWithNumbersAndUnderscores();

        // Strings
        System.out.println("==========\nStrings\n==========");
        StringDogg myStringDogg = new StringDogg();
        myStringDogg.playWithTextBlocks();
        System.out.println((myStringDogg.GREATEST_RAPPER));
        myStringDogg.playWithConcatenation();
        myStringDogg.playWithStringMethods();
        myStringDogg.playWithStringBuilder();

        // Garbage Collector
        System.out.println("==========\nGarbage Collector\n==========");
        System.gc(); // Invoke Garbage collector, but not guaranteed to do anything!

        // Operators
        System.out.println("==========\nOperators\n==========");
        var myOperator = new SmoothOperator();
        myOperator.playWithUnaryOperators();
        myOperator.playWithBinaryOperators();
        myOperator.playWithAssignmentOperators();
        myOperator.playWithComparisonOperators();

        // Flow Control
        System.out.println("==========\nFlow Control\n==========");
        // switch => boolean, long, float, double not allowed!
        var myFlowController = new FlowController();
        myFlowController.switchItLikeInJava17(3);
        myFlowController.switchExpressionWithJava17(100);
        myFlowController.playWithNamedLoops();
        // myFlowController.playWithInfiniteForLoop();
        myFlowController.playWithForeachLoop();

        // Arrays
        System.out.println("==========\nArrays\n==========");
        var myArrayCharles = new ArrayCharles();
        myArrayCharles.playWithArrays();
        myArrayCharles.playWithMultidimensionalArrays();

        // Dates and Times
        System.out.println("==========\nDates and Times\n==========");
        DateTimmy myDateTimmy = new DateTimmy();
        myDateTimmy.playWithDatesAndTimes();
        myDateTimmy.playWithDateAndTimeMethods();
        myDateTimmy.playWithDateTimePeriodsDurationsAndInstants();

        // Methods
        System.out.println("==========\nMethods\n==========");
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
    }
}