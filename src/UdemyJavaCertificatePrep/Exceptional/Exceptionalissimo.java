package Exceptional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptionalissimo {
    /* Does not compile, possibility to throw IOException! */
    public void readFirstByteFromFileDoesNotCompile(File fileName) {
        //FileInputStream file = new FileInputStream(fileName);
        //byte x = (byte) file.read();
        //System.out.println(x);
    }

    /* Fix 1: declare exception */
    public void readFirstByteFromFileWithThrows(File fileName) throws IOException {
        FileInputStream file = new FileInputStream(fileName);
        byte x = (byte) file.read();
        System.out.println(x);
    }

    /* Fix 2: try-catch block */
    public void readFirstByteFromFileHandleException(File fileName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            byte x = (byte) file.read();
            System.out.println(x);
        } catch (IOException e) {
            System.out.println("An IO error occurred");
            e.printStackTrace();
        }
    }

    public void printFourthElementNotHandled(int[] a) {
        System.out.println(a[3]);
    }

    public void printFourthElementHandled(int[] a) {
        try {
            System.out.println(a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
            e.printStackTrace();
        }
    }

    public void manuallyThrowExceptionIfGreaterThanEight(int x) {
        if (x > 8) {
            throw new IllegalArgumentException("Number is greater than 8");
        }
    }

    public void catchMultipleExceptionsSubclasses(File fileName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            byte x = (byte) file.read();
            System.out.println(x);
        } catch (FileNotFoundException e) { /* subclass of IOException */
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) { /* superclass */
            System.out.println("An IO error occurred");
            e.printStackTrace();
        }
    }

    public void catchMultipleExceptionsNotSubclasses(File fileName){
        try {
            FileInputStream file = new FileInputStream(fileName);
            byte x = (byte) file.read();
            System.out.println(x);
        } catch (IOException e) { /* not subclass */
            System.out.println("File not found");
            e.printStackTrace();
        } catch (NumberFormatException e) { /* not superclass */
            System.out.println("An IO error occurred");
            e.printStackTrace();
        }
    }

    public void catchMultipleExceptionsNotSubclassesCoolerWay(File fileName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            byte x = (byte) file.read();
            System.out.println(x);
        } catch (IOException | NumberFormatException e) { /* ⚠️ works only for independent classes!! */
            // } catch (FileNotFoundException e1 | NumberFormatException e2) { /* ⚠️ wrong syntax! */
            // } catch (FileNotFoundException e | NumberFormatException e) { /* ⚠️ wrong syntax! */
            e.printStackTrace();
        } finally {
            System.out.println("Finally block");
        }
    }

    // Resource Management
    public void useResourceManagementManual(String fileName) {
        FileInputStream is = null;
        try {
            // 1. open resource
            is = new FileInputStream(fileName);
            // 2. read file data
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    // 3. close resource
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Try With Resource Block (Automatic Resource Management)
    public void useResourceManagementAutomatic(String fileName) {
        try (FileInputStream is = new FileInputStream(fileName)) { /* open resource */
            /* read file data */
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* implicit finally block */
    }
}