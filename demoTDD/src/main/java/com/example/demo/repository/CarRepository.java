package com.example.demo.repository;

import com.example.demo.Entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long>{
	
	
	public Car findByName(String string);

}
