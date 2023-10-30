package com.fleetrental.model.domain;

import java.io.Serializable;
import java.util.Calendar;


public class Itinerary implements Serializable
{

  /**
  * 
  */
  private static final long serialVersionUID = 1139378081831306791L;

/** Pickup City Id */
  private String fleetRentalPickUpCityId; 

  /** Pickup City */
  private String fleetRentalPickUpCity; 

  /** Return City Id */
  private String fleetRentalDropOffCityId;

  /** Return City */
  private String fleetRentalDropOffCity;

  /** Pick-up Date */
  private String pickUpMonth;
  private String pickUpDay;
  private String pickUpYear;
  
  /** Pick-up Time */
  private String pickUpTime;
  
  /** Drop-off Date */
  private String dropOffMonth;
  private String dropOffDay;
  private String dropOffYear;
  
  /** Drop-off Time */
  private String dropOffTime;

  /** */ 
  private int qtyRentalDays = 0;
  
	/**
	 *
	 */
	public Itinerary() {

		// TODO Auto-generated constructor stub
	}


    public Itinerary(String fleetRentalPickUp, 
			         String fleetRentalDropOff,
			         String pickUpMonth,
			         String pickUpDay,
			         String pickUpYear,
			         String pickUpTime,
			         String dropOffMonth,
			         String dropOffDay, 
			         String dropOffYear,
			         String dropOffTime)
	{
		   this.fleetRentalPickUpCity = fleetRentalPickUp;
		   this.fleetRentalDropOffCity = fleetRentalDropOff;
		   this.pickUpMonth = pickUpMonth;
		   this.pickUpDay = pickUpDay;
		   this.pickUpYear = pickUpYear;
		   this.pickUpTime = pickUpTime;
		   this.dropOffMonth = dropOffMonth;
		   this.dropOffDay = dropOffDay;
		   this.dropOffYear = dropOffYear;
		   this.dropOffTime = dropOffTime;
		   
		   // determine qty of rental days by using Calendar class.		   
		   Calendar pickUpCalendar = Calendar.getInstance();
		   
		   // -1 from pickUpMonth since Calendar is 0 based (Jan is 0)
		   pickUpCalendar.set(Integer.parseInt(pickUpYear), 
				              (Integer.parseInt(pickUpMonth)-1), 
							  Integer.parseInt(pickUpDay));

		   Calendar dropOffCalendar = Calendar.getInstance();
		   
		   // -1 from pickUpMonth since Calendar is 0 based (Jan is 0)
		   dropOffCalendar.set(Integer.parseInt(dropOffYear), 
				              (Integer.parseInt(dropOffMonth)-1), 
							  Integer.parseInt(dropOffDay));

		   // convert pickUp and dropOff dates into milli seconds,
		   // so we can determine the qty of rental days.
		   long diffDayMillis =   dropOffCalendar.getTimeInMillis() 
		                        - pickUpCalendar.getTimeInMillis();		   

		   // divide by milli seconds in a day (24*60*60*1000)
		   qtyRentalDays = (int)(diffDayMillis/86400000);
		   
		   
	}

	/**
	 * @return Returns the dropOffDay.
	 */
	public String getDropOffDay() {
		return dropOffDay;
	}


	/**
	 * @return Returns the dropOffMonth.
	 */
	public String getDropOffMonth() {
		return dropOffMonth;
	}


	/**
	 * @return Returns the dropOffTime.
	 */
	public String getDropOffTime() {
		return dropOffTime;
	}


	/**
	 * @return Returns the dropOffYear.
	 */
	public String getDropOffYear() {
		return dropOffYear;
	}


	/**
	 * @return Returns the fleetRentalDropOff.
	 */
	public String getFleetRentalDropOffCityId() {
		return fleetRentalDropOffCityId;
	}


	/**
	 * @return Returns the fleetRentalDropOffCity.
	 */
	public String getFleetRentalDropOffCity() {
		return fleetRentalDropOffCity;
	}


	/**
	 * @param fleetRentalDropOffCity The fleetRentalDropOffCity to set.
	 */
	public void setFleetRentalDropOffCity(String fleetRentalDropOffCity) {
		this.fleetRentalDropOffCity = fleetRentalDropOffCity;
	}


	/**
	 * @param fleetRentalPickUpCity The fleetRentalPickUpCity to set.
	 */
	public void setFleetRentalPickUpCity(String fleetRentalPickUpCity) {
		this.fleetRentalPickUpCity = fleetRentalPickUpCity;
	}


	/**
	 * @return Returns the fleetRentalPickUp.
	 */
	public String getFleetRentalPickUpCityId() {
		return fleetRentalPickUpCityId;
	}


	/**
	 * @return Returns the fleetRentalPickUpCity.
	 */
	public String getFleetRentalPickUpCity() {
		return fleetRentalPickUpCity;
	}


	/**
	 * @return Returns the pickUpDay.
	 */
	public String getPickUpDay() {
		return pickUpDay;
	}


	/**
	 * @return Returns the pickUpMonth.
	 */
	public String getPickUpMonth() {
		return pickUpMonth;
	}


	/**
	 * @return Returns the pickUpTime.
	 */
	public String getPickUpTime() {
		return pickUpTime;
	}


	/**
	 * @return Returns the pickUpYear.
	 */
	public String getPickUpYear() {
		return pickUpYear;
	}


	/**
	 * @return Returns the qtyRentalDays.
	 */
	public int getQtyRentalDays() {
		return qtyRentalDays;
	}

