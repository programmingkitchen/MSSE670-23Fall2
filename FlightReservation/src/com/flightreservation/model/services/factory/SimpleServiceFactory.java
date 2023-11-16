package com.flightreservation.model.services.factory;
import com.flightreservation.model.services.reservationservice.IReservationService;
import com.flightreservation.model.services.reservationservice.ReservationServiceImpl;

/**
 * Simple service factory that will be improved in later versions.
 * 
 * @author rgran
 *
 */

public class SimpleServiceFactory {
	
	public IReservationService getReservationService() {
		return new ReservationServiceImpl();
	}

}
