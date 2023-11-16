package com.flightreservation.model.domain;
import java.time.LocalDateTime;

/**
 * This class is similar to the Itinerary Class, but we will use this 
 * for storing reservations in the database.   
 *
 */

public class Reservation {
	private int id;
	private LocalDateTime date;
	private Traveler traveler;
	private Flight flight;
	
	// Constructors
	public Reservation() {
	}

	public Reservation(int id, LocalDateTime date, Traveler traveler, Flight flight) {
		this.id = id;
		this.date = date;
		this.traveler = traveler;
		this.flight = flight;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Traveler getTraveler() {
		return traveler;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	// Validate
	/**
	 * The following must not be null, id, lastName, firstName
	 * @return true if valid
	 */
	public boolean validate() {
		if (id == 0)
			return false;
		if (date == null)
			return false;
		if (traveler == null)
			return false;
		if (flight == null)
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", traveler=" + traveler + ", flight=" + flight + "]";
	}
	
}
