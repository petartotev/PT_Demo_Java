package ClassDesign;

// 💡 FACT: Inheritance is TRANSITIVE: Cat extends Mammal extends Animal.
public class Cat extends Mammal {
    public Cat() {
        // ⚠️ Compiler inserts super() automatically!
        super(5); /* KEYWORD: super() */
    }

    public void setNameAndAge(String catName, int age) {
        name = catName;
        setAge(age);
    }
    /*
    or
    public void setNameAndAge(String name, int age) {
        super.name = name;
        setAge(age);
    }
    */

    public void meow() {
        System.out.println("Cat " + name + " (" + getAge() + ") says: meow!");
    }

    @Override /* can skip the @Override keyword, but it is useful */
    public void speak() {
        System.out.println("Meow!");
    }

    // No @Override keyword, but still acts as one!
    public void eat() {
        super.eat();
        System.out.println("Cat eats too!");
    }
}
