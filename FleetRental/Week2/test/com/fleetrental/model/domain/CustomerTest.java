package com.fleetrental.model.domain;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer customer1, customer2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

		customer1 = new Customer ("Simpson", "Homer", "homer@duff.com", "duff", "619.111.1234","619.111.1234");
		customer2 = new Customer ("Simpson", "Homer", "homer@duff.com", "duff", "619.111.1234","619.111.1234");

	}

	/**
	 * Test method for {@link com.fleetrental.model.domain.Customer#validate()}.
	 */
	@Test
	public final void testValidateCustomer() {
		System.out.println("starting testValidateCustomer()");
		// c1.validate should assert to True since all variables 
		// being passed to create a new Car are all valid.
		assertTrue ("customer validates", customer1.validate());
	       System.out.println("testValidate PASSED");
	}

	/**
	 * Test method for {@link com.fleetrental.model.domain.Customer#equals(com.fleetrental.model.domain.Customer)}.
	 */
	@Test
	public final void testEqualsCustomer() {
		System.out.println("starting testEqualsCustomer()");
		// this should assert to true since the contents of 
		// c1 and c2 class variables are identical.
		assertTrue ("customer1 equals customer2", customer1.equals(customer2));
	    System.out.println("testEqualsCustomer PASSED");		

	}
}
