package com.virtusa.SkyScanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/** This is a model class.  
 * Here id is set as the primary key and is a auto generated value
 * Stores details of the tickets
 * */

@Entity
public class TicketDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	int flightNumber;
	int passengerCount;
	double price;
	String seats;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "TicketDetails [id=" + id + ", flightNumber=" + flightNumber + ", passengerCount=" + passengerCount
				+ ", price=" + price + "]";
	}
	public TicketDetails(int id, int flightNumber, int passengerCount, double price) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.passengerCount = passengerCount;
		this.price = price;
	}
	
	public TicketDetails() {}
}
