package com.btpn.empolyee.service;

import java.util.Collection;

import com.btpn.empolyee.domain.Employee;

public interface EmployeeServiceInterface {

	Employee saveEmployee (Employee employee);

	Employee findEmployee (Employee employee);

	Collection<Employee> getAllEmployee();

	Boolean deleteEmployee (String idEmployee);

	Employee editEmployee (Employee employee);

}
