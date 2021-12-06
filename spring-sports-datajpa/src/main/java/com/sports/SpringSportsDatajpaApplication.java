package com.sports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sports.model.Sports;
import com.sports.model.Type;
import com.sports.service.ISportsService;

@SpringBootApplication
public class SpringSportsDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringSportsDatajpaApplication.class, args);
	}

	@Autowired
	ISportsService sportsService;

	@Override
	public void run(String... args) throws Exception {
//		Sports sports = new Sports("Cricket", 20, "Dravid", Type.OUTDOOR, "11 HRS", "Byjus", "gujarat", "India");
//		sportsService.addSports(sports);

		sportsService.getByCity("Dubai").forEach(System.out::println);
		sportsService.getByStadium("Mumbai").forEach(System.out::println);
		sportsService.findByCityAndCoach("Dubai", "CR").forEach(System.out::println);
		sportsService.getBySponsors("RedBull").forEach(System.out::println);

	}

}
