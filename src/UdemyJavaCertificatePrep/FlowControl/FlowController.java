package FlowControl;

public class FlowController {
    public void switchItLikeInJava17(int a) {
        boolean isAverage = false;
        switch(a) {
            case 1, 2, 3 -> System.out.println("Small int!");
            case 4, 5, 6 -> {
                System.out.println(("Average int"));
                isAverage = true;
            }
            case 7, 8, 9 -> System.out.println(("Big int"));
            default -> System.out.println("Int not cool!");
        }
        System.out.println("Is average: " + isAverage);
    }

    public void switchExpressionWithJava17(int a) {
        String typeOfInt = switch(a) {
            case 1,2,3 -> "small";
            case 4,5,6 -> "average";
            case 7,8,9 -> "big";
            case 100 -> {
                String x = "One ";
                String y = "Hundred";
                yield x + y;
            }
            default -> "unknown";
        };
        System.out.println(typeOfInt);
    }

    public void playWithNamedLoops() {
        int i = 5;
        OUTER_LOOP: while(i <= 10) { /* loop with label */
            System.out.println(i);
            i++;
        }
    }

    public void playWithInfiniteForLoop() {
        for ( ; ; ) {
            System.out.println("Ooops, infinite loop!");
        }
    }

    public void playWithForeachLoop() {
        String[] cars = new String[] { "VW", "Audi", "Skoda", "Mercedes" };
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
