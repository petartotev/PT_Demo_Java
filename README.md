# PT_Demo_Java

# Contents
- [Setup](#setup)
- [Testing](#testing)
- [C# vs. Java](#c-vs-java)
- [Notes](#notes)
- [Shortcuts](#shortcuts)
- [Questions](#questions)
- [Links](#links)
- [Course Contents](#course-contents)
  - [S2: Data Types](#data-types)
    - [Wrapper Classes](#wrapper-classes)
    - [Special Words](#special-words)
  - [S3: Operators](#operators)
    - [Unary Operators](#unary-operators)
    - [Binary Operators](#binary-operators)
    - [Assignment Operators](#assignment-operators)
    - [Comparison Operators](#comparison-operators)
  - [S11: Lambdas and Functional Programming](#lambdas-and-functional-programming)
    - [Method References](#method-references)
    - [Functional References](#functional-references)
    - [Common Functional Interfaces for Primitives](#common-functional-interfaces-for-primitives)
    - [Primitive Specific Functional Interfaces](#primitive-specific-functional-interfaces)
  - [S12: Collections](#collections)
    - [Map Methods](#map-methods)
    - [Compare Compares](#compare-compares)
  - [S13: Exceptions](#exceptions)
    - [Unchecked Exceptions](#unchecked-exceptions)
  - [S16: Streams](#streams)
    - [Optional](#optional)
      - [Common Optional Instance Methods](#common-optional-instance-methods)
    - [Stream Creation Methods](#stream-creation-methods)
    - [Terminal Stream Operations](#terminal-stream-operations)
  - [S17: Localization](#localization)
    - [Common Date Time Symbols](#common-date-time-symbols)
    - [NumberFormat Factory Methods](#numberformat-factory-methods)
  - [S18: Modules](#modules)
    - [module-info.java keywords](#module-infojava-keywords)
  - [S19: Concurrency](#concurrency)
    - [Future\<V\> Interface Methods](#futurev-interface-methods)

# TODO
1. Change images in Testing section (JUnit_Tests_Add_To_Library.png and JUnit_Plugin_Installed.png)

# Setup
1. Install IntelliJ IDEA Community (ideaIC-2024.2.4.exe) from https://www.jetbrains.com/idea/download/other.html
2. Open Existing Project (🔴 ERROR: Does not compile! Java JDK missing!)
3. Install JDK 17 Java Development Kit (jdk-17.0.12_windows-x64_bin) from https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
4. Go to Project > Structure > Choose Java 17 JDK:
![Project Structure](./res/Project-Structure_SDK-Java-17.png)
5. Go to Run > More Actions > Configure > Choose Arguments args[0] and args[1], separated by comma:
![Run Arguments](./res/Build-and-Run_Arguments.png)
6. Right click on any directory > Mark Directory As > **Sources Root**:
![Sources Root](./res/Sources-Root.png)

# Testing
1. Make sure you have `JUnit` plugin installed:
![Sources Root](./res/Sources-Root.png)
2. Create new `UdemyJavaCertificatePrepTests` directory.
3. Right-click on `UdemyJavaCertificatePrepTests` > Mark Directory As > **Test Resources Root**.
4. Create new `FlowControllerTests` Java Class.
5. Download the following jar files from **Maven Central Repository**:  
[junit-jupiter-api@5.11.3](https://central.sonatype.com/artifact/org.junit.jupiter/junit-jupiter-api/versions)  
[junit-jupiter-engine@5.11.3](https://central.sonatype.com/artifact/org.junit.jupiter/junit-jupiter-engine/versions)  
[junit-platform-commons@1.11.3](https://central.sonatype.com/artifact/org.junit.platform/junit-platform-commons/versions)  
[junit-platform-engine@1.11.3](https://central.sonatype.com/artifact/org.junit.platform/junit-platform-engine/versions)  
6. Copy-paste the jar files into `UdemyJavaCertificatePrepTests` directory.
7. Right-click on each of these and choose "Add to Library".
8. Go to File > Project Structure > Libraries > you can check your added libraries:
![Sources Root](./res/Sources-Root.png)
9. Implement `FlowControllerTests` using JUnit `@Test` annotations.
10. Run `FlowControllerTests`.

# C# vs. Java
| Feature                               | C#                             | Java                                 |  |
|---------------------------------------|--------------------------------|--------------------------------------|--|
| Variable Naming                       | energyField // camelCase       | energyField // camelCase             |  |
| Constant Naming                       | EnergyField // PascalCase      | ENERGY_FIELD // SNAKE_CASE           |  |
| Class, Interface, Enum Naming         | class Student // PascalCase    | class Student // PascalCase          |  |
| Identifier Variable / Property Naming | Id { get; set; } // PascalCase | getId() // camelCase                 |  |
| Method Naming                         | GetStudents() // PascalCase    | getStudents() // camelCase           |  |
|                                       |                                |                                      |  |
| Importing Libraries                   | using System;                  | import java.util.Random;             |  |
| Documentation Comments                | `///`                          | `/** * * @author */`                 |  |
| Print to Console                      | `Console.WriteLine("abc")`     | `System.out.println("abc")`          |  |
| Random Number Generation              | `new Random().Next(0, 101)`    | `new Random().nextInt(101)`          |  |
| Constants                             | const string MyTest            | final String MY_TEST                 |  |
| Foreach Loops                         | foreach (var car in Cars) { }  | for (String car : cars) { }          |  |
| Base keyword                          | base.name                      | super.name                           |  |
| Region                                | #region //smth #endregion      | // <editor-fold desc="Section Name"> |🙁|

# Notes
- float x = 2.7 // does not compile! needs 'f' at the end
- bit size of boolean is not specified, depends on the machine
- LVTI (Local Variable Type Inference)

# Shortcuts
| Shortcut                    | Description                               |
|-----------------------------|-------------------------------------------|
| Ctrl + Shift + /            | Comment out multiple lines                |
| Ctrl + Shift + [+/-]        | Expand / Collapse methods in a class      |
| Ctrl + D                    | Duplicate single line (Ctrl+C and Ctrl+V) |
| Ctrl + Shift + R            | Replace                                   |
| Ctrl + Alt + L              | Format a file                             |
| Alt + Shift + Up/Down Arrow | Move line up / down                       |
| Hold Alt and drag down/up   | Write on multiple lines                   |
| fori + tab                  | Automatically writes for (i = 0; i...     |
| sout + tab                  | Prints System.out.println();              |
| soutp + tab                 | Prints method parameters                  |
| soutv + tab                 | Prints variable's name and value          |

# Questions

# Links
- https://www.jetbrains.com/idea/download/other.html
- https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- https://docs.oracle.com/en/java/javase/17/

# Course Contents

S01: Introduction  
.1. Introduction  

S02: Building Blocks [OCA, OCP]  
2. The Environment [OCA]  
3. Class Structure [OCA]  
4. The main() method [OCA]  
5. Packages [OCA]  
6. Compile, Run and Archive [OCA]  
7. Objects [OCA]  
8. Data Types [OCA]  
9. Text Blocks [OCP]  
10. Variables [OCA]  
11. Local Variable Type Inference (LVTI) [OCP]  
12. Garbage Collector [OCA]  

S03: Operators [OCA, OCP]  
13. Operators in Java [OCA]  
14. Unary Operators [OCA]  
15. Binary Operators [OCA]  
16. Assignment Operator [OCA]  
17. Comparison Operators [OCA]  

S04: Flow Control [OCA, OCP]  
18. If-Else Statement [OCA]  
19. Switch Statement [OCA]  
20. Switch Expression [OCP]  
21. While Loop [OCA]  
22. Do/While Loop [OCA]  
23. For Loop [OCA]  
24. For-Each Loop [OCA]  

S05: Strings [OCA, OCP]  
25. String Methods [OCA]  
26. StringBuilder [OCA]  
27. String Pool [OCA]  

S06: Arrays [OCA, OCP]  
28. Creating an Array [OCA]  
29. Sorting, Searching & Comparing Arrays [OCA]  
30. Multidimensional Arrays [OCA]  

S07: Date and Time [OCA, OCP]  
31. Creating Dates and Times [OCA]  
32. Methods on Dates and Times [OCA]  
33. Period, Duration, Instant [OCA]  

S08: Methods [OCA, OCP]  
34. Defining Methods [OCA]  
35. Local and Instance Variables [OCA]  
36. Variable Arguments (Varargs) [OCA]  
37. Access Modifiers [OCA]  
38. Static Members [OCA]  
39. Boxing and Unboxing [OCA]  
40. Overloading Methods [OCA]  

S09: Class Design [OCA, OCP]  
41. Inheritance [OCA]  
42. Creating Classes [OCA]  
43. Creating Constructors [OCA]  
44. Using this() and super() [OCA]  
45. Initializing Objects [OCA]  
46. Inheriting Members [OCA]  

S10: Abstract Classes & Interfaces [OCA, OCP]  
47. Abstract Classes [OCA]  
48. Interfaces [OCA]  

S11: Lambdas & Functional Programming [OCA, OCP]  
49. Functional Interfaces and Lambdas [OCA]  
50. Using Predicate with Lambda [OCA]  
51. Method References [OCP]  
52. Built-in Functional Interfaces [OCP]  
53. Combining Implementations [OCP]  
54. Functional Interfaces for Primitives [OCP]  

S12: Collections [OCA, OCP]  
55. Common Collection Methods [OCA]  
56. List Interface [OCA]  
57. Set Interface [OCP]  
58. Queue Interface [OCP]  
59. Deque Interface [OCP]  
60. Map Interface [OCP]  
61. Sorting Data [OCP]  

S13: Exceptions [OCA, OCP]  
62. Understanding and Handling Exceptions [OCA]  
63. Try-with-resources [OCP]  

S14: Math APIs [OCP]  
64. Math API Methods  

S15: Beyond Classes [OCP]  
65. Enums  
66. Sealed Classes  
67. Records  
68. Nested Classes  
69. Polymorphism  

S16: Streams [OCP]  
70. Using Optional  
71. Understanding Pipeline  
72. Creating Stream Source  
73. Terminating the Stream  
74. Using Intermediate Operations  
75. Putting The Pipeline Together  
76. Primitive Streams  
77. Spliterator  
78. Collecting results  

S17: Localization [OCP]  
79. Formatting Values  
80. Internationalization  
81. Resource Bundles  

S18: Modules [OCP]  
82. Introduction to Modules  
83. Designing Modular App  
84. Compiling and Running Modular App  
85. Build-in Modules  
86. Command Line Operations  
87. Named, Automatic and Unnamed Modules  
88. Migration Strategies  

S19: Concurrency [OCP]  
89. Thread Concurrency  
90. Creating a Thread (intro)  
91. Creating a Thread (examples)  
92. Using Concurrency API  
93. Atomic Classes  
94. Synchronized Block  
95. Using CyclicBarrier  
96. Concurrent Collections  
97. Threading Problems  

S20: I/O [OCP]  
98. Working With Files  
99. Console Class  
100. Serialization  

S21: JDBC [OCP]  
101. Introduction to JDBC  
102. Connecting to a Database  
103. Using PreparedStatement  
104. Using CallableStatement  
105. Resource Leaks  

S22: Java 21 (1Z0-830 exam)  
106. Get Certified for Java SE 21  

## Data Types

| Keyword | Interface         | Type                  | Min           | Max             | Default | Example   |
|---------|-------------------|-----------------------|---------------|-----------------|---------|-----------|
| boolean | `BooleanSupplier` | true or false         | -             | -               | false   | true      |
| byte    | `Byte`            | 8-bit integral value  | -128          | 127             | 0       | 118       |
| short   | `Short`           | 16-bit integral value | -32,768       | 32,767          | 0       | -202      |
| int     | `IntSupplier`     | 32-bit integral value | -2,147,483,648 | 2,147,483,647  | 0       | 5106      |
| long    | `LongSupplier`    | 64-bit integral value | -2^63         | 2^63 - 1        | 0L      | 5106L     |
| float   | `Float`           | 32-bit floating value | -             | -               | 0.0f    | 511.183f  |
| double  | `DoubleSupplier`  | 64-bit floating value | -             | -               | 0.0f    | 511.183   |
| char    | `Character`       | 16-bit Unicode value  | 0             | 65,535          | \u0000  | 'c'       |

### Wrapper Classes

| Primitive Type | Wrapper Class | Example                        |
|----------------|---------------|--------------------------------|
| boolean        | Boolean       | `Boolean.valueOf(true);`       |
| byte           | Byte          | `Byte.valueOf((byte) 12);`     |
| short          | Short         | `Short.valueOf((short) 12);`   |
| int            | Integer       | `Integer.valueOf(12);`         |
| long           | Long          | `Long.valueOf(12L);`           |
| float          | Float         | `Float.valueOf(12.0F);`        |
| double         | Double        | `Double.valueOf(12.0);`        |
| char           | Character     | `Character.valueOf('c');`      |

### Special Words

|            |              |           |            |        |
|------------|--------------|-----------|------------|--------|
| abstract   | assert       | boolean   | break      | byte   |
| case       | catch        | char      | class      | const  |
| continue   | default      | do        | double     | else   |
| enum       | extends      | final     | finally    | float  |
| for        | goto         | if        | implements | import |
| instanceof | int          | interface | long       | native |
| new        | package      | private   | protected  | public |
| return     | short        | static    | strictfp   | super  |
| switch     | synchronized | this      | throw      | throws |
| transient  | try          | void      | volatile   | while  |

* **var** a.k.a. LVTI (Local Variable Type Inference) is not a special word due to legacy reasons, first appeared in Java 10.

## Operators

| Operator                        | Example(s)                                                           | Order Of         |
|---------------------------------|----------------------------------------------------------------------|------------------|
| Post-unary operator             | `a++`, `a--`                                                         | Left-to-Right    |
| Pre-unary operator              | `++a`, `--a`                                                         | Left-to-Right    |
| Other unary operators           | `-`, `!`, `~`, `+`, `(type)`                                         | Right-to-Left    |
| Cast                            | `(Type)a`                                                            | Left-to-Right    |
| Multiplication/division/modulus | `*`, `/`, `%`                                                        | Left-to-Right    |
| Addition/subtraction            | `+`, `-`                                                             | Left-to-Right    |
| Shift operators                 | `<<`, `>>`, `>>>`                                                    | Left-to-Right    |
| Relational operators            | `<`, `>`, `<=`, `>=`, `instanceof`                                   | Left-to-Right    |
| Equal to / not equal to         | `==`, `!=`                                                           | Left-to-Right    |
| Logical AND                     | `&`                                                                  | Left-to-Right    |
| Logical exclusive OR (XOR)      | `^`                                                                  | Left-to-Right    |
| Logical OR                      | `\|`                                                                 | Left-to-Right    |
| Conditional AND                 | `&&`                                                                 | Left-to-Right    |
| Conditional OR                  | `\|\|`                                                               | Left-to-Right    |
| Ternary operator                | `expr ? a : b`                                                       | Right-to-Left    |
| Assignment operators            | `=`, `+=`, `-=`, `*=`, `/=`, `%=`, `&=`, `\|=`, `<<=`, `>>=`, `>>>=` | Right-to-Left    |
| Arrow operator                  | `->`                                                                 | Right-to-Left    |

### Unary Operators

| Operator             | Example       | Description                                                   |
|----------------------|---------------|---------------------------------------------------------------|
| Logical complement   | `!b`          | Inverts the boolean value (`true` to `false` and vice versa). |
| Bitwise complement   | `~a`          | Inverts all bits in the integer.                              |
| Plus                 | `+a`          | Represents the unary plus (no effect on the value).           |
| Negation (minus)     | `-a`          | Negates the value, changing its sign.                         |
| Increment            | `++a; a++`    | Increments the value by 1 (prefix or postfix).                |
| Decrement            | `--a; a--`    | Decrements the value by 1 (prefix or postfix).                |
| Cast                 | `(int)a`      | Converts the value to a specified type.                       |

### Binary Operators
### Assignment Operators
### Comparison Operators

## Lambdas and Functional Programming

### Method References

| Lambda Expression               | Method Reference      |
|---------------------------------|-----------------------|
| `s -> System.out.println(s)`    | `System.out::println` |
| `(a, b) -> Math.min(a, b)`      | `Math::min`           |
| `t -> Gravity.freeFall(t)`      | `Gravity::freeFall`   |
| `() -> s.isEmpty()`             | `s::isEmpty`          |
| `s -> s.isBlank()`              | `String::isEmpty`     |

### Functional References

| Functional Interface | Method Signature   | Return Type |
|----------------------|--------------------|-------------|
| Supplier<T>          | `get()`            | T           |
| Consumer<T>          | `accept(T)`        | void        |
| BiConsumer<T,U>      | `accept(T, U)`     | void        |
| Predicate<T>         | `test(T)`          | boolean     |
| BiPredicate<T,U>     | `test(T, U)`       | boolean     |
| Function<T,R>        | `apply(T)`         | R           |
| BiFunction<T,U,R>    | `apply(T, U)`      | R           |
| UnaryOperator<T>     | `apply(T)`         | T           |
| BinaryOperator<T>    | `apply(T, T)`      | T           |

### Common Functional Interfaces for Primitives

| Functional Interface   | Return Type | Abstract Method Signature              |
|------------------------|-------------|----------------------------------------|
| BoolSupplier           | boolean     | `getAsBoolean()`                       |
| DoubleSupplier         | double      | `getAsDouble()`                        |
| IntSupplier            | int         | `getAsInt()`                           |
| LongSupplier           | long        | `getAsLong()`                          |
| DoubleConsumer         | void        | `accept(double a)`                     |
| IntConsumer            | void        | `accept(int a)`                        |
| LongConsumer           | void        | `accept(long a)`                       |
| DoublePredicate        | boolean     | `test(double a)`                       |
| IntPredicate           | boolean     | `test(int a)`                          |
| LongPredicate          | boolean     | `test(long v)`                         |
| DoubleFunction<R>      | R           | `apply(double value)`                  |
| IntFunction<R>         | R           | `apply(int value)`                     |
| LongFunction<R>        | R           | `apply(long value)`                    |
| DoubleUnaryOperator    | double      | `applyAsDouble(double value)`          |
| IntUnaryOperator       | int         | `applyAsInt(int value)`                |
| LongUnaryOperator      | long        | `applyAsLong(long value)`              |
| DoubleBinaryOperator   | double      | `applyAsDouble(double v, double w)`    |
| IntBinaryOperator      | int         | `applyAsInt(int v, int w)`             |
| LongBinaryOperator     | long        | `applyAsLong(long v, long w)`          |

### Primitive Specific Functional Interfaces

| Functional Interface       | Return Type | Abstract Method Signature                    |
|----------------------------|-------------|----------------------------------------------|
| ToDoubleFunction<T>        | double      | `applyAsDouble(T t)`                         |
| ToIntFunction<T>           | int         | `applyAsInt(T t)`                            |
| ToLongFunction<T>          | long        | `applyAsLong(T t)`                           |
| ToDoubleBiFunction<T, U>   | double      | `applyAsDouble(T t, U u)`                    |
| ToIntBiFunction<T, U>      | int         | `applyAsInt(T t, U u)`                       |
| ToLongBiFunction<T, U>     | long        | `applyAsLong(T t, U u)`                      |
| DoubleToIntFunction        | int         | `applyAsInt(double value)`                   |
| DoubleToLongFunction       | long        | `applyAsLong(double value)`                  |
| IntToDoubleFunction        | double      | `applyAsDouble(int value)`                   |
| IntToLongFunction          | long        | `applyAsLong(int value)`                     |
| LongToDoubleFunction       | double      | `applyAsDouble(long value)`                  |
| LongToIntFunction          | int         | `applyAsInt(long value)`                     |
| ObjDoubleConsumer<T>       | void        | `accept(T t, double v)`                      |
| ObjIntConsumer<T>          | void        | `accept(T t, int v)`                         |
| ObjLongConsumer<T>         | void        | `accept(T t, long v)`                        |

## Collections

| Collection Interface  | Sub-Interface    | Implementing Classes                    | Notes                                                        |
|-----------------------|------------------|-----------------------------------------|--------------------------------------------------------------|
| `Collection`          | `List`           | `ArrayList`, `LinkedList`               | `List` maintains order and allows duplicates                 |
|                       | `Set`            | `HashSet`, `TreeSet`                    | `Set` enforces unique elements                               |
|                       | `Queue`          | `LinkedList`, `PriorityQueue`           | `Queue` typically follows FIFO                               |
|                       | `Deque`          | `ArrayDeque`, `LinkedList`              | `Deque` supports FIFO and LIFO operations                    |
| `Map`                 | -                | `HashMap`, `TreeMap`, `LinkedHashMap`   | `Map` stores key-value pairs, doesn’t implement `Collection` |

### Map Methods

| Method                                          | Explanation                                                                       |
|-------------------------------------------------|-----------------------------------------------------------------------------------|
| `clear()`                                       | Clears the map                                                                    |
| `containsKey(Object key)`                       | Checks if the key is in the map                                                   |
| `containsValue(Object value)`                   | Checks if the value is in the map                                                 |
| `entrySet()`                                    | Returns `Set` of key/value pairs                                                  |
| `forEach()`                                     | Loops through key/value pairs                                                     |
| `get(Object key)`                               | Returns value mapped with key, or `null` if none exists                           |
| `getOrDefault(Object key, V defaultValue)`      | Same as `get`, but returns `defaultValue` if key doesn't exist                    |
| `isEmpty()`                                     | Checks if map is empty                                                            |
| `keySet()`                                      | Returns `Set` of all keys                                                         |
| `merge(K key, V value, BiFunction<V,V,V> func)` | Sets value if key doesn't exist, or applies `func` to existing value              |
| `put(K key, V value)`                           | Adds or replaces key/value pair, returns previous value or `null`                 |
| `putIfAbsent(K key, V value)`                   | Adds value if key is not present, returns `null` if added                         |
| `remove(Object key)`                            | Removes and returns value mapped to key, or `null` if none exists                 |
| `replace(K key, V value)`                       | Replaces value for given key if key is set, returns original value or `null`      |
| `replaceAll(BiFunction<K,V,V> func)`            | Replaces each value with results of function                                      |
| `size()`                                        | Returns number of key/value pairs in the map                                      |
| `values()`                                      | Returns collection of values                                                      |

### Compare Compares

| Difference                     | `Comparable`      | `Comparator`  |
|--------------------------------|-------------------|---------------|
| Package name                   | `java.lang`       | `java.util`   |
| Must be implemented by a class | YES               | NO            |
| Method name                    | `compareTo()`     | `compare()`   |
| Number of method parameters    | 1                 | 2             |
| Used with lambda               | NO                | YES           |

## Exceptions

### Unchecked Exceptions

| Type                           | Description                                                                                                  |
|--------------------------------|--------------------------------------------------------------------------------------------------------------|
| ArithmeticException            | Thrown when code tries to divide by 0.                                                                       |
| ArrayIndexOutOfBoundsException | Thrown when code uses an illegal index to access an array element.                                          |
| ClassCastException             | Thrown when code tries to cast an object to a class of which it is not an instance.                         |
| NullPointerException           | Thrown when there is a null reference where an object is required.                                          |
| IllegalArgumentException       | Thrown by a programmer to indicate that an illegal or inappropriate argument has been passed to a method.   |
| NumberFormatException          | A subclass of IllegalArgumentException, thrown when a String is converted to a numeric type but is in an inappropriate format. |

## Streams

### Optional

#### Common Optional Instance Methods

| Method                    | When Optional is empty               | When Optional Contains a value  |
|---------------------------|--------------------------------------|---------------------------------|
| `get()`                   | Throws exception                     | Returns value                   |
| `ifPresent(Consumer c)`   | Does nothing                         | Calls Consumer with value       |
| `isPresent()`             | Returns false                        | Returns true                    |
| `orElse(T other)`         | Returns other                        | Returns value                   |
| `orElseGet(Supplier s)`   | Returns result of Supplier           | Returns value                   |
| `orElseThrow()`           | Throws NoSuchElementException        | Returns value                   |
| `orElseThrow(Supplier s)` | Throws exception in Supplier         | Returns value                   |

### Stream Creation Methods

| Method                                      | Finite? | Description                                                                 |
|---------------------------------------------|---------|-----------------------------------------------------------------------------|
| `Stream.empty()`                            | Yes     | Creates a Stream with zero elements                                         |
| `Stream.of(varargs)`                        | Yes     | Creates a Stream with elements listed in varargs                            |
| `coll.stream()`                             | Yes     | Creates a Stream from a Collection                                          |
| `coll.parallelStream()`                     | Yes     | Creates a parallel Stream from a Collection                                 |
| `Stream.generate(supplier)`                 | No      | Creates a Stream by calling the Supplier for each element upon request      |
| `Stream.iterate(seed, unaryOperator)`       | No      | Creates a Stream using a seed for the first element, then applies the UnaryOperator for subsequent elements |
| `Stream.iterate(seed, predicate, unaryOperator)` | Depends | Same as before, but stops if the Predicate returns false                    |

### Terminal Stream Operations

| Method                                      | When Applied on Infinite Stream | Return Value   | Reduction |
|---------------------------------------------|---------------------------------|----------------|-----------|
| `count()`                                   | Does not terminate              | `long`         | Yes       |
| `min()` / `max()`                           | Does not terminate              | `Optional<T>`  | Yes       |
| `findAny()` / `findFirst()`                 | Terminates                      | `Optional<T>`  | No        |
| `allMatch()` / `anyMatch()` / `noneMatch()` | Sometimes terminates            | `boolean`      | No        |
| `forEach()`                                 | Does not terminate              | `void`         | No        |
| `reduce()`                                  | Does not terminate              | values         | Yes       |
| `collect()`                                 | Does not terminate              | varies         | Yes       |

## Localization

### Common Date Time Symbols

| Symbols | Meaning             | Example                                |
|---------|---------------------|----------------------------------------|
| y       | Year                | 23, 2023                               |
| M       | Month               | 2, 02, Feb, February                   |
| d       | Day                 | 7, 07                                  |
| h       | Hour                | 8, 08                                  |
| m       | Minute              | 25                                     |
| S       | Second              | 17                                     |
| a       | a.m. / p.m.         | AM, PM                                 |
| z       | Time zone name      | Central European Time, CET             |
| Z       | Time zone offset    | -600                                   |

### NumberFormat Factory Methods

| Method                                                     | Description                                 |
|------------------------------------------------------------|---------------------------------------------|
| getInstance(), getInstance(Locale locale)                  | General Purpose Formatter                   |
| getNumberInstance(), getNumberInstance(Locale locale)      | Same as getInstance                         |
| getCurrencyInstance(), getCurrencyInstance(Locale locale)  | For formatting monetary amounts             |
| getPercentInstance(), getPercentInstance(Locale locale)    | For formatting percentages                  |
| getIntegerInstance(), getIntegerInstance(Locale locale)    | Rounds decimal numbers before displaying    |
| getCompactNumberInstance(), getInstance(Locale l, Style s) | Returns compact number formatter            |

## Modules

### module-info.java keywords

| Keyword                                  | Description                                                                                       |
|------------------------------------------|---------------------------------------------------------------------------------------------------|
| requires <module>                        | Module depends on the code in another module.                                                     |
| requires transitive <module>             | If module A requires transitive module B, and module C requires module A, then C has access to B. |
| opens <package> to <module>              | Makes named package accessible to the named module at runtime.                                    |
| exports <package>                        | Public members of the named package are accessible to other modules.                              |
| uses <service>                           | The module uses a service (interface) which can be implemented elsewhere.                         |
| provides <service> with <implementation> | Module provides a concrete implementation of a service (interface).                               |

## Concurrency

### Future\<V\> Interface Methods

| Method                                           | Description                                                                                      |
|--------------------------------------------------|--------------------------------------------------------------------------------------------------|
| `boolean isDone()`                               | Returns `true` if the task was completed, threw an exception, or was canceled.                   |
| `boolean isCanceled()`                           | Returns `true` if the task was canceled before completing normally.                              |
| `boolean cancel(boolean mayInterruptIfRunning)`  | Attempts to cancel the task execution. Returns `true` if the task was successfully canceled.     |
| `V get()`                                        | Retrieves the result of the task.                                                               |
| `V get(long timeout, TimeUnit unit)`             | Retrieves the task result, waiting up to the specified time. Throws `TimeoutException` if not ready. |

