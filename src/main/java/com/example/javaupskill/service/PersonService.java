package com.example.javaupskill.service;

import com.example.javaupskill.model.Person;
import com.example.javaupskill.dto.PersonDto;
import com.example.javaupskill.model.PersonState;
import com.example.javaupskill.model.PhoneNumber;
import com.example.javaupskill.model.converter.PersonConverter;
import com.example.javaupskill.repository.PersonRepository;
import com.example.javaupskill.repository.PhoneNumberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService
{
    private final PersonRepository personRepository;
    private final PhoneNumberRepository phoneNumberRepository;

    public PersonService(PersonRepository personRepository, PhoneNumberRepository phoneNumberRepository)
    {
        this.personRepository = personRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    public PersonDto createPerson(PersonDto personDto) {
        Person person = PersonConverter.personDtoToPerson(personDto);
        person.setState(PersonState.INACTIVE);
        personRepository.save(person);
        return PersonConverter.personToPersonDto(person);
    }

    @Transactional
    public PersonDto createPersonWithTwoQueries(PersonDto personDto) {

        Person person = PersonConverter.personDtoToPerson(personDto);
        personRepository.save(person);

        for (String phoneNo : personDto.getPhoneStrings()) {
            insertPhoneNumber(person, phoneNo);
        }
        return PersonConverter.personToPersonDto(person);
    }

    private void insertPhoneNumber(Person person, String phoneNo)
    {
        PhoneNumber phoneNumber = PhoneNumber.builder()
                .person(person)
                .phoneNumber(phoneNo)
                .build();
        phoneNumberRepository.save(phoneNumber);
    }

    public ResponseEntity<PersonDto> updatePerson(PersonDto personDto) {
        Person person = PersonConverter.personDtoToPerson(personDto);
        Optional<Person> existingPerson = personRepository.findById(personDto.getId());
        if (existingPerson.isPresent()) {
            personRepository.save(person);
            return new ResponseEntity<>(personDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deletePerson(long id) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<PersonDto> getPerson(long id) {

        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PersonDto personDto = PersonConverter.personToPersonDto(optionalPerson.get());
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    public List<PersonDto> getAllPersons()
    {
        return PersonConverter.personListToPersonDtoList(personRepository.findAll());
    }

    public List<PersonDto> findAllByNameAndPhone(String name, String phone)
    {

//        return PersonConverter.personListToPersonDtoList(personRepository.findAllByLastNameContaining(name).stream()
//                .filter(person -> person.getPhoneNumbers().stream().anyMatch(phoneNumber -> phoneNumber.getPhoneNumber().contains(phone)))
//                .collect(Collectors.toList()));

        return PersonConverter.personListToPersonDtoList(personRepository.findAllByLastNameContainingAndPhoneNumbers_PhoneNumberContaining(name, phone));
    }
}
