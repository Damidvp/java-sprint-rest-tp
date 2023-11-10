package fr.diginamic.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.rest.model.Person;
import fr.diginamic.rest.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;
	
	public Person create(@Valid Person personToCreate) {
		return personRepo.save(personToCreate);
	}
	
	public Person update(@Valid Person updatedPerson) {
		return personRepo.save(updatedPerson);
	}
	
	public Page<Person> findAll(Pageable pageable){
		return this.personRepo.findAll(pageable);
	}
	
	public Person findById(Integer id) {
		return this.personRepo.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public void delete(@Valid Person deletedPerson) {
		this.personRepo.delete(deletedPerson);
	}
	
}
