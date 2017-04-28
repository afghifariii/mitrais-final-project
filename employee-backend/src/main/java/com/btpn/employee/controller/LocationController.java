package com.btpn.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.employee.entity.Location;
import com.btpn.employee.repository.LocationRepository;

@RestController
public class LocationController {

	@Autowired
	private LocationRepository locationRepo;
	
	public LocationController(LocationRepository locationRepo) {
		// TODO Auto-generated constructor stub
		this.locationRepo = locationRepo;
	}
	
	@GetMapping("/locations/all")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Location> allLocations() {
		return locationRepo.findAll();
	}
}
