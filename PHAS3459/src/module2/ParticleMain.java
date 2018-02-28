// This class will test the methods written in the FallingParticle class by simulating the falling particle, and outputting the final physical parameters //

package module2;

public class ParticleMain {

	public static void main(String[] args) {
		FallingParticle particle = new FallingParticle (5.2,3.6);
		FallingParticle.setH(10);

		// testing drop for deltaT = 0.5
		double dt = 0.5; // set deltaT
		FallingParticle.setv(0); // set initial velocity to zero
		FallingParticle.drop(particle, dt);
		System.out.println("The total time elapsed: "+particle.getT()+" seconds for dT = "+dt);	
		System.out.println("The final velocity of the particle: "+particle.getV());
		System.out.println();
		
		// testing drop for deltaT = 0.1
		double dt_2 = 0.1; // set deltaT
		FallingParticle.setv(0); // set initial velocity to zero
		FallingParticle.drop(particle, dt_2);
		System.out.println("The total time elapsed: "+particle.getT()+" seconds for dT = "+dt_2);	
		System.out.println("The final velocity of the particle: "+particle.getV());
		System.out.println();
		
		// testing drop for deltaT = 0.01
		double dt_3 = 0.01; // set deltaT
		FallingParticle.setv(0); // set initial velocity to zero
		FallingParticle.drop(particle, dt_3);
		System.out.println("The total time elapsed: "+particle.getT()+" seconds for dT = "+dt_3);	
		System.out.println("The final velocity of the particle: "+particle.getV());
		System.out.println();
		
		// testing drop for deltaT = 0.001
		double dt_4 = 0.001; // set deltaT
		FallingParticle.setv(0); // set initial velocity to zero
		FallingParticle.drop(particle, dt_4);
		System.out.println("The total time elapsed: "+particle.getT()+" seconds for dT = "+dt_4);	
		System.out.println("The final velocity of the particle: "+particle.getV());
		System.out.println();
		
		// testing drop for deltaT = 0.0001
		double dt_5 = 0.0001; // set deltaT
		FallingParticle.setv(0); // set initial velocity to zero
		FallingParticle.drop(particle, dt_5);
		System.out.println("The total time elapsed: "+particle.getT()+" seconds for dT = "+dt_5);	
		System.out.println("The final velocity of the particle: "+particle.getV());
		System.out.println();
		
		// explanations
		System.out.println();
		System.out.println("The smaller the time increment dT, the more accurate the final answers are to the real world scenario, because the change in position and velocity and calculated more frequently, so the while loop will end without the particle travelling through the floor significantly.");
		System.out.println("The first answer has a relatively large dT, so the time elapsed and final velocity are both overestimated, as the particle travelled through the floor before the while loop stopped.");
	}

}
