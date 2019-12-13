package model;

public class Factory {
	
	/**
	 * Creates a new Volvo240
	 */
	public static void newVolvo240() {
		Volvo240 v = new Volvo240();
		VehicleUniverse.addVehicle(v);
	}

	/**
	 * Creates a new Saab95
	 */
	public static void newSaab95() {
		Saab95 v = new Saab95();
		VehicleUniverse.addVehicle(v);
	}
	
	/**
	 * Creates a new Scania
	 */
	public static void newScania() {
		Scania v = new Scania();
		VehicleUniverse.addVehicle(v);
	}

	/**
	 * Makes a Man out of you
	 */
	public static void newMan() {
		Man v = new Man();
		VehicleUniverse.addVehicle(v);
	}
	
	/**
	 * Creates a new Stena
	 */
	public static void newStena() {
		Stena v = new Stena();
		VehicleUniverse.addVehicle(v);
	}

}
