package com.fleetrental.model.services.loginservice;

import com.fleetrental.model.services.exception.LoginException;
import com.fleetrental.model.domain.RentalComposite;
import com.fleetrental.model.services.IService;

/**
 * @author mike.prasad
 *
 */
public interface ILoginService extends IService
{

	public final String NAME = "ILoginService";

	/** 
	 * Authenticate customer into our application 
	 * @param RentalComposite 
	 * 							contains customer information to be authenticated 
	 * @throws LoginException 
	 * 							If the Customer object in the composite is null or
	 *   				        If the file that contains the customer information is not found or
	 *   					    If an unexpected exception is encountered while accessing the file.
	 * @return boolean
	 * 					true - if authenticated
	 * 				    false - if failed to authenticate
	 * */
	public boolean authenticateCustomer(RentalComposite rentalComposite) throws LoginException;

}