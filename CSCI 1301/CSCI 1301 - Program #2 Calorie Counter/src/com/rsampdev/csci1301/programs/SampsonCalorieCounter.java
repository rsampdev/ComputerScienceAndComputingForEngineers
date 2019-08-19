package com.rsampdev.csci1301.programs;

import javax.swing.JOptionPane;;

/* Rodney Sampson II
 * CSCI 1301
 * Program Two - Calorie Counter
 * 
 * This is a dialog box application that uses the biological sex, weight, height, and age of the user
 * to calculate the BMR (Basal metabolic rate) of the user, the daily calorie intake need of the user,
 * and the remaining daily calories the user needs to consume to maintain their current weight based
 * on the BMR of the user and the number of daily calories already eaten.
 *  
 * The BMR is calculated for biological males and females using the formulas below:
 *  
 * MALE: 	655 + (4.35 * weight in pounds) + (4.7 * height in inches) - (4.7 * age in years)
 * FEMALE:	665 + (6.23 * weight in pounds) + (12.7 * height in inches) - (6.8 x age in years)
 * 
 * */

public class SampsonCalorieCounter {

	public static void main(String[] args) {
		// Creating and instantiating the variables needed to calculate the BMR,
		// daily calorie intake need, and remaining daily calories with default values.
		String biologicalSex = "unknown";
		double exerciseStatus = 0;
		double dailyCalories = 0;
		double weight = 0;
		double height = 0;
		double age = 0;
		double bmr = 0;
		
		// A boolean value used to end loops when a task is completed.
		boolean isDone = false;
		
		// Presents a dialog box that explains the program's function to the user.
		JOptionPane.showMessageDialog(null, "Hello! This program is used to calculate your BMR (Basal metabolic rate),\n"
				  						  + "your daily calorie intake need, and your remaining daily calories.\n\n"
				  						  + "We only need to know a few things to calculate all this.\n\n"
				  						  + "Click 'OK' to get started.");
		
		// An array of questions that the user needs to be asked for the program to calculate the BMR.
		String[] bmrFormulaVariablesQuestions = new String[] {
				"Are you a biological male?",
				"What is your weight in pounds?",
				"What is your height in inches?",
				"What is your age in years?"
		};

		// Asking the user for their biological sex
		int userInputForBioSex = JOptionPane.showConfirmDialog(null, bmrFormulaVariablesQuestions[0]);

		// This if-else-if decides which biological sex based BMR formula to use based on the user's input.
		if (userInputForBioSex == JOptionPane.YES_OPTION) {
			biologicalSex = "male";
		} else if (userInputForBioSex == JOptionPane.NO_OPTION) {
			biologicalSex = "female";
		} else if ((userInputForBioSex == JOptionPane.CANCEL_OPTION) || userInputForBioSex == JOptionPane.CLOSED_OPTION) {
			JOptionPane.showMessageDialog(null, "Thank you. Come back soon.");
			return;
		}

		// An integer value that keeps track of the index in
		// the while loop relative to the BMR question array.
		int index = 1;
		
		// This while loop loops through the array of BMR questions, asks the user for input using an input dialog box,
		// parses out an appropriate value, and then assigns that value to the related variable based on the current loop index.
		while (index < bmrFormulaVariablesQuestions.length) {
			String dialogMessage = bmrFormulaVariablesQuestions[index];

			double tempValue = 0;

			// This try-catch is used to re-ask the current BMR question if an appropriate value is not able to be parsed out of the user's input.
			try {
				String userInput = JOptionPane.showInputDialog(null, dialogMessage);

				if (userInput != null) {
					// Parses the number value out of the user's input and then.
					tempValue = Double.parseDouble(userInput);
					
					// Assigns the parsed out temporary value to the appropriate variable based on the index.
					if (index == 1) {
						weight = tempValue;
					} else if (index == 2) {
						height = tempValue;
					} else if (index == 3) {
						age = tempValue;
					}
					
					// Increments the index variable.
					index++;
				} else {
					JOptionPane.showMessageDialog(null, "Thank you. Come back soon.");
					return;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter a number. Thank you.");
			}
		}
		
		// A string that contains a list of exercise habits.
		String exerciseDialogMessage = "Please enter the number of the statement that matches your exercise habits the best.\n"
									 + "1) You don't exercise. \n"
									 + "2) You engage in light exercise one to three days a week.\n"
									 + "3) You exercise moderately three to five times a week.\n"
									 + "4) You exercise intensely six to seven days a week.\n"
									 + "5) You exercise intensely six to seven days a week and have a physically active job.\n";
		
		// Asks the user to choose the number of exercise habit that best matches their own.
		// The number of the matching statement is then parsed out of the user's input and assigned to a variable.
		while (!isDone) {
			// This try-catch is used to re-ask the exercise habit question if an appropriate value is not able to be parsed out of the user's input.
			try {
				String userInput = JOptionPane.showInputDialog(null, exerciseDialogMessage);

				if (userInput != null) {
					// Parses the number out of the user's input.
					exerciseStatus = Integer.parseInt(userInput);
					
					// Checks if the parsed out exercise status is within the bounds of the available options.
					if (!(exerciseStatus >= 1 && exerciseStatus <= 5)) {
						throw new Exception();
					}
					
					// Sets the isDone variable to false to exit out of the loop.
					isDone = true;
				} else {
					JOptionPane.showMessageDialog(null, "Thank you. Come back soon.");
					return;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter a number 1-5. Thank you.");
			}
		}
		
		// Calculates the BMR of the user based on the their biological sex, weight, height, and age.
		if (biologicalSex.equals("male")) {
			bmr = 665 + (6.23 * weight) + (12.7 * height) - (6.8 * age);
		} else if (biologicalSex.equals("female")) {
			bmr = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
		}
		
		// Calculates the daily calories of the user based on their BMR and exercise habit.
		if (exerciseStatus == 1) {
			dailyCalories = bmr * 1.2;
		} else if (exerciseStatus == 2) {
			dailyCalories = bmr * 1.375;
		} else if (exerciseStatus == 3) {
			dailyCalories = bmr * 1.55;
		} else if (exerciseStatus == 4) {
			dailyCalories = bmr * 1.725;
		} else if (exerciseStatus == 5) {
			dailyCalories = bmr * 1.9;
		}
		
		// Creates a formatted string that contains all the health data of the user.
		String healthData = String.format("You are a %.0f year old %s.\n\n"
										+ "You are %.0f inches tall and weigh %.0f pounds.\n\n"
										+ "Your BMR (Basal metabolic rate) is: %,.2f.\n\n"
										+ "Your daily caloric intake need is: %,.2f.\n"
										, age, biologicalSex, height, weight, bmr, dailyCalories);
		
		// Presents the health data to the user. 
		JOptionPane.showMessageDialog(null, healthData);
				
		String message = "Have you eaten at all today?\n\n"
					   + "If you have, would you like to enter the number\n"
					   + "of calories for each snack or meal you've eaten\n"
					   + "to calculate your remaining daily caloric need?\n\n";

		// Asks the user if they would like to enter the calories of any meals or snacks they've eaten today.
		int userInputForEating = JOptionPane.showConfirmDialog(null, message);

		// This if-else-if statement decides whether to continue with the program and calculate
		// the remain daily calories of the user or present the current health data and then quit.
		if (userInputForEating == JOptionPane.YES_OPTION) {
			isDone = false;
		} else if (userInputForEating == JOptionPane.NO_OPTION) {
			isDone = true;
		} else if (userInputForEating == JOptionPane.CANCEL_OPTION || userInputForEating == JOptionPane.CLOSED_OPTION) {
			JOptionPane.showMessageDialog(null, "Thank you. Come back soon.");
			return;
		}
		
		// The remainingDailyCalories variable is assigned the default values of the
		// daily calories calculated from the BMR and exercise habit of the user.
		double remainingDailyCalories = dailyCalories;
		
		// Repeatedly asks the user for the number of calories for every snack or meal the user enters until the user decides to stop.
		// Every time the calories of a snack or meal is entered that number is subtracted from the remainingDailyCalories variable.
		while (!isDone) {
			String report = String.format("You can eat %,.2f more calories today.\n\n", remainingDailyCalories);
			String question = "How many calories was your snack or meal?\n";

			try {
				String userInput = JOptionPane.showInputDialog(null, report + question);

				if (userInput != null) {
					double calorieIntake = Double.parseDouble(userInput);
					
					// Subtracts the newly enter calories from the remainingDailyCalories variable.
					remainingDailyCalories -= calorieIntake;

					// If the user's remaining daily calories is less than or equal to zero, then we automatically break out the loop.
					if (remainingDailyCalories <= 0) {
						isDone = true;
						break;
					}
				} else {
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter the number of calories for your snack or meal.");
				continue;
			}

			report = String.format("You can eat %,.2f more calories today.", remainingDailyCalories);
			question = "Would you like to enter the calories for another snack or meal?";

			// Displays a small calorie report to the user and asks if they would like to enter another snack or meal.
			int userInput = JOptionPane.showConfirmDialog(null, report + "\n\n" + question);

			// If the user is not done entering snacks or meals the loop will continue.
			// If the user is done, then the isDone variable is set to true, and we break out of the loop.
			if (userInput == JOptionPane.NO_OPTION) {
				isDone = true;
			}
		}
		
		String calorieMessage = "";
		
		// Creates a formatted calorieMessage string based on whether or not the user has eaten more than their recommended daily calories. 
		if (remainingDailyCalories >= 0) {
			calorieMessage = String.format("You have %,.2f daily calories remaining.", remainingDailyCalories);
		} else {	
			calorieMessage = String.format("You have no daily calories remaining.\n\n"
						   				 + "You have eaten %,.2f too many calories today.", Math.abs(remainingDailyCalories));	
		}
		
		// Combines the health date and the calorie data into one string.
		String healthAndCalorieData = healthData + "\n" + calorieMessage;
		
		// Presents the health and calorie data to the user.
		JOptionPane.showMessageDialog(null, healthAndCalorieData);
	}
}
