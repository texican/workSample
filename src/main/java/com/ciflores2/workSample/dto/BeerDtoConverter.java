package com.ciflores2.workSample.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciflores2.workSample.jpa.entity.Beer;
import com.ciflores2.workSample.jpa.entity.Brewery;
import com.ciflores2.workSample.jpa.entity.Category;
import com.ciflores2.workSample.jpa.entity.Style;
import com.ciflores2.workSample.jpa.repository.BeerRepository;
import com.ciflores2.workSample.jpa.repository.BreweryRepository;
import com.ciflores2.workSample.jpa.repository.CategoryRepository;
import com.ciflores2.workSample.jpa.repository.StyleRepository;

@Component
public class BeerDtoConverter {

	@Autowired
	private BeerRepository beerRepo;
	@Autowired
	private BreweryRepository breweryRepo;
	@Autowired
	private StyleRepository styleRepo;
	List<Style> styles = new ArrayList<>();
	@Autowired
	private CategoryRepository categoryRepo;
	List<Category> categories = new ArrayList<>();

	public BeerDto convertToBeerDto(Beer beer) {
		String breweryName = breweryRepo.findBreweryNameById(beer.getBreweryId());
		// TODO:
		// String category = findCategoryById(beer.getCatId()).getCategoryName();
		// String style = findStyleById(beer.getStyleId()).getStyleName();
		String category = categoryRepo.findCategoryNameById(beer.getCatId());
		String style = styleRepo.findStyleNameById(beer.getStyleId());
		BeerDto beerDto = new BeerDto(beer.getId(), beer.getName(), beer.getBreweryId(), breweryName, beer.getCatId(),
				category, beer.getStyleId(), style, beer.getAbv(), beer.getIbu(), beer.getDescription());
		return beerDto;
	}

	public List<BeerDto> convertToBeerDtos(List<Beer> beers) {
		List<BeerDto> beerDtos = new ArrayList<>();

		for (Beer beer : beers) {
			beerDtos.add(convertToBeerDto(beer));
		}
		return beerDtos;
	}

	public BreweryDto convertToBreweryDto(Brewery brewery) {
		List<BeerDto> beerDtos = convertToBeerDtos(beerRepo.findBeersByBreweryId(brewery.getId()));

		BreweryDto breweryDto = new BreweryDto(brewery.getId(), brewery.getName(), brewery.getAddress(),
				brewery.getPhone(), brewery.getWebsite(), brewery.getDescription(), beerDtos);
		return breweryDto;
	}

	public List<BreweryDto> convertToBreweryDtos(List<Brewery> breweries) {
		List<BreweryDto> breweryDtos = new ArrayList<>();

		for (Brewery brewery : breweries) {
			breweryDtos.add(convertToBreweryDto(brewery));
		}
		return breweryDtos;
	}

}
