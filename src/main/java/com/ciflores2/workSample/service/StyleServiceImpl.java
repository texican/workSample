package com.ciflores2.workSample.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciflores2.workSample.jpa.entity.Style;
import com.ciflores2.workSample.jpa.repository.StyleRepository;

@Service
public class StyleServiceImpl implements StyleService {
	// TODO: Implement meaningful logging
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StyleRepository styleRepo;
	private List<Style> styles = new ArrayList<>();
	
	@Override
	public List<Style> findAllStyles() {
		return getStyles();
	}

	@Override
	public Style findStyleById(Long id) {
		getStyles();
		for (Style style : styles) {
			if (id == style.getId())
				return style;
		}
		return new Style();
	}

	@Override
	public List<Style> findStylesByName(String name) {
		return styleRepo.findStylesByStyleNameIgnoreCaseContaining(name);
	}

	private List<Style> getStyles() {
		if (styles.isEmpty()) {
			styles.addAll(styleRepo.findAll());
		}
		return styles;
	}

	@Override
	public String findStyleNameById(Long id) {
		return findStyleById(id).getStyleName();
	}
}
