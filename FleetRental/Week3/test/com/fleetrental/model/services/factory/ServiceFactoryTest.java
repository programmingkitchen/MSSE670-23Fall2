package com.fleetrental.model.services.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fleetrental.model.services.factory.ServiceFactory;
import com.fleetrental.model.services.loginservice.ILoginService;
import com.fleetrental.model.services.loginservice.LoginServiceImpl;

public class ServiceFactoryTest {


	ServiceFactory serviceFactory;
	
	@Before
	public void setUp() throws Exception {
		serviceFactory = new ServiceFactory();
	}


    /**
     * Test Factory to return the loginservice and assert it by 
     * checking it is an instance of LoginServiceImpl
     * 
     * This should be true since LoginServiceImpl implements ILoginService
     */
	@Test	
	public void testGetLoginService() {
 		ILoginService loginService = (ILoginService)serviceFactory.getLoginService();
  	    assertTrue(loginService instanceof LoginServiceImpl);
	}

}
