package com.ciflores2.workSample.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciflores2.workSample.jpa.entity.Category;
import com.ciflores2.workSample.jpa.entity.Style;
import com.ciflores2.workSample.jpa.repository.BeerRepository;
import com.ciflores2.workSample.jpa.repository.BreweryRepository;
import com.ciflores2.workSample.jpa.repository.CategoryRepository;
import com.ciflores2.workSample.jpa.repository.StyleRepository;

public class BeerDtoConverterTest {
	
	@Autowired
	private BeerDtoConverter converter;
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

	@Test
	public void convertToBeerDto_HappyPath() {
		
	}
	
	@Test
	public void convertToBeerDtos_HappyPath() {
		
	}
	
	@Test
	public void convertToBreweryDto_HappyPath() {
		
	}
	
	@Test
	public void convertToBreweryDtos_HappyPath() {
		
	}
	
}
