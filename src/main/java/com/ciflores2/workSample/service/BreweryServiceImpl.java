package com.ciflores2.workSample.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciflores2.workSample.dto.BreweryDto;
import com.ciflores2.workSample.dto.BreweryDtoConverter;
import com.ciflores2.workSample.jpa.repository.BreweryRepository;

@Service
public class BreweryServiceImpl implements BreweryService {
	// TODO: Implement meaningful logging
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BreweryRepository repo;
	@Autowired
	private BreweryDtoConverter converter;

	@Override
	public List<BreweryDto> findAllBreweries() {
		return converter.convertToBreweryDtoList(repo.findAll());
	}

	@Override
	public BreweryDto findBreweryById(Long id) {
		return converter.convertToBreweryDto(repo.findById(id).get());
	}

	@Override
	public String findBreweryNameById(Long id) {
		return repo.findBreweryNameById(id);
	}

	@Override
	public List<BreweryDto> findBreweriesByName(String name) {
		return converter.convertToBreweryDtoList(repo.findBreweriesByNameIgnoreCaseContaining(name));
	}
}
