package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	private PirateRepository pirateRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAndSavePirate(){
		Pirate pirate = new Pirate("Jack", "Sparrow", 32);
		pirateRepository.save(pirate);
	}
}
