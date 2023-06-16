package com.masaischool.service;

import com.masaischool.dao.FlightDao;
import com.masaischool.dao.FlightDaoImpl;
import com.masaischool.entity.Flight;
import com.masaischool.exceptions.NoRecordFoundException;
import com.masaischool.exceptions.SomeThingWentWrongException;

public class FlightServiceImpl implements FlightService{

	@Override
	public void addFlight(Flight flight) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		FlightDao fDao = new FlightDaoImpl();
		fDao.addFlight(flight);
	}

	@Override
	public void updateFlight(Flight flight) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		FlightDao fDao = new FlightDaoImpl();
		fDao.updateFlight(flight);
	}

}
