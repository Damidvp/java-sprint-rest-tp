package fr.diginamic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.rest.model.Person;
import fr.diginamic.rest.service.PersonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping
	public Page<Person> listPersons() {
		return personService.findAll(Pageable.ofSize(20));
	}
	
	@GetMapping("/{id}")
	public Person getOnePerson(@PathVariable("id") Integer id) {
		return personService.findById(id);
	}
	
	@PostMapping
	public Person createPerson(@Valid @RequestBody Person personItem) {
		return this.personService.create(personItem);
	}
	
	@PutMapping
	public Person updatePerson(@Valid @RequestBody Person personItem) {
		return this.personService.create(personItem);
	}
}
