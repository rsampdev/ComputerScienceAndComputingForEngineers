package com.rsampdev.csci1301.programs;

import javax.swing.JOptionPane;

/* Rodney Sampson II
 * CSCI 1301
 * Program One - Final Grade
 * 
 * This is a dialog box application that calculates the final grade of 
 * a Computer Science I class based on the syllabus specifications below.
 * 
 * Programs / Labs - 40%
 * 2 Tests (15% each) - 30%
 * Final Exam -  30%
 * 
 * */

public class SampsonFinalGrade {

	public static void main(String[] args) {
		// Instantiates all the percentage components of the final grade with zero and declares a final grade variable.
		double percentageOfProgramsAndLabs = 0;
		double percentageOfFinalExam = 0;
		double percentageOfTests = 0;
		double finalGrade;
		
		// Creates an array of all the assignment names to ask the user for input.
		String[] assignmentNames = new String[] {
				"Lab One",
				"Lab Two",
				"Lab Three",
				"Program One",
				"Program Two",
				"Program Three",
				"Program Four",
				"Program Five",
				"Test One",
				"Test Two",
				"the Final Exam"
		};
		
		// Welcomes the user to the program and describes its function.
		JOptionPane.showMessageDialog(null, "Hello, student! Welcome to the CSCI 1301 Final Grade Calculator!\n"
										  + "To calculate your final grade for CSCI 1301, please enter the grade you got for each requested assignment.");
		
		// This will loop through the assignmentNames array and ask for the grade of each assignment.
		for (int index = 0; index < assignmentNames.length; index++) {
			String dialogMessage = "What was your grade for " + assignmentNames[index] + "?";
			
			// Declares and instantiates a variable to temporarily hold the newly inputed grade.
			double assignmentGrade = 0;
			
			// This try-catch will try to parse out a double from a user inputed value and assign it to the assignmentGrade variable.
			// If the cancel button is pressed, and the user input is null, the application will thank the user and then exit out.
			// If parsing a double out of the user input fails then the exception will be caught, the current iteration of the
			// loop will be restarted, the user will be told to only enter a number, and then asked again for more input.
			try {
				String userInput = JOptionPane.showInputDialog(null, dialogMessage);
				
				if (userInput != null) {
					assignmentGrade = Double.parseDouble(userInput);
				} else {
					JOptionPane.showMessageDialog(null, "Thank you. Come back soon.");
					System.exit(0);
				}
			} catch (Exception e) {
				index -= 1;
				JOptionPane.showMessageDialog(null, "Please enter a number. Thank you.");
				continue;
			}
			
			// This if-else-if will decide which grade component of the final grade will receive the new assignment grade.
			if (index <= 7) {
				percentageOfProgramsAndLabs += assignmentGrade;
			} else if (index <= 9) {
				percentageOfTests += assignmentGrade;
			} else if (index <= 10) {
				percentageOfFinalExam += assignmentGrade;
			}
		}
		
		// Divides the sum total of each grade component by the corresponding number of assignments to get the average grade of each grade component.
		percentageOfProgramsAndLabs /= 8;
		percentageOfTests /= 2;
		
		// Multiples the average grade of each grade component by its corresponding weight of the final grade.
		percentageOfProgramsAndLabs *= 0.4;
		percentageOfFinalExam *= 0.3;
		percentageOfTests *= 0.3;
		
		// Calculates the final grade by adding up all the percentages.
		finalGrade = percentageOfProgramsAndLabs + percentageOfTests + percentageOfFinalExam;
		
		// Creates a final message string that rounds the final grade to 2 digits using String.format().
		String finalMessage = String.format("Your final grade for CSCI 1301 is: %.2f%n", finalGrade);
		
		// Displays the final grade to the user
		JOptionPane.showMessageDialog(null, finalMessage);
	}

}
