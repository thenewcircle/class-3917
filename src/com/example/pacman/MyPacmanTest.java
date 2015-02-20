package com.example.pacman;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class MyPacmanTest {

	@Test
	public void testMyValidator() {
		//1. Test Data
		String json = "Doug, Jacob, Mike";
		RequestMessage requestMessage = RequestMessage.parse(json);
		List<ValidationError> expectedErrors = Arrays.asList(
				new ValidationError("Doug", 7032),
				new ValidationError("Jacob", 7032),
				new ValidationError("Mike", 7032)
		);
		
		//2. Assemble
		CustomerService customerService = Mockito.mock(CustomerService.class);
		NetworkAddrService networkAddrService = Mockito.mock(NetworkAddrService.class);
		RequestMessageLogService requestMessageLogService = Mockito.mock(RequestMessageLogService.class);
		Mockito.when(customerService.findCustomer()).thenReturn("Doug");
		MyValidator validator = new MyValidator();
		validator.setCustomerService(customerService);
		validator.setNetworkAddrService(networkAddrService);
		validator.setRequestMessageLogService(requestMessageLogService);
		
		//3. Act (Do business logic)
		List<ValidationError> actualErrors = validator.validate(requestMessage);
		
		//4. Assert/Verify
		Assert.assertEquals(expectedErrors, actualErrors);
		verify(requestMessageLogService, times(3)).log((ValidationError) anyObject());
		
		//5. Clean Up
	}
	
}
