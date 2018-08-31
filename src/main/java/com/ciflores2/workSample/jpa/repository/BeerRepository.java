package com.ciflores2.workSample.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.ciflores2.workSample.jpa.entity.Beer;
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
@Repository
public interface BeerRepository extends JpaRepository<Beer, Long>{
	
	//@Query(value="SELECT * FROM beers WHERE brewery_id = ?1", nativeQuery = true)
	List<Beer> findBeersByBreweryId(Long id);
	
	List<Beer> findBeersByNameIgnoreCaseContaining(String beerName);
	
	@Query(value="INNER JOIN breweries ON beers.brewery_id=breweries.id WHERE breweries.name like '%?1%'", nativeQuery = true)
	List<Beer> findBeersByBreweryName(Long id);

}
