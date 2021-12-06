package com.rentalapp.service;

import java.util.List;

import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.RentalProperty;

public interface IRentalPropertyService {
	void addRentalProperty(RentalProperty rentalProperty);

	void updateRentalProperty(RentalProperty rentalProperty);

	void deleteRentalProperty(int propertyId);

	RentalProperty getById(int propertyId) throws PropertyNotFoundException;

	List<RentalProperty> getByCategory(String category) throws PropertyNotFoundException;

	List<RentalProperty> getByType(String type) throws PropertyNotFoundException;

	List<RentalProperty> getByRentRange(double start, double end) throws PropertyNotFoundException;

	List<RentalProperty> getByLesserDeposit(double deposit) throws PropertyNotFoundException;

	List<RentalProperty> getByLocation(String location) throws PropertyNotFoundException;

	List<RentalProperty> getByCity(String city) throws PropertyNotFoundException;

	List<RentalProperty> getAll();

	// custom queries
	List<RentalProperty> findByCatAndCity(String category, String city) throws PropertyNotFoundException;

	// named query
	List<RentalProperty> findByCatAndType(String category, String type) throws PropertyNotFoundException;

	// native query
	List<RentalProperty> findByTypeAndRents(String type, double rent);

	// modifying
	void updateProperty(int propertyid, double rent);
}
