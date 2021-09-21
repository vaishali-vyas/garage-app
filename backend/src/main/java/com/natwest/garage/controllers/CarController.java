package com.natwest.garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.garage.persistence.domain.Cars;
import com.natwest.garage.services.CarServices;

@RestController
@CrossOrigin
public class CarController {

	@Autowired
	private CarServices service;

	@GetMapping(path = "/readfromdb")
	// List because we would like to return multiple records
	public ResponseEntity<List<Cars>> getAll() {
		return new ResponseEntity<List<Cars>>(this.service.readAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/findbyid/{id}")
	// ID is unique or no need for list as we are returning 1 record
	public ResponseEntity<Cars> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<Cars>(this.service.findById(id), HttpStatus.FOUND);
	}

	@PostMapping(path = "/create")
	public ResponseEntity<Cars> create(@RequestBody Cars cars) {
		return new ResponseEntity<Cars>(this.service.create(cars), HttpStatus.CREATED);
	}

	@PutMapping(path = "/update/{id}")
	public ResponseEntity<Cars> update(@PathVariable("id") Long id, @RequestBody Cars cars) {
		return new ResponseEntity<Cars>(this.service.update(id, cars), HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}

	// Using my custom @Query
	// Find by make
	@GetMapping(path = "/findbymake/{make}")
	public ResponseEntity<List<Cars>> findByMake(@PathVariable String make) {
		return new ResponseEntity<List<Cars>>(this.service.findByMake(make), HttpStatus.OK);
	}

	// Find by model
	@GetMapping(path = "/findbymodel/{model}")
	public ResponseEntity<List<Cars>> findByModel(@PathVariable String model) {
		return new ResponseEntity<List<Cars>>(this.service.findByModel(model), HttpStatus.OK);
	}

	// Find by colour
	@GetMapping(path = "/findbycolour/{colour}")
	public ResponseEntity<List<Cars>> findByColour(@PathVariable String colour) {
		return new ResponseEntity<List<Cars>>(this.service.findByColour(colour), HttpStatus.OK);
	}

	// Find by reg
	@GetMapping(path = "/findbyreg/{reg}")
	public ResponseEntity<List<Cars>> findByReg(@PathVariable String reg) {
		return new ResponseEntity<List<Cars>>(this.service.findByReg(reg), HttpStatus.OK);
	}

	// Find by make and colour
	@GetMapping(path = "/findbymakeandcolour/{make}/{colour}")
	public ResponseEntity<List<Cars>> findByMakeAndColour(@PathVariable String make, @PathVariable String colour) {
		return new ResponseEntity<List<Cars>>(this.service.findByMakeAndColour(make, colour), HttpStatus.OK);
	}

	// Find by model and colour
	@GetMapping(path = "/findbymodelandcolour/{model}/{colour}")
	public ResponseEntity<List<Cars>> findByModelAndColour(@PathVariable String model, @PathVariable String colour) {
		return new ResponseEntity<List<Cars>>(this.service.findByModelAndColour(model, colour), HttpStatus.OK);
	}

}
