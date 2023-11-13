package com.fleetrental.model.services.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.fleetrental.model.business.exception.PropertyFileNotFoundException;

/**
 * 
 * NOTE: This class is not discussed in class slides, however recommended to understand and
 *       highly encouraged to apply in your homework. Its a neat way of loading properties into
 *       your application once and use it across all tiers (business, service etc)
 *       
 * This manager class primary responsibility is to the load the property file
 * into memory and make it available for all other classes to use.
 * 
 * This class's loadProperties method is called by the FleetRentalManager.
 * 
 * Once loaded, any other class can call it and request for a property value.
 * 
 * For example:
 *   1. The application.properties file that was loaded for this application 
 *      has these values:
 *  		 jdbc.url = jdbc:odbc:TimeZone
 *      	 jdbc.user = Homer
 *   		 jdbc.password = Duff
 *   2. Once this file is loaded, if a class wants to get the value for the 
 *      key jdbc.url, you would make the following call:
 *           PropertyManager.getPropertyValue("jdbc.url");
 *      This would return the string value, "jdbc:odbc:TimeZone"      
 *   
 *   
 *   FAQ: How to pass in Properties file to app while unit testing?
 *   
 *   Answer: 
 *   	 If running in Eclipse 
 *       =====================
 *       Right click on the unit test and navigate to
 *       
 *       1. Run As -> Run Configuration
 *       2. Select Arguments Tab
 *       3. In VM Arguments section, add the -D property 
 * 	           -Dprop_location=E:\FleetRental\config\application.properties
 * 
 *       If running on command line 
 *       ==========================
 *       You'd pass in the above -D option with the java command.
 *       
 * @author Mike.Prasad
 *
 */

public class PropertyManager
{
	private static Properties properties;
 
	/**
	 * Load the properties file so its contents are available
	 * for classes in the Model tier.
	 * 
	 * @param propertyFileLocation
	 * @throws PropertyFileNotFoundException
	 */
	public static void loadProperties(String propertyFileLocation) throws PropertyFileNotFoundException
	{
	    properties = new Properties();
	    FileInputStream sf = null;
	    try
	    {
	      sf = new FileInputStream(propertyFileLocation);
	      properties.load(sf);
     
	      System.out.println("Property file successfully loaded from location: " + propertyFileLocation);
	      System.out.println("Property Contents: " + properties.toString());

	    }
	    catch (FileNotFoundException fnfe) 
		 {
	    	System.out.println("Property file not found.");
	    	throw new PropertyFileNotFoundException ("Property File cannot be found.", fnfe);
		 }
	    catch (IOException ioe) 
	    {
	    	System.out.println("IOException while loading Properties file.");
	    	throw new PropertyFileNotFoundException ("IOException while loading Properties file.", ioe);	    	
	    }
	    catch (Exception excp) 
	    {
	    	System.out.println("Exception while loading Properties file.");
	    	throw new PropertyFileNotFoundException ("Exception while loading Properties file.", excp);	    	
	    }
		finally
		{
			if (sf != null)
			{	
			   try {
 			    sf.close();
			   } catch (IOException e) {
				// Can't do much here if exceptions occur, other then logging
				e.printStackTrace();
			   }
		    }	
		}	    
	} //end loadProperties()

	/**
	 * This methods returns the Value for the passed key.
	 * 
	 * @param key - key whose value needs to be returned
	 * @return String - value for the passed key
	 */
    static public String getPropertyValue (String key)
    {
    	return properties.getProperty(key);
    }
} // end class PropertyManager