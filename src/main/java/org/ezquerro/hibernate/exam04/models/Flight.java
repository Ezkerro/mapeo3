package org.ezquerro.hibernate.exam04.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private Date date;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idpassenger") // Nombre de la FK que se generará en la tabla de Book
	private List<Passenger> passengers = new ArrayList<Passenger>();

	public Flight(){
		
	}
	
	public Flight(String name, Date date){
		this.name = name;
		this.date = date;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}



	/**
	 * @return the passengers
	 */
	public List<Passenger> getPassengers() {
		return passengers;
	}



	/**
	 * @param passengers the passengers to set
	 */
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", date=" + date + ", passengers=" + passengers + "]";
	}
	
	

}
