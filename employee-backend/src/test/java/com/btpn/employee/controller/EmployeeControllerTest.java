package com.btpn.employee.controller;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.btpn.employee.entity.Employee;
import com.btpn.employee.entity.Location;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class EmployeeControllerTest {

//	@Autowired
//	private MockMvc mockMvc;
//
//	private Employee emp = new Employee();
//	
//	ObjectMapper mapper = new ObjectMapper();
//
//	@Before
//	public void createEmployee() throws Exception {
//		emp.setEmpId("1234567890");
//		emp.setFirstName("Ali Firdaus");
//		emp.setLastName("Ghifari");
//		emp.setGender("Male");
//		emp.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1993-06-27"));
//		emp.setmaritalStatus("Single");
//		emp.setNationality("Indonesian");
//		emp.setPhone("0809089999");
//		emp.setEmail("jancokers@gmail.com");
//		emp.setHiredDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-13"));
//		emp.setDivision("SWD Red");
//		emp.setSubDivision("Java Bootcamp");
//		emp.setGrade("SE - JP");
//		emp.setStatus("Contract");
//		emp.setLocation(new Location("1", "Jakarta"));
//		
//		String jsonContent = mapper.writeValueAsString(emp);
//
//		MvcResult result = this.mockMvc
//				.perform(post("/employees/").content(jsonContent).contentType("application/json;charset=UTF-8"))
//				.andExpect(status().isCreated()).andReturn();
//		
//		System.out.println(jsonContent);
//
//	}
//
//	@Test
//	public void findAll() throws Exception {
//		String jsonContent = mapper.writeValueAsString(emp);
//		
//		this.mockMvc.perform(get("/employees/all"))
//					.andExpect(status().isOk())
//					//.andExpect(content().string(containsString(jsonContent)))
//					.andReturn();
//	}
//	
//	
//	@Test
//	public void updateEmployee() throws Exception {
//		
//		emp.setEmail("JunitTest@junit.org");
//		
//		String jsonContent = mapper.writeValueAsString(emp);
//		
//		
//		this.mockMvc.perform(put("/employees/{id}", emp.getEmpId()).content(jsonContent)
//					.contentType("application/json;charset=UTF-8"))
//			        .andExpect(status().isOk())
//			        .andExpect(content().string(containsString(jsonContent)))
//			        .andReturn();
//	}
//	
//	@Test
//	public void deleteEmployee() throws Exception {
//		String jsonContent = mapper.writeValueAsString(emp);
//		
//		this.mockMvc.perform(delete("/employees/{id}", emp.getEmpId()))
//        .andExpect(status().isOk())
//        .andExpect(content().string(not(containsString(jsonContent))))
//        .andReturn();
//	}
	
}
