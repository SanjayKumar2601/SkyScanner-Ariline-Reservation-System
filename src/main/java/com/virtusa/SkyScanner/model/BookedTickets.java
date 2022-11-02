package com.virtusa.SkyScanner.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.NoArgsConstructor;


/** This is a model class.
 * Here payment status is set to default("Yet To Complete Payment")  
 * Here id is set as the primary key and is a auto generated value
 * The table is connected to users
 * Stores the booked ticket details
 * */
@Entity
public class BookedTickets {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int tid;
	
	
	int flightnumber;
	int adultcount;
	int childrencount;
	double price;
	String paymentstatus="Yet To Complete Payment";
	String seats;
	
	@ManyToOne
	Users u;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(int flightnumber) {
		this.flightnumber = flightnumber;
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

	public Users getU() {
		return u;
	}

	public void setU(Users u) {
		this.u = u;
	}

	
	
	public BookedTickets(int tid, int flightnumber, int adultcount, int childrencount,String seats,Users u) {
		super();
		this.tid = tid;
		this.flightnumber = flightnumber;
		this.adultcount = adultcount;
		this.childrencount = childrencount;
		this.seats=seats;
		this.u=u;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}






	@Override
	public String toString() {
		return "BookedTickets [tid=" + tid + ", flightnumber=" + flightnumber + ", adultcount=" + adultcount
				+ ", childrencount=" + childrencount + ", price=" + price + ", paymentstatus=" + paymentstatus
				+ ", seats=" + seats + ", u=" + u + "]";
	}

	public BookedTickets(int tid, int flightnumber, int adultcount, int childrencount, double price,
			String paymentstatus, String seats, Users u) {
		super();
		this.tid = tid;
		this.flightnumber = flightnumber;
		this.adultcount = adultcount;
		this.childrencount = childrencount;
		this.price = price;
		this.paymentstatus = paymentstatus;
		this.seats = seats;
		this.u = u;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public BookedTickets() {}

	
}
