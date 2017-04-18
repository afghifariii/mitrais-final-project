package com.btpn.empolyee.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.btpn.empolyee.entity.Location;

public interface LocationDao extends PagingAndSortingRepository<Location, String> {

}
