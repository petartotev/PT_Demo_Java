// import java.util.*.*  /* does not compile like this */
import DataTypes.*; /* wildcard */
import FlowControl.FlowController;
import Operators.SmoothOperator;

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
        System.out.println("==========\nData Types\n==========");
        Numberinho myNumberinho = new Numberinho();
        myNumberinho.playWithNumbersAndUnderscores();
        StringDogg myStringDogg = new StringDogg();
        myStringDogg.playWithTextBlocks();
        System.out.println((myStringDogg.GREATEST_RAPPER));

        // Garbage Collector
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
    }
}