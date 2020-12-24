package com.training.tests;

import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.training.Greeting;

class TestGreeting {


	private Greeting grtObj;
	
	@BeforeEach
	public void beforeTestMethod() {
		
		grtObj = new Greeting();
	}
	
	@Test
	@DisplayName(value = "Test the return value is equal to Hello World")
	@Disabled("Just checking")
	void testForReturnValue() {
	
		String expected = "Hello World";
		String actual =   grtObj.getMessage();
		
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,3})
	void testGetNameForNull(int idxPos) {
		
		LocalDate today = LocalDate.now();
		
		assumeTrue(today.getDayOfWeek().getValue()==3);
		assertNotNull(grtObj.getNames().get(idxPos));
		
	}

}
