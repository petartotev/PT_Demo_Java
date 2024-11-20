package ClassDesign;

/* subclass (child) */
public class Dog extends Animal {
    // 💡 FACT: Constructor has no return type and its name matches class name.
    public Dog() { System.out.println("Woof!"); }
    public Dog(String name) { System.out.println("Woof, " + name + "!"); } /* constructor overloading */
    public Dog(String name, int age) { System.out.println("Woof, " + name + "! Your age is " + age + "."); } /* constructor overloading */
}
