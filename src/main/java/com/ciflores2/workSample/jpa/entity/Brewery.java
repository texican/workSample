package com.ciflores2.workSample.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "breweries")
public class Brewery {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Embedded
	private Address address;
	private String phone;
	private String website;
	@Column(name = "filepath")
	private String filePath;
	private String description;
	private Integer addUser;
	@Column(name = "last_mod")
	private LocalDateTime lastModified;

	public Brewery() {
	}

	public Brewery(Long id, String name, Address address, String phone, String website, String filePath,
			String description, Integer addUser) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.website = website;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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