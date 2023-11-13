/**
 * 
 */
package com.fleetrental.model.services.registrationservice;

import com.fleetrental.model.domain.RentalComposite;
import com.fleetrental.model.services.IService;
import com.fleetrental.model.services.exception.RegistrationException;

/**
 * @author mike.prasad
 *
 */
public interface IRegistrationService extends IService
{

	public final String NAME = "IRegistrationService";

	/** Register customer into our application 
	 * @throws RegistrationException */
	public boolean registerCustomer(RentalComposite rentalComposite) throws RegistrationException;

}
