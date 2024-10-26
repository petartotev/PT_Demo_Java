public class Dog {
    String name = "Test";

    public Dog() {
        name = "Rex";
        System.out.println(("Constructor is executed. Dog's name set to Rex!"));
    }

    /*static*/ { System.out.println(("Initializer block is executed!")); }
}