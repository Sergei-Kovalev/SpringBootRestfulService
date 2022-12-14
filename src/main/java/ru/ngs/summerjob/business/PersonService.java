package ru.ngs.summerjob.business;

import ru.ngs.summerjob.domain.Person;

public interface PersonService {
    Person getPerson(int personId);
    void createPerson(String firstName, String lastName, int age);
    void updatePerson(String firstName, String lastName, int age, int id);
    void deletePerson(int id);
}
