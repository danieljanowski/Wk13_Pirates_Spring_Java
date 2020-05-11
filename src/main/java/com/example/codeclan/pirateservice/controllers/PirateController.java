package com.example.codeclan.pirateservice.controllers;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {

    @Autowired
    private PirateRepository pirateRepository;

    @GetMapping(value = "/pirates")
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    @GetMapping(value = "/pirate/{id}")
    public Optional<Pirate> getPirateById(@PathVariable Long id){
        return pirateRepository.findById(id);
    }
}
