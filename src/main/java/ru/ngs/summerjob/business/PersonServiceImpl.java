package ru.ngs.summerjob.business;

import org.springframework.stereotype.Service;
import ru.ngs.summerjob.domain.Person;
import ru.ngs.summerjob.exception.PersonNotFoundException;
import ru.ngs.summerjob.dao.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Person getPerson(int personId) {
        return personRepository.getPersonById(personId).orElseThrow(() ->new PersonNotFoundException(personId));
    }

    @Override
    public void createPerson(String firstName, String lastName, int age) {
        personRepository.insertPerson(firstName, lastName, age);
    }
}
