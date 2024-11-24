package DataTypes;

import java.io.PrintStream;
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
        System.out.println(john.indexOf('o')); /* 1 */
        System.out.println(john.indexOf('Z')); /* -1 (not found) */
        System.out.println(john.indexOf("hn", 4)); /* search for 'hn' starts at index 4 */

        // substring()
        System.out.println(john.substring(3));
        System.out.println(john.substring(3, 8)); /* ⚠️ WARNING: 8 is not included! */
        System.out.println(john.substring(3, 3)); /* empty string */
        //System.out.println(john.substring(8, 3)); /* 🔴 ERROR: StringIndexOutOfBoundsException */
        //System.out.println(john.substring(3, 666)); /* 🔴 ERROR: StringIndexOutOfBoundsException */

        // toLowerCase(), toUpperCase()
        String nameAsIs = "John Wayne";
        System.out.println(nameAsIs.toLowerCase());
        System.out.println(nameAsIs.toUpperCase());

        /* PT: C#'s ToLowerInvariant() and ToUpperInvariant() can be replaced in Java using Locale.ROOT: */
        System.out.println(nameAsIs.toLowerCase(Locale.ROOT));
        System.out.println(nameAsIs.toUpperCase(Locale.ROOT));

        var name1 = new String("John Doe");
        var name2 = new String("John Doe");
        var name3 = new String("john doe");

        // equals(), equalsIgnoreCase()
        System.out.println(name1 == name2); /* false */
        System.out.println(name1.equals(name2)); /* true */
        System.out.println(name1.equals(name3)); /* false */
        System.out.println(name1.equalsIgnoreCase(name3)); /* true */

        var student = "Peter Totev";

        // startsWith(), endsWith()
        if (student.startsWith("Peter") && student.endsWith("Totev")) {
            System.out.println("Match!");
        }
        //if (student.startsWith('P')) { } /* 🔴 ERROR: Does not compile! Does not accept characters! */

        // contains()
        if (student.contains("eter")) {
            System.out.println("Rhymes with meter!");
        }
        //if (student.contains('e')) { } /* 🔴 ERROR: Does not compile! Does not accept characters! */

        // replace()
        student = student.replace("v", "ff");
        student = student.replace('a', 'o'); /* 💡 FACT: Accepts characters! */
        System.out.println(student);

        // strip(), trim(), stripLeading(), stripTrailing()
        String myStringToTrim = "     abc  ";
        System.out.println("strip: " + "|" + myStringToTrim.strip() + "|");
        System.out.println("stripLeading: " + "|" + myStringToTrim.stripLeading() + "|");
        System.out.println("stripTrailing: " + "|" + myStringToTrim.stripTrailing() + "|");
        // trim() is like strip(), but supports Unicode!
        System.out.println("trim: " + "|" + myStringToTrim.trim() + "|");
        // 💡 FACT: All methods trim \t (tab), \n (new line), \r (carriage return)

        // indent(n), stripIndent()
        /*
        indent(n):
        - if n = 0 => does nothing
        - if n > 0 => adds the same number of blank spaces to each line
        - if n < 0 => tries to remove n whitespace characters from the beginning of line
        - normalizes existing line breaks
        - adds line break at the end if missing
        stripIndent()
        - removes all leading incidental whitespace
        - normalizes existing line breaks
        - does not add line break at the end if missing
         */
        String strToIndent = "     John\n   D.\n  Wayne";
        System.out.println("-----");
        System.out.println(strToIndent);
        System.out.println("-----");
        System.out.println(strToIndent.indent(2));
        System.out.println("-----");
        System.out.println(strToIndent.indent(-2));
        System.out.println("-----");
        System.out.println(strToIndent.stripIndent());
        System.out.println("-----");

        // translateEscapes();
        String nameToTranslateEscape = "John\\tWayne";
        System.out.println(nameToTranslateEscape); /* John\tWayne */
        System.out.println(nameToTranslateEscape.translateEscapes()); /* John    Wayne */

        // isEmpty(), isBlank()
        System.out.println("".isEmpty()); /* true */
        System.out.println("  ".isEmpty()); /* false */
        System.out.println("".isBlank()); /* true */
        System.out.println("  ".isBlank()); /* true */

        String myRandomString = (new Random()).nextInt(4) == 3 ? "Legit string" : " ";
        if (myRandomString == null || myRandomString.isEmpty() || myRandomString.isBlank()) {
            System.out.println("myRandomString is null, empty or whitespace!");
        }

        // format(), formatted()
        // %s - string
        // %d - digit
        // %c - char
        // %a - float, double
        // %b - boolean
        // %n - system-dependent line separator
        String test = "Test";
        Integer num = 5;
        System.out.println(String.format("%s has %d marbles", test, num));
        //System.out.println(String.format("%d has %s marbles", test, num)); /* 🔴 ERROR: java.util.IllegalFormatConversionException */
        System.out.println("%s has %d marbles".formatted(test, num));

        String someName = "   John Wayne  ";
        System.out.println(someName.trim().toUpperCase().replace('Y', 'R')); /* 💡 FACT: Chained methods are applied from left to right! */
    }

    public void playWithStringBuilder() {
        var test = "Testy Boo Boo";
        var stringBuilder = new StringBuilder(test);
        // 💡 FACT: substring(), indexOf(), length(), charAt() work in the same way as in String!

        stringBuilder.append("The Almighty!");

        //stringBuilder.appendLine("The Almighty!"); /* 👎👎 Java has no appendLine method! One has to use the cheat below: */
        stringBuilder.append("Some text").append(System.lineSeparator());

        stringBuilder.insert(6, "D. "); /* John D. Wayne */

        // delete(), deleteCharAt(2), replace(), reverse()
        /* TODO: Implement examples for the 4 methods above as in tutorial. */

        System.out.println(stringBuilder.toString());

        // 💡 FACT: StringBuilder doesn't implement equals() method => equals() acts the same as ==
        StringBuilder sbName1 = new StringBuilder("John");
        StringBuilder sbName2 = new StringBuilder("John");
        System.out.println(sbName1 == sbName2); /* false */
        System.out.println(sbName1.equals(sbName2)); /* false */

        // 💡 FACT: substring() returns a Strng and doesn't change the StringBuilder:
        StringBuilder sbName3 = new StringBuilder("John Wayne");
        sbName3.substring(2, 6);
        System.out.println(sbName3);
    }

    public void playWithStringPool() {
        String john = "John";
        String johnny = "John";
        System.out.println("Are John and Johnny the same? " + john == johnny);

        // 💡 FACT: Trim() is done in the run-time!
        String s1 = "John";
        String s2 = "John    ".trim(); /* compiler doesn't know these 2 are the same! */
        System.out.println(s1 == s2); /* false */

        // 💡 FACT: Concatenation is done in the compile-time!
        String s3 = "John Wayne";
        String s4 = "John" + " " + "Wayne";
        System.out.println(s3 == s4); /* true */

        // intern() - instructs to evaluate at compile-time
        String s5 = "John";
        String s6 = "John    ".trim().intern(); /* instructs compiler to evaluate before runtime! */
        System.out.println(s5 == s6); /* true */
        String s7 = "John";
        String s8 = "John    ".trim(); /* instructs compiler to evaluate before runtime! */
        System.out.println(s5 == s6.intern()); /* true, but bad practice - memory is allocated twice! */

        // 💡 FACT: if you don't want to use the string pool, use new String(something):
        // String name = "John";
        // String theName = new String("John");
        // System.out.printLn(name == theName);
    }
}
