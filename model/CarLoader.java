package model;

import java.util.ArrayList;

public class CarLoader<T extends Car>
		implements IFlatbedAngle, ILoadCar<T>, ILoadGarage<T>, ILoadCarTruck, ILoadCarFerry {

	private final ArrayList<T> carLoaded; // an array of the Vehicles in the carloader
	private final int carMaxCapacity; // the max capacity of the carloader
	private Flatbed flatbed; // a flatbed to load the vehicles

	/**
	 * Describes how the car loader works for trucks
	 * 
	 * @param maxCapacity the max car capacity on the car loader
	 */
	protected CarLoader(int maxCapacity) {
		flatbed = new Flatbed();
		carLoaded = new ArrayList<T>();
		carMaxCapacity = maxCapacity;
	}

	/**
	 * Describes how the car loader works for garages
	 * 
	 * @param maxCapacity the max car capacity on the car loader
	 * @param modelName   Specifiecs the specialities of the garage
	 */
	protected CarLoader(int maxCapacity, CarGarage<T> t) {
		carMaxCapacity = maxCapacity;
		carLoaded = new ArrayList<T>();
	}

	@Override
	public void increaseAngle(double amount) {
		flatbed.increaseAngle(70);

	}

	@Override
	public void decreaseAngle(double amount) {
		flatbed.decreaseAngle(70);

	}

	@Override
	public double getAngleFlatbed() {
		return flatbed.getAngleFlatbed();
	}

	@Override
	public void loadCar(T c) {
		if (carLoaded.size() < carMaxCapacity && flatbed.getAngleFlatbed() == 70) {
			c.isOnLoader();
			carLoaded.add(c);
		}

	}

	@Override
	public void unloadFirstCar() {
		if (flatbed.getAngleFlatbed() == 70) {
			carLoaded.get(0).isNotOnLoader();
			carLoaded.remove(0);
		}
	}

	@Override
	public void unloadLastCar() {
		if (flatbed.getAngleFlatbed() == 70) {
			carLoaded.get(carLoaded.size() - 1).isNotOnLoader();
			carLoaded.remove(carLoaded.size() - 1);
		}

	}

	@Override
	public void returnCar(T c) {
		c.isNotOnLoader();
		carLoaded.remove(c);
	}

	@Override
	public void depositCar(T c) {
		c.isOnLoader();
		carLoaded.add(c);
	}

	/**
	 * Moves all cars when the vehicle is moving
	 * 
	 * @param positionX Position in x to move the car
	 * @param positionY Position in y to move the car
	 */
	protected void moveAll(double positionX, double positionY) {
		for (T c : carLoaded) {
			c.updatePosition(positionX, positionY);
		}

	}

}
