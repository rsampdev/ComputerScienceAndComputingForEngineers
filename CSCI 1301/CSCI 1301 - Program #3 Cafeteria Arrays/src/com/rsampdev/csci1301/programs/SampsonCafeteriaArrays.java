package com.rsampdev.csci1301.programs;

import javax.swing.JOptionPane;

/* Rodney Sampson II
 * CSCI 1301
 * Program Three - Cafeteria Arrays
 * 
 * This program is an implementation of the following program specifications listed below:
 *	- Create an array of Strings and populate it with the days of the week (M-F).
 *	- Create a parallel array to store the entrees - you do not have this information.
 *		- You'll need to write a loop that asks the user what entree is stored on each day.
 *		- Your request from the user should indicate the day for which you are asking for info.
 *		- (e.g. "What entree is being served on Monday?")
 *	- Create a third parallel array that stores the prices.
 *		- You will also need to collect this from the user.
 *	- Write a loop that allows the user to input an entree.
 *		- Search for this entree, and tell the user on what day that entree will be served.
 *	- Write a loop that finds the highest-priced item.
 *		- Output the name of the item for the user.
 * 
 * */

public class SampsonCafeteriaArrays {

	public static void main(String[] args) {
		// An array of days in the weeks used to ask for the names of entrees and their prices.
		String[] daysOfTheWeek = new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		
		// The standard length used for array storage and iteration.
		final int NUM_DAYS_IN_WEEK = daysOfTheWeek.length;

		// The arrays used to store the entrees names and their prices parallel to the days of the week. 
		String[] entrees = new String[NUM_DAYS_IN_WEEK];
		double[] prices = new double[NUM_DAYS_IN_WEEK];

		// A boolean value used to keep track of when a task is done.
		boolean isDone = false;
		
		// A welcome string to inform the user of this program's capabilities.
		String welcome = "Hello, user.\n \n"
					   + "Enter the name and price of each entree served on each day.\n \n"
					   + "Then enter the name of the entree you'd like to eat.\n \n"
					   + "Click 'OK' to get started.";
		
		// Welcoming the user to the program using the welcome string.
		JOptionPane.showMessageDialog(null, welcome);
		
		// A for loop used to try to ask the user what entree is served on each day and the price for that entree.
		for (int index = 0; index < NUM_DAYS_IN_WEEK; index++) {
			try {
				// Asks the user for the name of the entree served on that day.
				// Initializes the user response to an empty string if the user response is null and the cancel button was not clicked.
				String response = JOptionPane.showInputDialog("What entree is being served on " + daysOfTheWeek[index] + "?", "");
				
				// Checks if the user's response is not null or not an empty string.
				// Cancels out the application if the user response is null, which is the case when the cancel button is pressed. 
				if (response != null) {
					if (!(response.length() > 0)) {
						throw new Exception();
					}
					
					// Assigns the user response at the current index of the entrees array.
					// Will capitalize the first letter if the first letter is not capital.
					if (response.length() > 1) {
						entrees[index] = (response.substring(0, 1).toUpperCase() + response.substring(1));
					} else {
						entrees[index] = response.toUpperCase();
					}
					
					// The isDone variable is set to false to prepare to ask for the price.
					isDone = false;
					
					// Repeatedly asks what the price of the entree is until an acceptable price is given. 
					while (!isDone) {
						try {
							// Asks the user for the price of the entree served on that day. 
							// Initializes the user response to an empty string if the user response is null and the cancel button was not clicked.
							response = JOptionPane.showInputDialog("What is the price of " + entrees[index] + "?", "");
							
							// Checks if the user response is not null or not an empty string.
							if (response != null) {
								if (!(response.length() > 0)) {
									throw new Exception();
								}
								
								// Tries to parse the user response into a double price value.
								// If this is possible, then the double price value is then stored
								// in an array parallel to the days and names arrays for the entrees.
								double value = Double.parseDouble(response);
								prices[index] = value;
								
								// The isDone boolean is set to true once an acceptable price is acquired from the user.
								isDone = true;
							} else {
								// Restarts the current iteration if the attempt to enter the price is canceled.
								if (index >= 1) {
									index--;
								} else {
									index = -1;
								}
								
								isDone = true;
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Please enter the price for " + entrees[index] + ".");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Thank you. Come back soon.");
					System.exit(0);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter the name of the entree being served on " + daysOfTheWeek[index]);
				
				// Restarts the current iteration if an acceptable entree name is not entered.
				if (index >= 1) {
					index--;
				} else {
					index = -1;
				}
			}
		}
		
		// A string that will store the info of the selected entree.
		String selectedEntreeInfo = "";
		isDone = false;
		
		// A while loop used to ask the user which entree they would like to eat. 
		while (!isDone) {
			try {
				// A string to hold the response of the user for the name of the entree they want. 
				// Initializes the user response to an empty string if the user response is null and the cancel button was not clicked.
				String response = JOptionPane.showInputDialog("What entree would you like to eat?", "");

				// Checks if the user response is not null and not an empty string.
				// Cancels out the application if the user response is null, which is the case when the cancel button is pressed. 
				if (response != null) {
					if (!(response.length() > 0)) {
						throw new Exception();
					}
					
					for (int index = 0; index < NUM_DAYS_IN_WEEK; index++) {
						// Checks the current index of the entrees array for the name of the entree the user has entered. 
						if (response.equalsIgnoreCase(entrees[index])) {
							isDone = true;
							
							// The name, day served, and price of the selected entree.
							String name = entrees[index];
							String day = daysOfTheWeek[index];
							double price = prices[index];
							
							// Stores the name, day served, and price of the selected entree.
							selectedEntreeInfo = String.format("%s is served on %ss for $%,.2f.", name, day, price);

							break;
						} else if (index == (entrees.length - 1)) {
							throw new Exception();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Thank you. Come back soon.");
					System.exit(0);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "That entree is not served any day of the week.\n \n"
												  + "Please enter another entree name.");
			}
		}

		// A variable to stores the index of the highest-priced entree.
		int highestPricedEntreeIndex = 0;
		double currentMaxPrice = 0;

		// A for loop used to find the index of the highest-priced entree.
		for (int index = 0; index < NUM_DAYS_IN_WEEK; index++) {
			double price = prices[index];

			// If a new max price is found it is set to be the new current max price.
			if (price >= currentMaxPrice) {
				currentMaxPrice = price;
				highestPricedEntreeIndex = index;
			}
		}

		// Variables that store the day, name, and price of the highest priced entree.
		String day = daysOfTheWeek[highestPricedEntreeIndex];
		String entree = entrees[highestPricedEntreeIndex];
		double price = prices[highestPricedEntreeIndex];
		
		// Stores and then presents the info of the user's selected entree and the highest-priced entree to the user.
		String highestPricedEntreeInfo = String.format("The highest-priced item, %s, is served on %ss for $%,.2f.", entree, day, price);
		JOptionPane.showMessageDialog(null, selectedEntreeInfo + "\n \n" + highestPricedEntreeInfo + "\n \n" + "Thank you. Enjoy your food.");
	}

}
