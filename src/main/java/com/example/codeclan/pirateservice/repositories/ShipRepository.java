package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findByPiratesFirstName(String firstName);
}
