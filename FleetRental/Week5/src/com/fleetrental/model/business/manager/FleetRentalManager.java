package com.fleetrental.model.business.manager;

import com.fleetrental.model.business.exception.ServiceLoadException;
import com.fleetrental.model.domain.Customer;
import com.fleetrental.model.domain.RentalComposite;
import com.fleetrental.model.services.exception.LoginException;
import com.fleetrental.model.services.exception.RegistrationException;
import com.fleetrental.model.services.factory.ServiceFactory;
import com.fleetrental.model.services.loginservice.ILoginService;
import com.fleetrental.model.services.registrationservice.IRegistrationService;

/**
 * This Manager class provides two key functionalities: 1. Has the properties
 * files loaded by the PropertyManager 2. Calls the ServiceFactory class and
 * executes the services being requested by the controller.
 *
 * Manager classes in reality provide a define set of functionality and govern
 * the overall processing of the application.
 *
 * @author Mike.Prasad
 *
 */

public class FleetRentalManager extends ManagerSuperType {

	private static FleetRentalManager _instance;

	/**
	 * keep the constructor private to prevent instantiation by outside callers.
	 */
	private FleetRentalManager() {
		// construct object . . .
	}

	/**
	 * Assures that there is only one FleetRentalManager created.
	 * 
	 * @return FleetRentalManager instance
	 */
	public static synchronized FleetRentalManager getInstance() {
		if (_instance == null) {
			_instance = new FleetRentalManager();
		}
		return _instance;
	}

	/**
	 * Generic method that all clients of this class can call to perform certain
	 * actions.
	 * 
	 * @param commandString
	 *            Holds the service name to be invoked *
	 * @param rentalComposite
	 *            Holds application specific domain state
	 * @return false if action failed true if action is successful
	 */
	@Override
	public boolean performAction(String commandString,
			RentalComposite rentalComposite) {
		boolean action = false;
		if (commandString.equals("RegisterCustomer")) {
			action = registerCustomer(IRegistrationService.NAME,
					rentalComposite);
		} else if (commandString.equals("LoginCustomer")) {
			action = loginCustomer(ILoginService.NAME, rentalComposite);
		}

		return action;
	}

	/**
	 * Method delegates to the ServiceFactory to execute a service. Good part of
	 * this approach is that the Manager knows the service by a string name -
	 * thus achieving the decoupling effect that we so desire in the MVC
	 * approach.
	 *
	 * @param commandString
	 *            contains the service that needs to be performed
	 * @param rentalComposite
	 *            contains the customer registration info needed
	 *
	 *            QUESTION TO STUDENTS: IS THIS WORTH PROPAGATING EXCEPTION TO
	 *            CALLER(View/Controller), OR SHOULD IT BE HANDLED LIKE BELOW?
	 *            Would propagating exception to the View/Controller in this tie
	 *            Presentation Layer to Model semantics? Is that considered
	 *            tight coupling?
	 *
	 */
	public boolean registerCustomer(String commandString,
			RentalComposite rentalComposite) {
		boolean isRegistered = false;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IRegistrationService iRegistrationService;

		try {
			iRegistrationService = (IRegistrationService) serviceFactory
					.getService(commandString);
			isRegistered = iRegistrationService
					.registerCustomer(rentalComposite);
		} catch (ServiceLoadException e1) {
			System.out.println("FleetRentalManager::registerCustomer failed"); // defaulting
																				// to
																				// isRegistered
																				// to
																				// false
		} catch (RegistrationException e) {
			System.out.println("FleetRentalManager::registerCustomer failed"); // defaulting
																				// to
																				// isRegistered
																				// to
																				// false
		}

		return isRegistered;

	}// end registerCustomer

	/**
	 * Invokes appropriate service to login the customer
	 * 
	 * @param commandString
	 *            contains the service that needs to be performed
	 * @param rentalComposite
	 *            contains the customer login information
	 * @return true if login information passed is valid false if login
	 *         information passed is invalid
	 */
	public boolean loginCustomer(String commandString,
			RentalComposite rentalComposite) {
		boolean isAuthenticated = false;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ILoginService iLoginService;

		try {
			iLoginService = (ILoginService) serviceFactory
					.getService(commandString);
			isAuthenticated = iLoginService
					.authenticateCustomer(rentalComposite);
		} catch (ServiceLoadException e1) {
			System.out.println("FleetRentalManager::login failed"); // defaulting
																	// to
																	// isAuthenticated
																	// to false
		} catch (LoginException e) {
			System.out.println("FleetRentalManager::login failed"); // defaulting
																	// to
																	// isAuthenticated
																	// to false
		}

		return isAuthenticated;
	} // end loginCustomer

	/**
	 * Main here for instructional purpose and should not be in your submitted
	 * work!
	 * 
	 * NOTE: We always use unit test to test the corresponding class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		FleetRentalManager fleetRentalManager = FleetRentalManager
				.getInstance();

		Customer customer = new Customer("Simpson", "Homer", "homer@duff.com",
				"duff", "619.111.1234", "619.111.1234");
		RentalComposite rentalComposite = new RentalComposite();
		rentalComposite.setCustomer(customer);

		boolean isRegistered = fleetRentalManager.performAction(
				"RegisterCustomer", rentalComposite);

		String message = isRegistered ? "FleetRentalManager::main - Successfully registered customer"
				: "FleetRentalManager::main - Failed to registered customer";
		System.out.println(message);

	} // end main
} // end class FleetRentalServerManager