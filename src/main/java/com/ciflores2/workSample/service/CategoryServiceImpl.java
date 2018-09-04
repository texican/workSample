package com.ciflores2.workSample.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciflores2.workSample.jpa.entity.Category;
import com.ciflores2.workSample.jpa.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	// TODO: Implement meaningful logging
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CategoryRepository categoryRepo;
	
	private List<Category> categories = new ArrayList<>();

	@Override
	public List<Category> findAllCategories() {
		return getCategories();
	}

	@Override
	public Category findCategoryById(Long id) {
		getCategories();
		for (Category cat : categories) {
			if (id == cat.getId())
				return cat;
		}
		return new Category();
	}

	@Override
	public List<Category> findCategoriesByName(String name) {
		return categoryRepo.findCategoriesByCategoryNameIgnoreCaseContaining(name);
	}

	private List<Category> getCategories() {
		if (categories.isEmpty()) {
			categories.addAll(categoryRepo.findAll());
		}
		return categories;
	}

	@Override
	public String findCategoryNameById(Long id) {
		return findCategoryById(id).getCategoryName();
	}
}
