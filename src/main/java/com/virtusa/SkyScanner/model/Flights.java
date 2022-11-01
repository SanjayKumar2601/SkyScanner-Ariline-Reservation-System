package com.virtusa.SkyScanner.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/** This is a model class.  
 * Here id is set as the primary key and is a auto generated value
 * Stores details of the Flights
 * */
@Entity
public class Flights{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	private int flightnumber;
	private String departure;
	private String destination;
	private String starttime;
	private String endtime;
	private double price;
	private int seatcount=100;
	
	

	public Flights(){}
	
	


	@Override
	public String toString() {
		return "Flights [id=" + id + ", flightnumber=" + flightnumber + ", departure=" + departure + ", destination="
				+ destination + ", starttime=" + starttime + ", endtime=" + endtime + ", price=" + price
				+ ", seatcount=" + seatcount + "]";
	}



	public Flights(int id, int flightnumber, String departure, String destination, String starttime, String endtime,
			double price, int seatcount) {
		super();
		this.id = id;
		this.flightnumber = flightnumber;
		this.departure = departure;
		this.destination = destination;
		this.starttime = starttime;
		this.endtime = endtime;
		this.price = price;
		this.seatcount = seatcount;
	}

	




	public int getflightnumber() {
		return flightnumber;
	}

	public void setflightnumber(int flightnumber) {
		this.flightnumber = flightnumber;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getstarttime() {
		return starttime;
	}

	public void setstarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getendtime() {
		return endtime;
	}

	public void setendtime(String endtime) {
		this.endtime = endtime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getSeatcount() {
		return seatcount;
	}

	public void setSeatcount(int seatcount) {
		this.seatcount = seatcount;
	}
	
	
	
}