	/**
	 * Auto generated - 
	 * Alt+Shift+S and select 'Generate hashcode() and equals()...' 
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dropOffDay == null) ? 0 : dropOffDay.hashCode());
		result = prime * result
				+ ((dropOffMonth == null) ? 0 : dropOffMonth.hashCode());
		result = prime * result
				+ ((dropOffTime == null) ? 0 : dropOffTime.hashCode());
		result = prime * result
				+ ((dropOffYear == null) ? 0 : dropOffYear.hashCode());
		result = prime
				* result
				+ ((fleetRentalDropOffCity == null) ? 0
						: fleetRentalDropOffCity.hashCode());
		result = prime
				* result
				+ ((fleetRentalDropOffCityId == null) ? 0
						: fleetRentalDropOffCityId.hashCode());
		result = prime
				* result
				+ ((fleetRentalPickUpCity == null) ? 0 : fleetRentalPickUpCity
						.hashCode());
		result = prime
				* result
				+ ((fleetRentalPickUpCityId == null) ? 0
						: fleetRentalPickUpCityId.hashCode());
		result = prime * result
				+ ((pickUpDay == null) ? 0 : pickUpDay.hashCode());
		result = prime * result
				+ ((pickUpMonth == null) ? 0 : pickUpMonth.hashCode());
		result = prime * result
				+ ((pickUpTime == null) ? 0 : pickUpTime.hashCode());
		result = prime * result
				+ ((pickUpYear == null) ? 0 : pickUpYear.hashCode());
		result = prime * result + qtyRentalDays;
		return result;
	}

	/**
	 * Auto generated - 
	 * Alt+Shift+S and select 'Generate hashcode() and equals()...' 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Itinerary other = (Itinerary) obj;
		if (dropOffDay == null) {
			if (other.dropOffDay != null)
				return false;
		} else if (!dropOffDay.equals(other.dropOffDay))
			return false;
		if (dropOffMonth == null) {
			if (other.dropOffMonth != null)
				return false;
		} else if (!dropOffMonth.equals(other.dropOffMonth))
			return false;
		if (dropOffTime == null) {
			if (other.dropOffTime != null)
				return false;
		} else if (!dropOffTime.equals(other.dropOffTime))
			return false;
		if (dropOffYear == null) {
			if (other.dropOffYear != null)
				return false;
		} else if (!dropOffYear.equals(other.dropOffYear))
			return false;
		if (fleetRentalDropOffCity == null) {
			if (other.fleetRentalDropOffCity != null)
				return false;
		} else if (!fleetRentalDropOffCity.equals(other.fleetRentalDropOffCity))
			return false;
		if (fleetRentalDropOffCityId == null) {
			if (other.fleetRentalDropOffCityId != null)
				return false;
		} else if (!fleetRentalDropOffCityId
				.equals(other.fleetRentalDropOffCityId))
			return false;
		if (fleetRentalPickUpCity == null) {
			if (other.fleetRentalPickUpCity != null)
				return false;
		} else if (!fleetRentalPickUpCity.equals(other.fleetRentalPickUpCity))
			return false;
		if (fleetRentalPickUpCityId == null) {
			if (other.fleetRentalPickUpCityId != null)
				return false;
		} else if (!fleetRentalPickUpCityId
				.equals(other.fleetRentalPickUpCityId))
			return false;
		if (pickUpDay == null) {
			if (other.pickUpDay != null)
				return false;
		} else if (!pickUpDay.equals(other.pickUpDay))
			return false;
		if (pickUpMonth == null) {
			if (other.pickUpMonth != null)
				return false;
		} else if (!pickUpMonth.equals(other.pickUpMonth))
			return false;
		if (pickUpTime == null) {
			if (other.pickUpTime != null)
				return false;
		} else if (!pickUpTime.equals(other.pickUpTime))
			return false;
		if (pickUpYear == null) {
			if (other.pickUpYear != null)
				return false;
		} else if (!pickUpYear.equals(other.pickUpYear))
			return false;
		if (qtyRentalDays != other.qtyRentalDays)
			return false;
		return true;
	}

	public String toString()
	{
	  StringBuffer strBfr = new StringBuffer();
	  strBfr.append ("fleetRentalPickUp Id:");
	  strBfr.append (fleetRentalPickUpCityId);
	  strBfr.append ("\nfleetRentalPickUp City:");
	  strBfr.append (fleetRentalPickUpCity);
	  strBfr.append ("\nfleetRentalDropOff Id:");
	  strBfr.append (fleetRentalDropOffCityId);
	  strBfr.append ("\nfleetRentalDropOff City:");
	  strBfr.append (fleetRentalDropOffCity);
	  strBfr.append ("\npickUpMonth :");
	  strBfr.append (pickUpMonth);
	  strBfr.append ("\npickUpDay :");
	  strBfr.append (pickUpDay);
	  strBfr.append ("\npickUpYear :");
	  strBfr.append (pickUpYear);
	  strBfr.append ("\npickUpTime :");
	  strBfr.append (pickUpTime);
	  strBfr.append ("\ndropOffMonth :");
	  strBfr.append (dropOffMonth);
	  strBfr.append ("\ndropOffDay :");
	  strBfr.append (dropOffDay);
	  strBfr.append ("\ndropOffYear :");
	  strBfr.append (dropOffYear);
	  strBfr.append ("\ndropOffTime :");
	  strBfr.append (dropOffTime);
	  strBfr.append ("\nqtyRentalDays :");
	  strBfr.append (qtyRentalDays);
	
	  return strBfr.toString();
	}
} //end Itinerary