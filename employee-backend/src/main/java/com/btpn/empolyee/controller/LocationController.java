package com.btpn.empolyee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.empolyee.dao.LocationDao;
import com.btpn.empolyee.entity.Location;

@RestController
public class CityController {

	@Autowired
	private LocationDao locationDao;
	
	@GetMapping("/locations/")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Location> allLocations() {
		return locationDao.findAll();
	}
}
