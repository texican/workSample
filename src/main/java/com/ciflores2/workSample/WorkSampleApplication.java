package com.ciflores2.workSample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ciflores2.workSample.jpa.repository.BeerRepository;


@SpringBootApplication
public class WorkSampleApplication {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BeerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(WorkSampleApplication.class, args);
	}
	
	


}
