package com.fleetrental.model.services.loginservice;

import com.fleetrental.model.domain.Customer;

public interface ILoginService {
	
	public boolean authenticateCustomer(Customer customer);

}
