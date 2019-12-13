package controller;

import model.Factory;
import model.ImmutableVehicle;
import model.VehicleUniverse;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
	// member fields:

	private String[] models = { "Volvo240", "Saab95", "Scania", "Man", "Stena" };

	// A list of cars, modify if needed
	// methods:

	// Calls the gas method for each car once
	public void gas(int amount) {
		double gas = ((double) amount) / 100;
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			v.gas(gas);
		}
	}

	// Calls the gas method for each car once
	public void brake(int amount) {
		double brake = ((double) amount) / 100;
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			v.brake(brake);
		}
	}

	public void turboOn() {
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			v.setTurboOn();
		}

	}

	public void turboOff() {
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			v.setTurboOff();
		}

	}

	public void liftBed(int amount) {
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			v.increaseAngle(amount);
		}

	}

	public void lowerBed(int amount) {
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			v.decreaseAngle(amount);
		}

	}

	public void start() {
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			v.startEngine();
		}

	}

	public void stop() {
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			v.stopEngine();
		}
	}

	public void addVehicle(String s) {
		switch (s) {
		case ("Volvo240"):
			Factory.newVolvo240();
			break;
		case ("Saab95"):
			Factory.newSaab95();
			break;
		case ("Scania"):
			Factory.newScania();
			break;
		case ("Man"):
			Factory.newMan();
			break;
		case ("Stena"):
			Factory.newStena();
			break;
		default:
			addVehicle(models[(int) (Math.random() * 5)]);
		}
	}

	public void removeVehicle(String s) {
		VehicleUniverse.removeSpecifiedVehicle(s);
	}
}
