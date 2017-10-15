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
		System.out.println("");
	}

}
