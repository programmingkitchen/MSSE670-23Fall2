package com.flightreservation.model.services.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.flightreservation.model.business.exception.PropertyFileNotFoundException;


public class PropertyManager {
	
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

}
