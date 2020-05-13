package com.example.codeclan.pirateservice.repositories;

import com.example.codeclan.pirateservice.models.Raid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaidRepository extends JpaRepository <Raid, Long> {
    List<Raid> findByLocation(String location);
    List<Raid> findByPiratesFirstName(String firstName);
    List<Raid> findByPiratesShipName(String name);
}
