package com.natwest.garage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.natwest.garage.persistence.domain.Cars;
import com.natwest.garage.persistence.repository.CarsRepository;

@Service
public class CarServices {

	public CarsRepository repo;

	public CarServices(CarsRepository repo) {
		super();
		this.repo = repo;
	}

	// Read
	public List<Cars> readAll() {
		return this.repo.findAll();
	}

	// Find by ID
	public Cars findById(Long id) {
		return this.repo.findById(id).orElseThrow();
	}

	// Create
	public Cars create(Cars cars) {
		return this.repo.saveAndFlush(cars);
	}

	// Update
	public Cars update(Long id, Cars cars) {
		// Need to check if it exists?
		Cars exists = this.repo.getById(id);
		exists.setMake(cars.getMake());
		exists.setModel(cars.getModel());
		exists.setColour(cars.getColour());
		exists.setReg(cars.getReg());
		Cars updated = this.repo.save(exists);
		return updated;
	}

	// Delete
	public Boolean delete(Long id) {
		this.repo.deleteById(id); // If this worked
		return this.repo.existsById(id); // This should be false
	}

	// Custom @Query
	// Find by make
	public List<Cars> findByMake(String make) {
		return this.repo.findByMake(make);
	}

	// Find by model
	public List<Cars> findByModel(String model) {
		return this.repo.findByModel(model);
	}

	// Find by colour
	public List<Cars> findByColour(String colour) {
		return this.repo.findByColour(colour);
	}

	// Find by reg
	public List<Cars> findByReg(String reg) {
		return this.repo.findByReg(reg);
	}

	// Find by make and colour
	public List<Cars> findByMakeAndColour(String make, String colour) {
		return this.repo.findByMakeAndColour(make, colour);
	}

	// Find by model and colour
	public List<Cars> findByModelAndColour(String model, String colour) {
		return this.repo.findByModelAndColour(model, colour);
	}

}
