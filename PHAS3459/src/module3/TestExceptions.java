package module3;

public class TestExceptions {

	public static void main(String[] args) {
		
	// testing complex class method exceptions
		
		Complex c1 = new Complex(0,0);
		Complex c2 = new Complex (1,1);
		Complex c3 = new Complex(0,0);		
		
		// testing normalise method with null vector exception
		try {
			Complex normalised_c1 = Complex.normalised(c1);
			System.out.println("The normalised complex number: "+normalised_c1);
			System.out.println();
			}
		catch (Exception e) {
			System.out.println(e);
			}
		
				
		// testing divide method
		try {
			Complex divide = Complex.divide(c2,c3);
			System.out.println("Dividing c2 by c3 gives: "+divide);
			System.out.println();
			}
		catch (Exception e) {
			System.out.println(e);
			}
			
			
	// testing three vector class method exceptions
			
		ThreeVector tv = new ThreeVector(3,5,2); // vector v1
		ThreeVector tv2 = new ThreeVector(0,0,0); // vector v2
			
		// testing angle method between a non-zero vector and the null vector
		try {
			System.out.println("The angle between the vectors "+tv+ " and " +tv2+ " is: "+ThreeVector.angle(tv,tv2)+" radians");	
			}
		catch (Exception e) {
			System.out.println(e);
			}
		
		// testing unit vector method while inputting the null vector in order to throw an exception
		try {
			ThreeVector uvec = ThreeVector.unitvector(tv2);	
			System.out.println("The unit vector is: "+uvec);
			}
		catch (Exception e) {
			System.out.println(e);
			}
		finally {System.out.println();}
		
		
	// testing falling particle class method exceptions
		
		// testing negative mass and negative initial height exceptions
		
		// set (mass,drag coefficient)
		try { FallingParticle particle = new FallingParticle (-5.2,-3.6); // set first arg to negative to test mass exception
			FallingParticle.setH(-5); // set arg to negative to test height exception
			System.out.println("The initial height of the particle has been set to: " +particle.h+ " m");
			}
		catch (Exception e) {
			System.out.println(e);
			}	
	
	}

}
