package com.flightreservation.model.domain;
import java.util.ArrayList;

public class Composite {
	
	private Flight flight;
	private Reservation reservation;
	private Traveler traveler;
	private ArrayList<Flight> flightList;
	private ArrayList<Reservation> reservationList;
	
	// Constructor
	public Composite() {
	}

	// Getters
	public Flight getFlight() {
		return flight;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public Traveler getTraveler() {
		return traveler;
	}

	public ArrayList<Flight> getFlightList() {
		return flightList;
	}

	public ArrayList<Reservation> getReservationList() {
		return reservationList;
	}

	// Setters
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}

	public void setFlightList(ArrayList<Flight> flightList) {
		this.flightList = flightList;
	}

	public void setReservationList(ArrayList<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	
	// toString

	@Override
	public String toString() {
		return "Composite [flight=" + flight + ", reservation=" + reservation + ", traveler=" + traveler
				+ ", flightList=" + flightList + ", reservationList=" + reservationList + "]";
	}
	
}
