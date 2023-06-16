package com.masaischool.dao;

import com.masaischool.entity.Flight;
import com.masaischool.exceptions.NoRecordFoundException;
import com.masaischool.exceptions.SomeThingWentWrongException;

public interface FlightDao {

	void addFlight(Flight flight) throws SomeThingWentWrongException;
	void updateFlight(Flight flight) throws SomeThingWentWrongException, NoRecordFoundException;
	
}
