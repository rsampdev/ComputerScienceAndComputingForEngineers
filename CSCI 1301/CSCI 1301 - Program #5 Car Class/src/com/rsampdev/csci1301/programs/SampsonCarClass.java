package com.rsampdev.csci1301.programs;

/*	Rodney Sampson II
 *	CSCI 1301
 *	Program Five - Car Class
 *
 *	This program follows the program specifications below:
 *
 *	Car class:
 *		- yearModel: integer
 *		- make: String
 * 		- speed: integer
 * 
 * 		+ Constructor(integer yearModel, String make):
 * 			yearModel => yearModel
 * 			make => make
 * 			0 => speed
 *
 *		Getters:
 *			+ yearModel: integer
 *			+ make: String
 *			+ speed: integer
 *
 *		Methods:
 *		 	+ accelerate: Increase speed by five
 *			+ brake: Decrease speed by five
 *
 *	Program:
 *		Call accelerate and print the speed after each call five times
 *		Call brake and print the speed after each call five times
 * 
 */

public class SampsonCarClass {

	public static void main(String[] args) {
		// Create an instance of type Car
		Car rangeRover = new Car(2019, "Range Rover");

		// Year model and make of the rangeRover Car instance
		System.out.println("Year Model: " + rangeRover.getYearModel());
		System.out.println("Make: " + rangeRover.getMake());
		
		// Starting speed of the rangeRover Car instance
		System.out.println("Current speed: " + rangeRover.getSpeed());

		// Call accelerate() on the rangeRover object and then print out the current speed five times
		for (int i = 0; i < 5; i++) {
			rangeRover.accelerate();
			System.out.println("Current speed: " + rangeRover.getSpeed());
		}

		// Call brake() on the rangeRover object and then print out the current speed five times
		for (int i = 0; i < 5; i++) {
			rangeRover.brake();
			System.out.println("Current speed: " + rangeRover.getSpeed());
		}

	}

}

class Car {
	private int yearModel; // To hold the year model of the car
	private String make; // To hold the make of the car
	private int speed; // To hold the speed of the car

	// Constructor: sets the yearModel and make to the values passed in
	// Speed is set to zero
	public Car(int yearModel, String make) {
		this.yearModel = yearModel;
		this.make = make;
		this.speed = 0;
	}

	// Getter for yearModel
	public int getYearModel() {
		return this.yearModel;
	}

	// Getter for make
	public String getMake() {
		return this.make;
	}

	// Getter for speed
	public int getSpeed() {
		return this.speed;
	}

	// Increase speed by five
	public void accelerate() {
		this.speed += 5;
	}

	// Decrease speed by five
	public void brake() {
		this.speed -= 5;
	}

}
