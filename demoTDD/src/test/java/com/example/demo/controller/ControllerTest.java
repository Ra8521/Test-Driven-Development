package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Matchers.anyString;
import com.example.demo.Entity.Car;
import com.example.demo.exception.CarNotFoundException;
import com.example.demo.services.CarService;
import static org.mockito.BDDMockito.*;
@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CarService carService;
	
	
	@Test 
	public void getCarTest() throws Exception{
		
		given(carService.getCarDetails(anyString())).willReturn(new Car("pirus","hybrid"));
		mockMvc.perform(MockMvcRequestBuilders.get("cars/pirus"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("name").value("pirus"))
					.andExpect(jsonPath("type").value("hybrid"));
	}
	
	@Test 
	public void getCar_notFound_Test() throws Exception{
		given(carService.getCarDetails(anyString())).willThrow(new CarNotFoundException());
		mockMvc.perform(MockMvcRequestBuilders.get("cars/pirus"))
		.andExpect(status().isNotFound());
	}
}
