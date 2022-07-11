package com.example.javaupskill.repository;

import com.example.javaupskill.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest
{
    @Autowired
    PersonRepository personRepository;

    @Test
    public void insertPersonWithQuery()
    {
//        Person person = new Person(1L, "Ion", "Popescu", null, null, new ArrayList<>());
//
//        personRepository.save(person);
    }
}