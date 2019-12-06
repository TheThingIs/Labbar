package controller;

import model.IFlatbedAngle;
import model.ITurbo;
import model.Vehicle;

import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
	// member fields:

	// A list of cars, modify if needed
	private static ArrayList<Vehicle> vehicles = new ArrayList<>();
	// methods:

	// Calls the gas method for each car once
	public void gas(int amount) {
		double gas = ((double) amount) / 100;
		for (Vehicle v : vehicles) {
			v.gas(gas);
		}
	}

	// Calls the gas method for each car once
	public void brake(int amount) {
		double brake = ((double) amount) / 100;
		for (Vehicle v : vehicles) {
			v.brake(brake);
		}
	}

	public static ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public static void addVehicle(Vehicle v) {
		vehicles.add(v);
	}

	public void turboOn() {
		for (Vehicle v : vehicles) {
			if (v instanceof ITurbo) {
				((ITurbo) v).setTurboOn();
			}
		}

	}

	public void turboOff() {
		for (Vehicle v : vehicles) {
			if (v instanceof ITurbo) {
				((ITurbo) v).setTurboOff();
			}
		}

	}

	public void liftBed(int amount) {
		for (Vehicle v : vehicles) {
			if (v instanceof IFlatbedAngle) {
				((IFlatbedAngle) v).increaseAngle(amount);
			}
		}

	}

	public void lowerBed(int amount) {
		for (Vehicle v : vehicles) {
			if (v instanceof IFlatbedAngle) {
				((IFlatbedAngle) v).decreaseAngle(amount);
			}
		}

	}

	public void start() {
		for (Vehicle v : vehicles) {
			v.startEngine();
		}

	}

	public void stop() {
		for (Vehicle v : vehicles) {
			v.stopEngine();
		}

	}
}
