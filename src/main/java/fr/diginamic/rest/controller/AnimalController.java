package fr.diginamic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.rest.model.Animal;
import fr.diginamic.rest.service.AnimalService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/animals")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	
	@GetMapping
	public Page<Animal> listAnimals() {
		return animalService.findAll(Pageable.ofSize(20));
	}
	
	@GetMapping("/{id}")
	public Animal getOneAnimal(@PathVariable("id") Integer id) {
		return animalService.findById(id);
	}
	
	@PostMapping
	public Animal createAnimal(@Valid @RequestBody Animal animalItem) {
		return this.animalService.create(animalItem);
	}
	
	@PutMapping
	public Animal updateAnimal(@Valid @RequestBody Animal animalItem) {
		return this.animalService.create(animalItem);
	}
	
	@DeleteMapping
	public void deleteAnimal(@Valid @RequestBody Animal animalItem) {
		this.animalService.delete(animalItem);
	}
	
}
