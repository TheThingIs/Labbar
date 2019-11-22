package Car;

public class CarGarage<T extends Car> implements ILoadGarage<T> {

	private CarLoader<T> carloader;

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
