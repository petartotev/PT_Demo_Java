package FlowControl;

import BeyondClasses.Compass;

public class FlowController {
    /* Switch */
    public void switchItLikeInJava8(int a) {
        switch(a) {
            case 0:
            case 1:
            case 2:
                System.out.println("Small num!");
                break;
            case 3:
            case 4:
                System.out.println("Medium num!");
                break;
            default:
                System.out.println("Big num!");
        }
    }

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
            case 101 -> { yield "Hi"; } /* ⚠️ SUGGESTION: Not a good practice to use yield with a single expression! */
            default -> "unknown";
        };
        System.out.println(typeOfInt);
    }

    public void switchExpressionWithUndefinedType(int a) {
        var printOut = switch(a) {
            case 0 -> "Good morning!";
            case 1 -> 7;
            case 2 -> true;
            default -> 3.14;
        };
        System.out.println(printOut);
    }

    public String switchExpressionUsingEnum(Compass value) {
        return switch(value) {
            case NORTH -> "NORTH!";
            case SOUTH -> "SOUTH!";
            case EAST -> "EAST!";
            case WEST -> "WEST!";
            /* Note that there is no need for default value in case of enums */
        };
    }

    /* While */
    public void playWithNamedWhileLoop() {
        int i = 5;
        OUTER_LOOP: while(i <= 10) { /* loop with label */
            System.out.println(i);
            i++;
        }
    }

    public void playWithMultipleNamedWhileLoops() {
        int i = 0, j = 0;
        OUTER_LOOP: while (true) {
            i++;
            j = 0;
            INNER_LOOP: while (true) {
                j++;
                System.out.println("(" + i + ", " + j + ") ");
                if (j ==3) break OUTER_LOOP;
            }
        }
    }

    public void playWithNestedWhileLoops() {
        int i = 0, j = 0;
        while (i < 3) {
            i++;
            j = 0;
            while (j < 3) {
                j++;
                System.out.println("(" + i + ", " + j + ") ");
            }
        }
    }

    /* Do While */
    public void playWithDoWhileLoop() {
        /* This block of code will be executed at least once! */
        var test = 1;
        do {
            System.out.println("Lovely day!");
        } while (test > 2);
    }

    /* For */
    public void playWithForLoop() {
        for (int i = 0; i < 11; i++) {
            System.out.println("i = " + i);
        }
    }

    public void playWithForLoopHavingMultipleParams() {
        for (int i = 0, j = 0; (i + j) < 5; i++, j++) {
            System.out.println("i = " + i + ", j = " + j);
        }
    }

    public void playWithInfiniteForLoop() {
        for ( ; ; ) {
            System.out.println("Ooops, infinite loop!");
        }
    }

    /* For "Each" */
    public void playWithForeachLoop() {
        String[] cars = new String[] { "VW", "Audi", "Skoda", "Mercedes" };
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
