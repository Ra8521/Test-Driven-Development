
package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import com.example.demo.Entity.Car;
import com.example.demo.repository.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void get_Cardetails() throws Exception {
		Car savedcar = entityManager.persistFlushFind(new Car("pirus", "hybrid"));
		Car car = repository.findByName("pirus");
		assertThat(car.getName()).isEqualTo("pirus");
	}

}

