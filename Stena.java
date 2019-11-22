package Car;

import java.awt.Color;

public class Stena extends Vehicle implements IFlatbedAngle, ILoadCar<Car>, ILoadCarFerry {

	private CarLoader<Car> carloader;

	/**
	 * Creates a Stena
	 */
	public Stena() {
		super(0, 90, Color.white, "Stena");
		carloader = new CarLoader<Car>(84);
	}

	@Override
	public double speedFactor() {
		if (getAngleFlatbed() == 0) {
			return getEnginePower() * 0.01;
		} else {
			return 0;
		}
	}

	@Override
	public void unloadFirstCar() {
		carloader.unloadFirstCar();
	}

	@Override
	public void loadCar(Car c) {
		carloader.loadCar(c);
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
	public double getAngleFlatbed() {
		return carloader.getAngleFlatbed();
	}

	@Override
	public void move() {
		super.move();
		carloader.moveAll(getPositionX(), getPositionY());
	}

}
