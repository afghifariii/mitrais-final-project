package com.btpn.employee.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.btpn.empolyee.controller.EmployeeController;
import com.btpn.empolyee.entity.Employee;
import com.btpn.empolyee.entity.Location;
import com.btpn.empolyee.repository.EmployeeRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=EmployeeController.class)
public class EmployeeControllerTest {
	
	private MockMvc mock;
	
	@MockBean
	private EmployeeRepository employeeRepo;
	
	@Before
	public void setup() throws ParseException {
		this.mock = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
		
		this.employeeRepo.deleteAll();
		Employee emp = new Employee();
		emp.setEmpId("2");
		emp.setFirstName("Ali Firdaus");
		emp.setLastName("Ghifari");
		emp.setGender("Male");
		emp.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1993-06-27"));
		emp.setmaritalStatus("Single");
		emp.setNationality("Indonesian");
		emp.setPhone("+628113151501");
		emp.setEmail("alifirdausghifari@gmail.com");
		emp.setHiredDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-13"));
		emp.setDivision("SWD Red");
		emp.setSubDivision("Java Bootcamp");
		emp.setGrade("SE - JP");
		emp.setStatus("Contract");
		emp.setLocation(new Location("1", "Jakarta"));
		this.employeeRepo.save(emp);
	}
	
	@Test
	public void allEmployees() throws Exception{
		this.mock.perform(get("/employees/all/"))
		.andExpect(status().isOk());
	}

}
