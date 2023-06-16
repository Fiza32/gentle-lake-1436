package com.masaischool.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.masaischool.entity.Flight;
import com.masaischool.exceptions.NoRecordFoundException;
import com.masaischool.exceptions.SomeThingWentWrongException;
import com.masaischool.service.FlightService;
import com.masaischool.service.FlightServiceImpl;

public class AdminUI {
	static void addFlight(Scanner sc) {
	    
	    System.out.println("Enter the flight details:");
	    System.out.print("Flight Number: ");
	    String flightNumber = sc.nextLine();
	    
	    System.out.print("Departure Time (yyyy-MM-dd HH:mm): ");
	    String departureTimeString = sc.nextLine();
	    LocalDateTime departureTime = LocalDateTime.parse(departureTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	    
	    System.out.print("Arrival Time (yyyy-MM-dd HH:mm): ");
	    String arrivalTimeString = sc.nextLine();
	    LocalDateTime arrivalTime = LocalDateTime.parse(arrivalTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	    
	    System.out.print("Price: ");
	    double price = sc.nextDouble();
	    /*
	     * Flight(String flightNumber, String departureCity, String destinationCity, LocalDateTime departureTime,
			LocalDateTime arrivalTime, double price)
	     */
	    // Create a new Flight object with the captured details
	    Flight newFlight = new Flight(flightNumber, departureTime, arrivalTime, price);
	    
	    // Create an object of Service Layer here
	    FlightService fService = new FlightServiceImpl();
	    try {
	    	fService.addFlight(newFlight);
	    	System.out.println("\nFlight details has been added successfully\n");
	    }catch(SomeThingWentWrongException se) {
	    	System.out.println(se.getMessage());
	    }
	    // Code to save the new flight to the database or perform any other necessary operations
	    // ...
	    sc.close();
	}
	
	public void updateFlightDetails(Scanner sc) throws NoRecordFoundException {

		System.out.println("Enter the flight details:");
	    System.out.print("Flight Number: ");
	    String flightNumber = sc.nextLine();
	    
	    System.out.print("Departure Time (yyyy-MM-dd HH:mm): ");
	    String departureTimeString = sc.nextLine();
	    LocalDateTime departureTime = LocalDateTime.parse(departureTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	    
	    System.out.print("Arrival Time (yyyy-MM-dd HH:mm): ");
	    String arrivalTimeString = sc.nextLine();
	    LocalDateTime arrivalTime = LocalDateTime.parse(arrivalTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	    
	    System.out.print("Price: ");
	    double price = sc.nextDouble();

	    // Create a new Flight object with the captured details
	    Flight newFlight = new Flight(flightNumber, departureTime, arrivalTime, price);
	    
	    // Create an object of Service Layer here
	    FlightService fService = new FlightServiceImpl();
	    
	    try {
	    	fService.updateFlight(newFlight);
	    	System.out.println("\nFlight details has been updated successfully\n");
	    }catch(SomeThingWentWrongException se) {
	    	System.out.println(se.getMessage());
	    }
	}
}
