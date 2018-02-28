<<<<<<< HEAD
/*
 * main method
 * creates applet that simulates solar system
 */

package module9;

import javax.swing.*;

public class SolarSystem {

	public static void main(String[] args) {
		// call method to create and display GUI
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGui();
			}
		});

	}

	public static void createAndDisplayGui() {
		JFrame frame = new JFrame("Solar System");

		// exit application if window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// GraphicsPanel panel = new GraphicsPanel(1920,1080);
		// AnimationPanel panel = new AnimationPanel(1920,1080,5);
		EmbellishedAnimPanel panel = new EmbellishedAnimPanel(1920,1080,5);
		frame.add(panel); // add animation to frame
		frame.pack(); // set component sizes and layout
		frame.setVisible(true); // display resulting frame
		panel.animationTimer.start(); // start animation on launch
	}
	
	
=======
package module9;

import javax.swing.*;

public class SolarSystem {

	public static void main(String[] args) {
		// call method to create and display GUI
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndDisplayGui();
			}
		});

	}

	public static void createAndDisplayGui() {
		JFrame frame = new JFrame("Solar System");

		// exit application if window is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsPanel panel = new GraphicsPanel(1920,1080);
		frame.add(panel); // add label to frame
		frame.pack(); // set component sizes and layout
		frame.setVisible(true); // display resulting frame
	}

>>>>>>> branch 'master' of https://github.com/OhieMayenin/PHAS3459.git
}
