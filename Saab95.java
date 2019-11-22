package Car;

import java.awt.*;

public class Saab95 extends Car {

	private boolean turboOn; // Check whenever the turbo is on

	/**
	 * Representation of a Saab95
	 */
	public Saab95() {
		super(2, 125, Color.red, "Saab95");
		turboOn = false;
	}

	/**
	 * Powers on the turbo
	 */
	public void setTurboOn() {
		turboOn = true;
	}

	/**
	 * Powers off the turbo
	 */
	public void setTurboOff() {
		turboOn = false;
	}

	@Override
	public double speedFactor() {
		if (!CheckIfOnLoader()) {
			double turbo = 1;
			if (turboOn) {
				turbo = 1.3;
			}
			return getEnginePower() * 0.01 * turbo;
		}
		return 0;
	}

}
