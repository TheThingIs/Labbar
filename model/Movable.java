package model;

public interface Movable {

	/**
	 * Moves the car in the direction of the X and Y coordinates
	 */
	void move();

	/**
	 * Turns the car left
	 */
	void turnLeft();

	/**
	 * Turns the car right
	 */
	void turnRight();

}
