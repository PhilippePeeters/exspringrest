package be.abis.exercise.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.LoginItem;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	
	@GetMapping("/persons/{id}")
	public Person findPerson(@PathVariable("id") int id) {
		return personService.findPerson(id);
	}

	@GetMapping("/persons/")
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
		
	}
	
	@PostMapping("/persons/")
	public void addPerson(@RequestBody Person person) throws IOException {
		try {
			personService.addPerson(person);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}
	
	@DeleteMapping("/persons/{id}")
	public void deletePerson(@PathVariable("id") int id) throws PersonCanNotBeDeletedException {
		try {
			personService.deletePerson(id);
		} catch (PersonCanNotBeDeletedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@GetMapping("/persons/login")
	public Person findPerson(@RequestBody LoginItem loginItem ) {
		return personService.findPerson(loginItem.getEmail(), loginItem.getPassword());
		
	}

	@PutMapping("/persons/{id}")
	public void changePassword(@PathVariable("id") int id, @RequestBody Person person)  throws IOException {
		personService.changePassword(person, person.getPassword());
	}
}
