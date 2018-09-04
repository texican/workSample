package com.ciflores2.workSample.dto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciflores2.workSample.jpa.entity.Beer;
import com.ciflores2.workSample.service.BreweryService;
import com.ciflores2.workSample.service.CategoryService;
import com.ciflores2.workSample.service.StyleService;

@Component
public class BeerDtoConverter {
	// TODO: Implement meaningful logging
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BreweryService breweryService;
	@Autowired
	private StyleService styleService;
	@Autowired
	private CategoryService categoryService;

	public BeerDto convertToBeerDto(Beer beer) {
		String breweryName = breweryService.findBreweryNameById(beer.getBreweryId());
		String category = categoryService.findCategoryNameById(beer.getCatId());
		String style = styleService.findStyleNameById(beer.getStyleId());
		
		BeerDto beerDto = new BeerDto(beer.getId(), beer.getName(), beer.getBreweryId(), breweryName, beer.getCatId(),
				category, beer.getStyleId(), style, beer.getAbv(), beer.getIbu(), beer.getDescription());
		return beerDto;
	}

	public List<BeerDto> convertToBeerDtoList(List<Beer> beers) {
		List<BeerDto> beerDtos = new ArrayList<>();

		for (Beer beer : beers) {
			beerDtos.add(convertToBeerDto(beer));
		}
		return beerDtos;
	}

}
