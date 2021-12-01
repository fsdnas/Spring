package com.rentalapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rentalapp.model.RentalProperty;

public class RentalPropertyMapper implements RowMapper<RentalProperty> {

	@Override
	public RentalProperty mapRow(ResultSet rs, int rowNum) throws SQLException {

		String name = rs.getString("name");
		String type = rs.getString("type");
		String category = rs.getString("category");
		String area = rs.getString("area");
		String bedrooms = rs.getString("bedrooms");
		String location = rs.getString("location");
		String city = rs.getString("city");
		double rentExpected = rs.getDouble("rentexpected");
		double securityDeposit = rs.getDouble("securitydeposit");
		int protertyId = rs.getInt("propertyid");

		RentalProperty property = new RentalProperty(name, category, protertyId, type, bedrooms, area, rentExpected,
				location, city, securityDeposit);
		return property;
	}

}
