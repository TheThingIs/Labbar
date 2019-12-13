package model;

import java.util.ArrayList;

public class VehicleUniverse {

	private static final ArrayList<Vehicle> vehicles = new ArrayList<>();

	/**
	 * Adds a Vehicle to the world
	 * @param v the Vehicle to add
	 */
	protected static void addVehicle(Vehicle v) {
		if (vehicles.size() < 10)
			vehicles.add(v);
	}
	
	/**
	 * Generates an Immutable arraylist
	 * @return an arraylist of ImmutableVehicle 
	 */
	public static ArrayList<ImmutableVehicle> getImmutableVehicles() {
		ArrayList<ImmutableVehicle> s = new ArrayList<>();

		for (Vehicle v : vehicles) {
			ImmutableVehicle v1 = new ImmutableVehicle(v);
			s.add(v1);
		}
		return s;
	}
	
	/**
	 * Removes a Specific or random Vehicle from the world
	 * @param s The modelname of the Vehicle to remove
	 */
	public static void removeSpecifiedVehicle(String s) {

		if (s.equals("Random") && vehicles.size() > 0) {
			Vehicle vl = vehicles.get((int) (Math.random() * vehicles.size()));
			vehicles.remove(vl);
			vl.notifyObservers();
		}
		for (Vehicle v : vehicles) {
			if (v.getModelName().equals(s)) {
				vehicles.remove(v);
				v.notifyObservers();
				break;
			}
		}

	}

}
