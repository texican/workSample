package com.ciflores2.workSample.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ciflores2.workSample.jpa.entity.Beer;
import com.ciflores2.workSample.jpa.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query(value="SELECT category_name FROM categories WHERE id = ?1", nativeQuery = true)
	String findCategoryNameById(Long id);
	
	List<Category> findCategoriesByCategoryNameIgnoreCaseContaining(String name);

}
