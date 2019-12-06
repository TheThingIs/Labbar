package model;

import java.awt.Color;

public class Man extends Vehicle implements IFlatbedAngle, ILoadCar<Car>, ILoadCarTruck {

	private CarLoader<Car> carloader;

	/**
	 * Creates a Man
	 */
	public Man() {
		super(2, 70, Color.WHITE, "Man");
		carloader = new CarLoader<Car>(6);
	}

	@Override
	public double speedFactor() {
		if (carloader.getAngleFlatbed() == 0) {
			return getEnginePower() * 0.01;
		} else {
			return 0;
		}
	}

	@Override
	public void increaseAngle(double amount) {
		if (getCurrentSpeed() == 0) {
			carloader.increaseAngle(70);
		}

	}

	@Override
	public void decreaseAngle(double amount) {
		if (getCurrentSpeed() == 0) {
			carloader.decreaseAngle(70);
		}
	}

	@Override
	public void loadCar(Car c) {
		if (getCurrentSpeed() == 0 && c.getPositionX() - getPositionX() <= 4
				&& c.getPositionY() - getPositionY() <= 4 && !c.CheckIfOnLoader()) {
			carloader.loadCar(c);
		}

	}

	@Override
	public void unloadLastCar() {
		if (getCurrentSpeed() == 0) {
			carloader.unloadLastCar();
		}
	}

	@Override
	public double getAngleFlatbed() {
		return carloader.getAngleFlatbed();
	}

	@Override
	public void move() {
		super.move();
		carloader.moveAll(getPositionX(), getPositionY());
	}

}
