package Methodology;

import java.util.Arrays;

public class MethodItem {
    public double tax = 0.2;
    public static double taxStatic = 0.2;

    public double getPrice(double inputPrice) {
        double margin = 0.05;
        return inputPrice * (1 + tax) * (1 + margin);
    }

    public double getStaticPrice(double inputPrice) {
        double margin = 0.05;
        return inputPrice * (1 + taxStatic) * (1 + margin);
    }

    public double getFinalMarginPrice(double inputPrice) {
        final double margin = 0.05;
        //margin = 0.02; 🔴 ERROR: Does not compile!
        return inputPrice * (1 + tax) * (1 + margin);
    }

    public void printSomethingUsingFinalArray() {
        final int[] a = { 1, 3, 5 };
        a[1] = 7;
        System.out.println(Arrays.toString(a)); /* [1, 7, 5] */
    }
}