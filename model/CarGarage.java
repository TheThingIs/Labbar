package model;

public class CarGarage<T extends Car> implements ILoadGarage<T> {

	private final CarLoader<T> carloader; //A carloader to manage cars
	
	/**
	 * Creates a new CarGarage
	 * @param maxCapacity an int of how many Cars the garage can hold
	 */
	public CarGarage(int maxCapacity) {
		carloader = new CarLoader<T>(maxCapacity, this);
	}

	@Override
	public void returnCar(T c) {
		carloader.returnCar(c);
	}

	@Override
	public void depositCar(T c) {
		carloader.depositCar(c);
	}

}
