package fr.diginamic.rest.mappers;

import org.springframework.stereotype.Component;


import fr.diginamic.rest.dto.AnimalDto;
import fr.diginamic.rest.model.Animal;
import fr.diginamic.rest.model.Person;

@Component
public class AnimalDtoMapper {

	public AnimalDto toDto(Animal animal) {
		AnimalDto dto = new AnimalDto();
		dto.setId(animal.getId());
		dto.setName(animal.getName());
		dto.setSpecies(animal.getSpecies().getCommonName());
		dto.setColor(animal.getColor());
		
		String persons = "";
		for(Person person : animal.getPerson()) {
			persons = person.getFirstname() + " " + person.getLastname().toUpperCase() + ", ";
		}
		dto.setPersons(persons);
		
		return dto;
	}
	
}
