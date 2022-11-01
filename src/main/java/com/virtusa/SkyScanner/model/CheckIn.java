package com.virtusa.SkyScanner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/** This is a model class.  
 * Here id is set as the primary key and is a auto generated value
 * Stores Check in details
 * */
@Entity
public class CheckIn {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	int ticketId;
	String seats;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public CheckIn(int ticketId, String seats) {
		super();
		this.ticketId = ticketId;
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "CheckIn [ticketId=" + ticketId + ", seats=" + seats + "]";
	}
	
	public CheckIn() {}
}
