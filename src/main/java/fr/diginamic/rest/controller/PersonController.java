package fr.diginamic.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.rest.exceptions.EntityToCreateHasAnIdException;
import fr.diginamic.rest.exceptions.EntityToUpdateHasNoIdException;
import fr.diginamic.rest.model.Person;
import fr.diginamic.rest.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> listPersons() {
		return personService.findAll();
	}
	
	@GetMapping("/pages")
	public Page<Person> findPage(
			@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize){
		return personService.findPage(PageRequest.of(pageNumber, pageSize));
	}
	
	@GetMapping("/{id}")
	public Person getOnePerson(@PathVariable("id") Integer id) {
		Optional<Person> result = Optional.ofNullable(personService.findById(id));
		if(!result.isPresent()) {
			throw new EntityNotFoundException();
		}
		return result.get();
	}
	
	@PostMapping
	public ResponseEntity<Object> createPerson(@Valid @RequestBody Person personItem) {
		if(personItem.getId() != null) {
			//return new ResponseEntity<>("Erreur : ID renseigné lors de la création !", HttpStatus.BAD_REQUEST);
			throw new EntityToCreateHasAnIdException();
		}
		this.personService.create(personItem);
		return new ResponseEntity<>("La personne " + personItem + " a bien été créée !", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Object> updatePerson(@Valid @RequestBody Person personItem) {
		if(personItem.getId() == null || personItem.getId() < 0) {
			//return new ResponseEntity<>("Erreur : ID renseigné invalide !", HttpStatus.BAD_REQUEST);
			throw new EntityToUpdateHasNoIdException();
		}
		this.personService.create(personItem);
		return new ResponseEntity<>("La personne " + personItem + " a bien été modifiée !", HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deletePerson(@Valid @RequestBody Person personItem) {
		if(personItem.getId() == null) {
			throw new EntityNotFoundException();
		}
		this.personService.delete(personItem);
	}
}
