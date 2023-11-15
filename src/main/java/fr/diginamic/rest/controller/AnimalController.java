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

import fr.diginamic.rest.dto.AnimalDto;
import fr.diginamic.rest.exceptions.EntityToCreateHasAnIdException;
import fr.diginamic.rest.exceptions.EntityToUpdateHasNoIdException;
import fr.diginamic.rest.model.Animal;
import fr.diginamic.rest.service.AnimalService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/animals")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@GetMapping
	public List<Animal> listAnimals() {
		return animalService.findAll();
	}
	
	@GetMapping("/pages")
	public Page<AnimalDto> findPage(
			@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize){
		return animalService.findPage(PageRequest.of(pageNumber, pageSize));
	}
	
	@GetMapping("/{id}")
	public Animal getOneAnimal(@PathVariable("id") Integer id) {
		Optional<Animal> result = Optional.ofNullable(animalService.findById(id));
		if(!result.isPresent()) {
			throw new EntityNotFoundException();
		}
		return result.get();
	}
	
	@PostMapping
	public ResponseEntity<Object> createAnimal(@Valid @RequestBody Animal animalItem) {
		if(animalItem.getId() != null) {
			//return new ResponseEntity<>("Erreur : ID renseigné lors de la création !", HttpStatus.BAD_REQUEST);
			throw new EntityToCreateHasAnIdException();
		}
		this.animalService.create(animalItem);
		return new ResponseEntity<>("L'animal " + animalItem + " a bien été créé !", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateAnimal(@Valid @RequestBody Animal animalItem) {
		if(animalItem.getId() == null || animalItem.getId() < 0 || !this.animalService.existsById(animalItem.getId())) {
			//return new ResponseEntity<>("Erreur : ID renseigné invalide !", HttpStatus.BAD_REQUEST);
			throw new EntityToUpdateHasNoIdException();
		}
		this.animalService.create(animalItem);
		return new ResponseEntity<>("L'animal " + animalItem + " a bien été modifié !", HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteAnimal(@Valid @RequestBody Animal animalItem) {
		if(animalItem.getId() == null || !this.animalService.existsById(animalItem.getId())) {
			throw new EntityNotFoundException();
		}
		this.animalService.delete(animalItem);
	}
	
}
