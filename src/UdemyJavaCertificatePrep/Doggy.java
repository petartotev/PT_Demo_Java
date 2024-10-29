public class Doggy {
    String name = "Test";

    public Doggy() {
        name = "Rex";
        System.out.println(("Constructor is executed. Dog's name set to Rex!"));
    }

    /*static*/ { System.out.println(("Initializer block is executed!")); }
}