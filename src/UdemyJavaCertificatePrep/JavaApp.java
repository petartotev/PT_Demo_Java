// import java.util.Random; /* OK */
// import java.util.*       /* OK, '.*' is called 'wildcard' */
// import java.util.*.*     /* 🔴 ERROR: Does not compile with 2 wildcards! */
import BeyondClasses.*;
import ClassDesign.*;
import Collections.ElCollector;
import Concurrancies.MyRunnableClass;
import Concurrancies.MyThreadClass;
import DataTypes.*;
import Exceptional.Door;
import Exceptional.Exceptionalissimo;
import Exceptional.MyFileClass;
import Exceptional.OutOfMilkException;
import FlowControl.FlowController;
import FunctionalProgramming.*;
import Methodology.MethodItem;
import Methodology.MethodMan;
import Methodology.MethodStaticItem;
import Operators.SmoothOperator;
import Streams.Optionalles;

import java.io.File;
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

// 💡 FACT: Class JavaApp is initialized automatically, as main() method is inside the class.
public class JavaApp {
    public static void main(String[] args) throws IOException, OutOfMilkException {
        System.out.println("=============== UDEMY.COM Java Certificate Prep: OCA (1Z0-808) & OCP (1Z0-829, 1Z0-830) by Luka Popov ===============");
        System.out.println("=============== S1: INTRODUCTION ===============");

        /*
        💡 SUGGESTION: Practice with mock exams, e.g. https://enthuware.com/
        (their questions are harder than the ones in the exam)
        Recommended IDEs:
        - IntelliJ
        - Eclipse
        - NetBeans
        Download JDK: JDK 1.8 (OCA), JDK 17 (OCP) or use online compilers:
        - https://www.jdoodle.com/online-java-compiler-ide
        - https://onecompiler.com/jshell
        Literature:
        - "OCA..."
        - "OCP Oracle Certified Professional Java SE 17 Developer Study Guide: Exam 1Z0-829" by Jeanne Boyarsky & Scott Selikoff
         */

        System.out.println("=============== S2: BUILDING BLOCKS [OCA, OCP] ===============");
        System.out.println("========== S2: The Environment [OCA]  ==========");

        /*
        Components of Java:
        - JDK (Java Development Kit)
        -- OpenJDK 1.8 (OCA) / 17 (OPA) - Oracle's JDK
        - JDK Key Commands
        -- javac: converts .java source files into .class bytecode
        -- java: executes a program
        -- jar: java archive (packaging files together)
        -- javadoc: for documentation
        - JRE (Java Runtime Environment)
        Allows users to run Java apps.
        After Java 8, one just uses full JDK to run Java apps (no separate JRE required).
         */

        System.out.println("========== S2: Class Structure [OCA]  ==========");

        /*
        Class - basic building block of Java programs.
        Object (realization) - instance of Class (blueprint).
        Reference - a variable that points to an object (the "name" of the Object instance).
        Members = Fields + Methods.
        Fields - hold information about the state of an object or a class.
        Methods (functions) - describe action or operation on the state.
         */

        Student myStudent = new Student();
        myStudent.setName("Petar");
        System.out.println((myStudent.getName()));

        /*
        1 file can contain multiple classes, but only 1 is top-level class (usually marked as public).
        If marked as public, file name must match class name.
        Only 1 class in a single file can be marked as public.
        👍 GOOD PRACTICE: Have each class in its own .java file.
         */

        Item myItem = new Item();
        SpecificItem mySpecificItem = new SpecificItem(); /* Internal class in the same Item.java file */

        System.out.println("========== S2: The main() method [OCA]  ==========");

        /*
        main() method - starts the Java program.
        public static void main(String[] args) { }
        - public - access modifier
        - static - method belongs to class (not to instance)
        - void - no return type
        - String[] args - input parameters (array of Strings)

        Alternative syntax of main() which works:
        public static void main(String[] args) { }
        public static void main(String[] someFunkyThings) { }
        public static void main(String args[]) { }
        public static void main(String... args) { }
        public final static void main(final String[] args) { }
        static public void main(String[] args) { }
         */

        // 🔴 ERROR:   Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0 at JavaApp.main(JavaApp.java:115)
        // ✅ SUCCESS: Go to Run/Debug Configurations > [...] > Run with parameters > Choose Program arguments (separated by BLANK SPACE).

        System.out.println("First name: " + args[0]);
        System.out.println("Last name: " + args[1]);

        /*
        javac JavaApp.java -> JavaApp.class
        java JavaApp Petar Totev
        => First name: Petar
           Last name: Totev

        java JavaApp John D. Wayne
        => First name: John
           Last name: D.

        java JavaApp "John D." Wayne
        => First name: John D.
           Last name: Wayne
         */

        System.out.println("========== S2: Packages [OCA]  ==========");

        /*
        Packages - Java classes are stored in packages.
        Packages ~ folders in which classes are stored.
        In order ot use a class, you must IMPORT a package in your program.
        Naming packages: com.udemy.javacourse.ocp; a.b.c
        => "com" folder contains "udemy" subfolder containing "javacourse" subfolder having "ocp" subfolder containing classes.
         */

        // Option 1 (explicit naming):
        java.util.Random myRandomExplicit = new java.util.Random();
        System.out.println(myRandomExplicit.nextInt(0,101));

        // Option 2 (using imports):
        //import java.util.Random;
        //import java.util.*;
        Random myRandomImported = new Random();
        System.out.println(myRandomImported.nextInt(0,101));

        Randomizer myRandomizer = new Randomizer();
        System.out.println(myRandomizer.getRandomNumber());

        /*
        import java.util.Date;
        import java.sql.Date; 🔴 ERROR: Does not compile!

        import java.util.Date;
        import.java.sql.*; ✅ SUCCESS: Java will use java.util.Date when Date is referenced.
         */

        System.out.println("========== S2: Compile, Run and Archive [OCA]  ==========");
        /* TODO */

        /*
        2 classes:
        1st class:
        2nd class:
        ...

        javac -d classes ocppackage/Ocp.java ocapackage/Oca.java

        /ocppackage
            Ocp.java
        /ocapackage
            Oca.java
        /classes
            /ocppackage
                Ocp.class
            /ocapackage
                Oca.class

        java -cp classes ocppackage.Ocp
        java -classpath classes ocppackage.Ocp
        java --class-path classes ocppackage.Ocp

        // from files in current folder
        jar -cvf myNewJarFile.jar .
        jar --create --verbose --file myNewJarFile.jar .

        // from files in custom folder
        jar -cvf myNewJarFile.jar -C myFolder
        jar --create --verbose --file myNewJarFile.jar -C myFolder
         */

        System.out.println("========== S2: Objects [OCA]  ==========");

        /*
        Code block - { ... }
        Instance initializer - code block outside the method.

        Order of initialization:
        1. Fields and instance initializer blocks in order which they appear.
        2. Constructor runs in the end.
         */

        Doggy myDoggyDog = new Doggy();
        System.out.println((myDoggyDog.name)); /* java: name has private access in Dog */

        /*
        Output:
        1. Initializer block executed!
        2. Constructor executed! Dog's name set to Rex!
        3. Rex
         */

        System.out.println("========== S2: Data Types [OCA]  ==========");

        /*
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#data-types

        Boolean 'true' and 'false' are completely unrelated to 1 and 0!
        Float requires f (or F) at the end.
        Long requires l (or L) at the end:
        long a = 29135135136136;  🔴 ERROR: Does not compile!
        long a = 29135135136136L; ✅ SUCCESS: Compiles!
        Bit size of boolean is not specified (depends on JVM).
         */

        int myIntInt = 1_000_000;
        int myStrangeTwelve = 1_2;
        int myStrangeTwelve2 = 1________2;
        double myDoubleDouble = 1_000_000.000_001;
        //double myInvalidDouble1 = _10.1; 🔴 ERROR: Does not compile!
        //double myInvalidDouble2 = 10.1_; 🔴 ERROR: Does not compile!
        //double myInvalidDouble3 = 10_.1; 🔴 ERROR: Does not compile!
        //double myInvalidDouble4 = 10._1; 🔴 ERROR: Does not compile!

        /*
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#wrapper-classes

        Primitives are not objects, but sometimes we prefer to work with objects - we use wrapper classes!
        Wrapper class = object type that corresponds to a primitive.
         */

        Integer wrapperInt = Integer.valueOf(5); /* valueOf == static method */ /* ⚠️ WARNING: Unnecessary boxing! */
        Integer numOutOfString = Integer.valueOf("12"); /* valueOf used to convert String into wrapper class */
        Integer usefulMethodInt = Integer.parseInt("101");
        //Integer p = new Integer(5); 🔴 ERROR: Does not compile! Deprecated, not impossible after Java 9!

        Numberinho myNumberinho = new Numberinho();
        myNumberinho.playWithNumbersAndUnderscores();

        /*
        Strings are NOT primitive types in Java!
         */

        System.out.println("========== S2: Text Blocks [OCP]  ==========");

        StringDogg myStringDogg = new StringDogg();

        /*
        Text blocks were introduced in Java 15.
         */

        /* there should be a new line after """ */
        /* white space which is common in front is ignored */
        /* white space after the common block will be included */
        String myFirstTextBlock = """ 
                "Java SE 17 Developer Course"
                      by Luka Popov""";
        String mySecondTextBlock = """
                      "Java SE 17 Developer Course"
                      by Luka Popov
                      """;
        System.out.println(myFirstTextBlock + "Hello!");  /* ... by Luka PopovHello!   */
        System.out.println(mySecondTextBlock + "Hello!"); /* ... by Luka Popov\nHello! */

        myStringDogg.playWithTextBlocks();
        System.out.println((myStringDogg.GREATEST_RAPPER));

        System.out.println("========== S2: Variables [OCA]  ==========");

        /*
        Variable - name for a piece of memory which stores data.
        Declare Variable - state variable type and give it a name:
        int x;
        Initialize variable - give variable a value:
        int x = 5;
        Identifier - name of variable.

        Identifier rules:
        1. Must begin with letter, currency symbol ($) or underscore (_).
        2. Can include numbers, but cannot start with a number.
        3. Single underscore is not allowed as identifier.
        4. You cannot use the reserved words as identifiers!
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#special-words

        Naming conventions (not obligatory):
        1. For variables and methods, use camelCase!
        2. For constants, use SNAKE_CASE!
        3. Identifiers of classes, interfaces, enums, use PascalCase!
         */

        int yin, yang; /* ⚠️ WARNING: Multiple variables can be declared on the same line, but NOT a good practice! */
        String myFunkyFirstName = "John", myFunkySecondName = "Snow";
        boolean vv = true, ww, zz = false;
        //int x, String name; /* 🔴 ERROR: Does not compile! */

        /*
        3 kinds of Variables:
        - local variables - within a block of code { ... }
        - instance variables (fields) - within an instance of a class
        - class variables (static) - belong to the whole class, all instance share it

        💡 FACT: Instance and class variables DO NOT require initialization! Local variables MUST be initialized before use!
         */

        /*
        Final Variables (constants)
        Cannot be changed!
        Can be applied to a reference!
        Reference cannot be modified, but the content of the object can!
         */

        final int MAX_HUMAN_HEIGHT = 240;
        final int[] MY_NUMBERS = new int[5];
        MY_NUMBERS[2] = 13;
        System.out.println(MY_NUMBERS[2]);
        //MY_NUMBERS = null; /* 🔴 ERROR: Does not compile! */

        /*
        Variable Scope
        Variables can go out of scope (cease to exist).
        Local variables: { to }.
        Method parameters: { duration of method }.
        Instance variables: in scope from declaration to garbage collection.
        Class variables: in scope from declaration until program ends.
         */

        System.out.println("========== S2: Local Variable Type Interface (LVTI) [OCP]  ==========");

        /*
        LVTI introduced in Java 10.
        LV => ONLY FOR local variables!
        TI => Inferred by the compiler.
         */

        var myA = 5; /* myA type is inferred by compiler */
        //var myA = "John Wayne"; /* 🔴 ERROR: Does not compile! Stays for the duration of the variable scope. */

        //var s = null; /* 🔴 ERROR: Does not compile! Cannot assign null to LVTI! */

        /* Var is not a reserved word (due to backward compatibility reasons)! */
        class Var { } /* ⚠️ WARNING: OK, but a BAD practice! */
        var var = 5;  /* ⚠️ WARNING: OK, but a BAD practice! */

        System.out.println("========== S2: Garbage Collection [OCA]  ==========");

        /*
        All Java objects are stored in Program's Memory Heap (a.k.a. free store).
        GC is a process of automatically freeing memory of the heap by removing objects no longer reachable in the program.
        If an object is eligible for GC, Java can remove it from Memory Heap.
        Process is out of our control - one cannot know if and when memory will be freed!

        💡 FACT: GC only cleans the HEAP!!! GC collects only objects, not references, even if they are hanging unused!
        📖 EXAM: Question: Which object is eligible for Garbage Collection?
         */

        System.gc(); /* ⚠️ WARNING: You suggest Java to clean the Heap, but not guaranteed to do anything! */

        System.out.println("=============== S3: OPERATORS [OCA, OCP] ===============");

        /*
        z = a + b is operation, where:
        z is result
        a and b are operands
        + is operator
        = is assignment operator.

        Unary operator: a++;
        Binary operator: a = b + c;
        Ternary operator: a = (b > 0) ? 3 : 2;

        Operator precedence!
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#operators
         */

        int myCalculation = 2 + 2 * 2 + 10 / 5 + 1; /* 9 */
        boolean myBooleanCalc = 2 > 1 && 2 + 2 * 2 == 5; /* false */

        int someValue = 1;
        int someValue2 = ++someValue*2; /* 4 */
        int anotherValue = 1;
        int anotherValue2 = anotherValue++*2; /* 2 */

        var myOperator = new SmoothOperator();

        myOperator.playWithUnaryOperators();
        myOperator.playWithBinaryOperators();
        myOperator.playWithAssignmentOperators();
        myOperator.playWithComparisonOperators();

        System.out.println("=============== S4: FLOW CONTROL [OCA, OCP] ===============");

        /*
        ⚠️ WARNING: Switch using Boolean, Long, Float, Double is not allowed!
        ⚠️ WARNING: Switch expression must handle all possible cases!
         */

        var myFlowController = new FlowController();

        myFlowController.switchItLikeInJava8(4);
        myFlowController.switchItLikeInJava17(3);
        myFlowController.switchExpressionWithJava17(100);
        myFlowController.switchExpressionWithUndefinedType(23);

        /*
        TODO: Switch expression using Enum!
         */

        myFlowController.playWithNamedWhileLoop();
        myFlowController.playWithMultipleNamedWhileLoops();
        myFlowController.playWithNestedWhileLoops();
        myFlowController.playWithDoWhileLoop();

        myFlowController.playWithForLoop();
        myFlowController.playWithForLoopHavingMultipleParams();
        // myFlowController.playWithInfiniteForLoop();
        myFlowController.playWithForeachLoop();

        System.out.println("=============== S5: STRINGS [OCA, OCP] ===============");
        System.out.println("========== S5: String Methods [OCA] ==========");

        /*
        String is a sequence of characters, implementing CharSequence interface.
        String name = "John Wayne";
        String name = new String("John Wayne");

        Concatenation:
        System.out.println(str1 + str2)
        System.out.println(str1.concat(str2));

        ⚠️ WARNING: Concatenation is processed from left to right!
         */

        myStringDogg.playWithConcatenation();

        myStringDogg.playWithStringMethods();

        /*
        STRINGS ARE IMMUTABLE!
         */
        String nameToImmute = "John Wayne";
        nameToImmute.toUpperCase();
        System.out.println("nameToImmute = " + nameToImmute); /* John Wayne */

        System.out.println("========== S5: StringBuilder [OCA] ==========");

        /*
        StringBuilder is a MUTABLE class which contains a String, which contains useful methods for manipulating strings.
         */

        myStringDogg.playWithStringBuilder();

        System.out.println("========== S5: String Pool [OCA] ==========");

        /*
        JVM stores a new string with literal value "John" in the memory location known as 'String Pool' or 'Intern Pool'.
        Next, one creates a new string variable and assign the same literal value "John".
        Java will save memory and look in the String pool for such literal.
        New variable will point to the existing location in the String pool.
         */

        String firstNameToTestStringPools = "Johnny Bravo";
        String secondNameToTestStringPools = "Johnny Bravo";
        System.out.println(firstNameToTestStringPools == secondNameToTestStringPools); /* true (same reference!) */

        myStringDogg.playWithStringPool();

        System.out.println("=============== S6: ARRAYS [OCA, OCP] ===============");
        System.out.println("========== S6: Creating an Array [OCA] ==========");
        System.out.println("========== S6: Sorting, Searching, Comparing Arrays [OCA] ==========");

        /*
        ⚠️ WARNING: Arrays don't implement equals method!
         */

        var myArrayCharles = new ArrayCharles();
        myArrayCharles.playWithArrays();

        System.out.println("========== S6: Multidimensional Arrays [OCA] ==========");

        myArrayCharles.playWithMultidimensionalArrays();

        System.out.println("=============== S7: DATE AND TIME [OCA, OCP] ===============");

        DateTimmy myDateTimmy = new DateTimmy();

        System.out.println("========== S7: Creating Dates and Times [OCA] ==========");

        /*
        import java.time.* package
         */

        myDateTimmy.playWithDateAndTime();

        System.out.println("========== S7: Methods on Dates and Times [OCA] ==========");

        myDateTimmy.playWithDateAndTimeMethods();

        System.out.println("========== S7: Period, Duration, Instant [OCA] ==========");

        myDateTimmy.playWithDatePeriods();
        myDateTimmy.playWithTimeDurations();
        myDateTimmy.playWithInstants();

        System.out.println("=============== S8: METHODS [OCA, OCP] ===============");

        MethodMan myMethodMan = new MethodMan();

        System.out.println("========== S8: Defining Methods [OCA] ===============");

        /*
        public final void printName(String name) throws InterruptedException { }

        Method name is Java Identifier (same rules as variable names).
        Parameters in Parameter List are separated by comma.
        Methods must have a body { } (even empty).
         */

        System.out.println("========== S8: Local and Instance Variables [OCA] ===============");

        /*
        Local Variable
        - defined inside  the block of code { }, go out of scope.
        - can have only 1 optional modifier: final.
        - once final variable is assigned a value - it can't be changed.
        - "effectively final" - if you can put 'final' in variable declaration and code still compiles.
        - all local variables must be explicitly initialized before used.

        Instance variables
        - defined on class level (belong to instance of class).
        - can have many optional modifiers: private, protected, public
        - can be marked as final, volatile, transient
        - if not initialized, they assume default values depending on type.

        Final - means that variable reference is constant!
         */

        MethodItem myMethodItem1 = new MethodItem();
        MethodItem myMethodItem2 = new MethodItem();

        // public double tax = 0.2;
        System.out.println(myMethodItem1.getPrice(100)); /* 126.0 */
        myMethodItem2.tax = 0.1;
        System.out.println(myMethodItem2.getPrice(100)); /* 115.50000000000001 */
        System.out.println(myMethodItem1.getPrice(100)); /* 126.0 */

        // final double margin = 0.05;
        System.out.println(myMethodItem1.getFinalMarginPrice(100));
        myMethodItem1.printSomethingUsingFinalArray();

        System.out.println("========== S8: Variable Arguments (Varargs) [OCA] ===============");

        myMethodMan.playWithVarArgsVariableArguments("test1", "test2", "test3");

        String[] myArgs = new String[] { "test333", "test666" };
        myMethodMan.playWithVarArgsVariableArguments("test111", myArgs); // but not anonymous array!

        /* ⚠️ WARNING: You cannot pass an anonymous array (!) */
        //myMethodMan.playWithVarArgsVariableArguments("test111", {"1","2","3"}); /* 🔴 ERROR: Array initializer is not allowed here!

        /* 💡 FACT: Varargs can be used in the main() method: */
        //public static void main(String... args) { }

        System.out.println("========== S8: Access Modifiers [OCA] ===============");

        /*
        Method Access Modifiers:
        - private - can be accessed only within the class they are declared
        - default (no keyword) - can be accessed only within the same package
        - protected - can be accessed within the same package and outside package from child classes
        - public - can be accessed from everywhere
         */

        System.out.println("========== S8: Static Members [OCA] ===============");

        // public static double taxStatic = 0.2;
        System.out.println("Static price myMethodItem1: " + myMethodItem1.getStaticPrice(100)); /* 126.0 */
        myMethodItem2.taxStatic = 0.1; /* ⚠️ WARNING: taxStatic also changed for myMethodMan1! */
        System.out.println("Static price myMethodItem2: " + myMethodItem2.getStaticPrice(100)); /* 115.50000000000001 */
        System.out.println("Static price myMethodItem1: " + myMethodItem1.getStaticPrice(100)); /* 115.50000000000001 */

        MethodStaticItem myMethodStaticItem = new MethodStaticItem();
        myMethodStaticItem.greet1();
        myMethodStaticItem.greet2();
        myMethodStaticItem.greet3();

        // Constants: usually marked 'static final' and SNAKE_CASE:
        System.out.println(myMethodMan.VALUE_ADDED_TAX);
        System.out.println(myMethodMan.TEST_CONST);

        // Static Imports
        myMethodMan.printPowOfTwo(5);

        System.out.println("========== S8: Boxing and Unboxing [OCA] ===============");

        /*
        Boxing - converting ("putting") a primitive into its wrapper class.
        Unboxing - converting a wrapper class to a primitive.
         */

        myMethodMan.playWithBoxingAndUnboxing();

        System.out.println("========== S8: Overloading Methods [OCA] ===============");

        myMethodMan.playWithOverloadedMethods();

        try {
            myMethodMan.playWithMethodSignature("test");
        } catch (InterruptedException iex) {
            System.out.println(iex.getMessage());
        } finally {
            System.out.println("myMethodMan.playWithMethodSignature was executed!");
        }

        System.out.println("=============== S9: CLASS DESIGN [OCA, OCP] ===============");
        System.out.println("========== S9: Inheritance [OCA] ===============");

        Animal myAnimal = new Animal();     /* superclass (parent) */
        Dog myDogExtendsAnimal = new Dog(); /* subclass (child) */

        /*
        Inheritance: Subclass can inherit members (fields and methods) from superclass.
        Inheritance is transitive!
        Java supports single inheritance - class can have only 1 direct superclass.
         */

        Animal myAnimalTransitive = new Animal(); /* superclass of Mammal */
        Mammal myMammalTransitive = new Mammal(); /* superclass of Dog - TRANSITIVE INHERITANCE! */
        Dog myDogTransitive = new Dog(); /* subclass */

        Classy myClassy = new Classy();

        /*
        Class Modifiers:
        - final
        - abstract
        - static
        - sealed        (Java 17)
        - non-sealed    (Java 17)
         */

        /*
        All Java classes inherit from java.lang.Object class:
            public class Dog { }
            public class Dog extends java.lang.Object { }
        Object has access to:
        - toString()
        - equals()
        - hashCode()
         */

        System.out.println("========== S9: Creating Classes [OCA] ===============");

        Mammal myCreatingClassMammal = new Mammal();
        System.out.println("myCreatingClassMammal age before: " + myCreatingClassMammal.getAge());
        myCreatingClassMammal.setAge(23);
        System.out.println("myCreatingClassMammal age after: " + myCreatingClassMammal.getAge());

        Cat myCat = new Cat(); /* extends Mammal */
        myCat.setNameAndAge("Rex", 5);
        myCat.meow();

        /*
        💡 FACT: If one of the classes is not public, you can have both classes in the same file.

        Keyword 'this' is used to access the members of the class you are in.
        Check Mammal.setAge();
        Keyword 'super' is used to access members of the superclass.
        Check Cat.setNameAndAge();
         */

        System.out.println("========== S9: Creating Constructors [OCA] ===============");

        /*
        ⭐ DEFINITION: Constructor - special method called every time you create an instance of an object.
        - Name of constructors must match class name.
        - Constructors don't have return type!

        💡 FACT: If class has no defined constructors => default constructor is created automatically:
        Dog() { }
         */

        Dog myDog1 = new Dog();
        Dog myDog2 = new Dog("Max");
        Dog myDog3 = new Dog("Max", 5);

        /*
        Constructors access modifiers:
        - public - constructors are usually made public
        - protected
        - default
        - private - if you don't want public no-argument constructor generated automatically.
        In this case, instance is usually created via some static method, and not using the keyword new.
         */

        System.out.println("========== S9: Using this() and super() [OCA] ===============");

        Elephant myElephant = new Elephant();

        /*
        this() Rules:
        1. Can be called in the first line of the constructor.
        2. Can be called only once.
        3. ⚠️ WARNING: Can create a cycle - constructors calling each other infinitely!
         */

        /*
        super() Rules:
        1. Must be called in the fist line of the constructor.
        2. Can be called only once.
        3. ⚠️ If no explicit this() or super() in the first line of the constructor, the compiler adds super() at the beginning of every constructor.
         */

        System.out.println("========== S9: Initializing Objects [OCA] ===============");

        /*
        Order of initialization:
        1. If superclass => initialized first
        2. All static variables are processed (in order of appearance)
        3. All static initializers are processed (in order of appearance)

        This all happens at most once for each class!
         */

        /* Order of Initialization when creating an Instance
        1. Initialize the class if it was not already initialized.
        2. If there is a superclass, initialize superclass.
        3. Process all instance variable declarations.
        4. Process all instance initializers.
        5. Initialize the constructor.
        TODO: Watch this again!
         */

        System.out.println("========== S9: Inheriting Members [OCA] ===============");

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

        /*
        TODO:
        Overriding private and static methods.
         */

        System.out.println("=============== S10: ABSTRACT CLASSES AND INTERFACES [OCA, OCP] ===============");

        System.out.println("========== S10: Abstract Classes [OCA]  ==========");

        /*
        Abstract class can be extended, but cannot be initialized.
        Abstract class can have constructors, but can be called only using 'super()' from the child class.
        ⚠️ WARNING: Abstract class or abstract method cannot be marked 'final'.
        ⚠️ WARNING: Abstract method cannot be marked 'private'.
        ⚠️ WARNING: 'abstract static' is not allowed (as static method cannot be overridden).
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
        System.out.println(Drivable.getSomethingFromStaticMethod());

        /*
        Rules for Using Private Interface Methods:
        1. marked with keyword 'private'
        2. must have a body
        3. private static methods may be called by any method in the interface
        4. non-static private methods may be called only by non-static methods
         */

        System.out.println("=============== S11: LAMBDAS AND FUNCTIONAL PROGRAMMING [OCA, OCP] ===============");

        System.out.println("========== S11: Functional Interfaces and Lambdas [OCA]  ==========");

        /*
        Functional Interface: an interface which has exactly one abstract method.
        Can be annotated with @FunctionalInterface.
        Pre-defined Functional Interfaces: Supplier, Predicate, Function etc.
        import java.util.function package
         */

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

        /*
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#method-references
         */

        Furniture myFurniture1 = s -> System.out.println(s); /* Lambda can be replaced with method reference. */
        myFurniture1.contain("myFurniture1");
        Furniture myFurniture2 = System.out::println;
        myFurniture2.contain("myFurniture1");
        Book myBook1 = (a,b) -> Math.min(a, b);
        myBook1.describeMinimal(5, 7);
        Book myBook2 = Math::min;
        myBook2.describeMinimal(5, 7);

        GravityCalculator myGravity = Gravity::freeFall;
        System.out.println(myGravity.path(5));

        System.out.println("========== S11: Built-In Functional Interfaces [OCP]  ==========");

        /*
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#Functional-Interfaces

        📦 import java.util.function package
        - contains many built-in functional interfaces
        - you need to know:
            - name of the interface
            - signature of the abstract method
            - return type of the abstract method
        a.k.a. FUNCTIONAL PROGRAMMING
         */

        System.out.println("===== Supplier =====");

        /*
        @FunctionalInterface
        public interface Supplier<T> {
            T get();
        }
         */

        Supplier<LocalDateTime> localDateTimeSupplier = () -> LocalDateTime.now();
        System.out.println("localDateTimeSupplier: " + localDateTimeSupplier.get());

        System.out.println("===== Consumer, BiConsumer =====");

        /*
        @FunctionalInterface
        public interface Consumer<T> {
            void accept(T t);
        }

        @FunctionalInterface
        public interface BiConsumer<T, U> {
            void accept(T t, U u);
        }
         */

        Consumer<String> greetConsumer = s -> System.out.println("Hi, " + s + "!");
        greetConsumer.accept("John");

        BiConsumer<String, String> greetBiConsumer = (s, t) -> System.out.println("Hi, " + s + " " + t + "!");
        greetBiConsumer.accept("John", "Snow");

        System.out.println("===== Predicate, BiPredicate =====");

        /*
        @FunctionalInterface
        public interface Predicate<T> {
            boolean test(T t);
        }

        @FunctionalInterface
        public interface BiPredicate<T, U> {
            boolean test(T t, U u);
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
        }

        @FunctionalInterface
        public interface BiFunction<T, U, R> {
            R apply(T t, U u);
        }
         */

        Function<Integer, Double> squareFunction = n -> (double)(n*n);
        var resultFunction = squareFunction.apply(5);
        System.out.println(resultFunction);

        BiFunction<String, Integer, String> concatenationBiFunction = (s, i) -> s + i;
        var resultBiFunction = concatenationBiFunction.apply("John", 25);
        System.out.println(resultBiFunction);

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

        UnaryOperator<Integer> negativeUnaryOperator = n -> -n;
        System.out.println(negativeUnaryOperator.apply(5));

        UnaryOperator<String> shoutUnaryOperator = String::toUpperCase;
        System.out.println(shoutUnaryOperator.apply("John"));

        BinaryOperator<Double> addBinaryOperator = (a, b) -> a + b;
        System.out.println(addBinaryOperator.apply(3.5, 1.5));

        BinaryOperator<String> connBinaryOperator = String::concat;
        System.out.println(connBinaryOperator.apply("John", "Snow"));

        System.out.println("========== S11: Combining Implementations [OCP]  ==========");
        System.out.println("===== S11: Helper Methods by Functional Interfaces [OCP]  =====");

        /*
        Consumer => andThen()
        Function => andThen(), compose()
        Predicate => and(), or(), negate()
         */

        Consumer<String> greet1 = s -> System.out.println("Hello, " + s + "!");
        Consumer<String> greet2 = s -> System.out.println("Goodbye, " + s + "!");
        Consumer<String> greet1and2 = greet1.andThen(greet2);
        greet1and2.accept("John"); /* Hello, John! Goodbye, John! */
        // Another way for the same thing:
        System.out.println();
        greet1.andThen(greet2).accept("John"); /* Hello, John! Goodbye, John! */

        Function<Integer, Integer> double123 = n -> n*n;
        Function<Integer, Integer> triple123 = n -> 3*n;
        // First function, then second function.
        Function<Integer, Integer> f1 = double123.andThen(triple123); /* (5 x 5) * 3 = 75 */
        System.out.println(f1.apply(5));
        // Second function first, then first function second.
        Function<Integer, Integer> f2 = double123.compose(triple123); /* (5 x 3) * (5 x 3) = 225 */
        System.out.println(f2.apply(5));

        Predicate<Integer> gt100 = n -> n > 100;
        Predicate<Integer> lt200 = n -> n < 200;
        Predicate<Integer> p1 = gt100.and(lt200);
        Predicate<Integer> p2 = gt100.or(lt200);
        Predicate<Integer> p3 = lt200.negate();

        System.out.println(p1.test(50)); /* false */
        System.out.println(p2.test(50)); /* true */
        System.out.println(p3.test(150)); /* if true, returns false */

        System.out.println("========== S11: Functional Interfaces for Primitives [OCP]  ==========");

        /*
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#Common-Functional-Interfaces-for-Primitives
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#Primitive-Specific-Functional-Interfaces

        TODO: Revise Primitive Specific Functional Interfaces
         */

        System.out.println("=============== S12: COLLECTIONS [OCA, OCP] ===============");
        System.out.println("========== S12: Common Collection Methods [OCA] ==========");

        /*
        ⭐ DEFINITION: Interfaces referred to as Collections: List, Set, Queue (Deque), Map
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#Collections

        List implements Collection
            ArrayList implements List (OCA)
        Set implements Collection
            HashSet implements Set
            TreeSet implements Set
        Queue implements Collection
            Deque implements Queue
            LinkedList implements Queue and List
        Map DOES NOT implement Collection (referred to as collections with lower 'c' - behave like collections, but they are not)
            HashMap implements Map
            TreeMap implements Map

        Diamond operator (<>) - used to imply the type of the element in the collection, e.g.:
        List<String> names = new ArrayList<String>();
         */

        ElCollector myCollector = new ElCollector();

        myCollector.playWithCommonCollectionMethods();

        System.out.println("========== S12: List Interface [OCA] ==========");

        /*
        ⭐ DEFINITION: List - an ordered collection that can contain duplicate entries.
        Unlike array, its size can change after being declared.
        2 classes implement List:
        - ArrayList - when you read more than you write
        - LinkedList - implements List and Deque [deck], a.k.a. "double-ended queue"

        2 ways to create List:
        - using Factory Methods
        - using Constructor

        Create List using FACTORY METHOD (⚠️ WARNING: Size is fixed (no adding or removing)):
        1. Arrays.asList(varargs) => fixed-size list backed by an array. Change array => changes list and vice versa.
        2. List.of(varargs) => returns immutable list.
        3. List.copyOf(collection) => returns immutable list, but as a copy of the original values.

        Create List using CONSTRUCTOR
         */

        myCollector.playWithListsCreatedByFactoryMethods();
        myCollector.playWithListsCreatedByConstructor();

        myCollector.playWithListMethods();
        myCollector.playWithTwoWaysToUseRemoveMethodForIntegers();

        System.out.println("========== S12: Set Interface [OCP] ==========");

                /*
        Set Interface - doesn't allow duplicate entries!

        2 implementations:
        - HashSet - stores key-value elements in hash table (key is hashCode(), value is Object)
            - 🔴 Does not keep order!
            - ✅ Takes the same time to add elements!
        - TreeSet - stores element in a sorted tree structure
            - ✅ Keeps order!
            - 🕑 Takes more time to add elements!
         */

        myCollector.playWithSets();

        System.out.println("========== S12: Queue Interface [OCP] ==========");

        /*
        ⭐ DEFINITION: Queue - First In, First Out (FIFO).
        Queue Interface is implemented by LinkedList class
        Proper methods: peek(), offer(E e), poll()
        Collection methods: element(), add(E e), remove()
         */

        myCollector.playWithQueues();

        System.out.println("========== S12: Deque Interface [OCP] ==========");

        /*
        ⭐ DEFINITION: Deque = double-ended queue.

        Deque Interface used as Stack:
        Implemented by ArrayDeque.
        LIFO = Last In First Out
        Proper methods: peek(), push(), poll()
        Collection methods: element(), add(E e), remove()
         */

        myCollector.playWithDequeuesAsStack();

        /*
        Deque Interface used as Double-Ended Queue:
        Implemented by LinkedList.
        Proper methods:
        - peekFirst(), offerFirst(), pollFirst()
        - peekLast(), offerLast(), pollLast()
        Collection methods:
        - getFirst(), addFirst(E e), removeFirst()
        - getLast(), addLast(E e), removeLast()
         */

        myCollector.playWithDequeuesAsDoubleEndedQueues();

        System.out.println("========== S12: Map Interface [OCP] ==========");

        /*
        ⭐ DEFINITION: Map - collection which stores key-value pairs.
        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#Map-Methods

        2 implementations of Map Interface:
        - HashMap
            - 🔴 Order not kept!
            - ✅ Same amount of time to add/get elements
        - TreeMap
            - ✅ Order preserved.
            - 🕑 takes more time to add/get elements
         */

        myCollector.playWithMaps();

        System.out.println("========== S12: Sorting Data [OCP] ==========");

        /*
        If elements in a Collection are primitives => sorted by natural order.
        If elements are strings:
        - numbers sort before letters
        - uppercase sort before lowercase.
        If not primitives - one needs to define their own criteria.
        2 approaches:
        - use a class implementing Comparable<T> interface
        - pass the implementation of Comparator<T> interface in sort() method

        📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#Compare-Compares
         */

        myCollector.playWithSorting();

        System.out.println("=============== S13: EXCEPTIONS [OCA, OCP] ===============");
        System.out.println("========== S13: Undestanding and Handling Exceptions [OCA] ==========");
        /*
        Exceptions occur when something goes wrong during runtime:
        - divide by 0
        - fetch non-existing index
        - open non-existing file
         */

        /*
        Exception Types Hierarchy:
        --------------------------
        java.lang.Throwable
        - java.lang.Error (unchecked ⚠️)
        - java.lang.Exception (checked ✔)
            - java.lang.RuntimeException (unchecked ⚠️) - does not inherit from Exception!
                - java.lang.ArithmeticException (unchecked ⚠️)
                - java.lang.IndexOutOfBoundsException (unchecked ⚠️)
                    - java.lang.ArrayIndexOutOfBoundsException (unchecked ⚠️)
                - java.lang.NullPointerException (unchecked ⚠️)
                - java.lang.ClassCastException (unchecked ⚠️)
                - java.lang.NumberFormatException (unchecked ⚠️)
                - java.lang.IllegalArgumentException (unchecked ⚠️)
            - java.lang.IOException (checked ✔)
                - java.io.IOException
                - java.io.FileNotFoundException
            - other exceptions

       ⭐ DEFINITION: Checked Exception - must be declared or handled by the application code where it is thrown.
       You cannot ignore them in the codebase as a programmer - you have to declare or handle them.
       All Checked Exceptions inherit from Exception (but not RuntimeException).
       Exception is declared when defining a method, using keyword 'throws'.
       Exception is handled using try-catch block.
       Main method must also declare or handle the checked exception!

       ⭐ DEFINITION: Unchecked Exception - may or may not be handled.
       📖 README: https://github.com/petartotev/PT_Demo_Java/blob/main/README.md#Unchecked-Exceptions
        */

        Exceptionalissimo ex = new Exceptionalissimo();

        //ex.readFirstByteFromFileDoesNotCompile(new File("file.txt")); // IOException (checked exception)
        //ex.readFirstByteFromFileWithThrows(new File("file.txt")); // IOException (checked exception)
        ex.readFirstByteFromFileHandleException(new File("file.txt")); // IOException (checked exception)
        // The line above ^ throws exception, but codebase continues...

        int[] a = {1, 2, 3};
        //ex.printFourthElementNotHandled(a); // ArrayIndexOutOfBoundsException (unchecked exception)
        //ex.printFourthElementHandled(a);

        //ex.manuallyThrowExceptionIfGreaterThanEight(9); // IllegalArgumentException

        //ex.playWithCustomOutOfMilkException(); /* 🔴 ERROR: Unhandled exception: Exceptional.OutOfMilkException!
        // Add throws OutOfMilkException in main() method
        ex.playWithCustomOutOfMilkException();  /* ✅ SUCCESS: Compiles! */

        //ex.catchMultipleExceptionsSubclasses(new File("file.txt")); // IOException
        //ex.catchMultipleExceptionsNotSubclasses(new File("file.txt")); // IOException
        //ex.catchMultipleExceptionsNotSubclassesCoolerWay(new File("file.txt")); // IOException

        System.out.println("========== S13: Try-with-resources [OCP] ==========");

        /*
        Resource Management
        ⭐ DEFINITION: Resource - any external data source (file, database etc.) is referred to as resource.
        Dealing with resources requires 3 steps:
        1. opening resource
        2. using resource
        3. closing resource
        ⚠️ WARNING: Forgetting to close the resource can cause 'resource leaks' which make the resource inaccessible.
         */

        //ex.useResourceManagementManual("file.txt");
        //ex.useResourceManagementAutomatic("file.txt");

        try (MyFileClass bookReader = new MyFileClass(1);
             MyFileClass movieReader = new MyFileClass(2)) {
            System.out.println("try block");
            throw new RuntimeException();
            // When exception occurs, first all resources are closed (starting with the latest).
            // Then, the program continues in a regular order.
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
        }

        /*
        Output:
            try block
            Close MyFileClass #2
            Close MyFileClass #1
            catch block
            finally block
         */

        try (Door d = new Door()) {
            throw new IllegalStateException("Something is wrong!");
            /* If try-with-resources block also throws exception in catch block,
            then only the first exception will be caught,
            other exceptions will be suppressed. */
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
            for (Throwable t : e.getSuppressed())
                System.out.println("Suppressed: " + t.getMessage());
        }

        /*
        Output:
            Caught: Something is wrong!
            Suppressed: Door does not close!
         */

        System.out.println("=============== S14: MATH APIS [OCP] ===============");

        /*
        import java.lang;
         */

        // min(), max()
        int aaa = Math.max(3, 11); /* 11 */
        int bbb = Math.min(2, -4); /* -4 */

        /* When you compare all types of numbers, be aware of autoscaling: */
        long aaaa = 5;
        int bbbb = 3;
        //int cccc = Math.max(aaaa, bbbb);      /* 🔴 ERROR: DOES NOT COMPILE, comparing int and long! */
        int dddd = (int) Math.max(aaaa, bbbb);  /* ✅ SUCCESS: Compiles! */

        // round()
        // if parameter is float, returns int.
        // if parameter is double, returns long.
        double ddddd = 2.56;
        long aaaaa = Math.round(ddddd);         /* 3 */
        //int bbbbb = Math.round(ddddd);        /* 🔴 ERROR: DOES NOT COMPILE, trying to assign long to int! */
        int c = (int) Math.round(ddddd);        /* ✅ SUCCESS: Compiles! */

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

        System.out.println("=============== S15: BEYOND CLASSES [OCP] ===============");

        System.out.println("========== S15: Enums ==========");
        /*
        Enum (enumeration) is a fixed set of constants.
        Enum provides type-safe checking - impossible to create an invalid enum value.
        Enums - seasons, compass directions, days of the week, deck of cards.
        Enums cannot extend a class, but can implement an interface.
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

        /*
        Output:
            0 : NORTH
            1 : SOUTH
            2 : EAST
            3 : WEST
         */

        // Enums used in a switch:
        Compass NO = Compass.NORTH;
        switch (NO) {
            //case Compass.NORTH -> ... /* 🔴 ERROR:  wrong syntax! */
            //case 1 -> ...             /* 🔴 ERROR:  wrong syntax! */
            case NORTH -> System.out.println("Heading North!");
            case SOUTH -> System.out.println("Heading South!");
            default -> System.out.println("Get back!");
        }

        // Enums can have Constructor and Instance Method(s):
        CompassWithCtor.NORTH.printInstruction();
        // 1. 💡 FACT: Constructors are called for each enum - 4 invocations, only once!
        // 2. Instruction "Up" is printed using printInstruction().

        /*
        Output:
            Constructor executed: Up!
            Constructor executed: Down!
            Constructor executed: Right!
            Constructor executed: Left!
            Up!
         */

        // Enums can implement Abstract Methods:
        System.out.println(CompassAbstract.SOUTH.getDirection());
        System.out.println(CompassNotAbstract.SOUTH.getDirection());
        System.out.println(CompassNotAbstract.SOUTH.getDirection());

        // Enums can implement Interfaces:
        System.out.println(CompassWithInterface.NORTH.getPlanetName()); /* Northern Star */
        System.out.println(CompassWithInterface.SOUTH.getPlanetName()); /* South Cross */
        System.out.println(CompassWithInterface.EAST.getPlanetName()); /* Earth */
        System.out.println(CompassWithInterface.WEST.getPlanetName()); /* Earth */

        /*
        Output:
            Northern Star!
            South Cross
            Earth
            Earth
         */

        System.out.println("========== S15: Sealed Classes ==========");

        /*
        Used to restrict other classes to directly extend your class.
        New keywords: sealed, non-sealed, permits.
        Sealed classes must be declared in the same package as its direct subclasses.
        Every listed subclass must extend the sealed class:
        - final, sealed, non-sealed

        Automobile
            Ford
            Renault
            Fiat
                Punto
                Uno
         */

        /*
        Interfaces can also be made sealed!
        Fish
            Eats
            ClownFish
            Shark

        💡 FACT: Interfaces cannot be final! Can be either sealed or non-sealed!
         */

        System.out.println("========== S15: Records ==========");

        /*
        ⭐ DEFINITION: Records - encapsulated classes, but without the boilerplate code.
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
        PupilRecord pr2 = new PupilRecord("Ivaylo", "Ivanov", 3);
        System.out.println(pr == pr2);      /* false? */
        System.out.println(pr.equals(pr2)); /* true? */

        /*
        We can override auto-generated constructor!
        This is called a canonical constructor.
         */

        // Canonical Constructor
        PupilRecordOverriddenCtor myPROC = new PupilRecordOverriddenCtor("john", "doe", 1);
        // Compact Constructor
        PupilRecordCompactCtor myPRCC = new PupilRecordCompactCtor("john", "doe", 1);

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

        A myPersonalA = new A();
        // Execute myPersonalA.main()!

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

        System.out.println("=============== S16: STREAMS [OCP] ===============");

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

        System.out.println("=============== S17: LOCALIZATION [OCP] ===============");

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

        System.out.println("=============== S18: MODULES [OCP] ===============");

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

        System.out.println("=============== S19: CONCURRENCY [OCP] ===============");

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

        System.out.println("=============== S22: JAVA 21 (1Z0-830 EXAM) ===============");
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