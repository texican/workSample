package com.ciflores2.workSample.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ciflores2.workSample.jpa.entity.Category;
import com.ciflores2.workSample.jpa.entity.Style;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {

	@Query(value="SELECT style_name FROM styles WHERE id = ?1", nativeQuery = true)
	String findStyleNameById(Long id);
	
	List<Style> findStylesByStyleNameIgnoreCaseContaining(String name);


}
