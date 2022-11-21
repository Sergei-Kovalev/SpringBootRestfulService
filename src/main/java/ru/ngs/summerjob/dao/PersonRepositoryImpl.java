package ru.ngs.summerjob.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.ngs.summerjob.domain.Person;

import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private static final String SQL_GET_PERSON_BY_ID = "SELECT id, first_name, last_name, age FROM person WHERE id = :id";
    private static final String SQL_INSERT_PERSON = "INSERT INTO person (first_name, last_name, age) VALUES (:firstName, :lastName, :age)";
    private static final String SQL_UPDATE_PERSON = "UPDATE person SET first_name = :firstName, last_name = :lastName, age = :age WHERE id = :id";

    private final PersonMapper personMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PersonRepositoryImpl(PersonMapper personMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.personMapper = personMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Person> getPersonById(int id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return jdbcTemplate.query(
                SQL_GET_PERSON_BY_ID,
                namedParameters,
                personMapper
        ).stream().findFirst();
    }

    @Override
    public void insertPerson(String firstName, String lastName, int age) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("firstName", firstName);
        namedParameters.addValue("lastName", lastName);
        namedParameters.addValue("age", age);
        jdbcTemplate.update(SQL_INSERT_PERSON, namedParameters);
    }

    @Override
    public void updatePerson(String firstName, String lastName, int age, int id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("firstName", firstName);
        namedParameters.addValue("lastName", lastName);
        namedParameters.addValue("age", age);
        namedParameters.addValue("id", id);
        jdbcTemplate.update(SQL_UPDATE_PERSON, namedParameters);
    }
}
