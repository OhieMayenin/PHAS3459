package module9;

import javax.swing.*;
import java.awt.*;

public class Animation extends JPanel {
	private final double G = 6.674*Math.pow(10, -11);
	private final double massSun = 100;
	private final double massMercury = 10;
	private final double massVenus = 30;
	private final double massEarth = 40;
	private final double massMars = 20;
	private static final double deltaTime = 0.1;
	private Timer animationTimer; // timer controlling frame rate
	
	
	public static void what() {
	double time;
	// F = GMm/r^2

	for (time = 0; time < 10000; time += deltaTime) {

		// animate mercury
		int xVenusRel = GraphicsPanel.xVenus - GraphicsPanel.xSun;


		// animate venus

		// animate earth

		// animate mars
	}
}
}