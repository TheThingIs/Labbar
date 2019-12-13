package model;

public class Flatbed implements IFlatbedAngle {

	private double angle; // the angle of the Liftbed
	
	/**
	 * Creates a flatbed
	 */
	protected Flatbed() {
		angle = 0;
	}

	@Override
	public void increaseAngle(double amount) {
		if (angle + amount <= 70 && amount > 0) {
			angle += amount;
		}
	}

	@Override
	public void decreaseAngle(double amount) {
		if (angle - amount >= 0 && amount > 0) {
			angle -= amount;
		}
	}

	@Override
	public double getAngleFlatbed() {
		return angle;
	}

}
