/**
 * 
 */
package com.fleetrental.model.domain;

import java.io.Serializable;

/**
 * @author mike.prasad
 * 
 */

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7661657477853633935L;

	/** Customer last name */
	private String lastName;

	/** Customer first name */
	private String firstName;

	/** Customer email address */
	private String emailAddress;

	/** Customer password */
	private String password;

	/** Customer day phone */
	private String dayTimePhone;

	/** Customer evening phone */
	private String eveningTimePhone;

	/** Customer address */
	private Address address;

	private Itinerary itinerary;

	/**
	 * Copy Constructor
	 * 
	 * @param customer
	 *            a <code>Customer</code> object
	 */
	public Customer(String lastName, String firstName, String emailAddress,
			String password, String dayTimePhone, String eveningTimePhone,
			Address address, Itinerary itinerary) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.dayTimePhone = dayTimePhone;
		this.eveningTimePhone = eveningTimePhone;
		this.address = address;
		this.itinerary = itinerary;
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param emailAddress
	 */
	public Customer(String lastName, String firstName, String emailAddress,
			String password, String dayTimePhone, String eveningTimePhone) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.dayTimePhone = dayTimePhone;
		this.eveningTimePhone = eveningTimePhone;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dayTimePhone
	 */
	public String getDayTimePhone() {
		return dayTimePhone;
	}

	/**
	 * @param dayTimePhone
	 *            the dayTimePhone to set
	 */
	public void setDayTimePhone(String dayTimePhone) {
		this.dayTimePhone = dayTimePhone;
	}

	/**
	 * @return the eveningTimePhone
	 */
	public String getEveningTimePhone() {
		return eveningTimePhone;
	}

	/**
	 * @param eveningTimePhone
	 *            the eveningTimePhone to set
	 */
	public void setEveningTimePhone(String eveningTimePhone) {
		this.eveningTimePhone = eveningTimePhone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	public boolean validate() {
		if (lastName == null)
			return false;
		if (firstName == null)
			return false;
		if (emailAddress == null)
			return false;
		if (password == null)
			return false;
		if (dayTimePhone == null)
			return false;
		if (eveningTimePhone == null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((dayTimePhone == null) ? 0 : dayTimePhone.hashCode());
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime
				* result
				+ ((eveningTimePhone == null) ? 0 : eveningTimePhone.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((itinerary == null) ? 0 : itinerary.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dayTimePhone == null) {
			if (other.dayTimePhone != null)
				return false;
		} else if (!dayTimePhone.equals(other.dayTimePhone))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (eveningTimePhone == null) {
			if (other.eveningTimePhone != null)
				return false;
		} else if (!eveningTimePhone.equals(other.eveningTimePhone))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (itinerary == null) {
			if (other.itinerary != null)
				return false;
		} else if (!itinerary.equals(other.itinerary))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [lastName=" + lastName + ", firstName=" + firstName
				+ ", emailAddress=" + emailAddress + ", password=" + password
				+ ", dayTimePhone=" + dayTimePhone + ", eveningTimePhone="
				+ eveningTimePhone + ", address=" + address + ", itinerary="
				+ itinerary + "]";
	}

}
