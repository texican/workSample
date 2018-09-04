package com.ciflores2.workSample.service;

import java.util.List;

import com.ciflores2.workSample.jpa.entity.Style;

public interface StyleService {

	public List<Style> findAllStyles();

	public Style findStyleById(Long id);

	public List<Style> findStylesByName(String name);
	
	public String findStyleNameById(Long id);
}
