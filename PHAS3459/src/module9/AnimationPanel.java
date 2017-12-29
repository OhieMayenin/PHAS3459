/*
 * extends GraphicsPanel
 * animates the panel
 */

package module9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationPanel extends GraphicsPanel implements ActionListener {
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;
	private JButton resetButton;
	public Timer animationTimer;
	public static int timeElapsed;
	int dt;

	/* Constructor adds timer to GraphicsPanel superclass */
	public AnimationPanel(int width, int height, int dt) {
		super(width, height);
		this.dt = dt;
		animationTimer = new Timer (dt, this);

		// adding buttons to GUI
		startButton = new JButton("Start");
		stopButton = new JButton("Pause");
		exitButton = new JButton("Exit");
		resetButton = new JButton("Reset");
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		resetButton.addActionListener(this);
		super.add(startButton);
		super.add(stopButton);
		super.add(resetButton);
		super.add(exitButton);

	}
	
	double cirMerc = 2*Math.PI*rMerc;
	double cirVenus = 2*Math.PI*rVenus;
	double cirEarth = 2*Math.PI*rEarth;
	double cirMars = 2*Math.PI*rMars;
	double cirJup = 2*Math.PI*rJup;
	double cirMoon = 2*Math.PI*rMoon;
	double cirComet = 2*Math.PI*rComet;
	
	// calculating total area swept in one orbit
	final double orbAreaMerc = Math.PI*rMerc*rMerc;
	final double orbAreaVenus = Math.PI*rVenus*rVenus;
	final double orbAreaEarth = Math.PI*rEarth*rEarth;
	final double orbAreaMars = Math.PI*rMars*rMars;
	
	double delta = 4; // arbitrary number to be scaled: change in angle per frame

	/**
	 * This is called by the animation Timer object
	 * to update the display, or buttons clicked
	 */

	/** Respond to button clicks */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==animationTimer) {
			timeElapsed += dt;
						
			angleMerc += 0.80*delta/cirMerc;
			angleVenus += 0.65*delta/cirVenus;
			angleEarth += 0.65*delta/cirEarth;
			angleMars += 0.50*delta/cirMars;
			angleJup += 0.165*delta/cirJup;
			angleMoon += 0.79*delta/cirMoon;
			
			angleComet += 0.010*delta/(Math.pow((Math.abs(rComet)+20),0.8));
			
			rComet = (int) (500*Math.sin(angleComet+Math.PI/4));
	
			cirComet = 2*Math.PI*rComet;

			repaint();
		}
		
		// buttons clicked
		else if (e.getSource()==startButton) {start();}
		else if (e.getSource()==stopButton) {stop();}
		else if (e.getSource()==exitButton) {System.exit(0);}
		
		else if (e.getSource()==resetButton) {
			timeElapsed = 0;
			angleMerc = 0;
			angleVenus = 0;
			angleEarth = 0;
			angleMars = 0;
			angleJup = 0;
			angleMoon = 0;
			angleComet = Math.PI/3;
			rComet = 500;
			cirComet = 2*Math.PI*rComet;
		}
	}

	/** Start the animation */
	public void start() {animationTimer.start();}
	/** Stop the animation */
	public void stop() {animationTimer.stop();}

}