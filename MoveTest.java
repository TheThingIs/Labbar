package Car;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoveTest {

	Volvo240 volvo = new Volvo240();
	Saab95 saab = new Saab95();
	Scania scania = new Scania();

	/**
	 * Tests the gas and brakes
	 */
	@Test
	public void gasAndBrakeTest() {
		assertEquals(125, saab.getEnginePower(), 0);
		saab.brake(1);
		assertEquals(0, saab.getCurrentSpeed(), 0);
		// Tests gas
		assertEquals(0.1, volvo.getCurrentSpeed(), 0);
		volvo.gas(1);
		assertEquals(1.35, volvo.getCurrentSpeed(), 0);
		// Test breaks
		volvo.brake(1);
		assertEquals(0.1, volvo.getCurrentSpeed(), 0.000001);
		// Tests negative values
		for (int i = 0; i < 150; i++) {
			volvo.brake(1);
		}
		assertEquals(0, volvo.getCurrentSpeed(), 0);
		// Tests maxspeed
		for (int i = 0; i < 150; i++) {
			volvo.gas(1);
		}
		assertEquals(100, volvo.getCurrentSpeed(), 0);
	}

	/**
	 * Tests if the vehicles can turn properly
	 */
	@Test
	public void turnTest() {
		volvo.turnLeft();
		assertEquals(95, volvo.getAngle(), 0);
		volvo.turnRight();
		assertEquals(90, volvo.getAngle(), 0);
		for (int i = 0; i < 72; i++) {
			volvo.turnRight();
		}
		assertEquals(90, volvo.getAngle(), 0);
		volvo.move();
		assertEquals(volvo.getCurrentSpeed(), volvo.getPositionY(), 0);
		assertEquals(0, volvo.getPositionX(), 0.0000001);
		for (int i = 0; i < 36; i++) {
			volvo.turnLeft();
		}
		volvo.move();
		assertEquals(0, volvo.getPositionY(), 0.0000001);
		assertEquals(0, volvo.getPositionX(), 0.0000001);
		for (int i = 0; i < 18; i++) {
			volvo.turnLeft();
		}
		volvo.move();
		assertEquals(volvo.getCurrentSpeed(), volvo.getPositionX(), 0.0000001);
		assertEquals(0, volvo.getPositionY(), 0.0000001);
	}

	/**
	 * Checks the turbo
	 */
	@Test
	public void turboTest() {
		saab.gas(1);
		assertEquals(1.35, saab.getCurrentSpeed(), 0);
		saab.setTurboOn();
		saab.gas(1);
		assertEquals(2.975, saab.getCurrentSpeed(), 0);
		saab.gas(1);
		assertEquals(4.6, saab.getCurrentSpeed(), 0);
		saab.setTurboOff();
		saab.gas(1);
		assertEquals(5.85, saab.getCurrentSpeed(), 0);
	}

	/**
	 * Checks Scania and its flatbed
	 */
	@Test
	public void scaniaTest() {
		scania.brake(1);
		assertEquals(0, scania.getAngleFlatbed(), 0);
		scania.increaseAngle(50);
		assertEquals(50, scania.getAngleFlatbed(), 0);
		scania.decreaseAngle(30);
		assertEquals(20, scania.getAngleFlatbed(), 0);
		scania.increaseAngle(51);
		assertEquals(20, scania.getAngleFlatbed(), 0);
		scania.decreaseAngle(21);
		assertEquals(20, scania.getAngleFlatbed(), 0);
		scania.gas(1);
		assertEquals(0, scania.getCurrentSpeed(), 0);
		scania.decreaseAngle(20);
		assertEquals(0, scania.getAngleFlatbed(), 0);
		scania.gas(1);
		assertEquals(0.7, scania.getCurrentSpeed(), 0.000001);
		
	}

	/**
	 * Starts all cars
	 */
	@BeforeEach
	public void resetStartAllCars() {
		volvo.startEngine();
		saab.startEngine();
		scania.startEngine();
	}

}