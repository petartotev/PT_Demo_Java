package BeyondClasses;

public enum CompassWithInterface implements Planet {
    NORTH {
        public String getPlanetName() { return "Northern Star"; }
    },
    SOUTH {
        public String getPlanetName() { return "South Cross"; }
    },
    EAST, WEST; /* default implementation */
    public String getPlanetName() {
        return "Earth";
    }
}
