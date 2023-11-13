/**
 * 
 */
package com.fleetrental.model.services.registrationservice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.fleetrental.model.domain.Customer;
import com.fleetrental.model.domain.RentalComposite;
import com.fleetrental.model.services.exception.RegistrationException;

/**
 * Registers new customer.
 * 
 * @author mike.prasad
 *
 */
public class RegistrationServiceImpl implements IRegistrationService {


	/**
	 * @param RentalComposite 
	 * 							contains customer information to be saved in file 
	 * @throws RegistrationException 
	 *   					    If we get an IOException writing to the file
	 *   
	 *   NOTE: In this implementation, only one customer is saved in the the file, which
	 *         means we can register and authenticate only one customer.
	 *         To append multiple customers, would require us to use an overloaded FileOutputStream, for example:
	 *         
	 *         new ObjectOutputStream (new FileOutputStream("RegisteredCustomer.out", true));
	 *         
	 *         With this one can successfully add multiple objects. 
	 *         
	 *         The pseudo code to write(register customer use case) would look like :
	 *         
	 *         Write Scenario:
	 *           Open object stream to write/append
	 *           write object
	 *           close stream
	 *         
	 *         We'd repeat the process to register next customer and so on.
	 *         
	 *         Now to read from this file that has multiple
	 *         entries would require one to loop while reading each object.
	 *         
	 *         The pseudo code to do this(login use case scenario) would look like :
	 *         
     *         Read Scenario:
	 *            Open Object stream to read
	 *            loop
	 *              read each object
	 *              exit on end of file
	 *            end loop  
	 *            
	 *          
	 *         Issue 
	 *                In the above case, where we are writing objects in one use case and reading them out in another use case, you
	 *                will get this exception : java.io.StreamCorruptedException: invalid type code: AC
	 *                
	 *                This can be produced in JDK 1.6.
	 *                
	 *                This issue will not appear, if in the write scenario, all objects were written all at once, in which case 
	 *                the read scenario will work fine. However, writing all objects at once is not practical in the use case where
	 *                customer's are being registered at different times.
	 *          
	 *         Summary       
	 *                Just go with only one object (Customer) that gets saved in using object stream as in this sample code. 
	 *                Or
	 *                See my Week 4 tip - "Tip - Esoteric Approach to Saving Objects into a File"
     *
	 */
	public boolean registerCustomer(RentalComposite rentalComposite) throws RegistrationException
	{		
		boolean isRegisteredCustomer = true;
		ObjectOutputStream output = null;
		
		try {

			// If customer passed is not null, then write to file system.
			// else return false
			Customer customer = rentalComposite.getCustomer();
			
			if ( customer!= null)
			{
				// Question: Where do you suspect that this output file can be found?
				// 
				// Note: How about passing the name and location of the out file via -D property as well?
				output = new ObjectOutputStream (new FileOutputStream("RegisteredCustomer.out"));
				output.writeObject(customer);
			}
			else
				isRegisteredCustomer = false;
			
		} catch (IOException ioEcxp) 
		{ 
		  System.out.println ("RegistrationServiceImpl::registerCustomer - Unable to Register customer");
		  
          // Note: If determined that the Manager class can't really do much with this exception,
		  //       then alternate to throwing this exception is to just log the error and return, in this
		  //       case with a false.
		  //       
		  throw new RegistrationException("Unable to register customer", ioEcxp);
		}
		finally
		{
			if (output != null)
			{	
			   try {
				output.flush();
 			    output.close();
			   } catch (IOException e) {
				// Can't do much here if exceptions occur, other then logging
				e.printStackTrace();
			   }
		    }	
		}
		
		return isRegisteredCustomer;
	} //end RegisterCustomer

} // end class RegistrationServiceImpl 
