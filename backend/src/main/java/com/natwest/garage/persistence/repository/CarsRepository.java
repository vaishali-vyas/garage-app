package com.natwest.garage.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.natwest.garage.persistence.domain.Cars;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long>{

	// Find by make
	@Query(value = "SELECT * FROM Cars WHERE make = ?1", nativeQuery = true)
	List<Cars>findByMake(String make);
	
	// Find by model
	@Query(value = "SELECT * FROM Cars WHERE model = ?1", nativeQuery = true)
	List<Cars>findByModel(String model);
	
	// Find by colour
	@Query(value = "SELECT * FROM Cars WHERE colour = ?1", nativeQuery = true)
	List<Cars>findByColour(String colour);
	
	// Find by reg
	@Query(value = "SELECT * FROM Cars WHERE reg =?1", nativeQuery = true)
	List<Cars>findByReg(String reg);
	
	// Find by make and colour
	@Query(value = "SELECT * FROM Cars WHERE make = ?1 and colour = ?2", nativeQuery = true)
	List<Cars>findByMakeAndColour(String make, String colour);
	
	// Find by model and colour
	@Query(value = "SELECT * FROM Cars WHERE model = ?1 and colour =?2", nativeQuery = true)
	List<Cars>findByModelAndColour(String model, String colour);
}
