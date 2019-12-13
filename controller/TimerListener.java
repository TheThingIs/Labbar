package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ImmutableVehicle;
import model.VehicleUniverse;

public class TimerListener implements ActionListener {


	/*
	 * Each step the TimerListener moves all the cars in the list
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		moveAll();
	}

	/**
	 * Moves all the cars represented on the view
	 */
	private void moveAll() {
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			v.move();
		}
	}

}
