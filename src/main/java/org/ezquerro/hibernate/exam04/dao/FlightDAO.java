/**
 * 
 */
package org.ezquerro.hibernate.exam04.dao;

import java.util.List;

import org.ezquerro.hibernate.exam04.HibernateSession;
import org.ezquerro.hibernate.exam04.models.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class FlightDAO implements FlightDAOInterface {


	public Flight selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Flight flight = (Flight) session.get(Flight.class, id);
	    
	    session.close();
	    return flight;
	}


	public List<Flight> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Flight> flights = session.createQuery("from Flight").list();
	    
	    session.close();
	    return flights;
	}

	
	public void insert(Flight flight) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.persist(flight);    
	    
	    session.getTransaction().commit();	         
	    session.close();

	}

	
	public void update(Flight flight) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(flight); 
		    
		    session.getTransaction().commit();		 
		    session.close();
	}


	public void delete(Flight flight) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(flight);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
