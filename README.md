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
- [Notes](#notes)
- [Links](#links)

## Setup
1. Install JDK 17 Java Development Kit (jdk-17.0.12_windows-x64_bin) from https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
2. Install IntelliJ IDEA Community (ideaIC-2024.2.4.exe) from https://www.jetbrains.com/idea/download/other.html

## C# vs. Java
| Feature                               | C#                             | Java                        |
|---------------------------------------|--------------------------------|-----------------------------|
| Variable Naming                       | energyField // camelCase       | energyField // camelCase    |
| Constant Naming                       | EnergyField // PascalCase      | ENERGY_FIELD // SNAKE_CASE  |
| Class, Interface, Enum Naming         | class Student // PascalCase    | class Student // PascalCase |
| Identifier Variable / Property Naming | Id { get; set; } // PascalCase | getId() // camelCase        |
| Method Naming                         | GetStudents() // PascalCase    | getStudents() // camelCase  |
|                                       |                                |                             |
| Importing Libraries                   | using System;                  | import java.util.Random;    |
| Documentation Comments                | `///`                          | `/** * * @author */`        |
| Print to Console                      | `Console.WriteLine("abc")`     | `System.out.println("abc")` |
| Random Number Generation              | `new Random().Next(0, 101)`    | `new Random().nextInt(101)` |
| Constants                             | const string MyTest            | final String MY_TEST        |
| Foreach Loops                         | foreach (var car in Cars) { }  | for (String car : cars) { } |
| Base keyword                          | base.name                      | super.name                  |

## Data Types

| Keyword | Type                  | Min           | Max             | Default | Example   |
|---------|-----------------------|---------------|-----------------|---------|-----------|
| boolean | true or false         | -             | -               | false   | true      |
| byte    | 8-bit integral value  | -128          | 127             | 0       | 118       |
| short   | 16-bit integral value | -32,768       | 32,767          | 0       | -202      |
| int     | 32-bit integral value | -2,147,483,648 | 2,147,483,647   | 0       | 5106      |
| long    | 64-bit integral value | -2^63         | 2^63 - 1        | 0L      | 5106L     |
| float   | 32-bit floating value | -             | -               | 0.0f    | 511.183f  |
| double  | 64-bit floating value | -             | -               | 0.0f    | 511.183   |
| char    | 16-bit Unicode value  | 0             | 65,535          | \u0000  | 'c'       |

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
* **var** is not a special word due to legacy reasons, first appeared in Java 10.
* **var** a.k.a. LVTI

## Operators

| Operator                        | Example(s)                                                           | Order Of         |
|---------------------------------|----------------------------------------------------------------------|-------------------|
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
| Assignment operators            | `=`, `+=`, `-=`, `*=`, `/=`, `%=`, `&=`, `\|=`, `<<=`, `>>=`, `>>>=` | Right-to-Left |
| Arrow operator                  | `->`                                                                 | Right-to-Left    |

### Unary Operators
### Binary Operators
### Assignment Operators
### Comparison Operators

## Notes
- float x = 2.7 // does not compile! needs 'f' at the end
- bit size of boolean is not specified, depends on the machine
- LVTI

## Questions
- Shortcut for formatting a file
- Shortcut for opening and closing methods
- Is there something like section in C#?

## Links
- https://www.jetbrains.com/idea/download/other.html
- https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
