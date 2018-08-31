package com.ciflores2.workSample.dto;

import java.io.Serializable;
import java.util.List;

import com.ciflores2.workSample.jpa.entity.Address;

public class BreweryDto implements Serializable {

	private static final long serialVersionUID = -94031777374685770L;
	private Long id;
	private String name;
	private List<BeerDto> beers;
	private Address address;
	private String phone;
	private String website;
	private String description;

	public BreweryDto(Long id, String name, Address address, String phone, String website, String description,
			List<BeerDto> beers) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.description = description;
		this.beers = beers;
	}

	public BreweryDto() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<BeerDto> getBeers() {
		return beers;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getWebsite() {
		return website;
	}

	public String getDescription() {
		return description;
	}

}
