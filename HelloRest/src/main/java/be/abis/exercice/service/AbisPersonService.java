package be.abis.exercice.service;

import be.abis.exercice.model.Person;

public class AbisPersonService implements PersonService {

	@Override
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return new Person("Philippe", "Peeters");
	}

}
