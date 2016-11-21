package org.ezquerro.hibernate.exam04;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.ezquerro.hibernate.exam04.dao.FlightDAO;
import org.ezquerro.hibernate.exam04.models.Passenger;
import org.ezquerro.hibernate.exam04.models.Flight;

public class Main {

	public static void main(String[] args) {
		
		Flight flight = new Flight();
		flight.setName("Vuelo 1");
		flight.setDate(new Date(90,05,21));
		
		Passenger passenger1 = new Passenger();
		passenger1.setName("DAVID");
		passenger1.setPhone("948674546");
		Passenger passenger2 = new Passenger();
		passenger2.setName("ARITZ");
		passenger2.setPhone("948435236");
		
		
		flight.getPassengers().add(passenger1);
		flight.getPassengers().add(passenger2);
		
		FlightDAO flightDAO = new FlightDAO();
		
		flightDAO.insert(flight);
		Flight flightById = new Flight();
		flightById = flightDAO.selectById(1L);
		
			System.out.println(flightById.toString());
		}

	}

