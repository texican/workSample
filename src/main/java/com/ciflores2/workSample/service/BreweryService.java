package com.ciflores2.workSample.service;

import java.util.List;

import com.ciflores2.workSample.dto.BreweryDto;

public interface BreweryService {

	public List<BreweryDto> findAllBreweries();

	public BreweryDto findBreweryById(Long id);

	List<BreweryDto> findBreweriesByName(String name);

	public String findBreweryNameById(Long breweryId);

}
