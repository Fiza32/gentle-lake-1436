package com.masaischool.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flight_id;
	
	@Column(name = "flight_number", nullable = false, unique = true)
    private String flightNumber;

//    @Column(name = "departure_city", nullable = false)
//    private String departureCity;
//
//    @Column(name = "destination_city", nullable = false)
//    private String destinationCity;
    
    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;
    
    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;
    
    @Column(name = "price", nullable = false)
    private double price;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(String flightNumber, LocalDateTime departureTime,
			LocalDateTime arrivalTime, double price) {
		super();
		this.flightNumber = flightNumber;
//		this.departureCity = departureCity;
//		this.destinationCity = destinationCity;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
/*
	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	
*/

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
     * import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// ...

public void setDepartureTimeFromUserInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter departure time (yyyy-MM-dd HH:mm): ");
    String userInput = scanner.nextLine();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    try {
        LocalDateTime departureTime = LocalDateTime.parse(userInput, formatter);
        this.departureTime = departureTime;
    } catch (DateTimeParseException e) {
        System.out.println("Invalid date format. Please enter the departure time in the format: yyyy-MM-dd HH:mm");
    }
}

     */
}
