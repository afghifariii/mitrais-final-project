package com.btpn.empolyee.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.btpn.empolyee.entity.Employee;

public interface EmployeeDao extends PagingAndSortingRepository<Employee, String> {

}
