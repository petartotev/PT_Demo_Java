// import java.util.Random; /* OK */
// import java.util.*       /* OK */
// import java.util.*.*     /* ⚠️ NOK - Does not compile like this with 2 wildcards */
import BeyondClasses.*;
import ClassDesign.*;       /* .* is 'wildcard' */
import Collections.ElCollectore;
import Concurrancies.MyRunnableClass;
import Concurrancies.MyThreadClass;
import DataTypes.*;
import Exceptional.Door;
import Exceptional.Exceptionalissimo;
import Exceptional.MyFileClass;
import FlowControl.FlowController;
import FunctionalProgramming.ElPredicatore;
import Operators.SmoothOperator;
import Streams.Optionalles;

import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.Stream;

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

        Classy myClassy = new Classy();

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

        System.out.println("========== S15: Enums ==========");
        /*
        Enum (enumeration) is a fixed set of constants.
        Enum provides type-safe checking - impossible to create an invalid enum value.
        Enums - seasons, compass directions, days of the week, deck of cards
         */

        // Simple Enums (no constructors, methods etc.)
        Compass N = Compass.NORTH;
        Compass S = Compass.valueOf("SOUTH"); /* alternative, but not usual */
        System.out.println(N);
        System.out.println(S);
        System.out.println(N == S);
        System.out.println(N == Compass.NORTH);

        // Compass.values() - returns array of values
        // direction.ordinal() - ordinal number of value
        // direction.name() - name of a value
        for (var direction : Compass.values()) {
            System.out.println(direction.ordinal() + " : " + direction.name());
        }

        // Enums used in a switch:
        Compass NO = Compass.NORTH;
        switch (NO) {
            //case Compass.NORTH -> ... /* ⚠️ wrong syntax! */
            //case 1 -> ...             /* ⚠️ wrong syntax! */
            case NORTH -> System.out.println("Heading North!");
            case SOUTH -> System.out.println("Heading South!");
            default -> System.out.println("Get back!");
        }

        // Enums can have Constructor and Instance Method(s):
        CompassWithCtor.NORTH.printInstruction();
        // 1. 💡 Constructors are called for each enum - 4 invocations, only once!
        // 2. Instruction "Up" is printed using printInstruction().

        // Enums can implement Abstract Methods:
        System.out.println(CompassAbstract.SOUTH.getDirection());
        System.out.println(CompassNotAbstract.SOUTH.getDirection());
        System.out.println(CompassNotAbstract.SOUTH.getDirection());

        // Enums can implement Interfaces
        System.out.println(CompassWithInterface.NORTH.getPlanetName()); /* Earth */

        System.out.println("========== S15: Sealed Classes ==========");

        /*
        Used to restrict other classes to directly extend your class.
        New keywords: sealed, non-sealed, permits
        Sealed classes must be declared in the same package as its direct subclasses.
        Every listed subclass must extend the sealed class:
        - final, sealed, non-sealed

        Automobile

         */

        /*
        Interfaces can also be made sealed!
        Fish
            Eats
            ClownFish
            Shark
         */

        System.out.println("========== S15: Records ==========");

        /*
        Encapsulated classes, but without boilerplate code.
        Encapsulation is secured.
        Constructor, getters, toString(), equals(), hashCode() are generated automatically.
        Records cannot have explicit instance fields.
        Records can have static fields and methods.
        Records can have instance methods.
         */

        PupilEncapsulated pe = new PupilEncapsulated("Petar", "Totev", 1);
        System.out.println(pe.getFirstName() + " " + pe.getLastName() + "; id: " + pe.getId());
        System.out.println(pe);

        PupilRecord pr = new PupilRecord("Petar", "Totev", 2);
        System.out.println(pr);

        // ❓ Canonical constructor
        // ❓ Compact constructor - without initializing field:
        // public Student { if (id < 10 || id > 1_000_000) throw new IllegalArgumentException(); }
        // TODO

        System.out.println("========== S15: Nested Classes ==========");

        /*
        ☁ Nested Class = class defined within another class.
        1. INNER CLASS - non-static, defined at the member level of class.
        - can have access modifier (private, protected...)
        - can extend another class or implement interfaces
        - can be marked abstract or final
        - can access all members of the enclosing class (including private members!)
        2. STATIC NESTED CLASS - static type, defined at the member level of a class.
        3. LOCAL CLASS - a class defined within a method body.
        4. ANONYMOUS CLASS - local class which doesn't have a name.
         */

        System.out.println("===== S15: Inner Class =====");

        // Inner class:
        Classifier myClassifier = new Classifier();
        myClassifier.printTwice();

        A myA = new A();
        // Execute myA.main()!

        System.out.println("===== S15: Static Nested Class =====");

        /*
        Can't access instance variables or methods declared in the outer class.
        Don't need an instance of the wider class to access it.
        Can be marked private or protected.
         */
        State myState = new State();

        System.out.println("===== S15: Local Class =====");

        /*
        Nested class defined within the method.
        Don't have access modifiers.
        Can be declared abstract or final.
        Can access all members of the enclosing class.
        Can access final and effectively final local variables.
         */
        PrintArea myArea = new PrintArea();
        myArea.calculateArea();

        System.out.println("===== S15: Anonymous Class =====");

        /*
        Special type of local class, but without a name.
        Cannot exist by itself, but must extend an existing class or implement an existing interface.
         */
        Store myStore = new Store();
        myStore.newPrice(123);

        ExamTrick myExamTrick = new ExamTrick();

        System.out.println("========== S15: Polymorphism ==========");

        /*
        Property of the object to take many different forms (poly = many, morph = form)
        To access a Java object, we have to have a reference pointing to that object.
        There are 3 ways to access the Java object:
        - using reference with the same type as the object
        - using reference that is superclass of the object
        - using interface reference
         */

        PolyShihTzu myShihTzu = new PolyShihTzu(); /* create a reference using the same type as object */
        System.out.println(myShihTzu.weight); /* 6 */

        PolyDog myDog = myShihTzu; /* create a second reference using superclass type */
        System.out.println(myDog.canRun()); /* true */

        PolyCanRun myPolyCanRun = myShihTzu; /* creating a reference using interface type */
        System.out.println(myPolyCanRun.canRunFast()); /* false */

        // NOTE: Only one object is created here (ShihTzu)!

        // Once you create a new reference, only the members of that reference type are accessible via that reference (!!)

        PolyCanRun canRun = new PolyShihTzu(); // reference canRun points to ShihTzu object -> OK
        // System.out.println(canRun.weight); // does not compile!

        PolyDog doggy = new PolyShihTzu(); // reference dog points to ShihTzu object -> OK
        // System.out.println(doggy.weight); // does not compile!
        // System.out.println(doggy.canRunFast()); // does not compile!

        PolyShihTzu shihTzuu = new PolyShihTzu();
        System.out.println(shihTzuu.weight);
        System.out.println(shihTzuu.canRunFast());

        /*
        Object vs. Reference
        1. The type of the object determines which properties exist within the object in memory.
        2. The type of the reference to the object determines which methods and variables are accessible to the Java program.

        Reference                   Object in memory (ShihTzu)
        [ shihTzu ] --------------> | weight = 6            |
        [   dog   ] --------------> | canRun()              |
        [ canRun  ] --------------> | canRunFast()          |
         */

        System.out.println("===== S15: Casting =====");

        PolyShihTzu shihTzu3 = new PolyShihTzu();
        PolyDog polyDog3 = shihTzu3; /* implicit casting to a supertype, OK */

        PolyShihTzu shihTzu4 = (PolyShihTzu) polyDog3; /* explicit cast to subtype, OK */

        // PolyShihTzu shihTzu5 = polyDog3; /* ClassCastException - you cannot put larger in smaller without the explicit cast */

        PolyDog myPolyDog6 = new PolyDog();
        //Ford myFord = (Ford) myPolyDog6; /* DOES NOT COMPILE! */

        // TODO: Overriding methods...

        // You can always limit polymorphism by making methods final, in which case they can't be overridden in a subclass.
        // Static methods cannot be overridden...
        // Final/static methods only hide the methods.

        System.out.println("=============== S16: Streams [OCP] ===============");

        System.out.println("========== S16: Optionals ==========");

        /*
        Optional - container object that is used to contain values.
        Like a box - either empty or containing objects.
        Optional object itself (box itself) is never null.
        There are methods to deal with the optional values without explicit null checks.
        Otherwise => NullPointerException.
         */

        Optional<Double> optional1 = Optionalles.average(10, 20, 30);
        System.out.println(optional1); /* Optional[20.0] */
        System.out.println(optional1.isPresent());

        Optional<Double> optional2 = Optionalles.average();
        System.out.println(optional2); /* Optional.empty */
        System.out.println(optional2.isPresent());
        //System.out.println(optional2.get()); /* 'Optional.get()' without 'isPresent()' check! => ⚠️⚠️⚠️ NoSuchElementException: No value present */

        // Good practice:
        // Optional myOptional = (value == null) ? Optional.empty() : Optional.of(value)
        //Double vals = LocalTime.now().getMinute() % 2 == 0 ? Double.valueOf(24) : Double.valueOf(null);
        Double vals = Double.valueOf(24);
        Optional myNullableOptional = Optional.ofNullable(vals);
        System.out.println("myNullableOptional: " + myNullableOptional);

        Optional<Double> optional3 = Optionalles.average(15);
        if (optional3.isPresent()) {
            System.out.println(optional3.get());
        }
        /* or */
        optional3.ifPresent(System.out::println);

        Optional<Double> myOptional = Optionalles.average();
        System.out.println(myOptional.orElse(Double.NaN)); /* NaN */
        System.out.println(myOptional.orElseGet(() -> Math.random())); /* must provide a Double (same type as Optional */

        //System.out.println(myOptional.orElseThrow()); // NoSuchElementException
        //System.out.println(myOptional.orElseThrow(() -> new IllegalStateException()));

        System.out.println("========== S16: Pipelines ==========");

        /*
        Stream in Java is a sequence of data
        Stream Pipeline is set of operations that run on the Stream
        Pipeline ~ an assembly line in a factory.
        - every line has a beginning (source)
        - after that one by one element in the line is processed (intermediate operations)
        - finally, we get the result (terminal operation)
        Date in the stream is not generated up front
        - rather, each element is created when needed -> lazy evaluation
         */

        /*
        Stream Pipeline
        1. Source - where the stream comes from (array of data)
        2. Intermediate operations - transform the stream into another stream
        - there can be many of these operations
        - don't run until terminal operation runs (lazy evaluation)
        3. Terminal Operation - produces a result, can be used once
        - after terminal operation, stream is no longer valid

         YOU CANNOT USE THE SAME STREAM TWICE
         */

        /*
        Stream Pipeline Schema

        [ Source ] -> [ Intermediate operations ] -> [ Terminal operation ]
                      [   ][   ][     ][   ][   ]
                              (optional)
         */

        System.out.println("========== S16: Creating Stream Source ==========");

        // Creating finite streams
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);

        // Converting Collection to Stream
        var list = List.of("a", "b", "c");
        Stream<String> fromList = list.stream();

        // Parallel Stream (operations are done in parallel rather than in sequence
        Stream<String> fromListParallel = list.parallelStream();

        // Create infinite streams
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNums = Stream.iterate(1, n -> n + 2);

        // These streams are infinite, they generate values infinitely:
        //randoms.forEach(System.out::println); /* will print until killed */

        // Operations like limit() can turn infinite stream to finite one

        // Create odd numbers, less than 50
        Stream<Integer> oddNumsUnder50 = Stream.iterate(1, n -> n < 50, n -> n + 2);
        oddNumsUnder50.forEach(System.out::println);

        System.out.println("========== S16: Terminating Stream Source ==========");

        // Counting
        Stream<String> names = Stream.of("John", "George", "Ben");
        System.out.println(names.count()); // 3

        // For infinite streams, count() never terminates.

        // If you invoke stream after being terminated:
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        //	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
        //	at java.base/java.util.stream.ReferencePipeline.reduce(ReferencePipeline.java:662)
        //	at java.base/java.util.stream.ReferencePipeline.min(ReferencePipeline.java:703)

        // Minimum / Maximum
        Stream<String> names2 = Stream.of("John", "George", "Ben");
        Optional<String> min = names2.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        // Using with empty stream:
        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent()); /* false */

        // These methods hang if applied to infinite stream.

        // Find Value from Stream:
        Stream<String> names3 = Stream.of("John", "George", "Ben");
        Stream<String> inf = Stream.generate(() -> "Luke");

        names3.findAny().ifPresent(System.out::println);
        inf.findAny().ifPresent(System.out::println); /* Luke */ /* Terminates infinite stream */

        // findFirst() always returns the first element

        // matching
        var myList = List.of("George", "21", "Ben");
        Stream<String> inf2 = Stream.generate(() -> "Luke");
        Predicate<String> ppp = s -> Character.isLetter(s.charAt(0));

        System.out.println(myList.stream().anyMatch((ppp))); /* true */
        System.out.println(myList.stream().allMatch((ppp))); /* false */
        System.out.println(myList.stream().noneMatch((ppp))); /* false */
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        //	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:229)
        //	at java.base/java.util.stream.ReferencePipeline.anyMatch(ReferencePipeline.java:632)
        //	at JavaApp.main(JavaApp.java:1025)
        // System.out.println(inf.anyMatch(ppp)); /* true */ /* Matching methods terminate infinite streams */

        // iterating
        Stream<String> names5 = Stream.of("John", "George", "Ben");
        names5.forEach(System.out::println); /* JohnGeorgeBen */

        // You cannot use traditional for loop on the Stream:
        Stream<Integer> s = Stream.of(1,2,3);
        //for (Integer i : s) { // DOES NOT COMPILE
        //    // do something
        //}
        // Instead, use forEach() - not a loop, but rather a terminal operator for streams

        // Reducing
        // Usually starts with initial value and merge to the next value
        var myArrayy = new String[] { "L", "u", "k", "e" };
        var result = "";
        for (var sss : myArrayy) result = result + sss; /* accumulator */
        System.out.println(result); /* Luke */

        // Same thing using Streams
        Stream<String> myStreamy = Stream.of("L", "u", "k", "e");
        String myName = myStreamy.reduce("", (sc, cs) -> sc + cs);
        System.out.println(myName); /* Luke */

        /* TODO */

        System.out.println("========== S16: Using Intermediate Operations ==========");

        /* TODO */

        System.out.println("=============== S17: Localization [OCP] ===============");

        System.out.println("========== S17: Formatting Values ==========");

        /*
        Formatting Numbers
        NumberFormat interface
        public final String format(double number)
        public final String format(long number)
         */

        double nummy = 12345.6789;
        NumberFormat form1 = new DecimalFormat("###,###,###.0");
        System.out.println(form1.format(nummy));
        NumberFormat form2 = new DecimalFormat("000,000.000000");
        System.out.println(form2.format(nummy));
        NumberFormat form3 = new DecimalFormat("My Balance: $#,###,###.##");
        System.out.println(form3.format(nummy));

        // Formatting Dates and Times
        /*
        You can use predefined formats (ISO_LOCAL_DATE)
         */

        LocalDate date = LocalDate.of(2023, Month.SEPTEMBER, 14);
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());
        System.out.println(date.getDayOfYear());

        // Display standard formats
        LocalDate datey = LocalDate.of(2023, Month.SEPTEMBER, 14);
        LocalTime timey = LocalTime.of(9, 6, 24);
        LocalDateTime dateTimey = LocalDateTime.of(datey, timey);

        System.out.println(datey.format(DateTimeFormatter.ISO_LOCAL_DATE));             /* 2023-09-14 */
        System.out.println(timey.format(DateTimeFormatter.ISO_LOCAL_TIME));             /* 09:06:24 */
        System.out.println(dateTimey.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));    /* 2023-09-14T09:06:24 */

        // Creating Custom Formats
        var dtt = LocalDateTime.of(2022, Month.SEPTEMBER, 14, 19, 6, 14);

        var f11 = DateTimeFormatter.ofPattern("dd.MM.yyyy.hh:mm:ss");
        System.out.println(dtt.format(f11)); /* 14.09.2022.07:06:14 */

        var f22 = DateTimeFormatter.ofPattern("MMM-dd-yy HH:mm:ss");
        System.out.println(dtt.format(f22)); /* сеп-14-22 19:06:14 */

        var f33 = DateTimeFormatter.ofPattern("MMMM-dd-yy hh:mm:ss a"); /* a = AM */
        System.out.println(dtt.format(f33)); /* септември-14-22 07:06:14 сл.об. */
        /* Alternative syntax! */
        System.out.println(f33.format(dtt)); /* септември-14-22 07:06:14 сл.об. */

        // Insert text values using single quotes:
        var f44 = DateTimeFormatter.ofPattern("'Date:' dd.MM.yy 'Time:' hh:mm:ss");
        System.out.println(f44.format(dtt)); /* Date: 14.09.22 Time: 07:06:14 */

        var f55 = DateTimeFormatter.ofPattern("MMM-dd-yyyy 'at' hh'h'mm'm'ss's'");
        System.out.println(f55.format(dtt)); /* сеп-14-2022 at 07h06m14s */

        System.out.println("========== S17: Internationalization ==========");

        System.out.println("===== S17: Locales =====");

        /*
        Localization - make program adaptable to multiple locations.
        - translating string to different languages
        - output dates in correct format
        - output numbers in correct format
         */

        Locale myLocale = Locale.getDefault();
        System.out.println(myLocale); /* en_GB = language_country */

        /* language - mandatory, country - optional */
        System.out.println(Locale.ITALIAN); /* it */
        System.out.println(Locale.ITALY); /* it_IT */
        System.out.println(new Locale("hi", "OK")); /* hi_OK */

        // Create Local
        Locale myLocaley = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US") /* could be in any order */
                .build();

        Locale localeFrench = new Locale("fr");
        Locale.setDefault(localeFrench);
        System.out.println(Locale.getDefault());

        System.out.println("===== S17: Localizing Numbers =====");

        /*
        Different countries have different conventions when it comes to numbers.
        Localization can help to display the number in the appropriate locale format.
        For this purpose, we use NumberFormat factory method.
         */

        // Formatting Numbers
        double myNummy = 1234.568;

        var us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(myNummy)); /* 1,234.568 */
        var it = NumberFormat.getInstance(Locale.ITALY);
        System.out.println(it.format(myNummy)); /* 1.234,568 */
        var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(myNummy)); /* 1 234,568 */

        // Formatting Currencies
        double price = 12.3;

        var ussy = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(ussy.format(price));
        var uk = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println(uk.format(price));

        // Formatting Percentages
        double discount = 0.151;

        var uspercent = NumberFormat.getPercentInstance(Locale.US);
        System.out.println(uspercent.format(discount)); /* 15% */
        var gerpercent = NumberFormat.getPercentInstance(Locale.GERMANY);
        System.out.println(gerpercent.format(discount)); /* 15 % */

        // Parsing Numbers
        String myNumStr = "15.72";
        var usns = NumberFormat.getInstance(Locale.US);
        // System.out.println(usns.parse(myNumStr)); /* Java.Text.ParseException */

        // Parsing Numbers with Currency

        // using CompactNumberFormat (new in Java 17!)
        int myNum = 8_765_432;
        var us1 = NumberFormat.getCompactNumberInstance();

        /* TODO */

        var hr = new Locale("hr", "HR");
        var priceHr = 4.32;

        System.out.println(hr.getDisplayLanguage()); /* Croatian */
        System.out.println(hr.getDisplayCountry()); /* Croatia */
        System.out.println(NumberFormat.getCurrencyInstance(hr).format(priceHr));

        System.out.println("========== S17: Resource Bundle ==========");

        /*
        Properties file which contains the locale-specific objects for the program.
        Basically a map with keys and values.

         */

        /* TODO */

        System.out.println("=============== S18: Modules [OCP] ===============");

        System.out.println("========== S18: Introduction to Modules ==========");

        /*
        Java Platform Module System (JPMS)
        JAR Files
        Make sure you have compatible versions of all libraries at runtime.

        Benefits:
        Better access control
        Clearer dependency manager
        Custom Java builds - choose which parts of JDK you need
        Improved security
        Improved performance

        Module = folder on your computer which contains:
        - a group of packages
        - module-info.java file
            - contents is called module declaration - defines dependencies
         */

        System.out.println("========== S18: Designing Modular App ==========");

        /* TODO */

        System.out.println("========== S18: Compiling and Running Modules ==========");

        /*
        Compiling with javac:
        Directory for class files   -d <dir>    n/a
        Module path                 -p <path>   --module-path <path>

        Running with java:
        Module name                 -m <name>   --module <name>
        Module path                 -p <path>   --module-path <path>
         */

        System.out.println("========== S18: Build-in Modules ==========");

        System.out.println("========== S18: Command Line Operations ==========");

        System.out.println("========== S18: Named, Automatic, Unnamed Modules ==========");

        System.out.println("========== S18: Migration Strategies ==========");

        System.out.println("=============== S19: Concurrency [OCP] ===============");

        System.out.println("========== S19: Thread Concurrency ==========");

        /*
        Basic Terminology
        - thread -
        - process -
        - shared environment -
        - task - single unit of work performed by the thread
            - implemented as a lambda expression in Java
            - can complete multiple independent tasks
        - shared memory
        - thread concurrency
        - content switch
        - thread priority

        Thread Concurrency
        - property of executing multiple threads and processes at the same time
        - number of threads CAN exceed number of CPUs - OS uses thread scheduler to determine which threads to execute.

        Thread's Life Cycle
        - after a thread is created it exists in 1 of 6 states:
        NEW - created, but not started
        RUNNABLE - running or able to be run
        TERMINATED - task completed
        BLOCKED - waiting to enter synchronized block
        WAITING - waiting indefinitely until notified
        TIMED_WAITING - waiting a specified time
         */

        /*
        Concurrency
        Create a thread
        1. Extend Thread class
        2. Implement Runnable interface
        3. Implement Callable interface (requires ExecutedService)

         */

        MyThreadClass myThreadClass = new MyThreadClass();
        // !!! Executed after printing the other chapters below (S20, S21, S22)
        // We have implemented run() method, but we run start()
        myThreadClass.start();
        /* Thread 'Thread-0' is being executed... */

        new Thread(new MyRunnableClass()).start();
        /* Thread 'Thread-1' is being executed from MyRunnableClass. */

        System.out.println("Thread '" + Thread.currentThread().getName() + "' is being executed");
        /* Thread 'main' is being executed */

        new Thread(() -> System.out.println("Thread '" + Thread.currentThread().getName() + "' is being executed using Lambda expression")).start();
        /* Thread 'Thread-2' is being executed using Lambda expression */

        // ACTION: Check SleepExample class!
        // ACTION: Check SleepInterruptedExample class!

        System.out.println("========== S19: Creating a Thread (intro + examples) ==========");

        System.out.println("========== S19: Using Concurrency API ==========");

        /*
        Concurrency API - import java.util.concurrent Package.
        ExecutedService Interface:
        - Defines services which create and manage threads.
        - Includes features like pooling, thread scheduling etc.
         */

        // Single-thread executor
        ExecutorService execService = Executors.newSingleThreadExecutor();
        // Threads are executed one by one:
        execService.execute(new Thread(() -> System.out.println("execService executes 1st thread!")));
        execService.execute(new Thread(() -> System.out.println("execService executes 2nd thread!")));
        execService.execute(new Thread(() -> System.out.println("execService executes 3rd thread!")));
        execService.shutdown(); /* ⚠️ if omitted, program never ends! */

        /*
        Future<V> instance
        There are 2 ways you can execute Runnable task
        1. using execute(Runnable task) method
        2. using submit(Runnable task) method - returns a value!
        Value is instance of a special interface Future<V>.
        Instance can be used to determine result of execution.
         */

        /*
        TimeUnit.NANOSECONDS
        TimeUnit.MICROSECONDS
        TimeUnit.MILLISECONDS
        TimeUnit.SECONDS
        TimeUnit.MINUTES
        TimeUnit.HOURS
        TimeUnit.DAYS
         */

        ExecutorService execService2 = Executors.newSingleThreadExecutor();

        AtomicInteger count = new AtomicInteger();
        Future<?> resultFuture = execService2.submit(() -> {
            for(int i = 0; i < 10_000_000; i++) count.getAndIncrement(); });

        try {
            var valuee = resultFuture.get(1, TimeUnit.MILLISECONDS);
            if (valuee == null) System.out.println("Task completed.");
        } catch (TimeoutException e) {
            System.out.println("Task didn't complete in time.");
        } catch ( InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        execService2.shutdown();

        System.out.println("========== S19: Atomic Classes ==========");

        System.out.println("========== S19: Synchronized Block ==========");

        System.out.println("========== S19: Using CyclicBarrier ==========");

        System.out.println("========== S19: Concurrent Collections ==========");

        System.out.println("========== S19: Threading Problems ==========");

        System.out.println("=============== S20: I/O [OCP] ===============");

        System.out.println("========== S20: Working with Files ==========");

        System.out.println("========== S20: Console Class ==========");

        System.out.println("========== S20: Serialization ==========");

        System.out.println("=============== S21: JBDC [OCP] ===============");

        System.out.println("========== S21: Introduction to JDBC ==========");

        /*
        JDBC = Java DataBase Connectivity
        - Access data from Relational Database.
        - Relational Databases organize data into tables consisting of rows and columns.

        SQL = Structured Query Language
        - Dialects of SQL - Postgres, MySQL, SQLite, Oracle SQL, Apache Derby etc.

        4 types of Interaction (CRUD):
        - CREATE (CREATE)
        - READ (SELECT)
        - UPDATE (UPDATE)
        - DELETE (DELETE)

         Import Package: java.sql.*
         */

        System.out.println("========== S21: Connecting to a Database ==========");

        /*
        Simple JDBC URL:
        jdbc:postgresql://localhost:5432/phonebook_db
        jdbc:postgresql://127.0.0.1:5432/phonebook_db
        protocol:subprotocol://subname:port/database-name

        Advanced JDBC URL:
        Can contain username, password, enable ssl encryption etc.
        jdbc:postgresql://localhost/phonebook_db?user=petar?password=123?ssl=true
         */

        /*
        🔴 ERROR: No suitable driver found for jdbc:postgresql://localhost:5432/phonebook_db?user=postgres?password=test1234
        1. Download driver (e.g. postgresql-42.7.3.jar) from https://jdbc.postgresql.org/download/.
        2. Move downloaded file to project directory.
        3. Right click, choose 'Add as Library', select OK with default settings.
        4. ✅ SUCCESS!
         */

        var myCarRandom = new Random();

        String[] brands = {
                "Toyota", "Ford", "Chevrolet", "Honda", "Nissan", "BMW", "Mercedes-Benz", "Volkswagen", "Audi", "Hyundai",
                "Kia", "Subaru", "Mazda", "Jeep", "Tesla", "Lexus", "Volvo", "Jaguar", "Porsche", "Ferrari"
        };

        String[] models = {
                "Corolla", "Mustang", "Camaro", "Civic", "Altima", "3 Series", "C-Class", "Golf", "A4", "Elantra",
                "Sorento", "Forester", "CX-5", "Wrangler", "Model S", "RX", "XC90", "F-Type", "911", "488"
        };

        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=test1234";

        try (Connection connection = DriverManager.getConnection(url)) {
            if (connection != null) {
                System.out.println("Connected!");

                // Step 1: Create a new table "Cars" if it does not exist
                String createTableSQL = "CREATE TABLE IF NOT EXISTS Cars (" +
                        "Brand VARCHAR(255), " +
                        "Model VARCHAR(255), " +
                        "Year INT)";
                try (Statement statement = connection.createStatement()) {
                    statement.execute(createTableSQL);
                    System.out.println("Table 'Cars' created successfully (if not already existing).");

                    // Step 2: Insert a new row into the "Cars" table
                    String insertSQL = String.format(
                            "INSERT INTO Cars (Brand, Model, Year) VALUES ('%s', '%s', '%d')",
                            brands[myCarRandom.nextInt(0, brands.length)],
                            models[myCarRandom.nextInt(0, models.length)],
                            myCarRandom.nextInt(2000,2025));
                    statement.executeUpdate(insertSQL);
                    System.out.println("Inserted a new row into the 'Cars' table.");

                    // Step 3: Select all records from the "Cars" table
                    String selectSQL = "SELECT * FROM Cars";
                    ResultSet resultSet = statement.executeQuery(selectSQL);

                    // Print the results
                    System.out.println("Cars table records:");
                    while (resultSet.next()) {
                        String brand = resultSet.getString("Brand");
                        String model = resultSet.getString("Model");
                        int year = resultSet.getInt("Year");
                        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
                    }
                }
            } else {
                System.out.println("Failed connection!");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("========== S21: Using PreparedStatement ==========");

        /*
        To get PreparedStatement objet, we have to use Connection object.
        1. DriverManager -> Connection (using getConnection() method)
        2. Connection -> PreparedStatement (using prepareStatement() method)
        3. PreparedStatement -> Execute SQL Query
         */

        String urlPrepared = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=test1234";

        String queryPrepared1 = "SELECT * FROM cars";

        try (Connection connectionPrepared = DriverManager.getConnection(urlPrepared);
            PreparedStatement ps = connectionPrepared.prepareStatement(queryPrepared1);
            ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                int year = rs.getInt("year");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                System.out.println(brand + ", " + model + ", " + year);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        /*
        PreparedStatement Methods (CRUD operations):
        SELECT:
        ResultSet rs = ps.executeQuery();
        INSERT, UPDATE, DELETE:
        int rowsAffected = ps.executeUpdate();
        SELECT, INSERT, UPDATE, DELETE (when not sure what operation is about to be executed):
        boolean isResultSet = ps.execute();
        true => ResultSet exists => call ps.getResultSet();
        false => no ResultSet => call ps.executeUpdate()
         */

        String urlPreparedExample = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=test1234";

        String queryPreparedExample = "INSERT INTO cars (brand, model, year) VALUES (?, ?, ?)";

        String exampleBrand = brands[myCarRandom.nextInt(0, brands.length)];
        String exampleModel = models[myCarRandom.nextInt(0, models.length)];
        int exampleYear = myCarRandom.nextInt(2000, 2025);

        try (Connection connectionPreparedExample = DriverManager.getConnection(urlPreparedExample);
             PreparedStatement psExample = connectionPreparedExample.prepareStatement(queryPreparedExample)) {
            psExample.setString(1, exampleBrand);
            psExample.setString(2, exampleModel);
            psExample.setInt(3, exampleYear);
            int affectedRows = psExample.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("A new record was inserted successfully!\n" + "Brand: " + exampleBrand + ", Model: " + exampleModel + ", Year: " + exampleYear);
            } else {
                System.out.println("No record was created!");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("========== S21: Using CallableStatement ==========");

        /*
        Stored Procedures - written in SQL.
        CallableStatement allows you to make use of Stored Procedures.

        Stored Procedures:
        - no parameters
        - IN - input parameters
        - OUT - output parameter
        - INOUT - a parameter that server for both input and output
         */

        // Using stored procedure read_phone_by_name(first_name) (IN parameter)

        /*
        String urlCallable = "jdbc:postgresql://localhost/phonebook_db";
        String procedureCall = "{call read_phone_by_name(?)}";

        try (Connection connCallable = DriverManager.getConnection(urlCallable);
             CallableStatement cs = connCallable.prepareCall(procedureCall)) {
            cs.setString(1, "John");
            boolean hasResults = cs.execute();
            if (hasResults) {
                ResultSet rsCallable = cs.getResultSet();
                while (rsCallable.next()) {
                    System.out.println(rsCallable.getString("firstName") + ": " + rsCallable.getString("phone"));
                }
            } else {
                System.out.println("No results!");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
         */

        // Using stored procedure read_phone_by_name(first_name, phone) (IN, OUT)

        /*
        String urlCallable = "jdbc:postgresql://localhost/phonebook_db";
        String procedureCall = "{call read_phone_by_name(?, ?)}";

        try (Connection connCallable = DriverManager.getConnection(urlCallable);
             CallableStatement cs = connCallable.prepareCall(procedureCall)) {
            cs.setString(1, "John");
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            String phone = cs.getString(2);
            System.out.println("Phone number for John: " + phone);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
         */

        System.out.println("========== S21: Resource Leaks ==========");

        /*
        Database resources are expensive and easily multiplied.
        Important to close resources after operation is done!
        Order is important:
        1. ResultSet => rs.close();
        2. PreparedStatement / CallableStatement => stmt.close();
        3. Connection, e.g. conn.close();

        GOOD PRACTICE: Use try-with-resources, but keep the order (reverse order from which they are initialized!
        Check examples above - they are how things should be done!
         */

        System.out.println("=============== S22: Java 21 (1Z0-830 exam) ===============");
        System.out.println("========== S22: Get Certified for Java SE 21 ==========");

        /*
        Get Certified for Java SE 21
        Since the release of Java SE 21 Developer Professional Certificate I highly recommend that you take 1Z0-830 (Java SE 21) exam instead of 1Z0-829 (Java SE 17).
        There are several reason why you should do that:
        It's always better to be certified in latest technology.
        The exam is easier, since pass threshold is the same, but you get 30 minutes more on the exam!
        The preparation is almost identical, if you are ready for Java 17, you'll be able to pass Java 21 with same knowledge.
        You can find more information about recently released exam at the official Oracle website.
        One additional thing you need to learn regarding Java SE 21 is dealing with virtual threads.
        If you understand how threads work in previous versions of Java, this should be an easy read: Virtual Threads.
        ...and you are ready to go! Good luck!
         */
    }
}