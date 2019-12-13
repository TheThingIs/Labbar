package controller;

import javax.swing.Timer;

import model.Vehicle;
import view.CarView;

public class App {

	// The delay (ms) corresponds to 20 updates a sec (hz)
	private final static int delay = 50;
	// The timer is started with an listener (see below) that executes the
	// statements
	// each step between delays.
	private final Timer timer;

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		App app = new App();
	}

	private App() {

		// Instance of this class
		CarController cc = new CarController();

		// Start a new view and send a reference of self
		CarView frame = new CarView("CarSim 1.0", cc);

		timer = new Timer(delay, new TimerListener());

		Vehicle.addObserver(frame.sp);
		Vehicle.addObserver(frame.drawPanel);

		// Start the timer
		timer.start();

	}

}
