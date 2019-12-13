package view;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.Factory;
import model.IVehicleObserver;
import model.ImmutableVehicle;
import model.VehicleUniverse;
// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements IVehicleObserver {

	/**
	 * Initializes the panel and reads the images
	 * @param x The width of the DrawPanel
	 * @param y The height of the DrawPanel
	 */
	public DrawPanel(int x, int y) {
		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(x, y));
		this.setBackground(Color.green);
	}

	// This method is called each time the panel updates/refreshes/repaints itself
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int pos = 0;
		for (ImmutableVehicle v : VehicleUniverse.getImmutableVehicles()) {
			try {
				g.drawImage(ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/" + v.getModelName() + ".jpg")),
						(int) Math.round(v.getPositionX()), pos + (int) Math.round(v.getPositionY()), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			pos += 70;
		}

	}
	
	@Override
	public void notifyObservers() {
		this.repaint();
	}
}
