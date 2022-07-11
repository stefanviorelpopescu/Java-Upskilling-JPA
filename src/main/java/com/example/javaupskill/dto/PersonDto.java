package com.example.javaupskill.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PersonDto
{
    private Long id;
    private String firstName;
    private String lastName;

    private String birthPlace;
    private Long birthDate;

    @JsonProperty("phone")
    private List<String> phoneStrings;
}
