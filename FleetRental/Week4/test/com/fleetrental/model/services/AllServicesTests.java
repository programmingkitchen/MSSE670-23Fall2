package com.fleetrental.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fleetrental.model.services.factory.ServiceFactoryTest;
import com.fleetrental.model.services.loginservice.LoginServiceImplTest;

@RunWith(Suite.class)
@SuiteClasses({ ServiceFactoryTest.class, LoginServiceImplTest.class })
public class AllServicesTests {

}
