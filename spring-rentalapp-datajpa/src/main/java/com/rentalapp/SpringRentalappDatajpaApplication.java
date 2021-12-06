package com.rentalapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rentalapp.model.RentalProperty;
import com.rentalapp.service.IRentalPropertyService;

@SpringBootApplication
public class SpringRentalappDatajpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRentalappDatajpaApplication.class, args);
	}

	@Autowired
	IRentalPropertyService propertyService;

	@Override
	public void run(String... args) throws Exception {
//		RentalProperty property = new RentalProperty("2BHK Apartment", "boys", "Apartment", "2BHK", "800 sqft",
//				200000, "Madhapur", "Hyderabad", 30000);
//		propertyService.addRentalProperty(property);

//		RentalProperty newProperty = propertyService.getById(200);
//		newProperty.setBedrooms("1 BHK");
//		newProperty.setCategory("family");
//		newProperty.setRentExpected(5000);
//		newProperty.setName("1BHK ring road property");
//		newProperty.setArea("3000");
//		propertyService.updateRentalProperty(newProperty);
//		
//		propertyService.getAll();
//		propertyService.getByCategory("boys");
//		propertyService.findByCatAndCity("boys", "Hyderabad").forEach(System.out::println);
//		propertyService.getByLesserDeposit(10000).forEach(System.out::println);
//
//		propertyService.getByRentRange(1000, 3000).forEach(System.out::println);

		propertyService.findByCatAndCity("family", "Hyderabad").forEach(System.out::println);
		propertyService.findByCatAndType("family", "Apartmenent").forEach(System.out::println);

		propertyService.findByTypeAndRents("Apartmenent", 10000);

		propertyService.updateProperty(271, 42000);
	}

}
