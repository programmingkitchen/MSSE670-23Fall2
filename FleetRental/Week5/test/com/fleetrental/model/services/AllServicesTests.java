package com.fleetrental.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fleetrental.model.services.factory.ServiceFactoryTest;
import com.fleetrental.model.services.loginservice.LoginServiceImplTest;
import com.fleetrental.model.services.registrationservice.RegistrationServiceImplTest;

/**
 * Note, cannot test this standalone as we need the FleetRentalManager to load application properties first
 * 
 * Hence, run the ApplicationTestSuite
 * 
 * @author Mike
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ ServiceFactoryTest.class, LoginServiceImplTest.class, RegistrationServiceImplTest.class })
public class AllServicesTests {

}
