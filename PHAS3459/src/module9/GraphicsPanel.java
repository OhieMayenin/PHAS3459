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
		g.fillOval(xSun, ySun, 70, 70);
			
		// MERCURY
		g.setColor(Color.GRAY);
		xMerc = width/3;
		yMerc = height/3;
		g.fillOval(xMerc, yMerc, 20, 20);
		
		// VENUS
		g.setColor(Color.ORANGE);
		xVenus = width/4;
		yVenus = height/4;
		g.fillOval(xVenus, yVenus, 25, 25);
		
		// EARTH
		g.setColor(Color.BLUE);
		xEarth = width/5;
		yEarth = height/5;
		g.fillOval(xEarth, yEarth, 30, 30);
		
		// MARS
		g.setColor(Color.RED);
		xMars = width/6;
		yMars = height/6;
		g.fillOval(xMars, yMars, 20, 20);
			
			
//		for (double r = 0.0; r < 1.0; r += 0.05) {
//			int x = (int) (width*r);
//			int y = height - (int) (height*r);
//			g.drawLine(x, 0, 0, y);
//		}
		
		Font f = new Font("TimesRoman",Font.BOLD,28);
		g.setFont(f);
		//g.drawString("where am i",width/2,height/2);
	}
}
