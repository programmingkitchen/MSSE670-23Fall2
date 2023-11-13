package com.fleetrental.model.services.registrationservice;

import junit.framework.TestCase;

import com.fleetrental.model.business.exception.ServiceLoadException;
import com.fleetrental.model.domain.Customer;
import com.fleetrental.model.domain.RentalComposite;
import com.fleetrental.model.services.exception.RegistrationException;
import com.fleetrental.model.services.factory.ServiceFactory;
import com.fleetrental.model.services.manager.PropertyManager;

public class RegistrationServiceImplTest extends TestCase {

	private RentalComposite rentalComposite;
	private Customer customer;
	private IRegistrationService registrationService;
	private ServiceFactory serviceFactory;

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	public void setUp() throws Exception {

		// Hmmm, we have load the properties via the PropertyManager
		String propertyFileLocation = System.getProperty("prop_location");

		// Now that we have the property file location, lets have the
		// PropertyManager class load it up
		PropertyManager.loadProperties(propertyFileLocation);

		serviceFactory = ServiceFactory.getInstance();

		customer = new Customer("Simpson", "Homer", "homer@duff.com", "duff",
				"619.111.1234", "619.111.1234");
		rentalComposite = new RentalComposite();
		rentalComposite.setCustomer(customer);

		new RegistrationServiceImpl();

		// initialize registrationService
		try {
			registrationService = (IRegistrationService) serviceFactory
					.getService("IRegistrationService");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("Should not see ServiceLoadException");
		}
	}

	/**
	 * Test for a successful registration
	 */

	public final void testRegisterCustomer() {

		try {
			boolean isRegistered = registrationService
					.registerCustomer(rentalComposite);
			assertTrue(isRegistered);
		} catch (RegistrationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test for a unsuccessful registration, by passing in null Customer
	 */

	public final void testRegisterCustomerUnSuccessful() {

		try {
			RentalComposite rentalComposite = new RentalComposite();
			boolean isRegistered = registrationService
					.registerCustomer(rentalComposite);
			assertFalse(isRegistered);
		} catch (RegistrationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test for a unsuccessful registration, by checking getting
	 * RegistrationException
	 */
	/*
	 * public final void testRegisterCustomerUnSuccessfulByException() {
	 * 
	 * try { RentalComposite rentalComposite = new RentalComposite(); boolean
	 * isRegistered = registrationServiceImpl.registerCustomer(rentalComposite);
	 * assertFalse(isRegistered); } catch (RegistrationException e) { return; }
	 * fail("Expected RegistrationException"); }
	 */
}
