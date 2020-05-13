package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long> {
    List<Pirate> findByFirstName(String firstName);

    List<Pirate> findByAgeGreaterThan(int age);

    int countByLastName(String lastName);

    List<Pirate> findByFirstNameOrLastName(String firstName, String lastName);
}

