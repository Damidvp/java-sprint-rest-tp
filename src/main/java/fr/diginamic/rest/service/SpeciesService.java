package fr.diginamic.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.diginamic.rest.model.Species;
import fr.diginamic.rest.repository.SpeciesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class SpeciesService {
	
	@Autowired
	SpeciesRepository speciesRepo;
	
	public Species create(@Valid Species speciesToCreate) {
		return speciesRepo.save(speciesToCreate);
	}
	
	public Species update(@Valid Species updatedSpecies) {
		return speciesRepo.save(updatedSpecies);
	}
	
	public Page<Species> findAll(Pageable pageable){
		return this.speciesRepo.findAll(pageable);
	}
	
	public Species findById(Integer id) {
		return this.speciesRepo.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public void delete(@Valid Species deletedSpecies) {
		this.speciesRepo.delete(deletedSpecies);
	}
	
}
