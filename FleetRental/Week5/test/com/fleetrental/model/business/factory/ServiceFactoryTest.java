package com.fleetrental.model.business.factory;

import junit.framework.TestCase;

import com.fleetrental.model.business.exception.ServiceLoadException;
import com.fleetrental.model.services.factory.ServiceFactory;
import com.fleetrental.model.services.loginservice.ILoginService;
import com.fleetrental.model.services.loginservice.LoginServiceImpl;

/**
 * 
 * @author mike.prasad
 *
 */

public class ServiceFactoryTest extends TestCase {

	ServiceFactory serviceFactory;
	

	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();
	}

	public void testGetInstance() {
	       assertNotNull(serviceFactory);
		}
	
    /**
     * Test Factory to return the loginservice and assert it by 
     * checking it is an instance of LoginServiceImpl
     * 
     * This should be true since LoginServiceImpl implements ILoginService
     */
	public void testGetLoginService() {
 		ILoginService loginService;
		try {
			loginService = (ILoginService)serviceFactory.getService(ILoginService.NAME);
	  	    assertTrue(loginService instanceof LoginServiceImpl);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

}
