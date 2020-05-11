package com.example.codeclan.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @JsonIgnoreProperties("ship")
    @OneToMany(mappedBy="ship")
    private List<Pirate> pirates;

    public Ship(String name) {
        this.id = id;
        this.name = name;
        this.pirates = new ArrayList<Pirate>();
    }

    public Ship() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
