package com.btpn.employee.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.btpn.employee.entity.Location;

@RestResource
public interface LocationRepository extends PagingAndSortingRepository<Location, String> {

}
