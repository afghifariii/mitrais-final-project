package com.btpn.empolyee.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.btpn.empolyee.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {

}
