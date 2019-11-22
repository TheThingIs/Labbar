package Car;

public interface ILoadCar<T extends Car> {

	/**
	 * Load a specified car onto the CarLoader
	 * 
	 * @param c A car to be loaded
	 */
	public void loadCar(T c);

}
