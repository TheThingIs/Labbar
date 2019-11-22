package Car;

public interface ILoadGarage<T extends Car> {

	/**
	 * Removes the specified car from the garage
	 * 
	 * @param c A car to remove from the garage
	 */
	public void returnCar(T c);

	/**
	 * Adds the specified car to the garage
	 * 
	 * @param c A car to add to the garage
	 */
	public void depositCar(T c);

}
