package com.flightreservation.model.services.reservationservice;
import  com.flightreservation.model.services.exception.ReservationException;
import java.time.LocalDateTime;

/**
 * Week 4:  adding try/catch blocks.
 * 
 * There are a lot of ways to do this.  This example is different from the sample code, 
 * in that we are not doing something "risky" like loading info from a file.  
 * 
 * We have to throw the exception in the try in order to get to the catch.  This is necessary, because
 * we are not doing anything where Java would throw an exception, like trying to load a file. 
 *  
 */

import java.util.ArrayList;

import com.flightreservation.model.domain.Traveler;
import com.flightreservation.model.domain.Composite;
import com.flightreservation.model.domain.Flight;
import com.flightreservation.model.domain.Reservation;

public class ReservationServiceImpl implements IReservationService {

	/**
	 * In the Week 4 solution, we are just implementing this method, but
	 * all methods should be implemented once the first method is working. 
	 * 
	 */
	@Override
	// public ArrayList<Flight> listFlights(Composite composite) throws ReservationException {
	public ArrayList<Flight> listFlights() throws ReservationException {
		System.out.println("List Flights.");
		
		ArrayList<Flight> flightList = null;
		
		try {
			flightList = getFlights();
			
			// We will immediately throw an exception for null as an example, but in real life, 
			// there could be a case where "No Flights Available."  
			if (flightList == null) {
				throw new ReservationException("ERROR:  No flights available.");
			}
			
			// For testing the general catch Exception. 
			//flightList.get(100);
		
		} catch (Exception ex){
			throw new ReservationException("ERROR:  There was a problem with the ReservationService.", ex);
		} 
		
		return flightList;
	}

	@Override
	public ArrayList<Reservation> listReservations(Composite composite) {
		System.out.println("List Reservations.");
		return getReservations();
	}

	/**
	 * Not implemented with a collection yet, just returning a a String showing something 
	 * passed in.  Working with the collection is optional for now. 
	 */
	@Override
	public boolean bookReservation(Composite composite) throws ReservationException {
		ArrayList<Reservation> reservationList = new ArrayList<>();
		
		boolean isBooked = false; 
		try {
			System.out.println("INFO: ReservationServiceImpl::Booking Reservation");
			
			if (composite.getTraveler() == null) {
				throw new ReservationException("ERROR: ReservationServiceImpl::Traveler is null.");
			}
			
			if (composite.getFlight() == null) {
				throw new ReservationException("ERROR: ReservationServiceImpl::Flight is null.");
			}
			
			// Make the reservation and get the list using an "interface"
			//The underlying code in the private methods will change when we add a real database.
			reservationList = addReservation(composite);
			
			
			// DEBUG:   This shows if we made the "simulated reservation."  All this will change when we add a real database.
			for (Reservation reservation : reservationList) {
				System.out.println(reservation.toString());
			}
			
			isBooked = true;  // Success if we made it here.
			
		} catch (Exception ex){
			throw new ReservationException("ERROR:  ReservationServiceImpl::There was a problem with the ReservationService.", ex);
		} 
		
		return isBooked;
	}

	/**
	 * Not implemented with a collection yet, just returning a a String showing something 
	 * passed in.  Working with the collection is optional for now. 
	 */
	@Override
	public boolean cancelReservation(Composite composite) {
		System.out.println("Cancel Flight: " + composite.getReservation().getId());
		return false;
	}
	
	/**
	 * 
	 * (OPTIONAL) SIMULATOR DATABASE (TEMPORARY)  USING "PRIVATE HELPER METHODS."
	 * 
	 * TODO This is ok for now when we are just returning lists, but we need to think about a different way to do this 
	 * if we try to add/delete items from the collection, since the private helper methods only initialize 
	 * and return things (no parameters).
	 * 
	 * This is one way to do a "simulator database" so we can actually see the application working, before 
	 * we attach an actual database that is required for "real functionality," e.g. create, retrieve, update, delete.
	 * Updates are very difficult without a database so we won't worry about them.  
	 * 
	 * At this stage, we can focus on two use cases,
	 * (1) returning a collection with a list of things (Flights or Reservations) 
	 * (2) add/delete of items from the one of the collections, flightList or reservationList. 
	 *  
	 * @return ArrayList<Flight> Flight List
	 */
	private ArrayList<Flight> getFlights(){
		ArrayList<Flight> flightList = new ArrayList<>();
		Flight flight1 = new Flight(100,"Atlanta","New York",LocalDateTime.parse("2021-04-01T12:00"),LocalDateTime.parse("2021-04-01T14:00"),"Boeing 737 Max",170);
		Flight flight2 = new Flight(101,"New York","Atlanta",LocalDateTime.parse("2021-04-01T12:00"),LocalDateTime.parse("2021-04-01T14:00"),"Boeing 737 Max",170);
		Flight flight3 = new Flight(200,"Atlanta","New Orleans",LocalDateTime.parse("2021-04-01T12:00"),LocalDateTime.parse("2021-04-01T14:00"),"Airbus A320",150);
		Flight flight4 = new Flight(200,"New Orleans","Atlanta",LocalDateTime.parse("2021-04-01T12:00"),LocalDateTime.parse("2021-04-01T14:00"),"Airbus A320",150);
		
		flightList.add(flight1);
		flightList.add(flight2);
		flightList.add(flight3);
		flightList.add(flight4);
		
		return flightList;
		
	}
	
	/**
	 * A simulator for the database to be used until we get the DB.
	 * @return ArrayList<Reservation> Reservation List
	 */
	private ArrayList<Reservation> getReservations(){
		ArrayList<Reservation> reservationList = new ArrayList<>();
		
		Traveler traveler = new Traveler(1000, "John", "Coltrane", "trane@jazz.com");
		Flight flight = new Flight(100,"Atlanta","New York",LocalDateTime.parse("2021-04-01T12:00"),LocalDateTime.parse("2021-04-01T14:00"),"Boeing 737 Max",170);
		Reservation reservation = new Reservation(2000, LocalDateTime.now(), traveler, flight);
		reservationList.add(reservation);
		return reservationList;
	}
	
	
	private ArrayList<Reservation> addReservation(Composite composite){
		ArrayList<Reservation> reservationList = new ArrayList<>();
		reservationList = getReservations();
	
		Reservation reservation = new Reservation(3000, LocalDateTime.now(), composite.getTraveler(), composite.getFlight());
		
		reservationList.add(reservation);
		return reservationList;
	}
}
