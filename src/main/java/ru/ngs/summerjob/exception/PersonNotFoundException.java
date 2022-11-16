package ru.ngs.summerjob.exception;

public class PersonNotFoundException extends RuntimeException {
    private final int personId;

    public PersonNotFoundException(int personId) {
        this.personId = personId;
    }

    @Override
    public String getMessage() {
        return "Person with id = " + personId + " not found";
    }
}
