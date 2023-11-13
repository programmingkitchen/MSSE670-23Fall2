package com.fleetrental.model.services.loginservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.fleetrental.model.services.exception.LoginException;
import com.fleetrental.model.domain.Customer;
import com.fleetrental.model.domain.RentalComposite;

/**
 * @author mike.prasad
 *
 */
public class LoginServiceImpl implements ILoginService {

	/** 
	 * Authenticate customer into our application 
	 * @param RentalComposite 
	 * 							contains customer information to be authenticated 
	 * @throws LoginException 
	 * 							If the Customer object in the composite is null or
	 *   				        If the file that contains the customer information is not found or
	 *   					    If an unexpected exception is encountered while accessing the file.
	 **/

	public boolean authenticateCustomer(RentalComposite rentalComposite)
			throws LoginException {
		
		boolean isValid = false;
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream (new FileInputStream("RegisteredCustomer.out"));
			Customer savedCustomer = (Customer)input.readObject();

			Customer inCustomer = rentalComposite.getCustomer();
			if (inCustomer != null)
			{
				if (savedCustomer.equals(inCustomer))
				  isValid = true;
				else
				  isValid = false;
			}
			else
			{
				/*
				 * NOTE: 
				 * 
				 * 1. Instead of throwing an exception, an alternate way(appropriate) would be to return a
				 * false from the method.				 
				 * 2. Throwing the exception here just to illustrate the use of it.
				 */
				throw new LoginException ("Null Customer passed to LoginServiceImpl::login");
			}			
		} catch (FileNotFoundException fnfe) {
			System.out.println ("File containing registered users not found!");
			throw new LoginException ("File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
			System.out.println ("IOException while accessing file containing registered users!");
			throw new LoginException ("IOException while accessing file containing registered users!", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println ("ClassNotFoundException while reading file containing registered users!");
			throw new LoginException ("ClassNotFoundException while reading file containing registered users!", cnfe);
		}
        finally
        {
			if (input != null)
			{	
			   try {
				   input.close();
			   } catch (IOException e) {
				// Can't do much here if exceptions occur, other then logging
				e.printStackTrace();
			   }
		    }	
        }//end try/catch/finally
      return isValid;
	} //end login

}