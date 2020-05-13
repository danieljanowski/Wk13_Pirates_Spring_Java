package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RaidController {

    @Autowired
    private PirateRepository pirateRepository;

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private RaidRepository raidRepository;

    @GetMapping(value = "/raids")
    public ResponseEntity<List<Raid>> getAllRaids(){
        List<Raid> foundRaids = raidRepository.findAll();
        return new ResponseEntity<List<Raid>>(foundRaids, HttpStatus.OK);
    }

    @GetMapping(value = "/raids/{id}")
    public ResponseEntity getRaid(@PathVariable Long id){
        return new ResponseEntity<>(raidRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/raids")
    public ResponseEntity postRaid(@RequestBody Raid raid){
        raidRepository.save(raid);
        return new ResponseEntity(raid, HttpStatus.CREATED);
    }

}
