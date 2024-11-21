package BeyondClasses;

public record PupilRecordCompactCtor(String firstName, String lastName, int id) {
    /* compact constructor */
    public PupilRecordCompactCtor {
        if (id < 10 || id > 1_000_000) throw new IllegalArgumentException();
    }
}