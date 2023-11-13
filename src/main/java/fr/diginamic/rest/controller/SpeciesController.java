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

import fr.diginamic.rest.model.Species;
import fr.diginamic.rest.service.SpeciesService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/species")
public class SpeciesController {
	
	@Autowired
	private SpeciesService speciesService;
	
	@GetMapping
	public Page<Species> listSpecies() {
		return speciesService.findAll(Pageable.ofSize(20));
	}
	
	@GetMapping("/{id}")
	public Species getOneSpecies(@PathVariable("id") Integer id) {
		return speciesService.findById(id);
	}
	
	@PostMapping
	public Species createSpecies(@Valid @RequestBody Species speciesItem) {
		return this.speciesService.create(speciesItem);
	}
	
	@PutMapping
	public Species updateSpecies(@Valid @RequestBody Species speciesItem) {
		return this.speciesService.create(speciesItem);
	}
	
	@DeleteMapping
	public void deleteSpecies(@Valid @RequestBody Species speciesItem) {
		this.speciesService.delete(speciesItem);
	}
	
}
