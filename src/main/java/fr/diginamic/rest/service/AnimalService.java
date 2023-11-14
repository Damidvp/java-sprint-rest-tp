package fr.diginamic.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import fr.diginamic.rest.model.Animal;
import fr.diginamic.rest.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AnimalService {
	
	@Autowired
	AnimalRepository animalRepo;
	
	public Animal create(@Valid Animal animalToCreate) {
		return animalRepo.save(animalToCreate);
	}
	
	public Animal update(@Valid Animal updatedAnimal) {
		return animalRepo.save(updatedAnimal);
	}
	
	public List<Animal> findAll(){
		return this.animalRepo.findAll();
	}
	
	public Page<Animal> findPage(Pageable pageable){
		return this.animalRepo.findAll(pageable);
	}
	
	public Animal findById(Integer id) {
		return this.animalRepo.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public void delete(@Valid Animal deletedAnimal) {
		this.animalRepo.delete(deletedAnimal);
	}
	
}
