package com.flightreservation.ui;
import java.util.List;
import java.time.LocalDateTime;

import com.flightreservation.model.business.manager.*;
import com.flightreservation.model.services.factory.ServiceFactory;
import com.flightreservation.model.services.reservationservice.IReservationService;
import com.flightreservation.model.domain.*;
import com.flightreservation.model.business.exception.*;
import com.flightreservation.model.services.exception.ReservationException;

/**
 * We need to pass in the app.properties file using the -D option.  We configure this in:
 * 
 * Run As (right click on project > 
 * Run Configurations (select from menu) > 
 * Arguments (tab of new window) > 
 * VM Arguments (bottom window)
 * 
 * FULL ARGUMENT (PUT THIS IN THE BOX AFTER CHANGING PATH)
 * WARNING:  follow this format exactly, no spaces anywhere. 
 * -Dprop_location:prop_location=C:\Users\rgran\Dropbox\ECLIPSE-WORKSPACE\MSSE670-AIRLINE-RESERVATION\AirlineReservation\config\application.properties
 *
 * -Dprop_location=D:\Dropbox\JAVA-MSSE670\WORKSPACE\AirlineReservation\config\application.properties
 *
 * In IntelliJ
 * Click the 3 dots next to the arrow and the bug.
 * "Add VM Properties"
 * Put the path below that.
 *
 * @author Randall Granier
 *
 */

public class RunApp {
	
	/**
	 * Changed the old "ServiceFactory" to "SimpleServiceFactory."   We still have both options.
	 * The newly renamed SimpleServiceFactory was called with the following code:
	 * 
	 * SimpleServiceFactory factory = new SimpleServiceFactory();
	 * IReservationService reservation = factory.getReservationService();
	 *
	 * @param args
	 */

/**
	public static void main(String[] args) {
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		//IReservationService reservation;
		IReservationService reservation;
		
		//
		// USE THIS APPROACH OF CASTING TO AN INTERFACE
		//
		// Here we are casting Factory output to ILoginService, which
		// means that loginService will only see methods declared in
		// the interface and implemented by LoginServiceImpl
		//
		try {
			//reservation = (IReservationService) serviceFactory.getService(IReservationService.NAME);
			reservation = (IReservationService) serviceFactory.getService(IReservationService.NAME);
			
			List<Flight> flightList = reservation.listFlights();
			
			//System.out.println(flightList);
			
			for (Flight flight : flightList) {
				System.out.println("Flight ID: " + flight.getId());
				System.out.println("Origin Airport: " + flight.getOriginAirport() + "\t\tDeparture Time: " + flight.getDepartureTime());
				System.out.println("Destination Airport: " + flight.getOriginAirport() + "\t\tArrival Time: " + flight.getArrivalTime());
			}
			
			// reservation.reserveFlight(100);
			
		} catch (ServiceLoadException ex) {
			ex.printStackTrace();
		} catch (ReservationException ex) {
			ex.printStackTrace();
		}

	}  // end main
**/

public static void main(String[] args) {

	String message = "";
	FlightReservationManager manager = FlightReservationManager.getInstance();

	Traveler traveler = new Traveler(2000, "Miles", "Davis", "miles@jazz.com");
	Flight flight = new Flight(200, "New York", "Los Angeles",
			LocalDateTime.parse("2021-04-15T12:00"),
			LocalDateTime.parse("2021-04-15T14:00"),
			"Airbus A320", 150);

	Composite composite = new Composite();
	composite.setTraveler(traveler);
	composite.setFlight(flight);

	//composite.setTraveler(null);;

	boolean isBooked = manager.performAction("BOOKRESERVATION", composite);

	// Ignore the weird code in the sample code, which does the same thing as this.   It's a Java short cut.
	if (isBooked) {
		message = "SUCCESS:  FlightReservationMain:: - Traveler resistered.";
	} else {
		message = "FAIL:  FlightReservationMain:: - Traveler not registered.";
	}

	System.out.println(message);





} // end main



} // end class RunApp
