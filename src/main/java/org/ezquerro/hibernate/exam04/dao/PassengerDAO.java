/**
 * 
 */
package org.ezquerro.hibernate.exam04.dao;

import java.util.List;

import org.ezquerro.hibernate.exam04.HibernateSession;
import org.ezquerro.hibernate.exam04.models.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PassengerDAO implements PassengerDAOInterface {


	public Passenger selectById(Long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Passenger passenger = (Passenger) session.get(Passenger.class, id);
	    
	    session.close();
	    return passenger;
	}


	public List<Passenger> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Passenger> passengers = session.createQuery("from Passenger").list();
	    
	    session.close();
	    return passengers;
	}

	
	public void insert(Passenger passenger) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	
	    session.persist(passenger);
	         
	    session.getTransaction().commit();
	    session.close();

	}


	public void update(Passenger passenger) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();	 
		    session.beginTransaction();
		 
		    session.merge(passenger);
		 
		    session.getTransaction().commit();
		    session.close();
	}


	public void delete(Passenger passenger) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();	    
	    session.beginTransaction();
	    
	    session.delete(passenger);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
