package fr.diginamic.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.rest.dto.PersonDto;
import fr.diginamic.rest.mappers.PersonDtoMapper;
import fr.diginamic.rest.model.Person;
import fr.diginamic.rest.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;
	
	@Autowired
	private PersonDtoMapper personDtoMapper;
	
	public Person create(@Valid Person personToCreate) {
		return personRepo.save(personToCreate);
	}
	
	public Person update(@Valid Person updatedPerson) {
		return personRepo.save(updatedPerson);
	}
	
	public List<Person> findAll(){
		return this.personRepo.findAll();
	}
	
	public Page<PersonDto> findPage(Pageable pageable){
		Page<Person> pagePersons = this.personRepo.findAll(pageable);
		return pagePersons.map((person) -> personDtoMapper.toDto(person));
	}
	
	public Person findById(Integer id) {
		return this.personRepo.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public boolean existsById(Integer id) {
		return this.personRepo.existsById(id);
	}
	
	public void delete(@Valid Person deletedPerson) {
		this.personRepo.delete(deletedPerson);
	}
	
}
