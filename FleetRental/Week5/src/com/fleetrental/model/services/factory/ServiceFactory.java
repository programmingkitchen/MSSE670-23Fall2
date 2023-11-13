/**
 * 
 */
package com.fleetrental.model.services.factory;

import com.fleetrental.model.business.exception.ServiceLoadException;
import com.fleetrental.model.services.manager.PropertyManager;
import com.fleetrental.model.services.IService;

/**
 * This factory class does a interesting operation which by taking
 * a string name of a service, creates a class equivalent of it
 * and returns it in this classes interface form.
 * 
 * 
 * For example:
 * 
 * 1. If the controller gets invoked as such:
 * 		fleetRentalController.performAction("ProcessItineraryService", rentalComposite);
 *  
 * 2. Controller then calls the FleetRentalManager to perform an action.
 *      Here commandString =  "ProcessItineraryService" from step 1
 *   	fleetRentalManager.performAction(commandString, rentalComposite);
 *   
 * 3. FleetRentalManager then makes the getService method call in this class:
 *      	IService iService = ServiceFactory.getService(commandString);
 *      
 *          Here commandString =  "ProcessItineraryService" from step 1
 *      
 *  4. Important to note here that all Service classes (com.fleetrental.business.services.*)
 *     implement IService interface.
 *     
 *     Hence, the getService method when done, instead of returning ProcessItineraryService
 *     class returns a IService interface class which continues the decoupling
 *     theme of MVC so the calling classes don't deal with a concrete ProcessItineraryService
 *     class but its interface. 
 *     
 *     Advantage of this is that the caller knows of only the interface the underlying
 *     implementation can change without impacting any classes in the upper
 *     tiers.
 *     
 * @author Mike.Prasad
 *
 */
public class ServiceFactory {
	
	// Next three lines part of the Singleton Pattern.
	// Read article on Singleton Pattern issues: http://www.ibm.com/developerworks/java/library/j-dcl.html
	private ServiceFactory() {}
	private static ServiceFactory serviceFactoryInstance;
	public static ServiceFactory getInstance() 
	{
		if (serviceFactoryInstance == null)
			serviceFactoryInstance = new ServiceFactory();		
		return serviceFactoryInstance;
	}


	
	/**
	 * 
	 * @param serviceName
	 *                 Name of the service interface
	 * @return
	 *                 Implementation of the service interface
	 *                 
	 * @throws ServiceLoadException
	 *                 Thrown when the implementation for the "serviceName" cannot be found and hence loaded
	 */
	public IService getService(String serviceName) throws ServiceLoadException
	{
		try 
		{
		   Class<?> c = Class.forName(getImplName(serviceName));
		   return (IService)c.newInstance();
		} catch (Exception excp) 
		{
		   serviceName = serviceName + " not loaded";
		   throw new ServiceLoadException(serviceName, excp);
		}
	}
	
	/**
	 * Unlike in the slides, this example uses the PropertyManager to get a property value. 
	 * Read documentation on PropertyManager
	 *  
	 * @param serviceName
	 *                 Name of the service interface
	 * @return string
	 *                 Implementation of the service interface
	 * Unit testing private methods: 
	 * 1. http://onjava.com/pub/a/onjava/2003/11/12/reflection.html
	 * 2. http://www.artima.com/suiterunner/private.html
	 */
	private String getImplName (String serviceName) //throws Exception
	{
		return PropertyManager.getPropertyValue(serviceName);
	}
	
} // end class ServiceFactory