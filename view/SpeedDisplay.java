package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import controller.CarController;
import model.Vehicle;

public class SpeedDisplay extends JPanel {

	/*
	 * private int speed; private final String vehicle;
	 * 
	 * public SpeedDisplay(String vehicle, int speed) { this.speed = speed;
	 * this.vehicle = vehicle; }
	 */
	public SpeedDisplay(int x, int y) {
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(x, 160));
		this.setBackground(Color.cyan);
	}

	// This method is called each time the panel updates/refreshes/repaints itself
	// TODO: Change to suit your needs.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int pos = 30;
		for (Vehicle v : CarController.getVehicles()) {
			g.setFont(new Font("TimesRoman", Font.BOLD, 24));
			g.drawString(v.getModelName() + "   " +  (Math.round(100 * v.getCurrentSpeed())) / 100.0, 0, pos);
			pos += 30;
		}

	}

}
