/**
 * 
 */
package com.fleetrental.model.business.manager;

import junit.framework.TestCase;

import com.fleetrental.model.domain.Customer;
import com.fleetrental.model.domain.RentalComposite;
import com.fleetrental.model.services.loginservice.ILoginService;
import com.fleetrental.model.services.registrationservice.IRegistrationService;

/**
 * This unit test tests the FleetRentalManager class. Only does positive/happy path testing.
 * Realistic test would be more comprehensive including all negative testing!
 * 
 * @author mike.prasad
 * 
 *
 */
public class FleetRentalManagerTest extends TestCase {

	private FleetRentalManager fleetRentalManager;
	private RentalComposite rentalComposite;
	private Customer customer;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		/*
		 * Don't forget that FleetManager has a static block where it loads
		 * the application.properties file, which means, we need to pass
		 * location of the application.properties.
		 * 
		 * If running in Eclipse, right click on the unit test and navigate to
		 * 
		 * 1. Run As -> Run Configuration
		 * 2. Select Arguments Tab
		 * 3. In VM Arguments section, add the -D property 
		 * 	  -Dprop_location=E:\FleetRental\config\application.properties
		 * 
		 * If running on command line, you'd pass in the above -D option with the java command.
		 * 
		 */
		
		fleetRentalManager = FleetRentalManager.getInstance();
		
		customer = new Customer ("Simpson", "Homer", "homer@duff.com", "duff", "619.111.1234","619.111.1234");
		rentalComposite = new RentalComposite();
		rentalComposite.setCustomer(customer);
	}

	
	/**
	 * Test performAction method for RegisterCustomer
	 */
	public final void testPerformActionOnRegisterCustomer()
	{
		boolean action = fleetRentalManager.performAction("RegisterCustomer", rentalComposite);
		assertTrue(action);
	}
	
	/**
	 * Test performAction method for LoginCustomer
	 */
	public final void testPerformActionOnLoginCustomer()
	{
		boolean action = fleetRentalManager.performAction("LoginCustomer", rentalComposite);
		assertTrue(action);
	}
	
	/**
	 * Test register customer
	 *
	 */
	public final void testRegisterCustomer() {
			boolean isRegistered = fleetRentalManager.registerCustomer(IRegistrationService.NAME, rentalComposite);			
			assertTrue(isRegistered);
	}

	/**
	 * Test login customer
	 */
	public final void testLoginCustomer() {
		boolean isLoggedIn = fleetRentalManager.loginCustomer(ILoginService.NAME, rentalComposite);			
		assertTrue(isLoggedIn);
}
} //end FleetRentalManagerTest
