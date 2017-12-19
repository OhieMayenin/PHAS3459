package module9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPanel extends GraphicsPanel implements ActionListener {
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	public Timer animationTimer;

	/* Constructor adds timer to GraphicsPanel superclass */
	public AnimationPanel(int width, int height, int dt) {
		super(width, height);
		animationTimer = new Timer (dt, this);

		// adding buttons to GUI
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		exitButton = new JButton("Exit");
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		super.add(startButton);
		super.add(stopButton);
		super.add(exitButton);
	}
	

	private static final double G = 6.674*Math.pow(10, -11); // gravitational constant
	private static final double M = 100; // mass of sun

	private static final double mMerc = 10; // mass of mercury
	private final double mVenus = 30; // mass of venus
	private final double mEarth = 40; // mass of earth
	private final double mMars = 20; // mass of mars


	// setting initial tangential speeds of planets
	private static final double uMerc = 10;
	private static final double uVenus = 10;
	private static final double uEarth = 10;
	private static final double uMars  =10;
	
	double cirMerc = 2*Math.PI*rMerc;
	double cirVenus = 2*Math.PI*rVenus;
	double cirEarth = 2*Math.PI*rEarth;
	double cirMars = 2*Math.PI*rMars;


	double delta = 5;


	/**
	 * This is called by the animation Timer object
	 * to update the display, or buttons clicked
	 */

	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==animationTimer) {
			angleMerc += 1.15*delta/cirMerc;
			angleVenus += delta/cirVenus;
			angleEarth += delta/cirEarth;
			angleMars += 0.85*delta/cirMars;

			repaint();
		}
		
		// buttons clicked
		else if (e.getSource()==startButton) {start();}
		else if (e.getSource()==stopButton) {stop();}
		else if (e.getSource()==exitButton) {System.exit(0);}
	}

	/** Start the animation */
	public void start() {animationTimer.start();}
	/** Stop the animation */
	public void stop() {animationTimer.stop();}

}