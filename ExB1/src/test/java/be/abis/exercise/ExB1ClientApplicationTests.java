package be.abis.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.CourseService;
import be.abis.exercise.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("development")
public class ExB1ClientApplicationTests {

	@Autowired 
	PersonService  personService;
	
	@Autowired
	CourseService CourseService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String baseUrl="http://localhost:8085/exercise/api/persons";
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindPersonById() {
		int id=2;
		Person person = restTemplate.getForObject(baseUrl+"/"+id, Person.class);
		System.out.println("Person : " + person.getFirstName());
		assertNotNull(person);
		assertEquals("Mary", person.getFirstName());
	}
	
	@Test
	public void testFindPersonByLogin() {
		Login login = new Login();
		login.setEmail("");
		login.setPassword("");
		Person person = restTemplate.postForObject(baseUrl+"/login", login, Person.class);
		System.out.println("Person : " + person.getFirstName());
		assertNotNull(person);
		assertEquals("Mary", person.getFirstName());
	}
	
}
