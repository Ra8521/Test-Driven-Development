package com.example.demo.Entity;

import java.util.function.IntPredicate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Car {
	
	@org.springframework.data.annotation.Id
	@GeneratedValue
	private Long Id;
	
	
	private String name;
	private String type;
	
	public Car() {
		
	}

	public Car(String name, String type) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.type= type;
	}

	public IntPredicate getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public IntPredicate getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
