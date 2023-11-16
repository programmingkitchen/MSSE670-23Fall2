package com.flightreservation.model.services.factory;
import com.flightreservation.model.business.exception.ServiceLoadException;
import com.flightreservation.model.services.IService;

/**
 * This factory class does a interesting operation which by taking a string name
 * of a service, creates a class equivalent of it and returns it in this classes
 * interface form.
 * 
 * Important to note here that all Service classes
 * (com.flightreservation.model.services.*) implement IService interface.
 * 
 * Hence, the getService method when done, instead of returning ILoginService or
 * IRegistrationService it returns a IService interface class which continues
 * the decoupling theme of MVC so the calling classes don't deal with a concrete
 * implementation class but its interface.
 * 
 * Advantage of this is that the caller knows of only the interface the
 * underlying implementation can change without impacting any classes in the
 * upper tiers.
 *
 */

public class ServiceFactory {
	
	// STUDY THIS: 
	// Next three lines part of the Singleton Pattern.
	// Read article on Singleton Pattern issues:
	// http://www.ibm.com/developerworks/java/library/j-dcl.html
	private ServiceFactory() {
	}

	private static ServiceFactory serviceFactory = new ServiceFactory();

	public static ServiceFactory getInstance() {
		return serviceFactory;
	}
	
	/**
	 * 
	 * @param serviceName
	 * @return
	 * @throws ServiceLoadException
	 */
	
	public IService getService(String serviceName) throws ServiceLoadException {
		try {
			// Class is a parametrizable class. By writing Class<?>, we're declaring a Class object 
			// which can be of any type (? is a wildcard). 
			// Reference about Generics and Wildcards:http://docs.oracle.com/javase/tutorial/java/generics/wildcards.html
			Class<?> c = Class.forName(getImplName(serviceName));
			return (IService) c.newInstance();
		} catch (Exception excp) {
			serviceName = serviceName + " not loaded";
			throw new ServiceLoadException(serviceName, excp);
		}
	}
	
	
	/**
	================================================================================
    OPTION 2 (BEST PRACTICE):  PASS IN THE PATH AT THE COMMAND LINE
	================================================================================
	ONLY MY COMPUTER ONLY 
	
	NOTE:  There is a "config" directory at the same level in the file system as the src and test directories.
	This directory contains a file called "application.properties." 
	
	Hard coding path of the file is restrictive because if the file
	is renamed or moved, one has to remember to update it here.
	
	More appropriate approach is to pass this as a System property (-D option)
	at application startup time.

	Student Exercise: Research and all -D option in your HW

	Hint(actually more like a solution) :

	
	If running in Eclipse
	=====================
	
	Right click on the unit test and navigate to
	1. Run As -> Run Configuration
	2. Select Arguments Tab
	3. In VM Arguments section, add the -D property
	-Dprop_location=<drive><location>\application.properties
	Example:
	-Dprop_location=E:\FleetRental\config\application.properties
	
	If running on command line
	==========================
	You'd pass in the above -D option with the java command.

    ================================================================================
	OPTION 1 (BAD EXCEPT FOR TROUBLESHOOTING):  HARD CODE THE PATH 
	================================================================================
	java.io.FileInputStream fis = new java.io.FileInputStream(
	"C:\\EDrive\\Regis\\MSCS670\\NewCourse\\NewCourseSoftwareInstall\\ganymede\\eclipse_workspace\\FleetRental_Week4\\config\\application.properties"
	);
	
	
	*/
	
	private String getImplName(String serviceName) throws Exception {

		// Uncomment to troubleshoot -D.  We need \\ to escape the won
		//String propertyFileLocation="C:\\Users\\rgran\\Dropbox\\ECLIPSE-WORKSPACE\\MSSE670-AIRLINE-RESERVATION\\AirlineReservation\\config\\application.properties";
		// String propertyFileLocation = "D:\\Dropbox\\JAVA-MSSE670\\WORKSPACE\\AirlineReservation\\config\\application.properties";
		System.out.println("Property passed with -D: " + System.getProperty("prop_location"));
		// Use -D to get the property file location.
		// Comment this out for troubleshooting problems with -D
		String propertyFileLocation = System.getProperty("prop_location");
		
		// DEBUG:  Property File Location
		// System.out.println("Property File Location passed : " + propertyFileLocation);
				
		
		java.util.Properties props = new java.util.Properties();
		java.io.FileInputStream fis = new java.io.FileInputStream(propertyFileLocation);
		props.load(fis);
		fis.close();
		
		// Uncomment to troubleshooting problems within the property file (after successful load).
		//String testName = props.getProperty(serviceName);
		//System.out.println("Service name: " + testName);
		
		return props.getProperty(serviceName);
	}

} // end class ServiceFactory
