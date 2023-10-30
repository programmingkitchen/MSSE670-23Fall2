package com.fleetrental.model.domain;

import java.io.Serializable;

/**
 * Composite object that holds customer's information such as itinerary,
 * personal information and list of available rentedCar rentals.
 * 
 * This class also behaves as a shopping cart holding above information.
 * 
 * @author Mike.Prasad
 *
 */
public class RentalComposite implements Serializable
{
	
  /**
  * 
  */
  private static final long serialVersionUID = -334371602256955290L;

/** Holds information of the customer */
  private Customer customer; 
  
  /** Holds the list of Cars available for rental */
  private AvailableRentals availableRentals;
  
  /** Customer's itinerary */
  private Itinerary itinerary;
  
  /** Car chosen by customer to rent */
  private Car rentedCar;
  
  
	/**
	 * @param 
	 */
	public RentalComposite() {}

  	
	/**
	 * @return Returns the itinerary.
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary The itinerary to set.
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	/**
		 * @return Returns the availableRentals.
		 */
		public AvailableRentals getAvailableRentals() {
			return availableRentals;
		}

		/**
		 * @param availableRentals The availableRentals to set.
		 */
		public void setAvailableRentals(AvailableRentals availableRentals) {
			this.availableRentals = availableRentals;
		}

		/**
		 * @return Returns the customer.
		 */
		public Customer getCustomer() {
			return customer;
		}
		/**
		 * @param customer The customer to set.
		 */
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		
		/**
		 * @return Returns the rentedCar.
		 */
		public Car getRentedCar() {
			return rentedCar;
		}

		/**
		 * @param rentedCar The rentedCar to set.
		 */
		public void setRentedCar(Car car) {
			this.rentedCar = car;
		}
		

		public String toString()
		{
		  StringBuffer strBfr = new StringBuffer();
		  strBfr.append("\nCustomer Info :\n");
		  strBfr.append(customer);
		  strBfr.append("\n\nAvailable Rentals :\n");
		  strBfr.append(availableRentals);
		  strBfr.append("\n\nItinerary :\n");
		  strBfr.append(itinerary);
		  strBfr.append("\n\nRented Car :\n");
		  strBfr.append(rentedCar);
		
		  return strBfr.toString();
		}


} //end class RentalComposite