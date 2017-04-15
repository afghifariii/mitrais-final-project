package com.btpn.empolyee.service;

import java.util.Collection;

import com.btpn.empolyee.domain.City;

public interface CityServiceInterface {
	
	Collection<City> getAllCity();
	
	City findCity (City city);

}
