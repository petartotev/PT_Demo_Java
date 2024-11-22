package Streams;

import java.util.Optional;

// 💡 SUGGESTION: You can avoid working with nulls by using Optional!
public class Optionalissimo {
    public static Optional<Double> average (int... myArrayNums) {
        if (myArrayNums.length == 0) {
            // empty()
            return Optional.empty();
        }
        int sum = 0;
        for (int number : myArrayNums) {
            sum += number;
        }
        // of((type) value)
        return Optional.of((double) sum / myArrayNums.length);
    }
}
