package fr.diginamic.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> createSpecies(@Valid @RequestBody Species speciesItem) {
		if(speciesItem.getId() != null) {
			return new ResponseEntity<>("Erreur : ID renseigné lors de la création !", HttpStatus.BAD_REQUEST);
		}
		this.speciesService.create(speciesItem);
		//this.speciesService.create(null);
		return new ResponseEntity<>("L'espèce " + speciesItem + " a bien été créée !", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateSpecies(@Valid @RequestBody Species speciesItem) {
		if(speciesItem.getId() == null || speciesItem.getId() < 0) {
			return new ResponseEntity<>("Erreur : ID renseigné invalide !", HttpStatus.BAD_REQUEST);
		}
		this.speciesService.create(speciesItem);
		return new ResponseEntity<>("L'espèce " + speciesItem + " a bien été modifiée !", HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteSpecies(@Valid @RequestBody Species speciesItem) {
		this.speciesService.delete(speciesItem);
	}
	
}
