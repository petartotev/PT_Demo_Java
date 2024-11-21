package BeyondClasses;

public record PupilRecordOverriddenCtor (String firstName, String lastName, int id) {
    public PupilRecordOverriddenCtor(String firstName, String lastName, int id) {
        if (id < 10 || id > 1_000_000) throw new IllegalArgumentException();
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
}