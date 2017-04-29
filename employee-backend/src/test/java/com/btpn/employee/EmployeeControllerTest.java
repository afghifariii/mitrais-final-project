package com.btpn.employee;


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
	public void getByLocation() throws Exception {
		
		this.mockMvc.perform(get("/employees/getby?firstName=&lastName=&gender=&location=1&sort=asc"))
					.andExpect(jsonPath("$", hasSize(2)))
					.andDo(print());
	}
	
	@Test
	public void getByGender() throws Exception {
		this.mockMvc.perform(get("/employees/getby?firstName=&lastName=&gender=male&location=&sort=asc"))
					.andExpect(jsonPath("$", hasSize(6)))
					.andDo(print());
	}
	
	@Test
	public void getByGenderAndLocation() throws Exception {
		this.mockMvc.perform(get("/employees/getby?firstName=&lastName=&gender=female&location=2&sort=asc"))
					.andExpect(jsonPath("$", hasSize(3)))
					.andDo(print());
	}
	
	@Test
	public void deleteEmployee() throws Exception {
		this.mockMvc.perform(delete("/employees/a46467bd-936d-4b27-91ed-ac91a52c481b"))
					.andExpect(status().isOk())
					.andDo(print());
	}
	
}