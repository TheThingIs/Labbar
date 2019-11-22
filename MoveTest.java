package Car;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoveTest {

	Volvo240 volvo = new Volvo240();
	Saab95 saab = new Saab95();
	Scania scania = new Scania();
	Man man = new Man();
	Stena stena = new Stena();
	CarGarage<Saab95> workshop = new CarGarage<Saab95>(8);

	/**
	 * Checks all setters and getters
	 */
	@Test
	public void settersGetters() {
		assertEquals(2, saab.getNrDoors(), 0);
		assertEquals(saab.getModelName(), "Saab95");
		assertEquals(Color.red, saab.getColor());
		saab.setColor(Color.blue);
		assertEquals(Color.blue, saab.getColor());
	}

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
	 * Checks Man and its flatbed and carloader
	 */
	@Test
	public void manTest() {
		man.brake(1);
		assertEquals(0, man.getAngleFlatbed(), 0);
		man.increaseAngle(0);
		man.gas(1);
		assertEquals(70, man.getAngleFlatbed(), 0);
		assertEquals(0, man.getCurrentSpeed(), 0);
		man.decreaseAngle(0);
		assertEquals(0, man.getAngleFlatbed(), 0);
		man.gas(1);
		assertEquals(0.7, man.getCurrentSpeed(), 0.000001);
		man.move();
		assertEquals(man.getCurrentSpeed(), man.getPositionY(), 0.000001);
		assertEquals(0, man.getPositionX(), 0.000001);
		man.brake(1);
		assertEquals(0.0, man.getCurrentSpeed(), 0);
		man.increaseAngle(0);
		assertEquals(70, man.getAngleFlatbed(), 0);
		man.loadCar(volvo);
		volvo.gas(1);
		volvo.move();
		assertEquals(0, volvo.getPositionX(), 0.000001);
		man.decreaseAngle(0);
		assertEquals(0, man.getAngleFlatbed(), 0);
		man.gas(1);
		man.move();
		assertEquals(2 * man.getCurrentSpeed(), man.getPositionY(), 0.000001);
		assertEquals(0, man.getPositionX(), 0.000001);
		assertEquals(man.getPositionY(), volvo.getPositionY(), 0.000001);
		assertEquals(0, volvo.getPositionX(), 0.000001);
		man.brake(1);
		man.increaseAngle(0);
		man.loadCar(saab);
		man.decreaseAngle(0);
		man.gas(1);
		man.move();
		man.brake(1);
		man.increaseAngle(0);
		saab.gas(1);
		man.unloadLastCar();
		assertEquals(man.getPositionY(), saab.getPositionY(), 0.000001);
		assertEquals(0, saab.getPositionX(), 0.000001);
		man.decreaseAngle(0);
		man.gas(1);
		man.move();
		assertEquals(man.getPositionY(), volvo.getPositionY(), 0.000001);
		assertEquals(0, volvo.getPositionX(), 0.000001);
		assertEquals(man.getPositionY() - man.speedFactor(), saab.getPositionY(), 0.000001);
		assertEquals(0, saab.getPositionX(), 0.000001);
	}

	/**
	 * Checks all functions of Stena
	 */
	@Test
	public void stenaTest() {
		stena.increaseAngle(70);
		stena.loadCar(saab);
		stena.loadCar(volvo);
		stena.decreaseAngle(70);
		stena.gas(1);
		stena.move();
		assertEquals(0.9, stena.getPositionY(), 0.000001);
		assertEquals(0, stena.getPositionX(), 0.000001);
		assertEquals(stena.getPositionY(), volvo.getPositionY(), 0.000001);
		assertEquals(0, volvo.getPositionX(), 0.000001);
		assertEquals(stena.getPositionY(), saab.getPositionY(), 0.000001);
		assertEquals(0, saab.getPositionX(), 0.000001);
		stena.brake(1);
		stena.increaseAngle(70);
		stena.unloadFirstCar();
		stena.decreaseAngle(70);
		stena.gas(1);
		stena.move();
		assertEquals(stena.getPositionY(), volvo.getPositionY(), 0.000001);
		assertEquals(0, volvo.getPositionX(), 0.000001);
		assertEquals(stena.getPositionY() - stena.getCurrentSpeed(), saab.getPositionY(), 0.000001);
		assertEquals(0, saab.getPositionX(), 0.000001);
		stena.brake(1);
		stena.increaseAngle(70);
		stena.gas(1);
		stena.move();
	}

	/**
	 * Checks if CarGarage is working properly
	 */
	@Test
	public void workshopTest() {
		workshop.depositCar(saab);
		workshop.returnCar(saab);
		//workshop.depositCar(volvo);
	}

	/**
	 * Starts all cars
	 */
	@BeforeEach
	public void resetStartAllCars() {
		volvo.startEngine();
		saab.startEngine();
		scania.startEngine();
		man.startEngine();
	}

}