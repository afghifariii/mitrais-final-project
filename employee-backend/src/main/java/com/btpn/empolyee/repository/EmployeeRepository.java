package com.btpn.empolyee.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.btpn.empolyee.entity.Employee;

@RestResource(exported = false)
public interface EmployeeDao extends PagingAndSortingRepository<Employee, String> {

}
