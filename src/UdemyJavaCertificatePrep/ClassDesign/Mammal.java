package ClassDesign;

public class Mammal extends Animal {
    private int age;
    protected String name;

    public Mammal() { setAge(0); }
    public Mammal(int age) {
        setAge(age);
    }

    public int getAge() {
        return age;
    }
    public void setAge(int theAge) {
        age = theAge;
    }
    /*
     or
     public void setAge(int age) {
         this.age = age;
     }
    */

    public void speak() {
        System.out.println("Mammal sound!");
    }

    public void eat() {
        System.out.println("Mammal eats!");
    }
}
