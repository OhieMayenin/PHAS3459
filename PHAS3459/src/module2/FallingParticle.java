package module2;

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
			public FallingParticle(double m,double d) {
				this.m = m;
				this.d = d;
							
		}
	
	// writing set and get methods
	
	// set height
	public static void setH(double set_h) {
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
	public static void doTimeStep(FallingParticle particle, double deltaT) {
		double a = (d*v*v/m) - g; // calculate acceleration
		// update position and velocity of particle after time deltaT
		v = v + a*deltaT;
		z = z + v*deltaT;
	}
	
	public static double drop(FallingParticle particle, double deltaT) {
		z = h;
		t = 0; // initialise elapsed time
		while (z > 0)  {
		doTimeStep(particle,deltaT);
		t = t + deltaT;
		}
		return z;
		
		
	}
	

}
