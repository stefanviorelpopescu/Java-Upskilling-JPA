package com.example.javaupskill.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(indexes = {@Index(columnList = "phoneNumber")})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PhoneNumber
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

//    @Column(unique = true)
    private String phoneNumber;

}
