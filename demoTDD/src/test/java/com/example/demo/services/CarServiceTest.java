package com.example.demo.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.Entity.Car;
import com.example.demo.exception.CarNotFoundException;
import com.example.demo.repository.CarRepository;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

	@Mock
	private CarRepository carRepository;
	
	private CarService carService;
	
	@Before(value = "")
	public void setUp() throws Exception{
		carService = new CarService(carRepository);
	}
	@Test
	public void getCarInfo() {
		given(carRepository.findByName("pirus")).willReturn(new Car("pirus","hybrid"));
		Car car = carService.getCarDetails("pirus");
		assertThat(car.getName()).isEqualTo("pirus");
		assertThat(car.getType()).isEqualTo("hybrid");
		
	}
	@Test(expected = CarNotFoundException.class)
	public void getCar_notFound_Test() throws Exception{
		given(carRepository.findByName("pirus")).willReturn(null);
	}
}
