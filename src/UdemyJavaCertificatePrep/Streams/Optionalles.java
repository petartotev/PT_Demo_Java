package Streams;

import java.util.Optional;

// You can avoid working with nulls by using Optional!
public class Optionalles {
    public static Optional<Double> average (int... myArrayNums) {
        if (myArrayNums.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int number : myArrayNums) {
            sum += number;
        }
        return Optional.of((double) sum / myArrayNums.length);
    }
}
