package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AssertFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Car;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationTesting {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testCardetails() throws Exception{
		//arrange
		
		//act
		ResponseEntity<Car>response = restTemplate.getForEntity("/cars/prius", Car.class);
		
		//assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody().getName()).isEqualTo("prius");
		assertThat(response.getBody().getType()).isEqualTo("hybrid");
	}

	}
