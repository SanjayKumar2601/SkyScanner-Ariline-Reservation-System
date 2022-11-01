package com.virtusa.SkyScanner.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/** This is a model class.
 * Here id is set as the primary key and is a auto generated value 
 * Store search details
 * */

@Entity
public class BookFlights {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String trip;
	@Column(name="departure")
	String from;
	@Column(name="destination")
	String to;
	String date;
	int adultcount;
	int childrencount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrip() {
		return trip;
	}
	public void setTrip(String trip) {
		this.trip = trip;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAdultcount() {
		return adultcount;
	}
	public void setAdultcount(int adultcount) {
		this.adultcount = adultcount;
	}
	public int getChildrencount() {
		return childrencount;
	}
	public void setChildrencount(int childrencount) {
		this.childrencount = childrencount;
	}
	@Override
	public String toString() {
		return "BookFlights [id=" + id + ", trip=" + trip + ", from=" + from + ", to=" + to + ", date=" + date
				+ ", adultcount=" + adultcount + ", childrencount=" + childrencount + "]";
	}
	public BookFlights(int id, String trip, String from, String to, String date, int adultcount, int childrencount) {
		super();
		this.id = id;
		this.trip = trip;
		this.from = from;
		this.to = to;
		this.date = date;
		this.adultcount = adultcount;
		this.childrencount = childrencount;
	}
	
	public BookFlights() {}
	

	
	
	
}
