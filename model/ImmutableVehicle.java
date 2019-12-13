package model;

/**
 * See Vehicle for details
 *
 */
public class ImmutableVehicle {

	private final Vehicle v;

	public ImmutableVehicle(Vehicle v) {
		this.v = v;
	}

	public double getPositionX() {
		return v.getPositionX();
	}

	public double getPositionY() {
		return v.getPositionY();
	}

	public double getCurrentSpeed() {
		return v.getCurrentSpeed();
	}

	public String getModelName() {
		return v.getModelName();
	}

	public void gas(double amount) {
		v.gas(amount);
	}

	public void brake(double brake) {
		v.brake(brake);
	}

	public void setTurboOn() {
		if (v instanceof ITurbo) {
			((ITurbo) v).setTurboOn();
		}
	}

	public void setTurboOff() {
		if (v instanceof ITurbo) {
			((ITurbo) v).setTurboOff();
		}
	}

	public void increaseAngle(int amount) {
		if (v instanceof IFlatbedAngle) {
			((IFlatbedAngle) v).increaseAngle(amount);
		}
	}

	public void decreaseAngle(int amount) {
		if (v instanceof IFlatbedAngle) {
			((IFlatbedAngle) v).decreaseAngle(amount);
		}
	}

	public void startEngine() {
		v.startEngine();
	}

	public void stopEngine() {
		v.stopEngine();
	}

	public void move() {
		v.move();
	}

}
