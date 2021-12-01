package com.rentalapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rentalapp.model.RentalProperty;
import com.rentalapp.repository.IRentalPropertyRepository;
import com.rentalapp.service.IRentalPropertyService;

@SpringBootApplication
public class SpringRentalappJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringRentalappJdbcApplication.class, args);
	}

	private IRentalPropertyService rentalPropertyService;

	@Autowired
	public void setRentalPropertyService(IRentalPropertyService rentalPropertyService) {
		this.rentalPropertyService = rentalPropertyService;
	}

	@Override
	public void run(String... args) throws Exception {

//		RentalProperty property = new RentalProperty("1BHK Apartment", "boys", 151, "Apartmenent", "5BHK", "800 sqft",
//				2000, "Ameerpet", "Hyderabad", 20000);
//		rentalPropertyService.addRentalProperty(property);
//
//		System.out.println("Property Added Successfully");

		rentalPropertyService.updateRentalProperty(100, 100000);

		rentalPropertyService.deleteRentalProperty(151);

		System.out.println("Get All Properties");
		rentalPropertyService.getAll().forEach(System.out::println);

		System.out.println("Get By city ");
		rentalPropertyService.getByCity("Hyderabad").forEach(System.out::println);

		System.out.println("Get by location");
		rentalPropertyService.getByLocation("Madhapur").forEach(System.out::println);

		System.out.println("Get by category");
		rentalPropertyService.getByCategory("boys").forEach(System.out::println);

		System.out.println("Get by range");
		rentalPropertyService.getByRentRange(1000, 5000).forEach(System.out::println);

		System.out.println("Get by Id");
		System.out.println(rentalPropertyService.getById(100));

		System.out.println("Get by type");
		rentalPropertyService.getByType("Apartmenent").forEach(System.out::println);

		System.out.println("Get by lesser deposit");
		rentalPropertyService.getByLesserDeposit(200000).forEach(System.out::println);
		;
	}

}
