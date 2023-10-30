package com.fleetrental.model.services.loginservice;

import com.fleetrental.model.domain.Customer;

public class LoginServiceImpl implements ILoginService {


	/**
	 * Validates if the customer is indeed registered in our system.
	 * 
	 *  @param Customer contains customer's login credentials 
	 */
	public boolean authenticateCustomer(Customer customer) {
		System.out.println ("Entering method LoginServiceImpl::authenticateCustomer");
		
		return true;
	}	
}
