package Car;

import java.util.ArrayList;

public class CarLoader {

	private ArrayList<Vehicle> carLoaded = new ArrayList<Vehicle>();
	private int carMaxCapacity;
	private Flatbed flatbed;

	/**
	 * Describes how the car loader works
	 * 
	 * @param maxCapacity the max car capacity on the car loader
	 */
	public CarLoader(int maxCapacity) {
		flatbed = new Flatbed();
		carMaxCapacity = maxCapacity;
	}

	/**
	 * 
	 * @return The flatbed in the car loader
	 */
	public Flatbed getFlatbed() {
		return flatbed;
	}

	/**
	 * Load a specified car onto the CarLoader
	 * 
	 * @param o            The Current Vehicle
	 * @param c            A car to be loaded
	 * @param currentSpeed The currentSpeed of the vehicle
	 */
	protected void loadCar(Vehicle o, Vehicle c) {
		if (c.getPositionX() - o.getPositionX() <= 4 && c.getPositionY() - o.getPositionY() <= 4) {
			if (o.getCurrentSpeed() == 0 && carLoaded.size() < carMaxCapacity && flatbed.getAngleFlatbed() == 0) {
				carLoaded.add(c);
			}
		}
	}

	/**
	 * Unloads the last car of the transport
	 */
	protected void unloadLastCar(double currentSpeed) {
		if (currentSpeed == 0 && flatbed.getAngleFlatbed() == 0) {
			carLoaded.remove(carLoaded.size() - 1);
		}
	}

	/**
	 * Unloads the first car of the transport
	 */
	protected void unloadFirstCar(double currentSpeed) {
		if (currentSpeed == 0 && flatbed.getAngleFlatbed() == 0) {
			carLoaded.remove(0);
		}
	}

	/**
	 * 
	 * @return an ArrayList of all cars of the car transport
	 */
	protected ArrayList<Vehicle> getposition() {
		return carLoaded;
	}

	/**
	 * 
	 * @return a car of the position on the loader
	 */
	protected Vehicle getPositionOfCar(int i) {
		return carLoaded.get(i);
	}

}
