package com.ciflores2.workSample.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "styles")
public class Style {
	@Id
	@GeneratedValue
	private Long id;
	private Long categoryId;
	private String styleName;
	@Column(name = "last_mod")
	private LocalDateTime lastModified;

	public Style() {
	}

	public Style(Long id, Long categoryId, String styleName) {
		this.id = id;
		this.categoryId = categoryId;
		this.styleName = styleName;
		this.lastModified = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}
}
