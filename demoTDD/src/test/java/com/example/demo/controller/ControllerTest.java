package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getCarTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("cars/pirus"))
					.andExpect(status().isOk())
					.andExpect(jsonPath("name").value("pirus"))
					.andExpect(jsonPath("type").value("hybrid"));
	}
	

}
