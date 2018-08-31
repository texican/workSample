package com.ciflores2.workSample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ciflores2.workSample.dto.BeerDto;
import com.ciflores2.workSample.dto.BreweryDto;
import com.ciflores2.workSample.service.BeerService;

@RestController
public class BeerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BeerService beerService;

	@GetMapping("/beers/{beerId}")
	public BeerDto findBeerById(@PathVariable Long beerId) {
		return beerService.findBeerById(beerId);
	}

	@GetMapping("/beers")
	public List<BeerDto> findAllBeers() {
		return beerService.findAllBeers();
	}
	
	//TODO: rethink URI
	@GetMapping("/beers/search/{beerName}")
	public List<BeerDto> findBeersByName(@PathVariable String beerName) {
		return beerService.findBeersByName(beerName);
	}

	@GetMapping("/breweries/{breweryId}")
	public BreweryDto findBreweryById(@PathVariable Long breweryId) {
		return beerService.findBreweryById(breweryId);
	}

	@GetMapping("/breweries")
	public List<BreweryDto> findAllBreweries() {
		return beerService.findAllBreweries();
	}

	//TODO: rethink URI
	@GetMapping("/breweries/search/{breweryName}")
	public List<BreweryDto> findBreweriesName(@PathVariable String breweryName) {
		return beerService.findBreweriesByName(breweryName);
	}

}
