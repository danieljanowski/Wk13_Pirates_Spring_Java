package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	private PirateRepository pirateRepository;

	@Autowired
	private ShipRepository shipRepository;

	@Autowired
	private RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPirateAndShip(){

		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate1);
	}

	@Test
	public void createPirateAndRaids(){

		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate1);

		Raid raid1 = new Raid("Monkey Island",150);
		raidRepository.save(raid1);

		raid1.addPirate(pirate1);
		raidRepository.save(raid1);

		pirate1.addRaid(raid1);
		pirateRepository.save(pirate1);
	}

	@Test
	public void canFindPiratesOver40(){
		List<Pirate> foundPirates = pirateRepository.findByAgeGreaterThan(40);
	}

	@Test
	public void canFindRaidForLocation(){
		List<Raid> foundRaids = raidRepository.findByLocation("Tortuga");
	}

	@Test
	public void canFindRaidByPiratesFname(){
		List<Raid> foundRaids = raidRepository.findByPiratesFirstName("John");
	}

	@Test
	public void canFindShipByPiratesFirstName(){
		List<Ship> foundShips = shipRepository.findByPiratesFirstName("William");
		assertEquals(1, foundShips.size());
	}

	@Test
	public void canFindRaidByShipName(){
		List<Raid> foundRaids = raidRepository.findByPiratesShipName("The Flying Dutchman");
	}

}
