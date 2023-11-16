package com.flightreservation.model.business.exception;

@SuppressWarnings("serial")
public class ServiceLoadException extends Exception {
	
	public ServiceLoadException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }

}
