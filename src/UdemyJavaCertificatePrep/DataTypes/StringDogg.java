package DataTypes;

import java.util.*;

public class StringDogg {
    public final String GREATEST_RAPPER = "Snoop Dogg";

    public void playWithTextBlocks() {
        String myTextBlockEndingWithNewLine = """
                   This is some test to try out TextBlock-s.
                       This goes a little to the right!
                """;
        System.out.println(myTextBlockEndingWithNewLine + "Hello!");

        String myTextBlockEndingOnSameLine = """
                   This is some test to try out TextBlock-s.
                       This goes a little to the right!""";
        System.out.println(myTextBlockEndingOnSameLine + "Hello!");
    }

    public void playWithConcatenation() {
        // concatenation
        System.out.println(3 + 8);
        System.out.println("John" + 3 + 8);
        System.out.println("John" + (3 + 8));
        System.out.println("John" + null);
        System.out.println(null + "John");
    }

    public void playWithStringMethods() {
        var john = "John Ahnorgkk";
        // length()
        System.out.println(john.length());
        // charAt()
        System.out.println(john.charAt(3));
        // indexOf()
        System.out.println(john.indexOf('o'));
        System.out.println(john.indexOf("hn", 4));
        System.out.println(john.indexOf('Z')); // -1

        // substring()
        System.out.println(john.substring(3));
        System.out.println(john.substring(3, 8));

        var name1 = new String("John Doe");
        var name2 = new String("John Doe");
        var name3 = new String("john doe");

        // equals(), equalsIgnoreCase()
        System.out.println(name1 == name2);
        System.out.println(name1.equals(name3));
        System.out.println(name1.equalsIgnoreCase(name3));

        var student = "Peter Totev";
        // startsWith(), endsWith()
        if (student.startsWith("Peter") && student.endsWith("Totev")) {
            System.out.println("Match!");
        }
        // contains()
        if (student.contains("eter")) {
            System.out.println("Rhymes with meter!");
        }

        // .replace()
        student = student.replace("v", "ff");

        // strip(), trim(), stripLeading(), stripTrailing()
        // trim() is like strip(), but supports Unicode
        // all methods trim \t (tab), \n (new line), \r (carriage return)

        // indent(), stripIndent()

        // translateEscapes();

        // isEmpty(), isBlank()
        String myRandomString = (new Random()).nextInt(4) == 3 ? "Legit string" : " ";
        String myNullString = null;
        String myEmptyString = "";
        String myBlankString = " ";
        if (myRandomString == null || myRandomString.isEmpty() || myRandomString.isBlank()) {
            System.out.println("myRandomString is null, empty or whitespace!");
        }

        // format(), formatted()
        String test = "Test";
        Integer num = 5;
        System.out.println(String.format("%s has %d marbles", test, num));
        // %s - string
        // %d - digit
        // %c - char
        // %a - float, double
        // %b - boolean
        System.out.println("%s has %d marbles".formatted(test, num));

        String someName = "   John Wayne  ";
        System.out.println(someName.trim().toUpperCase().replace('Y', 'R'));
    }

    public void playWithStringBuilder() {
        var test = "Testy Boo Boo";
        var stringBuilder = new StringBuilder(test);
        // substring(), indexOf(), length(), charAt() work at the same way!

        stringBuilder.insert(6, "D. ");
        stringBuilder.append("The Almighty!");
        System.out.println(stringBuilder.toString());
        //stringBuilder.appendLine("The Almighty!");
        System.out.println(stringBuilder.toString());
        // delete(), deleteCharAt(2), replace(), reverse()
        // doesn't implement equals() method

        // STRING POOL
        String john = "John";
        String johnny = "John";
        System.out.println("Are John and Johnny the same? " + john == johnny);
        // concatenation is done in the compile-time!
        // intern() - instruct to evaluate at compile-time

        // if you don't want to use the string pool:
        // String name = "John";
        // String theName = new String("John");
        // System.out.printLn(name == theName);
    }
}
