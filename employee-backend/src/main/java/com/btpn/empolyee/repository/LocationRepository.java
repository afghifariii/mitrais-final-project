package com.btpn.empolyee.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.btpn.empolyee.entity.Location;

public interface LocationRepository extends PagingAndSortingRepository<Location, String> {

}
