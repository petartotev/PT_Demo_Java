// import java.util.Random; /* OK */
// import java.util.*       /* OK */
// import java.util.*.*     /* ⚠️ NOK - Does not compile like this with 2 wildcards */
import ClassDesign.*;       /* .* is 'wildcard' */
import Collections.ElCollectore;
import DataTypes.*;
import Exceptional.Door;
import Exceptional.Exceptionalissimo;
import Exceptional.MyFileClass;
import FlowControl.FlowController;
import FunctionalProgramming.ElPredicatore;
import Operators.SmoothOperator;

import java.io.File;
import java.io.IOException;
import java.time.*;
import java.util.function.*;

// 💡 Class JavaApp is initialized automatically, as main() method is inside the class.
public class JavaApp {
    public static void main(String[] args) throws IOException {
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

        System.out.println("========== S10: Abstract Classes [OCA]  ==========");

        /*
        Abstract class can be extended, but cannot be initialized.
        Abstract class can have constructors, but can be called only using 'super()' from the child class.
        ⚠️ Abstract class or abstract method cannot be marked 'final'.
        ⚠️ Abstract method cannot be marked 'private'.
        ⚠️ 'abstract static' is not allowed (as static method cannot be overridden).
         */

        // Vehicle vehicle = new Vehicle(); /* Vehicle is abstract; cannot be instantiated */
        Car myCar = new Car();
        myCar.run();

        /*
        Rules for Using Abstract Methods:
        1. Only instance methods can be marked abstract (not variables, constructors, static methods).
        2. Abstract method can only be declared in abstract class.
        3. Non-abstract class which extends abstract class must implement all inherited methods.
        4. All other rules with overriding methods apply.
         */

        System.out.println("========== S10: Interfaces [OCA]  ==========");

        /*
        Interface is similar to abstract class, but one class can implement any number of interfaces.
        Keyword 'implements', separated by comma (,).
        All interfaces are implicitly abstract, so they cannot be marked 'final'.
         */

        /*
        Rules of Implementation:
        1. Keyword 'public' is required.
        2. Return type must be covariant with the interface method.
        3. Signature (name & parameters) must match the interface method.
        4. All inherited methods must be implemented.
        5. An interface can extend another interface.
         */

        Car myCar2 = new Car();
        // Class Car EXTENDS abstract class Vehicle => public abstract void run();
        // Class Car IMPLEMENTS interface Drivable => int distanceWithFullTank (int tankVolume);
        // Class Car IMPLEMENTS interface Paintable => void paint();
        // Interface Paintable EXTENDS interface Colorable => void colorize();
        myCar2.run();
        myCar2.distanceWithFullTank(100);
        myCar2.paint();
        myCar2.colorize();

        Employee myEmployee = new Employee();
        // Class Employee IMPLEMENTS interface Academic which has Study() method.
        // Class Employee IMPLEMENTS interface Employable which also has Study() method.
        // Class Employee needs only 1 @Override which fits both methods.
        myEmployee.study();

        /*
        USING DEFAULT METHODS (use 'default' keyword)
        Interface Drivable is already declared and implemented by Car...
        We need to add a new method refuel(), but we don't want to make all child classes implement it.
         */
        myCar2.refuel();

        /*
        Rules for Using Default Methods:
        1. Keyword default with a method can only be used in the interface.
        2. Has to have a body (default implementation).
        3. Implicitly public.
        4. Cannot be abstract, final, static.
        5. May or may not be overridden by a class implementing the interface.
        6. If class inherits 2 default methods with the same signature, it must override the method.
         */
        myCar2.playWithElements();

        // STATIC INTERFACE METHODS

        // PRIVATE INTERFACE METHODS

        /*
        Rules for Using Private Interface Methods:
        1. marked with keyword 'private'
        2. must have a body
        3. private static methods may be called by any method in the interface
        4. non-static private methods may be called only by non-static methods
         */

        System.out.println("=============== S11: Lambdas & Functional Programming [OCA, OCP] ===============");

        System.out.println("========== S11: Functional Interfaces and Lambdas [OCA]  ==========");

        // Functional interface - an interface that has exactly one abstract method.
        // @FunctionalInterface - annotation for functional interface
        // Predefined functional interfaces: Supplier, Consumer, Predicate, Function

        // Using Class Beetle implementing Insect:
        Beetle myBeetle = new Beetle();
        myBeetle.crawl();

        // Using Anonymous Class:
        Insect myBeetle2 = new Insect() {
            public void crawl() { System.out.println("Insect crawls by definition from initialization!"); }
        };
        myBeetle2.crawl();

        // Lambda Expression:
        Insect myLambdaBeetle = () -> System.out.println("Lambda Beetle!");
        myLambdaBeetle.crawl();

        Fuckable myMultiplyingAnimal = (a, b) -> a * b;
        myMultiplyingAnimal.multiply(2, 5);

        /*
        One parameter:
        n -> 2*n
        (n) -> 2*n
        (int n) -> 2*n
        n -> { return 2*n; }
        (n) -> { return 2*n; }
        (int n) -> { return 2*n; }

        More parameters:
        (a, b) -> a*b
        (int a, int b) -> a*b
        (a, b) -> { return a*b; }
        (int a, int b) -> { return a*b; }
         */

        System.out.println("========== S11: Using Predicates With Lambda [OCA]  ==========");

        /*
        Predicate - predefined functional interface provided by Java.
        Import java.util.function.
        Predicate has 1 abstract method: test(T) which takes an argument of T and returns boolean:

        @FunctionalInterface
        public interface Predicate<T> {
            boolean test(T t);
            // ...
        }
         */

        ElPredicatore myElPredicatore = new ElPredicatore();
        myElPredicatore.playWithRawPredicates();

        Predicate<Integer> myPredicate = n -> n*n + 5 < 100;
        ElPredicatore.myProbe(5, myPredicate);
        ElPredicatore.myProbe(5, n -> n > 3);
        ElPredicatore.myProbe(15, n -> n < 10);

        System.out.println("========== S11: Method References [OCP]  ==========");

        // TODO

        System.out.println("========== S11: Built-In Functional Interfaces [OCP]  ==========");

        /*
        import java.util.function package
         */

        System.out.println("===== Supplier =====");

        /*
        @FunctionalInterface
        public interface Supplier<T> {
            T get();
        }
         */

        Supplier<LocalDateTime> dtImpl = () -> LocalDateTime.now();
        System.out.println(dtImpl.get());

        System.out.println("===== Consumer, BiConsumer =====");

        /*
        @FunctionalInterface
        public interface Consumer<T> {
            void accept(T t);
            // ...
        }

        @FunctionalInterface
        public interface BiConsumer<T, U> {
            void accept(T t, U u);
            // ...
        }
         */

        Consumer<String> greet = s -> System.out.println("Hello, " + s + "!");
        greet.accept("John");
        BiConsumer<String, String> greets = (s, t) -> System.out.println("Hello, " + s + " " + t + "!");
        greets.accept("John", "Snow");

        System.out.println("===== Predicate, BiPredicate =====");

        /*
        @FunctionalInterface
        public interface Predicate<T> {
            boolean test(T t);
            // ...
        }

        @FunctionalInterface
        public interface BiPredicate<T, U> {
            boolean test(T t, U u);
            // ...
        }
         */

        Predicate<Integer> gt10 = n -> n > 10;
        System.out.println(gt10.test(5));

        BiPredicate<Integer, Integer> gt = (n, m) -> n > m;
        System.out.println(gt.test(5, 10));

        System.out.println("===== Function, BiFunction =====");

        /*
        @FunctionalInterface
        public interface Function<T, R> {
            R apply(T t);
            // ...
        }

        @FunctionalInterface
        public interface BiFunction<T, U, R> {
            R apply(T t, U u);
            // ...
        }
         */

        Function<Integer, Double> square = n -> (double)(n*n);
        var res = square.apply(5);
        System.out.println(res);

        BiFunction<String, Integer, String> con = (s, i) -> s + i;
        var myCon = con.apply("John", 25);
        System.out.println(myCon);

        System.out.println("===== UnaryOperator, BinaryOperator =====");

        /*
        @FunctionalInterface
        public interface UnaryOperator<T> extends Function<T,T> {
            // ...
        }

        @FunctionalInterface
        public interface BinaryOperator<T> extends BiFunction<T,T,T> {
            // ...
        }
         */

        UnaryOperator<Integer> negative = n -> -n;
        System.out.println(negative.apply(5));

        UnaryOperator<String> shout = String::toUpperCase;
        System.out.println(shout.apply("John"));

        BinaryOperator<Double> add = (a, b) -> a + b;
        System.out.println(add.apply(3.5, 1.5));

        BinaryOperator<String> conn = String::concat;
        System.out.println(conn.apply("John", "Snow"));

        System.out.println("========== S11: Helper Methods by Functional Interfaces [OCP]  ==========");

        /*
        Consumer => andThen()
        Function => andThen(), compose()
        Predicate => and(), or(), negate()
         */

        Consumer<String> greet1 = s -> System.out.println("Hello, " + s + "!");
        Consumer<String> greet2 = s -> System.out.println("Goodbye, " + s + "!");
        Consumer<String> greet1and2 = greet1.andThen(greet2);
        greet1and2.accept("John");
        System.out.println();
        greet1.andThen(greet2).accept("John");

        Function<Integer, Integer> double123 = n -> n*n;
        Function<Integer, Integer> triple123 = n -> 3*n;
        // First function, then second function.
        Function<Integer, Integer> f1 = double123.andThen(triple123); /* (5 x 5) * 3 */
        System.out.println(f1.apply(5));
        // Second function first, then first function second.
        Function<Integer, Integer> f2 = double123.compose(triple123); /* (5 x 3) * (5 x 3) */
        System.out.println(f2.apply(5));

        Predicate<Integer> gt100 = n -> n > 10;
        Predicate<Integer> lt20 = n -> n < 20;
        Predicate<Integer> p1 = gt10.and(lt20);
        Predicate<Integer> p2 = gt10.or(lt20);
        Predicate<Integer> p3 = lt20.negate();

        System.out.println(p1.test(5)); /* false */
        System.out.println(p2.test(5)); /* true */
        System.out.println(p3.test(5)); /* if true, returns false */

        System.out.println("========== S11: Functional Interfaces for Primitives [OCP]  ==========");

        System.out.println("=============== S12: Collections [OCA, OCP] ===============");

        /*
        List implements Collection
            ArrayList implements List
        Set implements Collection
            HashSet and TreeSet implement Set
        Queue (Deque) implements Collection
            Deque implements Queue
            LinkedList implements Queue and List
        Map DOES NOT implement Collection
            HashMap and TreeMap implement Map interface
         */

        ElCollectore myCollectore = new ElCollectore();

        myCollectore.playWithCommonCollectionMethods();

        myCollectore.playWithLists();
        myCollectore.playWithListMethods();
        myCollectore.playWithRemovingFromIntegersList();

        myCollectore.playWithSets();

        myCollectore.playWithQueues();
        myCollectore.playWithDequeuesAsStack();
        myCollectore.playWithDequeuesAsDoubleEndedQueues();

        myCollectore.playWithMaps();

        myCollectore.playWithSorting();

        System.out.println("=============== S13: Exceptions [OCA, OCP] ===============");

        /*
        Exceptions occur when something goes wrong during runtime:
        - divide by 0
        - fetch non-existing index
        - open non-existing file
         */

        /*
        java.lang.Throwable
        - java.lang.Error (unchecked ⚠️)
        - java.lang.Exception
            - java.lang.RuntimeException (unchecked ⚠️) - does not inherit from Exception!
                - java.lang.ArithmeticException
                - java.lang.ArrayIndexOutOfBoundsException
                - java.lang.NullPointerException
                - java.lang.ClassCastException
                - java.lang.NumberFormatException
            - java.lang.
            IOException
                - java.io.IOException
                - java.io.FileNotFoundException
            - other exceptions
        */

        Exceptionalissimo ex = new Exceptionalissimo();
        //ex.readFirstByteFromFileDoesNotCompile(new File("file.txt")); // IOException
        //ex.readFirstByteFromFileWithThrows(new File("file.txt")); // IOException
        //ex.readFirstByteFromFileHandleException(new File("file.txt")); // IOException

        int[] a = {1, 2, 3};
        //ex.printFourthElementNotHandled(a); // ArrayIndexOutOfBoundsException
        //ex.printFourthElementHandled(a);

        //ex.manuallyThrowExceptionIfGreaterThanEight(9); // IllegalArgumentException

        /*
        Unchecked Exceptions
        */

        //ex.catchMultipleExceptionsSubclasses(new File("file.txt")); // IOException
        //ex.catchMultipleExceptionsNotSubclasses(new File("file.txt")); // IOException
        //ex.catchMultipleExceptionsNotSubclassesCoolerWay(new File("file.txt")); // IOException

       /*
       Resource Management
       - any external data sources (file, database etc.) referred to resource
       - dealing with resource requires 3 steps:
       1. opening resource
       2. using resource
       3. closing resource
       */

        //ex.useResourceManagementManual("file.txt");
        //ex.useResourceManagementAutomatic("file.txt");

        try (MyFileClass bookReader = new MyFileClass(1);
             MyFileClass movieReader = new MyFileClass(2)) {
            System.out.println("try block");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
        }

        /*
        Output:
        try block
        closing MyFileClass #2
        closing MyFileClass #1
        catch block
        finally block
         */

        try (Door d = new Door()) {
            throw new IllegalStateException("Something is wrong!");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
            for (Throwable t : e.getSuppressed())
                System.out.println("Suppressed: " + t.getMessage());
        }

        /*
        Output:
        Caught: Something is wrong
        Suppressed: Door does not close
         */

        System.out.println("=============== S14: Math APIs [OCP] ===============");

        // min(), max()
        int aaa = Math.max(3, 11);
        int bbb = Math.min(2, -4);

        long aaaa = 5;
        int bbbb = 3;
        // int cccc = Math.max(aaaa, bbbb); DOES NOT COMPILE
        int dddd = (int) Math.max(aaaa, bbbb);

        // round()
        // if parameter is float, returns int
        // if parameter is double, returns long
        double ddddd = 2.56;
        long aaaaa = Math.round(ddddd);
        //int bbbbb = Math.round(ddddd); /* DOES NOT COMPILE */
        int c = (int) Math.round(ddddd);

        // ceil(), floor()
        // take any number, returns double
        double r = Math.ceil(2.45); // 3.0
        double p = Math.floor(2.45); // 2.0
        double q = Math.floor(2.99); // 2.0

        // exponents: pow()
        // take any number, returns double
        double pp = Math.pow(2, 5); // 32
        double qq = Math.pow(25, 0.5); // 5

        // random numbers
        double ran = Math.random(); // between 0 and 1, not included

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