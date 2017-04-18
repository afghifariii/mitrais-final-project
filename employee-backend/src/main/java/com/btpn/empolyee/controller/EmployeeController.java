package com.btpn.empolyee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.empolyee.dao.EmployeeDao;
import com.btpn.empolyee.entity.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@PostMapping("/employees/")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveEmployee(@RequestBody Employee emp){
		employeeDao.save(emp);
	}
	
	@GetMapping("/employees/")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> allEmployees() {

		return employeeDao.findAll();
	}

}
