package com.ciflores2.workSample.dto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciflores2.workSample.jpa.entity.Brewery;
import com.ciflores2.workSample.service.BeerService;

@Component
public class BreweryDtoConverter {
	// TODO: Implement meaningful logging
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BeerService beerService;

	public BreweryDto convertToBreweryDto(Brewery brewery) {
		List<BeerDto> beerDtos = beerService.findBeersByBreweryId(brewery.getId());

		BreweryDto breweryDto = new BreweryDto(brewery.getId(), brewery.getName(), brewery.getAddress(),
				brewery.getPhone(), brewery.getWebsite(), brewery.getDescription(), beerDtos);
		return breweryDto;
	}

	public List<BreweryDto> convertToBreweryDtoList(List<Brewery> breweries) {
		List<BreweryDto> breweryDtos = new ArrayList<>();

		for (Brewery brewery : breweries) {
			breweryDtos.add(convertToBreweryDto(brewery));
		}
		return breweryDtos;
	}

}
