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

import com.ciflores2.workSample.jpa.entity.Style;
import com.ciflores2.workSample.jpa.repository.StyleRepository;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class StyleServiceImplTest {

	@InjectMocks
	private StyleServiceImpl service;
	private Style goodStyle, badStyle;
	private List<Style> styles;

	@Mock
	private StyleRepository styleRepo;

	@Before
	public void init() {
		goodStyle = new Style(1l, 1l, "Good beer style");
		badStyle = new Style(2l, 2l, "Bad beer style");
		styles = Stream.of(goodStyle, badStyle).collect(Collectors.toList());

	}

	@Test
	public void testFindAllStyles_ReturnsListOfStyles() {
		when(styleRepo.findAll()).thenReturn(styles);

		assertThat(service.findAllStyles(), is(styles));
	}
}
