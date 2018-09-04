package com.ciflores2.workSample.service;

import java.util.List;

import com.ciflores2.workSample.jpa.entity.Category;

public interface CategoryService {
	
	public List<Category> findAllCategories();

	public Category findCategoryById(Long id);

	public List<Category> findCategoriesByName(String name);
	
	public String findCategoryNameById(Long id);
}
