package ru.ngs.summerjob.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.ngs.summerjob.business.PersonService;
import ru.ngs.summerjob.domain.Person;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{personId:\\d+}")                         //получение данных
    public Person getPersonService(@PathVariable int personId) {
        return personService.getPerson(personId);
    }

    @PostMapping                                                    //добавление данных
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@Valid @RequestBody PersonRequest request) {
        personService.createPerson(request.firstName(), request.lastName(), request.age());
    }

    @PutMapping(value = "/{personId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)                          //изменение данных
    public void updatePerson(@Valid @RequestBody PersonRequest request,
                             @PathVariable int personId) {
        personService.updatePerson(
                request.firstName(),
                request.lastName(),
                request.age(),
                personId
        );
    }
}
