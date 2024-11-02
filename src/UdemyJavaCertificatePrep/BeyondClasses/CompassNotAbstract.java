package BeyondClasses;

public enum CompassNotAbstract {
    NORTH {
        public String getDirection() { return "CompassNotAbstract: Up"; }
    },
    SOUTH {
        public String getDirection() { return "CompassNotAbstract: Down"; }
    },
    EAST, WEST;
    public String getDirection() { return "CompassNotAbstract: Sideways"; } /* method cannot be abstract, as EAST and WEST provide no implementation */
}
