package be.abis.exercise.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/allpersons/")
	public ArrayList<Person> getAllPersons() {
		return null;
		
	}

	@GetMapping("/persons/{id}")
	public Person findPerson(@PathVariable("id") int id) {
		return personService.findPerson(id);
	}

	@GetMapping("/persons/{email}/{passWord}")
	public Person findPerson(@PathVariable("email") String emailAddress, @PathVariable("passWord") String passWord) {
		return null;
		
	}
	
	@PostMapping("/persons/")
	public void addPerson(@RequestBody Person p) throws IOException {
		
	}
	
	@DeleteMapping("/persons/{id}")
	public void deletePerson(@PathVariable("id") int id) throws PersonCanNotBeDeletedException {
		
	}
	
	@PutMapping("/password/{person}/{passWord}")
	public void changePassword(@RequestBody Person person, @PathVariable("passWord") String newPswd) throws IOException {
		
	}
	
	
	
/*	ArrayList<Person> getAllPersons();
    Person findPerson(int id);
    Person findPerson(String emailAddress, String passWord);
    void addPerson(Person p) throws IOException;
    public void deletePerson(int id) throws PersonCanNotBeDeletedException;
    void changePassword(Person p, String newPswd) throws IOException;  */
}
