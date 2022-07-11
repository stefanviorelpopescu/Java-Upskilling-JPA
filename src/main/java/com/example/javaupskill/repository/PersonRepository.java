package com.example.javaupskill.repository;

import com.example.javaupskill.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>
{
    List<Person> findAllByLastNameContaining(String name);

    List<Person> findAllByLastNameContainingAndPhoneNumbers_PhoneNumberContaining(String name, String phone);

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Transactional
//    public void insertPersonWithQuery(Person person) {
//        entityManager.createNativeQuery("insert into person(id, first_name, last_name) values (?, ?, ?)")
//                .setParameter(1, person.getId())
//                .setParameter(2, person.getFirstName())
//                .setParameter(3, person.getLastName())
//                .executeUpdate();
//    }
//
//    @Transactional
//    public Person insertPersonWithEntityManager(Person person) {
//        entityManager.persist(person);
//        return person;
//    }
//
//    @Transactional
//    public void updatePersonWithEntityManager(Person person) {
//        entityManager.merge(person);
//    }
//
//    @Transactional
//    public void deletePersonWithEntityManager(long id) {
//        Optional<Person> optionalPerson = getById(id);
//        optionalPerson.ifPresent(person -> entityManager.remove(person));
//    }
//
//    public Optional<Person> getById(long id) {
//        Person person = entityManager.find(Person.class, id);
//        if (person == null) {
//            return Optional.empty();
//        }
//        return Optional.of(person);
//    }
}
