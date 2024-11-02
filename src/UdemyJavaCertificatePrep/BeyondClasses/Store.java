package BeyondClasses;

public class Store {
    // Works with interfaces as well (interface Sale)
    abstract class Sale {
        abstract int discount();
    }
    public int newPrice(int oldPrice) {
        // Sale is an instance of the anonymous class { ... } with the implementation of discount() method from abstract class Sale.
        Sale sale = new Sale() {
            int discount() { return 2; }
        };
        return oldPrice - sale.discount();
    }
}
