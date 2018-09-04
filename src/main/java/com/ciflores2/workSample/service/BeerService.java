package com.ciflores2.workSample.service;

import java.util.List;

import com.ciflores2.workSample.dto.BeerDto;

public interface BeerService {

	public List<BeerDto> findAllBeers();

	public BeerDto findBeerById(Long id);

	public List<BeerDto> findBeersByName(String name);

	public List<BeerDto> findBeersByBreweryId(Long id);

}
