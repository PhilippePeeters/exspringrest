package be.abis.exercise.model;

import java.util.ArrayList;

public class PersonsList {
    private ArrayList<Person> persons;
	 
    public PersonsList() {
    	persons = new ArrayList<>();
    }

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}
    
    
}
