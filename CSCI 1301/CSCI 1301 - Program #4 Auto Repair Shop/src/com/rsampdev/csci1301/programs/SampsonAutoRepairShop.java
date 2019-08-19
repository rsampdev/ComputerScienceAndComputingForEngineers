package com.rsampdev.csci1301.programs;

import java.util.Scanner;

/* Rodney Sampson II
 * CSCI 1301
 * Program Four - Auto Repair Shop
 * 
 * This command-line program follows the program specifications below:
 * 
 * You are writing a program for an auto maintenance shop.
 * The shop performs routine maintenance on cars.
 * Do not perform input validation with this program!
 * 
 * In main, ask the user what make of automobile they own.
 * 		Store this data in a string.   
 * 
 * Your first method should take the make via parameter and present the user with the following greeting:
 * 		Hello!  We will be happy to service your <insert name> automobile today!
 * 
 * Write a second method named carMaintenance.
 * 		It should take in the make via parameter and return the price to Main.
 * 		Create two local arrays: services and prices.
 * 			One will hold these strings: Oil Change, Tire Rotation, Air Filter, Check Fluids
 * 			The second will hold these doubles: 39.99, 49.99, 19.99, 10.99
 * 		Loop through the services array and ask the user which services he wants for his <insert make>.
 * 			Make sure you display the price along with the service.
 * 			Use an accumulator to total the price for all requested services, using the prices array.
 * 		Return the price to Main.
 * 
 * Write a third method name finalPrice that takes in the price from Main.
 * 		First, tack on 30% for labor to the price.
 * 		Then, ask if the car is an import.
 * 		If the answer is yes, add another 5% to the price.
 * 		Add 7% sales tax.
 * 		Display the total price to the user from this method.
 * 
 */

public class SampsonAutoRepairShop {

	public static void main(String[] args) {
		// Create a scanner object to get console input from the user.
		Scanner console = new Scanner(System.in);

		System.out.println("What is the make of your automobile?");

		// Store the user's car make.
		String carMake = console.nextLine();
		
		// Greet the user.
		carGreeting(carMake);

		// Calculate the base price of the maintenance
		double basePrice = carMaintenance(carMake, console);

		// Calculate and present the final post-tax price of the maintenance.
		finalPrice(basePrice, carMake, console);

		// Close the scanner object to prevent resource leak.
		console.close();
	}
	
	// A simple method to greet the user using the make of their car.
	static void carGreeting(String carMake) {
		System.out.println("Hello! We will be happy to service your " + carMake + " automobile today!");
	}
	
	static double carMaintenance(String carMake, Scanner input) {
		// Parallel arrays for services and their prices.
		String[] services = new String[] { "Oil Change", "Tire Rotation", "Air Filter", "Check Fluids" };
		double[] prices = new double[] { 39.99, 49.99, 19.99, 10.99 };

		// An accumulator for the price.
		double price = 0;

		// Loop through the services array and ask the user if they want the service performed.
		for (int index = 0; index < services.length; index++) {
			// Name and price of the current service.
			String service = services[index];
			double servicePrice = prices[index];
			
			// Ask the user if they want the current service performed.
			String query = String.format("Enter \'yes\' if you want the displayed service performed on your %s: %s for $%,.2f.", carMake, service, servicePrice);
			System.out.println(query);

			String response = input.nextLine();

			// Increment the price accumulator with the cost of the service if the user wants that service performed.
			if (response.equalsIgnoreCase("yes")) {
				price += prices[index];
			}
			
			// Print out to the user the current running total of the pre-tax price of the maintenance.
			String message = String.format("The current pre-tax total price for the maintenance on your %s is: $%,.2f.", carMake, price);
			System.out.println(message);
		}

		return price;
	}
	
	static void finalPrice(double basePrice, String carMake, Scanner input) {
		// Base labor tax.
		double tax = 1.3;
		
		System.out.println("Is your " + carMake + " an import?");
		String isImport = input.nextLine();

		// Apply import tax if the car is an import.
		if (isImport.equalsIgnoreCase("yes")) {
			tax += 0.05;
		}
		
		// Apply sales tax.
		tax += 0.07;
		
		// Apply the accumulated tax to the base price.
		double finalPrice = basePrice * tax;
		
		// Formatted string for the price and tax of the maintenance.
		String formattedPreTaxPrice = String.format("The total pre-tax price for the maintenance on your %s is: $%,.2f.", carMake, basePrice);
		String formattedFinalPrice = String.format("The total post-tax price for your car maintenance is: $%,.2f.", finalPrice);
		String formattedTax = String.format("The total tax on the maintenance on your %s is: $%,.2f.", carMake, (finalPrice - basePrice));

		// Print out the formatted strings.
		System.out.println(formattedPreTaxPrice);
		System.out.println(formattedFinalPrice);
		System.out.println(formattedTax);
	}

}
