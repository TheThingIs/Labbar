package model;

import java.awt.*;

public class Volvo240 extends Car {

	public final static double trimFactor = 1.25;

	/**
	 * Representation of a Volvo240
	 */
	public Volvo240() {
		super(4, 100, Color.black, "Volvo240", 100, 60);
	}

	@Override
	public double speedFactor() {
		if (!CheckIfOnLoader()) {
			return getEnginePower() * 0.01 * trimFactor;
		}
		return 0;
	}

}
