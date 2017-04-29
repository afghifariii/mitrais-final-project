package com.btpn.employee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.btpn.employee.entity.Location;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Location.class)
public class LocationTest {
	
	@Test
	public void LocationTest() {
		Location location = new Location("1", "Jakarta");
		
		assertEquals("1", location.getId());
		assertEquals("Jakarta", location.getCity());
	}

}
