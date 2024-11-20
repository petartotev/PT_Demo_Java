// Comments are similar to ones in C#!

/* Same as C#! */

/*
 * This is the usual way to write multiline comments.
 * It's very readable like this.
*/

/** <- "Javadoc"
 * This class Student was the first class I ever created using Java.
 * @author Petar Totev <-- "Javadoc tag"
 //* @param – Describes a method parameter.
 //* @return – Describes the return value of a method.
 //* @throws – Describes exceptions thrown by a method.
 //* @exception – Describes exceptions thrown by a method.
 //* @since – Indicates when the feature was added.
 //* @deprecated – Marks a method or class as deprecated.
 */
public class Student {
    public Student() {
        System.out.println("Student is created!");
    }

    String name;
    public String getName() {
        return name;
    }
    public void setName(String theName) {
        name = theName;
    }
}