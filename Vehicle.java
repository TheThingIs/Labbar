package Car;

import java.awt.*;

public abstract class Vehicle implements Movable, Speed {

	private double angle; // Angle the car is facing
	private double positionX; // Position in Y-direction
	private double positionY; // Position in X-direction
	private int nrDoors; // Number of doors on the car
	private double enginePower; // Engine power of the car
	private double currentSpeed; // The current speed of the car
	private Color color; // Color of the car
	private String modelName; // The car model name

	/**
	 * Representation of a car
	 * 
	 * @param nrDoors     number of doors on the car
	 * @param enginePower the power of the engine of the car
	 * @param color       the color of the car
	 * @param modelName   the cars model name
	 */
	public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
		this.setAngle(90);
		this.nrDoors = nrDoors;
		this.color = color;
		this.enginePower = enginePower;
		this.modelName = modelName;
		stopEngine();
	}

	/**
	 * 
	 * @return the number of doors on the car
	 */
	public int getNrDoors() {
		return nrDoors;
	}

	/**
	 * 
	 * @return the power of the engine of the car
	 */
	public double getEnginePower() {
		return enginePower;
	}

	/**
	 * 
	 * @return the current speed of the car
	 */
	public double getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 * 
	 * @return the color of the car
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * 
	 * @param clr sets the color of the car
	 */
	public void setColor(Color clr) {
		color = clr;
	}

	/**
	 * 
	 * @return the model name of the car
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Starts the engine of the specified car
	 */
	public void startEngine() {
		setCurrentSpeed(0.1);
	}

	/**
	 * Stops the engine of the specified car
	 */
	public void stopEngine() {
		setCurrentSpeed(0);
	}

	/**
	 * Increases the speed of the car with the specified amount
	 * 
	 * @param IncreasedSpeed the amount of speed to increase current speed with in
	 *                       interval 0,enginepower
	 */
	private void setCurrentSpeed(double IncreasedSpeed) {
		if (IncreasedSpeed <= enginePower && IncreasedSpeed >= 0) {
			this.currentSpeed = IncreasedSpeed;
		} else if (IncreasedSpeed <= 0) {
			this.currentSpeed = 0;
		}

	}

	/**
	 * 
	 * @return Position in X-coordinate of the car
	 */
	public double getPositionX() {
		return positionX;
	}

	/**
	 * 
	 * @return Set position X-coordinate of the car
	 */
	private void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	/**
	 * 
	 * @return Position in y-coordinate of the car
	 */
	public double getPositionY() {
		return positionY;
	}

	/**
	 * 
	 * @return Set position Y-coordinate of the car
	 */
	private void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	/**
	 * 
	 * @return the angle of the car
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * 
	 * @return Set angle of the car
	 */
	private void setAngle(double angle) {
		this.angle += angle % 360;
		if (this.angle < 0) {
			this.angle = 355;
		}
	}

	/**
	 * gases the speed with the specified amount
	 * 
	 * @param amount to gas the speed with
	 */
	public void gas(double amount) {
		if (amount <= 1 && amount > 0) {
			incrementSpeed(amount);
		}
	}

	/**
	 * brakes the speed with the specified amount
	 * 
	 * @param amount to brake the speed with
	 */
	public void brake(double amount) {
		if (amount <= 1 && amount > 0) {
			decrementSpeed(amount);
		}
	}

	@Override
	public void move() {
		this.setPositionX(this.getPositionX() + Math.cos(Math.toRadians(this.getAngle())) * this.getCurrentSpeed());
		this.setPositionY(this.getPositionY() + Math.sin(Math.toRadians(this.getAngle())) * this.getCurrentSpeed());
	}

	@Override
	public void turnLeft() {
		this.setAngle(5);
	}

	@Override
	public void turnRight() {
		this.setAngle(-5);
	}

	/**
	 * increments the speed with the specified amount
	 * 
	 * @param amount to increments the speed with
	 */
	private void incrementSpeed(double amount) {
		setCurrentSpeed(getCurrentSpeed() + speedFactor() * amount);
	}

	/**
	 * decrements the speed with the specified amount
	 * 
	 * @param amount to decrements the speed with
	 */
	private void decrementSpeed(double amount) {
		setCurrentSpeed(getCurrentSpeed() - speedFactor() * amount);
	}

}
