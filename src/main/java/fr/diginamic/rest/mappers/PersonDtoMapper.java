package fr.diginamic.rest.mappers;

import org.springframework.stereotype.Component;

import fr.diginamic.rest.dto.PersonDto;
import fr.diginamic.rest.model.Person;

@Component
public class PersonDtoMapper {
	
	public PersonDto toDto(Person person) {
		PersonDto dto = new PersonDto();
		dto.setId(person.getId());
		dto.setName(person.getLastname().toUpperCase() + " " + person.getFirstname());
		dto.setAge(person.getAge());
		
		String[] animals = new String[person.getAnimals().size()];
		for(int i=0; i<person.getAnimals().size(); i++) {
			animals[i] = person.getAnimals().get(i).getName() + " (" 
					+ person.getAnimals().get(i).getSpecies().getCommonName() + ")";
		}
		dto.setAnimals(animals);
		
		return dto;
	}
	
}
