package com.ciflores2.workSample.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

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

@RunWith(MockitoJUnitRunner.class)
public class BeerServiceImplTest {
	
	@Autowired
	private BeerServiceImpl service;
	private Beer beer;
	private List<Beer> beers;
	private BeerDto beerDto;
	private List<BeerDto> beerDtos;
	private Brewery brewery;
	private BreweryDto breweryDto;
	private List<Brewery> breweries;
	private List<BreweryDto> breweryDtos;
	private Category category;
	private List<Category> categories;
	private Style style;
	private List<Style> styles;
	
	@Mock
	private BeerRepository beerRepo;
	@Mock
	private BreweryRepository breweryRepo;
	@Mock
	private StyleRepository styleRepo;
	@Mock
	private CategoryRepository categoryRepo;
	@Mock
	private BeerDtoConverter converter;

	@Before
	public void init() {
		service = new BeerServiceImpl();
		//TODO: Populate Entities & DTO's
	}

	@Test
	public void testFindAllBeers() {
		when(converter.convertToBeerDtos(beers)).thenReturn(beerDtos);
		assertThat(service.findAllBeers(), is(beerDtos));
	}
	
	
	@Test
	public void testFindAllBreweries() {
		when(converter.convertToBreweryDtos(breweries)).thenReturn(breweryDtos);
		assertThat(service.findAllBreweries(), is(breweryDtos));
	}
}
