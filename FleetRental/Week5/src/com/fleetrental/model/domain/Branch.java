package com.fleetrental.model.domain;

import java.io.Serializable;
import java.util.List;

public class Branch implements Serializable {

	private static final long serialVersionUID = 1L;

	Address address;
	List<Car> carList;
	AvailableRentals availableRentals;

	public Branch(Address address, List<Car> carList,
			AvailableRentals availableRentals) {
		this.address = address;
		this.carList = carList;
		this.availableRentals = availableRentals;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public AvailableRentals getAvailableRentals() {
		return availableRentals;
	}

	public void setAvailableRentals(AvailableRentals availableRentals) {
		this.availableRentals = availableRentals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime
				* result
				+ ((availableRentals == null) ? 0 : availableRentals.hashCode());
		result = prime * result + ((carList == null) ? 0 : carList.hashCode());
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
		Branch other = (Branch) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (availableRentals == null) {
			if (other.availableRentals != null)
				return false;
		} else if (!availableRentals.equals(other.availableRentals))
			return false;
		if (carList == null) {
			if (other.carList != null)
				return false;
		} else if (!carList.equals(other.carList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Branch [address=" + address + ", carList=" + carList
				+ ", availableRentals=" + availableRentals + "]";
	}

}
