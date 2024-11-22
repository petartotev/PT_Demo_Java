package BeyondClasses;

public class Store {
    // Works with interfaces as well (interface Sale)
    abstract class Sale {
        abstract int discount();
    }

    public int newPrice(int oldPrice) {
        // Option 1
        Sale sale1 = new Sale() { int discount() { return 2; } };

        // Option 2
        // Sale is an instance of the anonymous class { ... } with the implementation of discount() method from abstract class Sale.
        Sale sale2 = new Sale() {
            int discount() { return 2; }
        };

        return oldPrice - sale2.discount();
    }
}
