package BeyondClasses;

import java.util.Objects;

public final class PupilEncapsulated {
    private final String firstName;
    private final String lastName;
    private final int id;

    public PupilEncapsulated(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student { firstName = " + firstName + ", lastName = " + lastName + ", id = " + id + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PupilEncapsulated pupil = (PupilEncapsulated) o;
        return id == pupil.id && Objects.equals(firstName, pupil.firstName) && Objects.equals(lastName, pupil.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }
}
