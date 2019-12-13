package view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.CarController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller
 * in it's state. It communicates with the Controller by calling methods of it
 * when an action fires of in each of it's components. TODO: Write more
 * actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame {
	private static final int X = 1000;
	private static final int Y = 1000;

	// The controller member
	private final CarController carC;

	public final DrawPanel drawPanel = new DrawPanel(X, (Y / 2) + 200);
	public final SpeedDisplay sp = new SpeedDisplay(X, Y);
	private final ArrayList<JButton> buttons = new ArrayList<>();
	private final ArrayList<String> vechicleString = new ArrayList<>();
	private final JPanel controlPanel = new JPanel();
	private final JPanel spinnerPanel = new JPanel();
	private int gasAmount;
	private int liftAmount;
	private String vehicleSwitch = "Random";

	/**
	 * The view where everything is displayed on
	 * @param framename Title for the applications
	 * @param cc A CarController to control the cars
	 */
	public CarView(String framename, CarController cc) {
		createVehicleSpinner();
		createButtons();
		this.carC = cc;
		initComponents(framename);
	}
	
	/**
	 * Adds all the items to the vehicleSpinner
	 */
	private void createVehicleSpinner() {
		vechicleString.add("Random");
		vechicleString.add("Volvo240");
		vechicleString.add("Saab95");
		vechicleString.add("Scania");
		vechicleString.add("Man");
		vechicleString.add("Stena");

	}
	
	/**
	 * Adds all the buttons to the view
	 */
	private void createButtons() {
		buttons.add(new JButton("Gas"));
		buttons.add(new JButton("Turbo on"));
		buttons.add(new JButton("Lift Bed"));
		buttons.add(new JButton("Add car"));
		buttons.add(new JButton("Start all cars"));
		buttons.add(new JButton("Stop all cars"));
		buttons.add(new JButton("Brake"));
		buttons.add(new JButton("Turbo off"));
		buttons.add(new JButton("Lower Bed"));
		buttons.add(new JButton("Remove car"));
	}

	/**
	 * Sets everything in place and fits everything 
	 * @param title the title of the application
	 */
	private void initComponents(String title) {
		this.setResizable(false);
		this.setTitle(title);
		this.setPreferredSize(new Dimension(X, Y));
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		this.add(drawPanel);
		this.add(sp);
		spinnerPanel.setLayout(new GridLayout(8, 1));
		createGasSpinner();
		spinnerPanel.add(new JLabel(""));
		createCarSpinner();
		spinnerPanel.add(new JLabel(""));
		createLiftSpinner();

		this.add(spinnerPanel);
		controlPanel.setLayout(new GridLayout(2, 4));
		placeButtons();
		controlPanel.setPreferredSize(new Dimension((X / 2) + 28, 200));
		this.add(controlPanel);
		controlPanel.setBackground(Color.CYAN);
		setStyleButtons();
		buttonsAction();

		// Make the frame pack all it's components by respecting the sizes if possible.
		this.pack();

		// Get the computer screen resolution
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// Center the frame
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		// Make the frame visible
		this.setVisible(true);
		// Make sure the frame exits when "x" is pressed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	/**
	 * Sets a specific style to the stop and start all cars buttons
	 */
	private void setStyleButtons() {
		buttons.get(4).setBackground(Color.blue);
		buttons.get(4).setForeground(Color.white);
		buttons.get(4).setPreferredSize(new Dimension(X / 6 - 15, 200));
		this.add(buttons.get(4));

		buttons.get(5).setBackground(Color.red);
		buttons.get(5).setForeground(Color.black);
		buttons.get(5).setPreferredSize(new Dimension(X / 6 - 15, 200));
		this.add(buttons.get(5));

	}
	
	/**
	 * Places all the buttons in the right order
	 */
	private void placeButtons() {
		for (int i = 0; i < buttons.size(); i++) {
			controlPanel.add(buttons.get(i), i);
			buttons.get(i).setFont(new Font("TimesRoman", Font.BOLD, 18));
		}

	}

	/**
	 * Specifies the specific actions of each button
	 */
	private void buttonsAction() {
		buttons.get(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.gas(gasAmount);
			}
		});

		buttons.get(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.turboOn();
			}
		});

		buttons.get(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.liftBed(liftAmount);
			}
		});

		buttons.get(3).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.addVehicle(vehicleSwitch);
			}
		});

		buttons.get(4).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.start();
			}
		});

		buttons.get(5).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.stop();
			}
		});

		buttons.get(6).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.brake(gasAmount);
			}
		});

		buttons.get(7).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.turboOff();
			}
		});

		buttons.get(8).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.lowerBed(liftAmount);
			}
		});

		buttons.get(9).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				carC.removeVehicle(vehicleSwitch);
			}
		});

	}
	
	/**
	 * Creates the Vehicle spinner
	 */
	private void createCarSpinner() {
		SpinnerListModel spinnerModel = new SpinnerListModel(vechicleString);

		JSpinner addRemove = new JSpinner(spinnerModel);

		addRemove.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				vehicleSwitch = (String) ((JSpinner) e.getSource()).getValue();
			}
		});

		spinnerPanel.add(new JLabel("Car to add or remove"), BorderLayout.PAGE_START);
		spinnerPanel.add(addRemove, BorderLayout.PAGE_END);

	}
	
	/**
	 * Creates the Flatbed spinner
	 */
	private void createLiftSpinner() {
		SpinnerModel spinnerModel = new SpinnerNumberModel(0, // initial value
				0, // min
				70, // max
				1);// step
		JSpinner gasSpinner = new JSpinner(spinnerModel);
		gasSpinner.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				liftAmount = (int) ((JSpinner) e.getSource()).getValue();
			}
		});
		spinnerPanel.add(new JLabel("Amount to lift bed"));
		spinnerPanel.add(gasSpinner);

	}
	
	/**
	 * Creates the gas and brake spinner
	 */
	private void createGasSpinner() {
		SpinnerModel spinnerModel = new SpinnerNumberModel(0, // initial value
				0, // min
				100, // max
				1);// step
		JSpinner gasSpinner = new JSpinner(spinnerModel);
		gasSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				gasAmount = (int) ((JSpinner) e.getSource()).getValue();
			}
		});
		spinnerPanel.add(new JLabel("Amount of gas"));
		spinnerPanel.add(gasSpinner);

	}
}