package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Car;

@RestController
public class CarController {
	
	@GetMapping("/cars/{name}")
	private Car getCar(@PathVariable String name){
		return null;
		
	}

}
