package com.rentalapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "rentalproperty") // to give/map to a different table name
@NamedQuery(name = "findByCatType", query = "from RentalProperty r where r.category=?1 and r.type=?2")
public class RentalProperty {

	private String name;
	private String category; // family/bachelors/boys/girls
	@Id
	@Column(name = "propertyid")
	@GeneratedValue(generator = "property_seq", strategy = GenerationType.AUTO) // creates a sequence with a name
																				// hibernate seq
	@SequenceGenerator(name = "property_seq", sequenceName = "property_sequence", initialValue = 200, allocationSize = 10)
	private Integer propertyId;
	private String type;
	private String bedrooms;
	private String area;
	@Column(name = "expectedRent")
	private double rentExpected;
	private String location;
	private String city;
	@Column(name = "deposit")
	private double securityDeposit;

	public RentalProperty(String name, String category, String type, String bedrooms, String area, double rentExpected,
			String location, String city, double securityDeposit) {
		super();
		this.name = name;
		this.category = category;

		this.type = type;
		this.bedrooms = bedrooms;
		this.area = area;
		this.rentExpected = rentExpected;
		this.location = location;
		this.city = city;
		this.securityDeposit = securityDeposit;
	}

	public RentalProperty() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(String bedrooms) {
		this.bedrooms = bedrooms;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getRentExpected() {
		return rentExpected;
	}

	public void setRentExpected(double rentExpected) {
		this.rentExpected = rentExpected;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSecurityDeposit() {
		return securityDeposit;
	}

	public void setSecurityDeposit(double securityDeposit) {
		this.securityDeposit = securityDeposit;
	}

	@Override
	public String toString() {
		return "RetalProperty [name=" + name + ", category=" + category + ", propertyId=" + propertyId + ", type="
				+ type + ", bedrooms=" + bedrooms + ", area=" + area + ", rentExpected=" + rentExpected + ", location="
				+ location + ", city=" + city + ", securityDeposit=" + securityDeposit + "]";
	}

}
