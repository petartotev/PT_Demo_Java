# PT_Demo_Java

## Contents
- [Setup](#setup)
- [C# vs. Java](#c-vs-java)
- [Data Types](#data-types)
- [Wrapper Classes](#wrapper-classes)
- [Special Words](#special-words)
- [Operators](#operators)
  - [Unary Operators](#unary-operators)
  - [Binary Operators](#binary-operators)
  - [Assignment Operators](#assignment-operators)
  - [Comparison Operators](#comparison-operators)
- [Lambdas and Functional Programming](#lambdas-and-functional-programming)
  - [Method References](#method-references)
  - [Functional References](#functional-references)
  - [Common Functional Interfaces for Primitives](#common-functional-interfaces-for-primitives)
  - [Primitive Specific Functional Interfaces](#primitive-specific-functional-interfaces)
- [Collections](#collections)
  - [Map Methods](#map-methods)
  - [Compare Compares](#compare-compares)
- [Exceptions](#exceptions)
  - [Unchecked Exceptions](#unchecked-exceptions)
- [Notes](#notes)
- [Links](#links)

## Setup
1. Install JDK 17 Java Development Kit (jdk-17.0.12_windows-x64_bin) from https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
2. Install IntelliJ IDEA Community (ideaIC-2024.2.4.exe) from https://www.jetbrains.com/idea/download/other.html

## C# vs. Java
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

## Wrapper Classes

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

## Special Words

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

## Compare Compares

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

## Notes
- float x = 2.7 // does not compile! needs 'f' at the end
- bit size of boolean is not specified, depends on the machine
- LVTI (Local Variable Type Inference)

## Shortcuts
- Ctrl + Shift + / => Comment out multiple lines
- Ctrl + D => Duplicate a single line (Ctrl + C and Ctrl + V)
- Ctrl + Shift + R => Replace
- Alt + Shift + Up/Down Arrow => Move line up / down
- Hold Alt and drag down/up => Write on multiple lines
- Ctrl + Shift + [+] / Ctrl + Shift + [-] => Expand / Collapse methods in a class
- Ctrl + Alt + L => Format a file

## Questions

## Links
- https://www.jetbrains.com/idea/download/other.html
- https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- https://docs.oracle.com/en/java/javase/17/
