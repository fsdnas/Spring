/**
 * 
 */
package com.rentalapp.repository;

import java.util.List;

import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.RentalProperty;

/**
 * @author ShaikNayeemAhamed
 *
 */
public interface IRentalPropertyRepository {

	void addRentalProperty(RentalProperty rentalProperty);

	void updateRentalProperty(int propertyId, double expectedRent);

	void deleteRentalProperty(int propertyId);

	RentalProperty findById(int propertyId) throws PropertyNotFoundException;

	List<RentalProperty> findByCategory(String category) throws PropertyNotFoundException;

	List<RentalProperty> findByType(String type) throws PropertyNotFoundException;

	List<RentalProperty> findByRentRange(double start, double end) throws PropertyNotFoundException;

	List<RentalProperty> findByLesserDeposit(double deposit) throws PropertyNotFoundException;

	List<RentalProperty> findByLocation(String location) throws PropertyNotFoundException;

	List<RentalProperty> findByCity(String city) throws PropertyNotFoundException;
	
	List<RentalProperty> findAll();

}
