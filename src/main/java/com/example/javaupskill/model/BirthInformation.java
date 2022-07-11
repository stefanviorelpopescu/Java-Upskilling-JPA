package com.example.javaupskill.model;

import lombok.*;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class BirthInformation
{
    private String birthPlace;

    private Long birthDate;
}
