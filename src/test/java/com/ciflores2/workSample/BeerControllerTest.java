package com.ciflores2.workSample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.ciflores2.workSample.service.BeerService;

public class BeerControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private BeerService beerServiceMock;
	
	@Test
	public void getBeerById_HappyPath() {
		
	}
	
	@Test
	public void getBreweryById_HappyPath() {
		
	}
	
	@Test
	public void getAllBeer_HappyPath() {
		
	}
	
	@Test
	public void getAllBreweries_HappyPath() {
		
	}
}
