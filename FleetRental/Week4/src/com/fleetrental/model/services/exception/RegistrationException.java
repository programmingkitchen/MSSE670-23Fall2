/**
 * 
 */
package com.fleetrental.model.services.exception;

/**
 * @author mike.prasad
 *
 */
public class RegistrationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistrationException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
}
