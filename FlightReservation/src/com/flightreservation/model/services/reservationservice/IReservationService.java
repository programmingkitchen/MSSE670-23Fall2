package com.flightreservation.model.services.reservationservice;
import com.flightreservation.model.domain.*;
import com.flightreservation.model.services.IService;
import com.flightreservation.model.services.exception.ReservationException;

import java.util.ArrayList;

/**
 * 
 * Week 4: This now extends the newly created "IService".
 * 
 * Add a variable NAME so that the Registration Interface knows the name
 * by which it is called by the Factory. 
 *
 */
public interface IReservationService extends IService {
	
	public final String NAME = "IReservationService";
	
	// public ArrayList<Flight> listFlights(Composite composite) throws ReservationException ;
	public ArrayList<Flight> listFlights() throws ReservationException ;
	public ArrayList<Reservation> listReservations(Composite composite);
	public boolean bookReservation(Composite composite) throws ReservationException;
	public boolean cancelReservation(Composite composite);

}
