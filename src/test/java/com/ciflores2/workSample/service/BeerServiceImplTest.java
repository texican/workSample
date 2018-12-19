package com.ciflores2.workSample.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ciflores2.workSample.dto.BeerDto;
import com.ciflores2.workSample.dto.BeerDtoConverter;
import com.ciflores2.workSample.dto.BreweryDto;
import com.ciflores2.workSample.jpa.entity.Address;
import com.ciflores2.workSample.jpa.entity.Beer;
import com.ciflores2.workSample.jpa.entity.Brewery;
import com.ciflores2.workSample.jpa.repository.BeerRepository;
import com.ciflores2.workSample.jpa.repository.BreweryRepository;
import com.ciflores2.workSample.jpa.repository.CategoryRepository;
import com.ciflores2.workSample.jpa.repository.StyleRepository;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class BeerServiceImplTest {

	@InjectMocks
	private BeerServiceImpl service;
	private Beer goodBeer;
	private Beer badBeer;
	private BeerDto goodBeerDto;
	private BeerDto badBeerDto;
	private List<Beer> goodBeers;
	private List<BeerDto> goodBeerDtos;
	private List<Beer> badBeers;
	private List<BeerDto> badBeerDtos;
	private List<Beer> allBeers;
	private List<BeerDto> allBeerDtos;
	private Brewery goodBrewery;
	private BreweryDto goodBreweryDto;
	private Brewery badBrewery;
	private BreweryDto badBreweryDto;

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

		goodBeer = new Beer(1l, 1l, "Beer", 1l, 1l, 7.4f, 40f, 0f, 0, "", "A pretty good beer", 1);
		goodBeerDto = new BeerDto(1l, "Beer", 1l, "Good Beer Brewing", 1l, "Good beer category", 1l, "Good beer style",
				7.4f, 40f, "A pretty good beer");

		badBeer = new Beer(2l, 2l, "Bad Beer", 2l, 2l, 3.2f, 4f, 0f, 0, "", "A bad beer", 1);
		badBeerDto = new BeerDto(1l, "Bad Beer", 1l, "Bad Beer Brewing", 1l, "Bad beer category", 1l, "Bad beer style",
				7.4f, 40f, "A bad beer");

		allBeers = Stream.of(goodBeer, badBeer).collect(Collectors.toList());
		allBeerDtos = Stream.of(goodBeerDto, badBeerDto).collect(Collectors.toList());

		goodBeers = Stream.of(goodBeer).collect(Collectors.toList());
		goodBeerDtos = Stream.of(goodBeerDto).collect(Collectors.toList());

		badBeers = Stream.of(badBeer).collect(Collectors.toList());
		badBeerDtos = Stream.of(badBeerDto).collect(Collectors.toList());

		Address address = new Address("address1", "address2", "city", "state", "zipCode", "country");

		goodBrewery = new Brewery(1l, "Good Beer Brewing", address, "phone", "website", "filePath", "A good beer brewery", 1);
		goodBreweryDto = new BreweryDto(1l, "Good Beer Brewing", address, "phone", "website", "A good beer brewery", goodBeerDtos);

		badBrewery = new Brewery(2l, "Bad Beer Brewing", address, "phone", "website", "filePath", "A bad beer brewery",	1);
		badBreweryDto = new BreweryDto(2l, "Bad Beer Brewing", address, "phone", "website", "A bad beer brewery", badBeerDtos);

	}

	@Test
	public void testFindAllBeers() {
		when(beerRepo.findAll()).thenReturn(allBeers);
		when(converter.convertToBeerDtoList(allBeers)).thenReturn(allBeerDtos);

		 assertThat(service.findAllBeers(), is(allBeerDtos));
	}


}
