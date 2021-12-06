package com.sports.service;

import java.security.KeyRep.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.Repository.ISportsRepo;
import com.sports.exceptions.SportNotFoundException;
import com.sports.model.Sports;

@Service
public class SportsServiceImpl implements ISportsService {

	private ISportsRepo sportsRepo;

	@Autowired
	public void setSportsRepo(ISportsRepo sportsRepo) {
		this.sportsRepo = sportsRepo;
	}

	@Override
	public void addSports(Sports sports) {
		sportsRepo.save(sports);
	}

	@Override
	public void updateSports(Sports sports) {
		sportsRepo.save(sports);

	}

	@Override
	public void deleteSports(int sportsId) {
		sportsRepo.deleteById(sportsId);

	}

	@Override
	public Sports getById(int sportsId) throws SportNotFoundException {
		return sportsRepo.findById(sportsId).orElseThrow(() -> new SportNotFoundException("invalid id"));

	}

	public List<Sports> getByStadium(String stadium) {
		List<Sports> sportsList = sportsRepo.findByStadium(stadium);
		if (sportsList.isEmpty()) {
			throw new SportNotFoundException("stadium not found");
		}
		return sportsList;

	}

	public List<Sports> getByCity(String city) {
		List<Sports> sportsList = sportsRepo.findByCity(city);
		if (sportsList.isEmpty()) {
			throw new SportNotFoundException("city not found");
		}
		return sportsList;

	}

	@Override
	public List<Sports> getAll() {

		return sportsRepo.findAll();
	}

	@Override
	public List<Sports> getBySponsors(String sponser) {
		List<Sports> sportsList = sportsRepo.findBySponsors(sponser);
		if (sportsList.isEmpty()) {
			throw new SportNotFoundException("sponser not found");
		}
		return sportsList;
	}

	@Override
	public List<Sports> getByType(com.sports.model.Type type) {
		List<Sports> sportsList = sportsRepo.findByType(type);
		if (sportsList.isEmpty()) {
			throw new SportNotFoundException("type not found");
		}
		return sportsList;
	}

	@Override
	public List<Sports> findByCityAndCoach(String city, String coach) {
		List<Sports> sportsList = sportsRepo.findByCityAndCoach(city, coach);
		if (sportsList.isEmpty()) {
			throw new SportNotFoundException("city not found");
		}
		return sportsList;
	}

}
