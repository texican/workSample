package com.ciflores2.workSample.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ciflores2.workSample.jpa.entity.Category;
import com.ciflores2.workSample.jpa.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class CategoryServiceImplTest {

	@InjectMocks
	private CategoryServiceImpl service;
	private Category goodCategory, badCategory;
	private List<Category> categories;

	@Mock
	private CategoryRepository categoryRepo;

	@Before
	public void init() {
		goodCategory = new Category(1l, "Good beer category");
		badCategory = new Category(2l, "Bad beer category");
		categories = Stream.of(goodCategory, badCategory).collect(Collectors.toList());
	}

	@Test
	public void testFindAllCategories_ReturnsListOfCategories() {
		when(categoryRepo.findAll()).thenReturn(categories);

		assertThat(service.findAllCategories(), is(categories));
	}
}
