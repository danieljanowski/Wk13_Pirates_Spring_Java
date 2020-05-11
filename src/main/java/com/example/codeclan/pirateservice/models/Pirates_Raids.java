package com.example.codeclan.pirateservice.models;

import javax.persistence.*;

@Entity
@Table(name="pirates_raids")

public class Pirates_Raids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pirate_id", nullable = false)
    private Pirate pirate;

    @ManyToOne
    @JoinColumn(name = "raid_id", nullable = false)
    private Raid raid;

    public Pirates_Raids(Pirate pirate, Raid raid) {
        this.pirate = pirate;
        this.raid = raid;
    }

    public Pirates_Raids() {
    }

    public Long getId() {
        return id;
    }

    public Pirate getPirate() {
        return pirate;
    }

    public void setPirate(Pirate pirate) {
        this.pirate = pirate;
    }

    public Raid getRaid() {
        return raid;
    }

    public void setRaid(Raid raid) {
        this.raid = raid;
    }
}
