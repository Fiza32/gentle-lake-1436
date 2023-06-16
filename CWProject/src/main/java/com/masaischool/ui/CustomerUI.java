package com.masaischool.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masaischool.entity.Customer;
import com.masaischool.entity.LoggedInUserId;
import com.masaischool.exceptions.NoRecordFoundException;
import com.masaischool.exceptions.SomeThingWentWrongException;
import com.masaischool.service.CustomerService;
import com.masaischool.service.CustomerServiceImpl;



public class CustomerUI {
	static void customerRegistration(Scanner sc) {
		//Information required for Customer Registration
		System.out.print("Enter Your Name ");
		String name = sc.next();
		
		System.out.print("Enter Your Email Address ");
		String email = sc.next();
		
		System.out.print("Enter date of birth ");
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
		
		System.out.print("Enter Username: ");
		String username = sc.next();
		
		System.out.print("Enter password ");
		String password = sc.next();
		
		//Create an object of customer
		Customer customer = new Customer(name, email, dateOfBirth, username, password, null);
		
		try {
			//Create an object of CustomerService
			CustomerService customerService = new CustomerServiceImpl();
			customerService.addCustomer(customer);
			System.out.println("Customer added successfully");
		}catch(SomeThingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	/*
	 * Role of Customer/Traveler
	1. Register for a customer account by providing necessary information.
	2. Log in to the customer account using registered credentials.
	3. Search for available flights based on criteria such as departure city, destination, dates,
	and passenger count.
	4. View flight options, including schedules, prices, and available seat inventory.
	5. Filter flight options based on preferences such as price range, departure time.
	6. Select desired flights and provide passenger details for booking.
	7. Proceed with the booking process to confirm the flight reservation.
	8. Receive confirmation of the booking.
	9. View their bookings
	10. Cancel bookings
	11. Log out from the customer account.

	 */
	static void displayCustomerMenu() {
		System.out.println("1. Search Flights: ");
		System.out.println("2. View Flights: ");
		System.out.println("3. Filter Flights (by price range, departure time)");
		System.out.println("4. Book a Flight: ");
		System.out.println("5. View Your Booking Details: ");
		System.out.println("5. Cancle Your Flight Booking: ");
		System.out.println("6. Change Password");
		System.out.println("7. Delete Account");
		System.out.println("0. Logout");
	}
	
	static void userMenu(Scanner sc) {
		int choice = 0;
		do {
			displayCustomerMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				//this code is same as we have used on the admin side
    				//so we are using here as it is
    				break;
    			case 2:
    				break;
    			case 3:
    				//code to purchase a new policy
    				break;
    			case 4:
    				//code to view policies purchased by logged in user
    				break;
    			case 5:
    				break;
    			case 6:
    				changePassword(sc);
    				break;
    			case 7:
    				deleteAccount(sc);
    				System.out.println("Logging you out");
    				choice = 0;
    			case 0:
    				LoggedInUserId.loggedInUserId = -1;	//-1 id cannot belong to any customer
    				System.out.println("Bye Bye User");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
	}
	
	static void userLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.login(username, password);
			userMenu(sc);
		}catch(NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void changePassword(Scanner sc) {
		System.out.print("Enter old password ");
		String oldPassword = sc.next();
		System.out.print("Enter new password ");
		String newPassword = sc.next();
		System.out.print("Re-Enter new password ");
		String reEnterNewPassword = sc.next();
		
		//Check if new password is correct
		if(!newPassword.equals(reEnterNewPassword)) {
			System.out.println("New password and Re-Entered password mismtached");
			return;
		}else if(newPassword.equals(oldPassword)) {
			System.out.println("New password and old password must be different");
			return;
		}
		
		try {
			CustomerService customerService = new CustomerServiceImpl();
			customerService.changePassword(oldPassword, reEnterNewPassword);
			System.out.println("Password updated");
		}catch(SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void deleteAccount(Scanner sc) {
		System.out.print("Are you sure you want to delete your account?[y/n] ");
		char choice = sc.next().toLowerCase().charAt(0);
		if(choice == 'y') {
			try {
				CustomerService customerService = new CustomerServiceImpl();
				customerService.deleteAccount();
				System.out.println("Its really sad to see you go, As per your request account is deleted");			
			}catch(SomeThingWentWrongException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
}
