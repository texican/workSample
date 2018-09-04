package com.ciflores2.workSample.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beers")
public class Beer {
	@Id
	@GeneratedValue
	private Long id;
	private Long breweryId;
	private String name;
	private Long categoryId;
	private Long styleId;
	private Float abv;
	private Float ibu;
	private Float srm;
	private Integer upc;
	@Column(name = "filepath")
	private String filePath;
	private String description;
	private Integer addUser;
	@Column(name = "last_mod")
	private LocalDateTime lastModified;

	public Beer() {
	}

	public Beer(Long id, Long breweryId, String name, Long catId, Long styleId, Float abv, Float ibu, Float srm,
			Integer upc, String filePath, String description, Integer addUser) {
		this.id = id;
		this.breweryId = breweryId;
		this.name = name;
		this.categoryId = catId;
		this.styleId = styleId;
		this.abv = abv;
		this.ibu = ibu;
		this.srm = srm;
		this.upc = upc;
		this.filePath = filePath;
		this.description = description;
		this.addUser = addUser;
		this.lastModified = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBreweryId() {
		return breweryId;
	}

	public void setBreweryId(Long breweryId) {
		this.breweryId = breweryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCatId() {
		return categoryId;
	}

	public void setCatId(Long catId) {
		this.categoryId = catId;
	}

	public Long getStyleId() {
		return styleId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public Float getAbv() {
		return abv;
	}

	public void setAbv(Float abv) {
		this.abv = abv;
	}

	public Float getIbu() {
		return ibu;
	}

	public void setIbu(Float ibu) {
		this.ibu = ibu;
	}

	public Float getSrm() {
		return srm;
	}

	public void setSrm(Float srm) {
		this.srm = srm;
	}

	public Integer getUpc() {
		return upc;
	}

	public void setUpc(Integer upc) {
		this.upc = upc;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAddUser() {
		return addUser;
	}

	public void setAddUser(Integer addUser) {
		this.addUser = addUser;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

}
