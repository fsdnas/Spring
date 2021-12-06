package com.rentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		rentalPropertyRepo.save(rentalProperty);

	}

	@Override
	public void updateRentalProperty(RentalProperty rentalProperty) {
		rentalPropertyRepo.save(rentalProperty);

	}

	@Override
	public void deleteRentalProperty(int propertyId) {
		rentalPropertyRepo.deleteById(propertyId);

	}

	@Override
	public RentalProperty getById(int propertyId) throws PropertyNotFoundException {
		return rentalPropertyRepo.findById(propertyId).orElseThrow(() -> new PropertyNotFoundException("invalid id"));

	}

	@Override
	public List<RentalProperty> getByCategory(String category) throws PropertyNotFoundException {
		List<RentalProperty> propertyList = rentalPropertyRepo.findByCategory(category);
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("category not found");

		}
		return propertyList;
	}

	@Override
	public List<RentalProperty> getByType(String type) throws PropertyNotFoundException {
		List<RentalProperty> propertyList = rentalPropertyRepo.findByType(type);
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("type not found");

		}
		return propertyList;
	}

	@Override
	public List<RentalProperty> getByRentRange(double start, double end) throws PropertyNotFoundException {
		List<RentalProperty> propertyList = rentalPropertyRepo.findByExpectedRent(start, end);
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("range not found");

		}
		return propertyList;
	}

	@Override
	public List<RentalProperty> getByLesserDeposit(double deposit) throws PropertyNotFoundException {
		List<RentalProperty> propertyList = rentalPropertyRepo.findByDeposit(deposit);
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("not found");

		}
		return propertyList;
	}

	@Override
	public List<RentalProperty> getByLocation(String location) throws PropertyNotFoundException {
		List<RentalProperty> propertyList = rentalPropertyRepo.findByLocation(location);
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("location not found");

		}
		return propertyList;
	}

	@Override
	public List<RentalProperty> getByCity(String city) throws PropertyNotFoundException {
		List<RentalProperty> propertyList = rentalPropertyRepo.findByCity(city);
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("city not found");

		}
		return propertyList;
	}

	@Override
	public List<RentalProperty> getAll() {
		return rentalPropertyRepo.findAll();
	}

	@Override
	public List<RentalProperty> findByCatAndCity(String category, String city) throws PropertyNotFoundException {
		List<RentalProperty> propertyList = rentalPropertyRepo.findbyCatAndCity(category, city);
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("city not found");

		}
		return propertyList;
	}

	@Override
	public List<RentalProperty> findByCatAndType(String category, String type) throws PropertyNotFoundException {
		List<RentalProperty> propertyList = rentalPropertyRepo.findByCatAndType(category, type);
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("category and type not found");

		}
		return propertyList;
	}

	@Override
	public List<RentalProperty> findByTypeAndRents(String type, double rent) {
		List<RentalProperty> propertyList = rentalPropertyRepo.findByTypeAndRents(type, rent);
		if (propertyList.isEmpty()) {
			throw new PropertyNotFoundException("type and rent not found");

		}
		return propertyList;
	}

	@Override
	@Transactional
	public void updateProperty(int propertyid, double rent) {
		rentalPropertyRepo.updateProperty(propertyid, rent);

	}

}
