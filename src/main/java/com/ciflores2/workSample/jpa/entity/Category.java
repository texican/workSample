package com.ciflores2.workSample.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	private String categoryName;
	@Column(name="last_mod")
	private LocalDateTime lastModified;

	public Category() {
		super();
	}

	public Category(Long id, String categoryName, LocalDateTime lastModified) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.lastModified = lastModified;
	}

	public Category(String categoryName, LocalDateTime lastModified) {
		super();
		this.categoryName = categoryName;
		this.lastModified = lastModified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}
}
