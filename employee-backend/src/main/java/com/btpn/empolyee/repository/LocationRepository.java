package com.btpn.empolyee.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.btpn.empolyee.entity.Location;

@RestResource
public interface LocationRepository extends PagingAndSortingRepository<Location, String> {

}
