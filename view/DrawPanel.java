package view;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.CarController;
import model.Saab95;
import model.Scania;
import model.Vehicle;
import model.Volvo240;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

	// Just a single image, TODO: Generalize
	// To keep track of a singel cars position
	private Map<Vehicle, Image> images = new HashMap<>();

	private ArrayList<SpeedDisplay> sp = new ArrayList<>();

	// TODO: Make this genereal for all cars
	// public void moveit(int x, int y) {

	// }

	// Initializes the panel and reads the images
	public DrawPanel(int x, int y) {

		this.setDoubleBuffered(true);
		this.setPreferredSize(new Dimension(x, y));
		this.setBackground(Color.green);
		// Print an error message in case file is not found with a try/catch block
		try {
			// You can remove the "pics" part if running outside of IntelliJ and
			// everything is in the same main folder.
			// volvoImage = ImageIO.read(new File("Volvo240.jpg"));

			// Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to
			// pics.
			// if you are starting in IntelliJ.
			Volvo240 v = new Volvo240();
			CarController.addVehicle(v);
			Saab95 s = new Saab95();
			CarController.addVehicle(s);
			Scania sc = new Scania();
			CarController.addVehicle(sc);

			images.put(v, ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Volvo240.jpg")));
			images.put(s, ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Saab95.jpg")));
			images.put(sc, ImageIO.read(DrawPanel.class.getResourceAsStream("../pics/Scania.jpg")));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	// This method is called each time the panel updates/refreshes/repaints itself
	// TODO: Change to suit your needs.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int pos = 0;
		for (Vehicle v : CarController.getVehicles()) {
			g.drawImage(images.get(v), (int) Math.round(v.getPositionX()), pos + (int) Math.round(v.getPositionY()),
					null);
			pos += 100;
		}

	}
	
	public void moveAll() {
		for (Vehicle v : CarController.getVehicles()) {
			v.move();
		}
	}
}
