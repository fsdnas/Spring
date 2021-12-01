package com.rentalapp.service;

import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.RentalProperty;
import com.rentalapp.repository.IRentalPropertyRepository;

@Service
public class RentalPropertyServiceImpl implements IRentalPropertyService {

	private IRentalPropertyRepository rentalPropertyRepo;

	@Autowired
	public void setRentalPropertyRepo(IRentalPropertyRepository rentalPropertyRepo) {
		this.rentalPropertyRepo = rentalPropertyRepo;
	}

	@Override
	public void addRentalProperty(RentalProperty rentalProperty) {
		rentalPropertyRepo.addRentalProperty(rentalProperty);

	}

	@Override
	public void updateRentalProperty(int propertyId, double expectedRent) {
		rentalPropertyRepo.updateRentalProperty(propertyId, expectedRent);

	}

	@Override
	public void deleteRentalProperty(int propertyId) {
		rentalPropertyRepo.deleteRentalProperty(propertyId);

	}

	@Override
	public RentalProperty getById(int propertyId) throws PropertyNotFoundException {

		return rentalPropertyRepo.findById(propertyId);
	}

	@Override
	public List<RentalProperty> getByCategory(String category) throws PropertyNotFoundException {
		List<RentalProperty> rentalPropertyList = rentalPropertyRepo.findByCategory(category).stream()
				.sorted(Comparator.comparing(RentalProperty::getBedrooms)).collect(Collectors.toList());

		return rentalPropertyList;
	}

	@Override
	public List<RentalProperty> getByType(String type) throws PropertyNotFoundException {
		List<RentalProperty> rentalPropertyList = rentalPropertyRepo.findByType(type).stream()
				.sorted(Comparator.comparing(RentalProperty::getBedrooms)).collect(Collectors.toList());

		return rentalPropertyList;
	}

	@Override
	public List<RentalProperty> getByRentRange(double start, double end) throws PropertyNotFoundException {
		List<RentalProperty> rentalPropertyList = rentalPropertyRepo.findByRentRange(start, end);
//				.sorted(Comparator.comparing(RentalProperty::getRentExpected)).collect(Collectors.toList());

		return rentalPropertyList;
	}

	@Override
	public List<RentalProperty> getByLesserDeposit(double deposit) throws PropertyNotFoundException {
		List<RentalProperty> rentalPropertyList = rentalPropertyRepo.findByLesserDeposit(deposit);
//		.stream()
//				.sorted(Comparator.comparing(RentalProperty::getSecurityDeposit)).collect(Collectors.toList());
		return rentalPropertyList;
	}

	@Override
	public List<RentalProperty> getByLocation(String location) throws PropertyNotFoundException {
		List<RentalProperty> rentalPropertyList = rentalPropertyRepo.findByLocation(location).stream()
				.sorted(Comparator.comparing(RentalProperty::getLocation)).collect(Collectors.toList());

		return rentalPropertyList;
	}

	@Override
	public List<RentalProperty> getByCity(String city) throws PropertyNotFoundException {
		List<RentalProperty> rentalPropertyList = rentalPropertyRepo.findByCity(city).stream()
				.sorted(Comparator.comparing(RentalProperty::getCity)).collect(Collectors.toList());

		return rentalPropertyList;
	}

	@Override
	public List<RentalProperty> getAll() {
		List<RentalProperty> rentalPropertyList = rentalPropertyRepo.findAll().stream()
				.sorted(Comparator.comparing(RentalProperty::getName)).collect(Collectors.toList());

		return rentalPropertyList;
	}

}
