package ru.ngs.summerjob.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ngs.summerjob.business.PersonService;
import ru.ngs.summerjob.domain.Person;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{personId:\\d+}")
    public Person getPersonService(@PathVariable int personId) {
        return personService.getPerson(personId);
    }
}
