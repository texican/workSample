package com.ciflores2.workSample.service;

import java.util.List;

import com.ciflores2.workSample.dto.BeerDto;
import com.ciflores2.workSample.dto.BreweryDto;
import com.ciflores2.workSample.jpa.entity.Category;
import com.ciflores2.workSample.jpa.entity.Style;

public interface BeerService {
	
	public List<BeerDto> findAllBeers();

	public BeerDto findBeerById(Long id);
	
	public List<BeerDto> findBeersByName(String name);
	
	public List<BreweryDto> findAllBreweries();

	public BreweryDto findBreweryById(Long id);
	
	List<BreweryDto> findBreweriesByName(String name);

	public List<Style> findAllStyles();

	public Style findStyleById(Long id);
	
	public List<Style> findStylesByName(String name);
	
	public List<Category> findAllCategories();

	public Category findCategoryById(Long id);
	
	public List<Category> findCategoriesByName(String name);
}
