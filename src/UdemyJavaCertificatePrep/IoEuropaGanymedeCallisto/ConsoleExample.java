package IoEuropaGanymedeCallisto;

import java.io.Console;
import java.util.Arrays;

public class ConsoleExample {
    public static void main(String[] args) {
        Console console = System.console(); /* Singleton! */
        String myName = console.readLine("What is your name? ");
        console.format("Hello, %s!%n", myName);
        console.writer().println("-".repeat(30));

        /*
        If you run program from IntelliJ:
        🔴 ERROR: Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.io.Console.readLine(String, Object[])" because "console" is null at IoEuropaGanymedeCallisto.ConsoleExample.main(ConsoleExample.java:9)
        You need to run it from Terminal:
        1. Go to View > Tool Windows > Terminal
        2. cd .\src\UdemyJavaCertificatePrep\IoEuropaGanymedeCallisto
        3. javac ConsoleExample.java
        4. java ConsoleExample.java
        5. ✅ SUCCESS: What is your name? ...
        */

        char[] password = console.readPassword("Please, enter the password: ");
        System.out.println("password.toString() = " + password.toString());
        char[] passwordToConfirm = console.readPassword("Please, enter the password again: ");
        System.out.println("passwordToConfirm.toString() = " + passwordToConfirm.toString());

        if (Arrays.equals(password, passwordToConfirm)) {
            console.printf("Password successfully set.%n");
        } else {
            console.printf("ERROR: Passwords do not match!&n");
        }
    }
}
