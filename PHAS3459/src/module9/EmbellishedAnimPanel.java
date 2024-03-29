/*
 * extends AnimationPanel
 * adds static decoration including
 * asteroid belt and background stars
 */

package module9;

import java.util.Random;

public class EmbellishedAnimPanel extends AnimationPanel{
	int width;
	int height;
	
	public EmbellishedAnimPanel (int width, int height, int dt) {
		super(width,height,dt);
		this.width = width;
		this.height = height;
		createStarField(); // randomly generate star coordinates
		createAsteroidBelt(); // randomly generate asteroid coordinates

	}
	
	public static final int NUM_STARS = 200;
	private static final int starMaxRadius = 3;
	static int[] starX;
	static int[] starY;
	static int[] starRadius;

	public static final int NUM_AST = 3500;
	private static final int asteroidMaxRadius= 5;
	static int[] astX;
	static int[] astY;
	static int[] astRadius;
	
	/*
	 * generates x,y coordinates and radii of stars
	 * to be painted in GraphicsPanel
	 */
	public void createStarField() {
		// create arrays of specified lengths
		Random rand = new Random();
		starX = new int[NUM_STARS];
		starY = new int[NUM_STARS];
		starRadius = new int[NUM_STARS];
		
		// fill arrays with randomly generated coordinates and radius
		for (int i = 0; i < NUM_STARS; i++) {
			starX[i] = rand.nextInt(width);
			starY[i] = rand.nextInt(height);
			starRadius[i] = rand.nextInt(starMaxRadius);
		}
	}
	
	/*
	 * generates x,y coordinates and radii of asteroids in asteroid belt
	 * to be painted in GraphicsPanel
	 */
	public void createAsteroidBelt() {
		// create arrays of specified lengths
		Random rand = new Random();
		astX = new int[NUM_AST];
		astY = new int[NUM_AST];
		astRadius = new int[NUM_AST];
		
		// fill arrays with randomly generated coordinates and radius
		for (int i = 0; i < NUM_AST; i++) {
			astX[i] = rand.nextInt(width);
			astY[i] = rand.nextInt(height);	
			astRadius[i] = rand.nextInt(asteroidMaxRadius);
		}

	}


}
