package ClassDesign;

/* subclass (child) */
public class Dog extends Animal {
    // Constructor: no return type and name matches class name.
    public Dog() { System.out.println("Woof"); }

    public Dog(String name) { System.out.println("Woof, " + name); }
}
