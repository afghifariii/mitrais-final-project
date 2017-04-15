package com.btpn.empolyee.repository;

import org.springframework.data.repository.CrudRepository;

import com.btpn.empolyee.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
