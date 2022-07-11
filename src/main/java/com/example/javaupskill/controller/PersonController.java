package com.example.javaupskill.controller;

import com.example.javaupskill.dto.PersonDto;
import com.example.javaupskill.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController
{
    private final PersonService personService;

    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable long id) {
        return personService.getPerson(id);
    }

    @GetMapping("/all")
    public List<PersonDto> getPerson() {
        return personService.getAllPersons();
    }

    @PostMapping("/create")
    public PersonDto createPerson(@RequestBody PersonDto person) {
        return personService.createPerson(person);
    }

    @PutMapping("/update")
    public ResponseEntity<PersonDto> updatePerson(@RequestBody PersonDto personDto) {
        return personService.updatePerson(personDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable long id) {
        return personService.deletePerson(id);
    }

    @GetMapping("/find")
    public List<PersonDto> findPersons(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "phone") String phone) {
        return personService.findAllByNameAndPhone(name, phone);
    }

}
