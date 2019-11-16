package Car;

import java.awt.*;

public class Scania extends Vehicle implements FlatbedAngle {

	private Flatbed flatbed;

	/**
	 * Creates a Scania
	 */
	public Scania() {
		super(2, 70, Color.WHITE, "Scania");
		flatbed = new Flatbed();
	}

	/**
	 * Returns the Scania speedfactor
	 */
	@Override
	public double speedFactor() {
		if (flatbed.getAngleFlatbed() == 0) {
			return getEnginePower() * 0.01;
		} else {
			return 0;
		}
	}

	public double getAngleFlatbed() {
		return flatbed.getAngleFlatbed();
	}

	@Override
	public void increaseAngle(double amount) {
		if (getCurrentSpeed() == 0) {
			flatbed.increaseAngle(amount);
		}

	}

	@Override
	public void decreaseAngle(double amount) {
		if (getCurrentSpeed() == 0) {
			flatbed.decreaseAngle(amount);
		}

	}

}