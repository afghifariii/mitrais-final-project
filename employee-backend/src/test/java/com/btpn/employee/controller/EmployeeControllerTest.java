package com.btpn.employee.controller;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
					.andExpect(jsonPath("$.location.id").value("1"))
					.andExpect(jsonPath("$.location.city").value("Jakarta"))
					.andExpect(status().isOk())
					.andDo(print());
	}
	
	@Test
	public void updateEmployee() throws Exception {
		
		String employee = "{"
				+"\"empId\": \"a46467bd-936d-4b27-91ed-ac91a52c481b\","
			    +"\"firstName\": \"Berke\","
			    +"\"lastName\": \"Yeardley\","
			    +"\"gender\": \"Female\"," //update the gender to Female
			    +"\"dateOfBirth\": \"1971-06-18\","
			    +"\"nationality\": \"Indonesia\","
			    +"\"maritalStatus\": \"Single\","
			    +"\"phone\": \"62-(925)131-2899\","
			    +"\"email\": \"byeardley0@npr.org\","
			    +"\"hiredDate\": \"2009-06-09\","
			    +"\"suspendDate\": null,"
			    +"\"division\": \"CDC - TechOne\","
			    +"\"grade\": \"SE - AN\","
			    +"\"subDivision\": \"Ruby Trainer\","
			    +"\"status\": \"Contract\","
			    +"\"photo\": null," //update photo to null
			    +"\"location\": {\"city\": \"Jakarta\", \"id\": \"1\" }"
				+"}";
		this.mockMvc.perform(put("/employees/a46467bd-936d-4b27-91ed-ac91a52c481b")
					.contentType(MediaType.APPLICATION_JSON)
					.content(employee))
					.andExpect(jsonPath("$.empId").value("a46467bd-936d-4b27-91ed-ac91a52c481b"))
					.andExpect(jsonPath("$.firstName").value("Berke"))
					.andExpect(jsonPath("$.lastName").value("Yeardley"))
					.andExpect(jsonPath("$.gender").value("Female"))
					.andExpect(jsonPath("$.dateOfBirth").isNotEmpty())
					.andExpect(jsonPath("$.nationality").value("Indonesia"))
					.andExpect(jsonPath("$.maritalStatus").value("Single"))
					.andExpect(jsonPath("$.phone").value("62-(925)131-2899"))
					.andExpect(jsonPath("$.subDivision").value("Ruby Trainer"))
					.andExpect(jsonPath("$.status").value("Contract"))
					.andExpect(jsonPath("$.hiredDate").isNotEmpty())
					.andExpect(jsonPath("$.grade").value("SE - AN"))
					.andExpect(jsonPath("$.division").value("CDC - TechOne"))
					.andExpect(jsonPath("$.email").value("byeardley0@npr.org"))
					.andExpect(jsonPath("$.photo").isEmpty())
					.andExpect(jsonPath("$.location.id").value("1"))
					.andExpect(jsonPath("$.location.city").value("Jakarta"))
					.andExpect(status().isOk())
					.andDo(print());
	}
	
	@Test
	public void saveEmployee() throws Exception {
		String employee = "{"
						    +"\"firstName\": \"Warteg\","
						    +"\"lastName\": \"Bahari\","
						    +"\"gender\": \"Male\","
						    +"\"dateOfBirth\": \"1994-02-08\","
						    +"\"nationality\": \"Indonesia\","
						    +"\"maritalStatus\": \"Single\","
						    +"\"phone\": \"08098999\","
						    +"\"email\": \"satriyawicaksana@gmail.com\","
						    +"\"hiredDate\": \"2017-03-13\","
						    +"\"suspendDate\": null,"
						    +"\"division\": \"CDC AsteRx\","
						    +"\"grade\": \"SE - JP\","
						    +"\"subDivision\": \"Java Bootcamp\","
						    +"\"status\": \"Contract\","
						    +"\"photo\": null,"
						    +"\"location\": {\"city\": \"Jakarta\", \"id\": \"1\" }"
							+"}";
		this.mockMvc.perform(post("/employees/")
					.contentType(MediaType.APPLICATION_JSON)
					.content(employee))
					.andExpect(status().isCreated());
	}
	
}