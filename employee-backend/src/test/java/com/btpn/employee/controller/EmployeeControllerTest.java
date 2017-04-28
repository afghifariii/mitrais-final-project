package com.btpn.employee.controller;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.runners.MethodSorters;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void createEmployee() throws Exception {
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
	}

	@Test
	public void findAll() throws Exception {
		
		this.mockMvc.perform(get("/employees/all"))
					.andExpect(jsonPath("$", hasSize(20)))
					.andDo(print());
	}
	
	@Test
	public void findById() throws Exception {
		this.mockMvc.perform(get("/employees/a46467bd-936d-4b27-91ed-ac91a52c481b"))
					.andExpect(jsonPath("$.empId").value("a46467bd-936d-4b27-91ed-ac91a52c481b"))
					.andExpect(jsonPath("$.firstName").value("Berke"))
					.andExpect(jsonPath("$.lastName").value("Yeardley"))
					.andExpect(jsonPath("$.gender").value("Male"))
					.andExpect(jsonPath("$.dateOfBirth").value("1971-06-18"))
					.andExpect(jsonPath("$.nationality").value("Indonesia"))
					.andExpect(jsonPath("$.maritalStatus").value("Single"))
					.andExpect(jsonPath("$.phone").value("62-(925)131-2899"))
					.andExpect(jsonPath("$.subDivision").value("Ruby Trainer"))
					.andExpect(jsonPath("$.status").value("Contract"))
					.andExpect(jsonPath("$.hiredDate").value("2009-06-09"))
					.andExpect(jsonPath("$.grade").value("SE - AN"))
					.andExpect(jsonPath("$.division").value("CDC - TechOne"))
					.andExpect(jsonPath("$.email").value("byeardley0@npr.org"))
					.andExpect(jsonPath("$.photo").isNotEmpty())
					.andExpect(jsonPath("$.location").isNotEmpty())
					.andDo(print());
	}
}