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
	// coordinates of the Moon
	static int xMoon;
	static int yMoon;

	// set polar coordinates
	//	static int rMerc = (int) Math.sqrt((xMerc - xSun)*(xMerc - xSun) + (yMerc - ySun)*(yMerc - ySun));
	//	static int rVenus = (int) Math.sqrt((xVenus - xSun)*(xVenus - xSun) + (yVenus - ySun)*(yVenus - ySun));;
	//	static int rEarth = (int) Math.sqrt((xEarth - xSun)*(xEarth - xSun) + (yEarth - ySun)*(yEarth - ySun));;
	//	static int rMars = (int) Math.sqrt((xMars - xSun)*(xMars - xSun) + (yMars - ySun)*(yMars - ySun));;

	// set them constant
	static int rMerc = 50;
	static int rVenus = 100;
	static int rEarth = 170;
	static int rMars = 220;
	static int rMoon = 17; // RADIUS FROM EARTH
	
	// set initial angles of planets
	double angleMerc = Math.atan2(yMerc, xMerc);
	double angleVenus = Math.atan2(yVenus, xVenus);;
	double angleEarth = Math.atan2(yEarth, xEarth);;
	double angleMars = Math.atan2(yMars, xMars);;
	double angleMoon= Math.atan2(yMoon, xMoon);;
	
	// boolean for colours
	boolean colour = true;

	/* Constructor just sets size of panel. */
	public GraphicsPanel(int width, int height) {
		setPreferredSize(new Dimension(width,height));
		//Timer animationTimer = new Timer(dt,this);
		//animationTimer.start();
	}



	/* Must override this method, which is called
	 * by the Swing framework whenever the display
	 * needs updating.
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // call superclass method first
		Graphics2D g2 = (Graphics2D) g;
		int width = getWidth();
		int height = getHeight();

		// BACKGROUND SPACE
		GradientPaint background = new GradientPaint(width, height, Color.BLACK, 0,0, Color.BLACK, colour);
		g2.setPaint(background);
		g2.fillRect(0, 0, width, height);
		
		// adding stars in background
		g.setColor(Color.WHITE);
		for (int i = 0; i < EmbellishedAnimPanel.NUM_STARS; i++) {
			g2.fillOval(EmbellishedAnimPanel.starX[i], EmbellishedAnimPanel.starY[i], 
					EmbellishedAnimPanel.starRadius[i], EmbellishedAnimPanel.starRadius[i]);
		}
		
		// adding asteroid belt
		g.setColor(Color.darkGray);
		for (int i = 0; i < EmbellishedAnimPanel.NUM_AST; i++) {
			if(Math.sqrt(Math.pow((EmbellishedAnimPanel.astX[i] - xSun),2) + Math.pow((EmbellishedAnimPanel.astY[i] - ySun),2))>370
					&& Math.sqrt(Math.pow((EmbellishedAnimPanel.astX[i] - xSun),2) + Math.pow((EmbellishedAnimPanel.astY[i] - ySun),2))<450) {
				g2.fillOval(EmbellishedAnimPanel.astX[i], EmbellishedAnimPanel.astY[i],
						EmbellishedAnimPanel.astRadius[i], EmbellishedAnimPanel.astRadius[i]);
			}
		}


		// SUN
		GradientPaint sunColor = new GradientPaint(xSun-20, ySun-35, Color.RED, xSun+25, ySun+35, Color.YELLOW, colour);
		g2.setPaint(sunColor);
		xSun = width/2;
		ySun = height/2;
		int sunHeight = 33;
		int sunWidth = 33;
		g2.fillOval(xSun, ySun, sunHeight, sunWidth);

		// MERCURY
		xMerc = (int) (rMerc*Math.cos(angleMerc));
		yMerc = (int) (rMerc*Math.sin(angleMerc));
		GradientPaint mercColor = new GradientPaint(xMerc-4, yMerc-4, Color.gray, xMerc+4, yMerc+4, Color.darkGray, colour);
		g2.setPaint(mercColor);
		g.fillOval(xMerc+xSun, yMerc+ySun+(sunHeight/2), 7, 7);

		// VENUS	
		xVenus = (int) (rVenus*Math.cos(angleVenus));
		yVenus = (int) (rVenus*Math.sin(angleVenus));
		GradientPaint venColor = new GradientPaint(xVenus-10, yVenus-10, Color.RED, xVenus+10, yVenus+10, Color.YELLOW, colour);
		g2.setPaint(venColor);
		g2.fillOval(xVenus+xSun, yVenus+ySun+(sunHeight/2), 11, 11);

		// EARTH
		xEarth = (int) (rEarth*Math.cos(angleEarth));
		yEarth = (int) (rEarth*Math.sin(angleEarth));
		GradientPaint earthColor = new GradientPaint(xEarth-12, yEarth-12, Color.cyan, xEarth+8, yEarth+8, Color.BLUE, colour);
		g2.setPaint(earthColor);
		g2.fillOval(xEarth+xSun, yEarth+ySun+(sunHeight/2), 14, 14);

		// MARS	
		xMars = (int) (rMars*Math.cos(angleMars));
		yMars = (int) (rMars*Math.sin(angleMars));
		GradientPaint marsColor = new GradientPaint(xMars, yMars, Color.RED, xMars+7, yMars+7, Color.black, colour);
		g2.setPaint(marsColor);
		g.fillOval(xMars+xSun, yMars+ySun+(sunHeight/2), 9, 9);
		
		// Earth's moon
		xMoon = (int) (rMoon*Math.cos(angleMoon));
		yMoon = (int) (rMoon*Math.sin(angleMoon));
		GradientPaint moonColor = new GradientPaint(xEarth-12, yEarth-12, Color.darkGray, xEarth+8, yEarth+8, Color.gray, colour);
		g2.setPaint(moonColor);
		g2.fillOval(xSun+xMoon+xEarth+5, ySun+yMoon+yEarth+(sunHeight/2)+5, 6, 6);


//		 GradientPaint redtowhite = new GradientPaint(x, y, Color.red, 200, y, Color.white);
//		    g2.setPaint(redtowhite);

		 
		    
		Font f = new Font("TimesRoman",Font.BOLD,20);
		g.setFont(f);
		g.drawString("Time Elapsed: " +AnimationPanel.timeElapsed/1000 + " s",width/20,height/20);
	}
}