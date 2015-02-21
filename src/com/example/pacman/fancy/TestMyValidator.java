package com.example.pacman.fancy;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

public class TestMyValidator {

	@BeforeClass
	public static void reinitializeGlobals() {
		ConfigurationService.reset();
	}
	
	@Test
	public void testValidateScenerio1() {
		//1. Create test data
		String[] customers = {};
		Object thingToValidate = customers;
		List<ValidationError> expectedResult = Collections.emptyList();

		//2. Assemble the application under test
		CustomerService customerService = Mockito.mock(CustomerService.class);
		RequestMessageLogService messageLogService = Mockito.mock(RequestMessageLogService.class);
		Mockito.when(customerService.findCustomers()).thenReturn(customers);
		MyValidator validator = new MyValidator();
		validator.setCustomerService(customerService);
		validator.setRequestMessageLogService(messageLogService);
		
		//3. Execute the business logic
		List<ValidationError> actualResult = validator.validate(thingToValidate);
		
		//4. Verify results
		Assert.assertEquals(expectedResult, actualResult);
		verify(messageLogService, never()).logValidationErrors(anyList());
		verifyZeroInteractions(messageLogService);
		
		
		Mockito.verify(messageLogService, never()).logValidationErrors(anyList());

		//5.  Cleanup
	}
	
	@Test
	public void testValidateScenerio2() {
		//1. Create test data
		String[] customers = {"Doug", "Jacob"};
		Object thingToValidate = customers;
		List<ValidationError> expectedResult = Arrays.asList(
				new ValidationError(7032, "Doug"),
				new ValidationError(7032, "Jacob"));
		
		//2. Assemble the application under test
		CustomerService customerService = Mockito.mock(CustomerService.class);
		RequestMessageLogService messageLogService = Mockito.mock(RequestMessageLogService.class);
		Mockito.when(customerService.findCustomers()).thenReturn(customers);
		MyValidator validator = new MyValidator();
		validator.setCustomerService(customerService);
		validator.setRequestMessageLogService(messageLogService);
		
		//3. Execute the business logic
		List<ValidationError> actualResult = validator.validate(thingToValidate);
		
		//4. Verify results
		Assert.assertEquals(expectedResult, actualResult);
		verify(messageLogService, times(1)).logValidationErrors(anyList());

		//5.  Cleanup
	}
	
	@Test
	public void testValidateScenerio3() {
		//1. Create test data
		String[] customers = {"Doug"};
		Object thingToValidate = customers;
		List<ValidationError> expectedResult = Arrays.asList(new ValidationError(7032, "Doug"));
		
		//2. Assemble the application under test
		CustomerService customerService = Mockito.mock(CustomerService.class);
		RequestMessageLogService messageLogService = Mockito.mock(RequestMessageLogService.class);
		Mockito.when(customerService.findCustomers()).thenReturn(customers);
		MyValidator validator = new MyValidator();
		validator.setCustomerService(customerService);
		validator.setRequestMessageLogService(messageLogService);
		
		//3. Execute the business logic
		List<ValidationError> actualResult = validator.validate(thingToValidate);
		
		//4. Verify results
		Assert.assertEquals(expectedResult, actualResult);
		Mockito.verify(messageLogService).logValidationErrors(expectedResult);
		
		//5.  Cleanup
	}
	
}
