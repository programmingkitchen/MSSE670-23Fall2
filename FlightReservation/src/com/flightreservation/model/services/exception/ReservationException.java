package com.flightreservation.model.services.exception;

/**
 *
 * We add a new constructor so we can pass a String only.  We need this for 
 * our existing throw in the try block (since there is no Java exception, that
 * we could be potentially triggering.
 * 
 * @author Randall Granier
 *
 */
public class ReservationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ReservationException(final String inMessage)
    {
        super(inMessage);
    }

	
	public ReservationException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }

}
