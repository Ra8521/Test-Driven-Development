package com.example.demo.services;

import com.example.demo.Entity.Car;
import com.example.demo.repository.CarRepository;

public class CarService {
	private CarRepository carRepository;
	public CarService(CarRepository carRepository) {
		// TODO Auto-generated constructor stub
		this.carRepository =  carRepository;
	}

	public Car getCarDetails(String carName) {
		return null;
		
	}

}
