package com.fleetrental.model.domain;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllDomainTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.fleetrental.model.domain");
		//$JUnit-BEGIN$
		suite.addTestSuite(CarTest.class);
		suite.addTestSuite(CustomerTest.class);
		//$JUnit-END$
		return suite;
	}

}
