package FunctionalProgramming;

import java.util.function.Predicate;

public class ElPredicatore {
    public void playWithRawPredicates() {
        Predicate<Integer> gt10 = n -> n > 10;
        System.out.println(gt10.test(7));
        System.out.println(gt10.test(12));
    }

    public static void myProbe(int n, Predicate<Integer> predicate) {
        if (predicate.test(n)) {
            System.out.println("Passed!");
        }
        else {
            System.out.println("Failed!");
        }
    }
}
