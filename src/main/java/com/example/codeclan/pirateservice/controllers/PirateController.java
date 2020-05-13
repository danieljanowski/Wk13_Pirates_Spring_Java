package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {

    @Autowired
    private PirateRepository pirateRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private RaidRepository raidRepository;


    /**
     * TDDO write a countroller route for findByFirstName
     * This controlle aloows is to do
     * GET /pirates returning [] of all the pirates
     * GET /pirates?firstName=John
     */


    @GetMapping(value = "/pirates")
    public ResponseEntity<List<Pirate>> getAllPirates(
            @RequestParam(name = "firstName", required = false) String firstName,
            @RequestParam (name = "age", required = false) Integer age
        ){
        //the one where we find all the pirates:
        if (firstName != null){
            return new ResponseEntity<>(pirateRepository.findByFirstName(firstName), HttpStatus.OK);
        }

        if (age != null){
            return new ResponseEntity<>(pirateRepository.findByAgeGreaterThan(age), HttpStatus.OK);
        }

        List<Pirate> foundPirates = pirateRepository.findAll();
        return new ResponseEntity<List<Pirate>>(foundPirates, HttpStatus.OK);

        //teh one that we find all the pirates with the given firstname
    }

    @GetMapping(value = "/pirate/{id}")
    public ResponseEntity getPirate(@PathVariable Long id) {
        return new ResponseEntity<>(pirateRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/pirates")
    public ResponseEntity postPirate(@RequestBody Pirate pirate) {
        pirateRepository.save(pirate);
        return new ResponseEntity<>(pirate, HttpStatus.CREATED);
    }
}

