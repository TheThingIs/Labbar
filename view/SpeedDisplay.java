package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

import model.IVehicleObserver;
import model.ImmutableVehicle;
import model.VehicleUniverse;

public class SpeedDisplay extends JPanel implements IVehicleObserver {

	/**
	 * Creates a new SpeedDisplay that displays the speed of the cars represented on
	 * the view
	 * @param x The width of the SpeedDisplay
	 * @param y The height of the SpeedDisplay
	 */
	public SpeedDisplay(int x, int y) {
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(x, 60));
		this.setBackground(Color.cyan);
	}

	// This method is called each time the panel updates/refreshes/repaints itself
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int posX = 0;
		int posY = 20;
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			g.setFont(new Font("TimesRoman", Font.BOLD, 20));
			g.drawString(v.getModelName() + " " + (Math.round(100 * v.getCurrentSpeed())) / 100.0, posX, posY);
			posX += 200;
			if (posX >= 200 * 5) {
				posX = 0;
				posY = 50;
			}
		}

	}

	@Override
	public void notifyObservers() {
		this.repaint();

	}

}
