package org.ezquerro.hibernate.exam04.dao;

import java.util.List;

import org.ezquerro.hibernate.exam04.models.Passenger;


public interface PassengerDAOInterface {
	
	public Passenger selectById(Long id);
	public List<Passenger> selectAll ();
	public void insert (Passenger passenger);
	public void update (Passenger passenger);
	public void delete (Passenger passenger);

}
