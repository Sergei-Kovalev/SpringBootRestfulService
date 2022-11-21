package ru.ngs.summerjob.dao;

import ru.ngs.summerjob.domain.Person;

import java.util.Optional;

public interface PersonRepository {
    Optional<Person> getPersonById(int id);
    void insertPerson(String firstName, String lastName, int age);
    void updatePerson(String firstName, String lastName, int age, int id);
}
