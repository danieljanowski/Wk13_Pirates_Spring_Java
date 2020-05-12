package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipController {

    @Autowired
    private PirateRepository pirateRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private RaidRepository raidRepository;

    @GetMapping(value = "/ships")
    public ResponseEntity<List<Ship>> getAllShips() {
        List<Ship> foundShips = shipRepository.findAll();
        return new ResponseEntity<List<Ship>>(foundShips, HttpStatus.OK);
    }

    @GetMapping(value = "/ship/{id}")
    public ResponseEntity getShip(@PathVariable Long id){
        return new ResponseEntity<>(shipRepository.findById(id), HttpStatus.OK);
    }

}
