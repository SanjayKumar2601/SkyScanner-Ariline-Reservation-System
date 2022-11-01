package com.virtusa.SkyScanner.model;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/** This is a model class.  
 * Here id is set as the primary key and is a auto generated value
 * Stores details of the users
 * The table is connected to Booked Tickets table
 * */
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	String name;
	String email;
	String password;
	
	@OneToMany(targetEntity=BookedTickets.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="cp_fk",referencedColumnName="id")
	List<BookedTickets> tickets;

	public Users() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<BookedTickets> getTickets() {
		return tickets;
	}

	public void setTickets(List<BookedTickets> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", tickets="
				+ tickets + "]";
	}

	public Users(int id, String name, String email, String password, List<BookedTickets> tickets) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tickets = tickets;
	}
	

	public Users(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
}
