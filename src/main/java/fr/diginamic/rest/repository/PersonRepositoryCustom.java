package fr.diginamic.rest.repository;

import fr.diginamic.rest.model.Animal;
import fr.diginamic.rest.model.Person;

public interface PersonRepositoryCustom {
	
	void deletePersonsWithoutAnimal();
	void createPersonEntities(Integer numberOfEntities);
	
	void adoptAnimalForPerson(Person person, Animal animal);
	void giveAnimalsToRandomPersons(Integer numberOfAdoptions);
}
