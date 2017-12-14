package module9;

import javax.swing.*;
import java.awt.*;

public class Animation extends JPanel {
	
	private static final double G = 6.674*Math.pow(10, -11); // gravitational constant
	private static final double M = 100; // mass of sun
	private static final double mMerc = 10; // mass of mercury
	private final double mVenus = 30; // mass of venus
	private final double mEarth = 40; // mass of earth
	private final double mMars = 20; // mass of mars
	private static final double dt = 0.1; // time step of animation
	private Timer animationTimer; // timer controlling frame rate
	
	// setting initial tangential speeds of planets
	private static final double uMerc = 10;
	private static final double uVenus = 10;
	private static final double uEarth = 10;
	private static final double uMars  =10;
	 
	public static void animationStart() {
	double time;
	// F = GMm/r^2

	for (time = 0; time < 10000; time += dt) {

		// animate mercury
		int xMercRel = GraphicsPanel.xMerc - GraphicsPanel.xSun;
		double MercForce = G*M*mMerc/xMercRel*xMercRel;
		
		// calculate change in position in radial direction
		double drMerc = uMerc*dt + ((1/2*mMerc)*MercForce*dt*dt); 
		
		// dr = 
		
		// ds = ut + 1/2at^2;
		
		


		// animate venus

		// animate earth

		// animate mars
	}
}
}