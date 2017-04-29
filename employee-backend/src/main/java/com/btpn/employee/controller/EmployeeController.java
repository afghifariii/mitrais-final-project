package com.btpn.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.employee.entity.Employee;
import com.btpn.employee.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping("/employees/all")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> allEmployees() {
		Sort.Order sorting = new Sort.Order(Sort.Direction.ASC, "lastName");
		return employeeRepo.findAll(new Sort(sorting));
	}

	@GetMapping("/employees/getby")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> getBy(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String gender, @RequestParam String location, @RequestParam String sort) {
		
		Sort.Order sorting;
		if (sort.equals("asc")) {
			
			sorting = new Sort.Order(Sort.Direction.ASC, "lastName").ignoreCase();
			
		} else {
			
			sorting = new Sort.Order(Sort.Direction.DESC, "lastName").ignoreCase();
			
		}
		if (gender.equals("") && location.equals("")) {
			
			return employeeRepo.findByFirstNameContainingOrLastNameContainingAllIgnoreCase(firstName, lastName,
					new Sort(sorting));
			
		} else if (gender.equals("") && !location.equals("")) {
			
			return employeeRepo.findByLocationAndSort(firstName.toLowerCase(), lastName.toLowerCase(),
					location, new Sort(sorting));
			
		} else if (!gender.equals("") && location.equals("")) {
			
			return employeeRepo.findByGenderAndSort(firstName.toLowerCase(), lastName.toLowerCase(),
					gender.toLowerCase(), new Sort(sorting));
			
		} else {
			return employeeRepo.findByLocationGenderAndSort(firstName.toUpperCase(), lastName.toUpperCase(),
					gender.toLowerCase(), location, new Sort(sorting));
		}
	}

	@PostMapping("/employees/")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveEmployee(@RequestBody Employee emp){
		return employeeRepo.save(emp);
	}

	@GetMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee findById(@PathVariable String id) {
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
	public String deleteEmployee(@PathVariable String id) {
		return employeeRepo.deleteByEmpId(id);
	}

}
