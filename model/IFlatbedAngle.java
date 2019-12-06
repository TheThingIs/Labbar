package model;

public interface IFlatbedAngle {

	/**
	 * Increases the angle of the flatbed
	 * 
	 * @param amount       amount to be increased
	 * @param currentSpeed The speed of the vehicle
	 */
	public void increaseAngle(double amount);

	/**
	 * Decreases the angle of the flatbed
	 * 
	 * @param amount       amount to be decreased
	 * @param currentSpeed The speed of the vehicle
	 */
	public void decreaseAngle(double amount);

	/**
	 * 
	 * @return angle of the flatbed
	 */
	public double getAngleFlatbed();

}
