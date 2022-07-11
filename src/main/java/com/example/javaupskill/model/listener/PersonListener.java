package com.example.javaupskill.model.listener;

import com.example.javaupskill.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

public class PersonListener
{
    private static final Logger log = LoggerFactory.getLogger(PersonListener.class);

    @PrePersist
    @PreUpdate
    public void logNewUserAttempt(Person person) {
        log.info("Attempting to add new user with username: " + person.getFirstName());
    }

    @PostPersist
    @PostUpdate
    public void logNewUserAdded(Person person) {
        log.info("Added user '" + person.getFirstName() + "' with ID: " + person.getId());
    }

    @PreRemove
    public void logUserRemovalAttempt(Person person) {
        log.info("Attempting to delete user: " + person.getFirstName());
    }

    @PostRemove
    public void logUserRemoval(Person person) {
        log.info("Deleted user: " + person.getFirstName());
    }

    @PostLoad
    public void logUserLoad(Person person) {
        log.info("Selected user: " + person.getFirstName());
    }
}
