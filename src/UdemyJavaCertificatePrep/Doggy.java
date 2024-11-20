public class Doggy {
    String name = "Chip"; /* instance variable */

    /* Executed 2nd */
    public Doggy() {
        name = "Rex";
        System.out.println(("Constructor executed! Dog's name set to Rex!"));
    }

    // ⚠️ WARNING: Method name Doggy is the same as its class name!
    public void Doggy() {
        System.out.println("This compiles, but not a good practice!");
    }

    /* Executed 1st */
    /*static*/ { System.out.println(("Initializer block executed!")); }
}