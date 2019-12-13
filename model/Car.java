package model;

import java.awt.*;

public abstract class Car extends Vehicle {

	private boolean isOnLoader; // If this car is on a carloader

	protected Car(int nrDoors, double enginePower, Color color, String modelName) {
		super(nrDoors, enginePower, color, modelName);
	}
	/**
	 * Representation of a Car
	 * 
	 * @param nrDoors     number of doors on the car
	 * @param enginePower the power of the engine of the car
	 * @param color       the color of the car
	 * @param modelName   the cars model name
	 * @param imageWidth  the width of the image
	 * @param imageHeight the height of the image
	 */
	protected Car(int nrDoors, double enginePower, Color color, String modelName, int imageWidth, int imageHeight) {
		super(nrDoors, enginePower, color, modelName, imageWidth, imageHeight);
	}

	/**
	 * 
	 * @return If the specified car is on a carloader
	 */
	public boolean CheckIfOnLoader() {
		return isOnLoader;
	}

	/**
	 * This car is on a carloader
	 */
	public void isOnLoader() {
		this.isOnLoader = true;
	}

	/**
	 * This car is not a carloader
	 */
	public void isNotOnLoader() {
		this.isOnLoader = false;
	}

	/**
	 * Updates the coordinates of the car
	 * 
	 * @param positionX Position in x to move the car
	 * @param positionY Position in y to move the car
	 */
	protected void updatePosition(double positionX, double positionY) {
		if (CheckIfOnLoader()) {
			setPositionX(positionX);
			setPositionY(positionY);
		}
	}

}
