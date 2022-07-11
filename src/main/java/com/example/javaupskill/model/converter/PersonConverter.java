package com.example.javaupskill.model.converter;

import com.example.javaupskill.model.BirthInformation;
import com.example.javaupskill.model.Person;
import com.example.javaupskill.dto.PersonDto;
import com.example.javaupskill.model.PhoneNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonConverter
{
    public static PersonDto personToPersonDto(Person person) {
        List<String> phoneList = person.getPhoneNumbers().stream()
                .map(PhoneNumber::getPhoneNumber)
                .collect(Collectors.toList());
        return PersonDto.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .birthPlace(person.getBirthInformation().getBirthPlace())
                .birthDate(person.getBirthInformation().getBirthDate())
                .phoneStrings(phoneList)
                .build();
    }

    public static List<PersonDto> personListToPersonDtoList(List<Person> personList) {
        return personList.stream()
                .map(PersonConverter::personToPersonDto)
                .collect(Collectors.toList());
    }

    public static Person personDtoToPerson(PersonDto personDto) {
        Person person = Person.builder()
                .id(personDto.getId())
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .birthInformation(new BirthInformation(personDto.getBirthPlace(), personDto.getBirthDate()))
                .phoneNumbers(new ArrayList<>())
                .build();
        personDto.getPhoneStrings().forEach(phoneString -> person.getPhoneNumbers().add(new PhoneNumber(null, person, phoneString)));
        return person;
    }

}
