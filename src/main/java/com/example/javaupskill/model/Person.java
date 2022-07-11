package com.example.javaupskill.model;

import com.example.javaupskill.model.converter.SubscriptionStatusConverter;
import com.example.javaupskill.model.listener.PersonListener;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(PersonListener.class)
//@Table(uniqueConstraints = {@UniqueConstraint(name = "person_fName_lName_uk", columnNames = {"firstName", "lastName"})})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @Embedded
    private BirthInformation birthInformation;

    @Enumerated(EnumType.STRING)
    private PersonState state;

    @Convert(converter = SubscriptionStatusConverter.class)
    private SubscriptionStatus subscriptionStatus;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;

}
