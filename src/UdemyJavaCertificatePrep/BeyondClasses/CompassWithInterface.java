package BeyondClasses;

public enum CompassWithInterface implements Planet {
    NORTH, SOUTH, EAST, WEST;
    public String getPlanetName() {
        return "Earth";
    }
}
