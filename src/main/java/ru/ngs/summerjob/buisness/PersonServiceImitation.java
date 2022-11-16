package ru.ngs.summerjob.buisness;

import org.springframework.stereotype.Service;
import ru.ngs.summerjob.domain.Person;
import ru.ngs.summerjob.exception.PersonNotFoundException;

@Service
public class PersonServiceImitation implements PersonService {
    @Override
    public Person getPerson(int personId) {
        if (personId == 123) {
            return new Person(
                    personId,
                    "Ivan",
                    "Ivanov"
            );
        } else {
            throw new PersonNotFoundException(personId);
        }
    }
}
