package com.sports.service;

import java.util.List;

import com.sports.exceptions.SportNotFoundException;
import com.sports.model.Sports;
import com.sports.model.Type;

public interface ISportsService {
	void addSports(Sports sports);

	void updateSports(Sports sports);

	void deleteSports(int sportsId);

	Sports getById(int sportsId) throws SportNotFoundException;

	List<Sports> getAll();

	List<Sports> getByStadium(String stadium);

	List<Sports> getByCity(String city);

	List<Sports> findByCityAndCoach(String city, String coach);

	List<Sports> getByType(Type type);

	List<Sports> getBySponsors(String sponser);

}
