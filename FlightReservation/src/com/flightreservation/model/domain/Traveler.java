package com.flightreservation.model.domain;

public class Traveler {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String streetAddress;
	private String city;
	private String state;
	private int zip;
	
	
	// Constructors
	public Traveler() {
	}

	public Traveler(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Traveler(int id, String firstName, String lastName, String email, String phone, String streetAddress,
			String city, String state, int zip) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZip() {
		return zip;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	

	// Validate
	/**
	 * The following must not be null, id, lastName, firstName
	 * @return true if valid
	 */
	public boolean validate() {
		if (id == 0)
			return false;
		if (lastName == null)
			return false;
		if (firstName == null)
			return false;
		if (email == null)
			return false;
		return true;
	}
	
	// toString
	@Override
	public String toString() {
		return "Traveler [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + "]";
	}

}
