package com.fleetrental.model.business;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fleetrental.model.business.manager.FleetRentalManagerTest;

/**
 * Properties are being passed is using the -D option. See 
 * PropertyManager for details on this.
 * 
 * @author mike.prasad
 *
 */

@RunWith(Suite.class)
@SuiteClasses({ FleetRentalManagerTest.class})
public class AllBusinessTests {

}
