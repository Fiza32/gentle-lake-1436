package com.masaischool.dao;

import com.masaischool.entity.Flight;
import com.masaischool.exceptions.NoRecordFoundException;
import com.masaischool.exceptions.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class FlightDaoImpl implements FlightDao{

	@Override
	public void addFlight(Flight flight) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			//check if Flight with same name exists
			Query query = em.createQuery("SELECT count(f) FROM Flight f WHERE flightNumber = :flightNumber");
			query.setParameter("flightNumber", flight.getFlightNumber());
			if((Long)query.getSingleResult() > 0) {
				//you are here means Flight with given Number exists so throw exceptions
				throw new SomeThingWentWrongException("Flight already exists with this Number " + flight.getFlightNumber());
			}
			
			//you are here means no Flight with given Number
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(flight);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void updateFlight(Flight flight) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			//check if company with company with given id exists
			Flight flightFromDB = em.find(Flight.class, flight.getFlightNumber());
			if(flightFromDB == null)
				throw new NoRecordFoundException(flight.getFlightNumber());

			//You are here means company exists with given id
			//check if company is to be renamed
			if(!flightFromDB.getFlightNumber().equals(flight.getFlightNumber())) {
				//you are here means company is to be renamed, check for no existing company with new name.
				//check if company with same name exists
				Query query = em.createQuery("SELECT count(f) FROM Flight f WHERE flightNumber = :flightNumber");
				query.setParameter("flightNumber", flight.getFlightNumber());
				if((Long)query.getSingleResult() > 0) {
					//you are here means Flight with given Number exists so throw exceptions
					throw new SomeThingWentWrongException("Flight already exists with this Number " + flight.getFlightNumber());
				}
			}
			
			//proceed for update operation
			
			EntityTransaction et = em.getTransaction();
			et.begin();
//			flightFromDB.setCompanyName(flight.getCompanyName());
			flightFromDB.setDepartureTime(flight.getDepartureTime());
			flightFromDB.setArrivalTime(flight.getArrivalTime());
			flightFromDB.setPrice(flight.getPrice());
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

}
