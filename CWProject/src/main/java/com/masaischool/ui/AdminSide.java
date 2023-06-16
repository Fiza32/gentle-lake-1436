package com.masaischool.ui;

import java.util.Scanner;
/*
 * Role of Admin
1. Register for an admin account by providing necessary information.
2. Log in to the admin account using registered credentials.
3. Add new flights to the system, providing flight details such as flight number, departure,
and arrival times, and price.
4. Update flight information, including flight schedules and prices.
5. Remove flights from the system.
6. Generate reports on flight bookings, including the number of bookings and revenue
generated
7. Log out from the admin account.
*/




public class AdminSide {

	static void displayAdminMenu() {
		System.out.println("1. Add New Flight to the System: ");
		System.out.println("2. Update Flight Information: ");
		System.out.println("3. Remove Flight from the System: ");
		System.out.println("4. View Reports on Flight Bookings: ");
		System.out.println("5. View All Insurance Plan");
		System.out.println("6. Update Insurance Plan");
		System.out.println("7. Update premium for an age band of a plan");
		System.out.println("8. See List of all Customers");
		System.out.println("9. See policy reports");
		System.out.println("10. Make Policies Discountinued");
		System.out.println("0. Logout");
	}
	
	static void adminMenu(Scanner sc) {
		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				AdminUI.addFlight(sc);;
    				break;
    			case 2:
//    				AdminUI.viewCompanies();
    				break;
    			case 3:
//    				AdminUI.updateCompanyDetails(sc);
    				break;
    			case 4:
//    				AdminUI.addPlan(sc);
    				break;
    			case 5:
//    				AdminUI.viewPlan();
    				break;
    			case 6:
//    				AdminUI.updatePlan(sc);
    				break;
    			case 7:
//    				AdminUI.updatePremiumAndSurcharge(sc);
    				break;
    			case 8:
//    				AdminUI.viewAllCustomers();
    				break;
    			case 9:
//    				AdminUI.viewPolicyReport();
    				break;
    			case 10:
//    				AdminUI.makePoliciesDiscontinued();
    				break;
    			case 0:
    				System.out.println("Bye Bye Admin");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	
	static void adminLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		}else {
			System.out.println("Invalid Username or Password");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("1. Admin Login");
    		System.out.println("2. Customer Login");
    		System.out.println("3. Customer Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
//    				adminLogin(sc);
    				break;
    			case 2: 
//    				CustomerUI.userLogin(sc);
    				break;
    			case 3:
//    				CustomerUI.customerRegistration(sc);
    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
	}
}
