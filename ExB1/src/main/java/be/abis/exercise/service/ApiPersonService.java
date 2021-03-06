package be.abis.exercise.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.model.PersonsList;


@Service
public class ApiPersonService implements PersonService {

	@Autowired
	private RestTemplate restTemplate;
	
	private String baseUri = "http://localhost:8085/exercise/api/persons";
	
	@Override
	public ArrayList<Person> getAllPersons() {
		PersonsList personsList = restTemplate.getForObject(baseUri, PersonsList.class);
		System.out.println(personsList.getPersons().size());
		return personsList.getPersons();
	}

	@Override
	public Person findPerson(int id) {
		Person person = restTemplate.getForObject(baseUri+"/"+id, Person.class);
		System.out.println("Person : " + person.getFirstName());
		return person;
	}

	@Override
	public Person findPerson(String emailAddress, String passWord) {
		Login login = new Login();
		login.setEmail(emailAddress);
		login.setPassword(passWord);
		Person person = restTemplate.postForObject(baseUri+"/login", login, Person.class);
		return person;
	}

	@Override
	public void addPerson(Person p) throws IOException {
		restTemplate.postForObject(baseUri+"/persons", p, Void.class);
	}

	@Override
	public void deletePerson(int id) throws PersonCanNotBeDeletedException {
		restTemplate.delete(baseUri+"/persons/"+id, Void.class);
	}

	@Override
	public void changePassword(Person p, String newPswd) throws IOException {
		restTemplate.put(baseUri+"/persons/"+p.getPersonId(), p, newPswd, Void.class);
	}

}
