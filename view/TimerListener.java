package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {

	private CarView frame;

	/**
	 * Represents a TimerListener
	 * 
	 * @param frame A Carview
	 */
	public TimerListener(CarView frame) {
		this.frame = frame;
	}

	/*
	 * Each step the TimerListener moves all the cars in the list and tells the view
	 * to update its images. Change this method to your needs.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// x = (int) Math.round(v.getPositionX());
		// y = (int) Math.round(v.getPositionY());
		// frame.drawPanel.moveit(x, y);
		// repaint() calls the paintComponent method of the panel
		frame.drawPanel.moveAll();
		frame.drawPanel.repaint();
		frame.sp.repaint();

	}

}
