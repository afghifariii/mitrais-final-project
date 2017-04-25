package com.btpn.empolyee.controller;

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

import com.btpn.empolyee.entity.Employee;
import com.btpn.empolyee.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping("/employees/all")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> allEmployees() {
		Sort.Order sorting = new Sort.Order(Sort.Direction.ASC, "lastName").ignoreCase();
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
			
			return employeeRepo.findByLocationAndSort(firstName.toUpperCase(), lastName.toUpperCase(),
					location.toUpperCase(), new Sort(sorting));
			
		} else if (!gender.equals("") && location.equals("")) {
			
			return employeeRepo.findByGenderAndSort(firstName.toUpperCase(), lastName.toUpperCase(),
					gender.toUpperCase(), new Sort(sorting));
			
		} else {
			return employeeRepo.findByLocationGenderAndSort(firstName.toUpperCase(), lastName.toUpperCase(),
					gender.toUpperCase(), location.toUpperCase(), new Sort(sorting));
		}
	}

	@PostMapping("/employees/")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveEmployee(@RequestBody Employee emp) {
		employeeRepo.save(emp);
	}

	@GetMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Employee findById(@PathVariable String id) {
		return employeeRepo.findOne(id);
	}

	@PutMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEmployee(@PathVariable String id, @RequestBody Employee emp) {
		emp.setEmpId(id);
		employeeRepo.save(emp);
	}

	@DeleteMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteEmployee(@PathVariable String id) {
		return employeeRepo.deleteByEmpId(id);
	}

}
