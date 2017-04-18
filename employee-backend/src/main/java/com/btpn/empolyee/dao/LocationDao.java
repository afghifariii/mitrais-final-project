package com.btpn.empolyee.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.btpn.empolyee.entity.City;

public interface CityDao extends PagingAndSortingRepository<City, String> {

}
