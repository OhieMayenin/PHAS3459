package module9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPanel extends GraphicsPanel implements ActionListener {
	
	/* Constructor adds timer to GraphicsPanel superclass */
	public AnimationPanel(int width, int height, int dt) {
		super(width, height);
		Timer animationTimer = new Timer (dt, this);
	
	}
		
	private static final double G = 6.674*Math.pow(10, -11); // gravitational constant
	private static final double M = 100; // mass of sun
	
	private static final double mMerc = 10; // mass of mercury
	private final double mVenus = 30; // mass of venus
	private final double mEarth = 40; // mass of earth
	private final double mMars = 20; // mass of mars
	
	private static final double dt = 1; // time step of animation in ms
	private Timer animationTimer;
	
	// setting initial tangential speeds of planets
	private static final double uMerc = 10;
	private static final double uVenus = 10;
	private static final double uEarth = 10;
	private static final double uMars  =10;
	
	// set initial angles of planets
	double angleMerc = Math.atan2(yMerc, xMerc);
	double angleVenus = Math.atan2(yVenus, xVenus);;
	double angleEarth = Math.atan2(yEarth, xEarth);;
	double angleMars = Math.atan2(yMars, xMars);;
	double delta = 1;
	
	// initialise planet coordinates in terms of r and angle
//	xMerc = super.rMerc*Math.cos(angleMerc);
//	yMerc = super.rMerc*Math.sin(angleMerc);
	
	
	
	 /**
	 * This is called by the animation Timer object
	 * to update the display
	 */
	 public void actionPerformed(ActionEvent event) {
	 angleMerc += delta;
	 repaint();
	 }
	
	 
	 /** Respond to button clicks */
//	 public void actionPerformed(ActionEvent e) {
//	 if (e.getSource()==startButton) start();
//	 else if (e.getSource()==stopButton) stop();
//	 else if (e.getSource()==exitButton) System.exit(0);
//	 }
	 
	/** Start the animation */
	 public void start() {animationTimer.start();}
	 /** Stop the animation */
	 public void stop() {animationTimer.stop();}
	
}