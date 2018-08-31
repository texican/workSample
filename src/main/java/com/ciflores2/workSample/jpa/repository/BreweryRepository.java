package com.ciflores2.workSample.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ciflores2.workSample.jpa.entity.Brewery;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Long> {

	@Query(value="SELECT name FROM breweries WHERE id = ?1", nativeQuery = true)
	String findBreweryNameById(Long id);
	
	List<Brewery> findBreweriesByNameIgnoreCaseContaining(String name);

}
