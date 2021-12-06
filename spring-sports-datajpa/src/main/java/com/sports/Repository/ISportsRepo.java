package com.sports.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sports.model.Sports;
import com.sports.model.Type;

@Repository
public interface ISportsRepo extends JpaRepository<Sports, Integer> {

	// Custom Queries
	@Query("from Sports s where s.type =?1")
	List<Sports> findByType(Type type);

	@Query("from Sports s where s.stadium =?1")
	List<Sports> findByStadium(String stadium);

	@Query("from Sports s where s.city =?1")
	List<Sports> findByCity(String city);

	@Query("from Sports s where s.sponsors =?1")
	List<Sports> findBySponsors(String sponsors);

	@Query("from Sports s where s.city =?1 and coachname=?2")
	List<Sports> findByCityAndCoach(String city, String coach);

}
