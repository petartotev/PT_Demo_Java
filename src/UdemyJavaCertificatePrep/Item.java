public class Item {
    // public Item() { } - if you don't provide a constructor, compiler auto-generates one with empty body.

}

class SpecificItem { } /* this compiles as SpecificItem is an internal class */

//public class AnotherPublicItem { } /* 🔴 ERROR: Does not compile! Only 1 class in a file can be marked as static. */