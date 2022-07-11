package com.example.javaupskill.repository;

import com.example.javaupskill.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long>
{
    List<PhoneNumber> findAllByPersonId(Long personId);
}
