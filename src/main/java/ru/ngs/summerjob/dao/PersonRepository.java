package ru.ngs.summerjob.dao;

import ru.ngs.summerjob.domain.Person;

import java.util.Optional;

public interface PersonRepository {
    Optional<Person> getPersonById(int id);
}
