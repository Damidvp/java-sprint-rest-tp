package fr.diginamic.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.diginamic.rest.enums.Sex;
import fr.diginamic.rest.model.Animal;
import fr.diginamic.rest.model.Species;

public interface AnimalRepository extends JpaRepository<Animal, Integer>, AnimalRepositoryCustom{
	
	List<Animal> findBySpecies(Species species);
	List<Animal> findAllByColorIn(List<String> colors);
	
	@Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = ?1")
	Integer countAllBySex(Sex sex);
	@Query("SELECT CASE WHEN size(a.person) > 0 THEN true ELSE false END FROM Animal a WHERE a = ?1")
	Boolean checkIfAnimalIsAdopted(Animal animal);

}
