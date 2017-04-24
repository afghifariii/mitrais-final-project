package com.btpn.empolyee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.empolyee.entity.Employee;
import com.btpn.empolyee.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping("/employees/all")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> allEmployees() {

		return employeeRepo.findAll();
	}
	
	@PostMapping("/employees/")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody Employee emp){
		return employeeRepo.save(emp);
	}
	
	@GetMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee findById (@PathVariable String id){
		return employeeRepo.findOne(id);
	}
	
	@PutMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee updateEmployee(@PathVariable("id") String id, @RequestBody Employee emp ){
		emp.setEmpId(id);
		return employeeRepo.save(emp);
	}
	
	@DeleteMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable("id") String id){
		employeeRepo.delete(id);
	}

}
