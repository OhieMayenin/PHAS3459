package module9;

import javax.swing.*;
import java.awt.*;

public class GraphicsPanel extends JPanel {
	
	// coordinates of Sun
	static int xSun;
	static int ySun;
	// coordinates of Mercury
	static int xMerc;
	static int yMerc;
	// coordinates of Venus
	static int xVenus;
	static int yVenus;
	// coordinates of Earth
	static int xEarth;
	static int yEarth;
	// coordinates of Mars
	static int xMars;
	static int yMars;
	
	/* Constructor just sets size of panel. */
	public GraphicsPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
	}
	
	
	 /* Must override this method, which is called
	 * by the Swing framework whenever the display
	 * needs updating.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // call superclass method first
		int width = getWidth();
		int height = getHeight();
		
		// BACKGROUND SPACE
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		// SUN
		g.setColor(Color.YELLOW);
		xSun = width/2;
		ySun = height/2;
		g.fillOval(xSun, ySun, 35, 35);
			
		// MERCURY
		g.setColor(Color.GRAY);
		xMerc = 5*width/9;
		yMerc = 5*height/9;
		g.fillOval(xMerc, yMerc, 6, 6);
		
		// VENUS
		g.setColor(Color.ORANGE);
		xVenus = 2*width/5;
		yVenus = 2*height/5;
		g.fillOval(xVenus, yVenus, 10, 10);
		
		// EARTH
		g.setColor(Color.BLUE);
		xEarth = 2*width/6;
		yEarth = 2*height/6;
		g.fillOval(xEarth, yEarth, 12, 12);
		
		// MARS
		g.setColor(Color.RED);
		xMars = 2*width/7;
		yMars = 2*height/7;
		int xSunInt = (int) xSun;
		int ySunInt = (int) ySun;
		g.fillOval(xMars, yMars, 8, 8);
			
				
		Font f = new Font("TimesRoman",Font.BOLD,28);
		g.setFont(f);
	}
}