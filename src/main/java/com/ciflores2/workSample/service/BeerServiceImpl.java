package com.ciflores2.workSample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciflores2.workSample.dto.BeerDto;
import com.ciflores2.workSample.dto.BeerDtoConverter;
import com.ciflores2.workSample.jpa.entity.Beer;
import com.ciflores2.workSample.jpa.repository.BeerRepository;

@Service
public class BeerServiceImpl implements BeerService {
	// TODO: Implement meaningful logging
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BeerRepository repo;
	@Autowired
	private BeerDtoConverter converter;

	@Override
	public List<BeerDto> findAllBeers() {
		return converter.convertToBeerDtoList(repo.findAll());
	}

	@Override
	public BeerDto findBeerById(Long id) {
		return converter.convertToBeerDto(repo.findById(id).get());
	}

	@Override
	public List<BeerDto> findBeersByBreweryId(Long id) {
		return converter.convertToBeerDtoList(repo.findBeersByBreweryId(id));
//		return repo.findBeersByBreweryId(id);
	}

	@Override
	public List<BeerDto> findBeersByName(String name) {
		return converter.convertToBeerDtoList(repo.findBeersByNameIgnoreCaseContaining(name));
	}
}
