package BeyondClasses;

// 💡 Enums can have constructors and instance methods:
public enum CompassWithCtor {
    NORTH("Up!"), SOUTH("Down!"), EAST("Right!"), WEST("Left!"); /* ; is required */

    private final String instruction;

    private CompassWithCtor(String instruction) { /* 💡 Enum has implicitly private constructor */
        this.instruction = instruction;
        System.out.println("Constructor executed: " + instruction);
    }

    public void printInstruction() {
        System.out.println(instruction);
    }
}
