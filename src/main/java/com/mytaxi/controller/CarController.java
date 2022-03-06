package com.mytaxi.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.car.CarService;

@RestController
@RequestMapping("v1/cars")
public class CarController  {
	
	private CarService carService;
	
	@Autowired
	public CarController (CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/{carId}")
	public CarDTO  find(@Valid @PathVariable String carId) throws EntityNotFoundException {
		return CarMapper.makeCarDTO(carService.find(carId));
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public CarDTO  create(@Valid @RequestBody CarDO carDO) throws ConstraintsViolationException {
		return CarMapper.makeCarDTO( carService.create(carDO));
	}
	
	@DeleteMapping("/{carId}")
	public void delete(@Valid @PathVariable String carId) throws EntityNotFoundException {
		carService.delete(carId);
		
	}
	
	@GetMapping("/licenseplate/{licensePlate}")
	public CarDTO find2(@Valid @PathVariable String licensePlate) throws EntityNotFoundException {
		return CarMapper.makeCarDTO(carService.find2(licensePlate));
	}

	
	@GetMapping
	@Cacheable ("drivers")
	public List<CarDTO> findAll() throws EntityNotFoundException {
		return CarMapper.makeCarDTOList(carService.findAll());
		
	}
	
}
