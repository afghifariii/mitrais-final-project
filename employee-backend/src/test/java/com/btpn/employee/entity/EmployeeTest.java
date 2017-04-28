package com.btpn.employee.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Employee.class)
public class EmployeeTest {

	@Test
	public void EmployeeTest() throws ParseException {
		Employee employee = new Employee();
		employee.setFirstName("Ali Firdaus");
		employee.setLastName("Ghifari");
		employee.setGender("Male");
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1993-06-27"));

		employee.setGrade("SE - JP");
		employee.setLocation(new Location("1", "Jakarta"));

		assertEquals("Ali Firdaus", employee.getFirstName());
		assertEquals("Ghifari", employee.getLastName());
		assertEquals("Male", employee.getGender());
		assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("1993-06-27"), employee.getDateOfBirth());
		assertEquals("SE - JP", employee.getGrade());
		assertEquals(("1"), employee.getLocation().getId());
	}

}
