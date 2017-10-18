// This  class will define a Falling Particle with physical parameters and write relevant methods in order to simulate a particle... //
// ...being dropped from a specified height, which will be tested in the ParticleMain class.//

package module3;

public class FallingParticle {
	public static double m,d,t,z,h,v;
	// m, mass in kg
	// d, drag coefficient in kg/m
	// t, time elapsed since particle dropped in seconds
	// z, vertical position of particle measured upwards from base in m
	// h, initial starting height of particle measured upwards from base in m
	// v, velocity of particle measured upwards in m/s
	
	public static final double g = 9.81; //free fall due to gravity
	
	// constructor, used for later instantiations
			public FallingParticle(double m,double d) throws Exception {
				if (m <=0 ) {
					throw new Exception ("The particle must have a positive, non-zero mass in order to be physical.");
				}
				if (d < 0) {
					throw new Exception ("The drag coefficent cannot be negative.");
			}
				this.m = m;
				this.d = d;
							
		}
	
	// writing set and get methods
	
	// set height
	public static void setH(double set_h) throws Exception {
		if (set_h < 0) {
			throw new Exception("The particle cannot have a negative initial height, as it is measured upwards from the base.");
		}
		h = set_h;	
		}
	
	// set velocity
	public static void setv(double set_v) {
		v = set_v;	
	}	
		
	// get current position of particle Z
	public double getZ() {
		return z;	
		}
		
	// get current velocity of particle
	public double getV() {
		return v;	
		}
	
	// get time elapsed since particle was dropped
	public double getT() {
		return t;	
		}
		
	// adding time step method
	public static void doTimeStep(FallingParticle particle, double deltaT) throws Exception {
		double a = (d*v*v/m) - g; // calculate acceleration
		// update position and velocity of particle after time deltaT
		v = v + a*deltaT;
		z = z + v*deltaT;
	}
	
	public static double drop(FallingParticle particle, double deltaT) throws Exception {
		if (z < 0) {
			throw new Exception("The particle cannot have a negative vertical position, as it is measured upwards from the ground.");
		}
		z = h;
		t = 0; // initialise elapsed time
		while (z > 0)  {
		doTimeStep(particle,deltaT);
		t = t + deltaT;
		}
		return z;
		
		
	}
	

}
