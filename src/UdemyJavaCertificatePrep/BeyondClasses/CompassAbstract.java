package BeyondClasses;

// 💡 FACT: Enums can implement abstract methods!
public enum CompassAbstract {
    // Enum requires values to be listed in the beginning, then methods.
    NORTH {
        public String getDirection() { return "CompassAbstract: Up"; }
    },
    SOUTH {
        public String getDirection() { return "CompassAbstract: Down"; }
    },
    EAST {
        public String getDirection() { return "CompassAbstract: Right"; }
    },
    WEST {
        public String getDirection() { return "CompassAbstract: Left"; }
    };
    public abstract String getDirection(); /* abstract method */
}
