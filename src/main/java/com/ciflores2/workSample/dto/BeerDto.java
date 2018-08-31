package com.ciflores2.workSample.dto;

import java.io.Serializable;

public class BeerDto implements Serializable {

	private static final long serialVersionUID = -80023302983167579L;
	private Long id;
	private String name;
	private Long breweryId;
	private String breweryName;
	private Long categoryId;
	private String categoryName;
	private Long styleId;
	private String style;
	private Float abv;
	private Float ibu;
	private String description;

	public BeerDto(Long id, String name, Long breweryId, String breweryName, Long categoryId, String categoryName, Long styleId,
			String style, Float abv, Float ibu, String description) {
		super();
		this.id = id;
		this.name = name;
		this.breweryId = breweryId;
		this.breweryName = breweryName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.styleId = styleId;
		this.style = style;
		this.abv = abv;
		this.ibu = ibu;
		this.description = description;
	}

	public BeerDto() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getBreweryId() {
		return breweryId;
	}

	public String getBreweryName() {
		return breweryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Long getStyleId() {
		return styleId;
	}

	public String getStyle() {
		return style;
	}

	public Float getAbv() {
		return abv;
	}

	public Float getIbu() {
		return ibu;
	}

	public String getDescription() {
		return description;
	}

}
