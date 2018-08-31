package com.ciflores2.workSample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciflores2.workSample.dto.BeerDto;
import com.ciflores2.workSample.dto.BeerDtoConverter;
import com.ciflores2.workSample.dto.BreweryDto;
import com.ciflores2.workSample.jpa.entity.Beer;
import com.ciflores2.workSample.jpa.entity.Brewery;
import com.ciflores2.workSample.jpa.entity.Category;
import com.ciflores2.workSample.jpa.entity.Style;
import com.ciflores2.workSample.jpa.repository.BeerRepository;
import com.ciflores2.workSample.jpa.repository.BreweryRepository;
import com.ciflores2.workSample.jpa.repository.CategoryRepository;
import com.ciflores2.workSample.jpa.repository.StyleRepository;

@Service
public class BeerServiceImpl implements BeerService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
	@Autowired
	private BeerDtoConverter converter;

	@Override
	public List<BeerDto> findAllBeers() {
		return converter.convertToBeerDtos(beerRepo.findAll());
	}

	@Override
	public BeerDto findBeerById(Long id) {
		Optional<Beer> beer = beerRepo.findById(id);
		BeerDto beerDto = converter.convertToBeerDto(beer.get());
		return beerDto;
	}

	@Override
	public List<BeerDto> findBeersByName(String name) {
		return converter.convertToBeerDtos(beerRepo.findBeersByNameIgnoreCaseContaining(name));
	}

	@Override
	public List<BreweryDto> findAllBreweries() {
		return converter.convertToBreweryDtos(breweryRepo.findAll());
	}

	@Override
	public BreweryDto findBreweryById(Long id) {
		Optional<Brewery> brewery = breweryRepo.findById(id);
		BreweryDto breweryDto = converter.convertToBreweryDto(brewery.get());
		return breweryDto;
	}

	@Override
	public List<BreweryDto> findBreweriesByName(String name) {
		return converter.convertToBreweryDtos(breweryRepo.findBreweriesByNameIgnoreCaseContaining(name));
	}

	@Override
	public List<Style> findAllStyles() {
		if (styles.isEmpty()) {
			loadStyles();
		}
		return styles;
	}

	@Override
	public Style findStyleById(Long id) {
		if (styles.isEmpty()) {
			loadStyles();
		}
		for (Style style : styles) {
			if (id == style.getId())
				return style;
		}
		return new Style();
	}

	@Override
	public List<Style> findStylesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAllCategories() {
		if (categories.isEmpty()) {
			loadCategories();
		}
		return categories;
	}

	@Override
	public Category findCategoryById(Long id) {
		if (categories.isEmpty()) {
			loadCategories();
		}
		for (Category cat : categories) {
			if (id == cat.getId())
				return cat;
		}
		return new Category();
	}

	@Override
	public List<Category> findCategoriesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	private void loadStyles() {
		styles.addAll(styleRepo.findAll());
	}

	private void loadCategories() {
		categories.addAll(categoryRepo.findAll());
	}
}
