package com.btpn.employee.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.btpn.employee.entity.Employee;
import com.btpn.employee.entity.Location;
import com.btpn.employee.repository.EmployeeRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeControllerTest {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeController employeeController;
	
//	@Test
//	public void findByFirstNameContainingOrLastNameContainingAllIgnoreCase(){
//		entityManager.persist(entity)
//	}

//	@Before
//	public void setup() throws ParseException {
//		this.mock = MockMvcBuilders.standaloneSetup(this.employeeController).build();
//	}
//
//	@Test
//	public void saveEmployee() throws Exception {
//		String employee = "{"
//							+ "\"firstName\": \"Donald\","
//							+ "\"lastName\": \"Duck\","
//							+ "\"gender\": \"Male\","
//							+ "\"dateOfBirth\": \"1993-06-27\","
//							+ "\"nationality\": \"Indonesian\","
//							+ "\"maritalStatus\": \"Single\","
//							+ "\"phone\": \"08113151500\","
//							+ "\"email\": \"donaldduck@gmail.com\","
//							+ "\"hiredDate\": \"2017-03-13\","
//							+ "\"suspendDate\": null,"
//							+ "\"division\": \"CDC AsteRx\","
//							+ "\"grade\": \"SE-JP\","
//							+ "\"subDivision\": \"Java Bootcamp\","
//							+ "\"status\": \"Contract\","
//							+ "\"photo\": null,"
//							+ "\"location\": {"
//							+ "\"id\": \"4\"}"
//						+ "}";
//		this.mock.perform(post("/employees/")
//				.content(employee)
//				.contentType("application/json"))
//		.andExpect(status().isCreated());						  
//
//	}
//	
//	@Test
//	public void updateEmployee() throws Exception {
//		String employee = "{"
//				+ "\"firstName\": \"Donald\","
//				+ "\"lastName\": \"Duck\","
//				+ "\"gender\": \"Male\","
//				+ "\"dateOfBirth\": \"1993-06-27\","
//				+ "\"nationality\": \"Indonesian\","
//				+ "\"maritalStatus\": \"Single\","
//				+ "\"phone\": \"08113151500\","
//				+ "\"email\": \"donaldduck@gmail.com\","
//				+ "\"hiredDate\": \"2017-03-13\","
//				+ "\"suspendDate\": null,"
//				+ "\"division\": \"CDC AsteRx\","
//				+ "\"grade\": \"SE-JP\","
//				+ "\"subDivision\": \"Java Bootcamp\","
//				+ "\"status\": \"Contract\","
//				+ "\"photo\": null,"
//				+ "\"location\": {"
//				+ "\"id\": \"4\"}"
//			+ "}";
//			this.mock.perform(put("/employees/2")
//				.content(employee)
//				.contentType("application/json"))
//			.andExpect(status().isOk());
//	}
//	
//	@Test
//	public void deleteEmployee() throws Exception {
//		this.mock.perform(delete("/employees/2"))
//		.andExpect(status().isOk());
//	}
//
//	@Test
//	public void allEmployees() throws Exception {
//		this.mock.perform(get("/employees/all/"))
//		.andExpect(status().isOk())
//		.andExpect(content().string(""));
//	}
//
//	@Test
//	public void findByIdFound() throws Exception {
//		// Found
//		this.mock.perform(get("/employees/2"))
//		.andExpect(status().isOk());
//	}
//
//	@Test
//	public void findByIdNotFound() throws Exception {
//		this.mock.perform(get("/employees/3")).andExpect(status().isOk()).andExpect(content().string(""));
//	}
//
}
