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
import fr.diginamic.rest.model.Species;
import fr.diginamic.rest.service.SpeciesService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/species")
public class SpeciesController {
	
	@Autowired
	private SpeciesService speciesService;
	
	@GetMapping
	public List<Species> listSpecies() {
		return speciesService.findAll();
	}
	
	@GetMapping("/pages")
	public Page<Species> findPage(
			@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize){
		return speciesService.findPage(PageRequest.of(pageNumber, pageSize));
	}
	
	@GetMapping("/{id}")
	public Species getOneSpecies(@PathVariable("id") Integer id) {
		Optional<Species> result = Optional.ofNullable(speciesService.findById(id));
		if(!result.isPresent()) {
			throw new EntityNotFoundException();
		}
		return speciesService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Object> createSpecies(@Valid @RequestBody Species speciesItem) {
		if(speciesItem.getId() != null) {
			//return new ResponseEntity<>("Erreur : ID renseigné lors de la création !", HttpStatus.BAD_REQUEST);
			throw new EntityToCreateHasAnIdException();
		}
		this.speciesService.create(speciesItem);
		//this.speciesService.create(null);
		return new ResponseEntity<>("L'espèce " + speciesItem + " a bien été créée !", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Object> updateSpecies(@Valid @RequestBody Species speciesItem) {
		if(speciesItem.getId() == null || speciesItem.getId() < 0 || !this.speciesService.existsById(speciesItem.getId())) {
			//return new ResponseEntity<>("Erreur : ID renseigné invalide !", HttpStatus.BAD_REQUEST);
			throw new EntityToUpdateHasNoIdException();
		}
		this.speciesService.create(speciesItem);
		return new ResponseEntity<>("L'espèce " + speciesItem + " a bien été modifiée !", HttpStatus.OK);
	}
	
	@DeleteMapping
	public void deleteSpecies(@Valid @RequestBody Species speciesItem) {
		if(speciesItem.getId() == null || !this.speciesService.existsById(speciesItem.getId())) {
			throw new EntityNotFoundException();
		}
		this.speciesService.delete(speciesItem);
	}
	
}
