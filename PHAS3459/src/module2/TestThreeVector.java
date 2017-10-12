package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		
		// defining vectors to be used in calculations to follow
		ThreeVector tv = new ThreeVector(3,5,2); // vector v1
		ThreeVector tv2 = new ThreeVector(2,4,1); // vector v2
		ThreeVector tv3 = new ThreeVector(0,0,0); // vector v3
		
		// Testing methods
		
		//testing magnitude method
		double mag_ans = tv.magnitude();
		
	    // testing unit vector method
		ThreeVector uvec = tv.unitvector();
		
		// Now printing answers, where java will use the toString method
		// to print the answers in the required format
		System.out.println("The input vector is: "+tv);
		System.out.println("The magnitude is: "+mag_ans);
		System.out.println("The unit vector is: "+uvec);
		System.out.println();
		
		
		// TESTING SCALAR PRODUCT METHOD
		
		// v1.v2
		System.out.println("The scalar product of the vectors "+tv+ " and "+tv2+ " is: "+tv.scalarProduct(tv2));
		// v1.v3
		System.out.println("The scalar product of the vectors "+tv+ " and "+tv3+ " is: "+tv.scalarProduct(tv3));
		System.out.println();
		
		// TESTING VECTOR PRODUCT METHOD
		
		// v1 x v2
		System.out.println("The vector product of the vectors "+tv+ " and " +tv2+ " is: "+tv.vectorProduct(tv2));
		// v1 x v3
		System.out.println("The vector product of the vectors "+tv+ " and " +tv3+ " is: "+tv.vectorProduct(tv3));
		System.out.println();
		
		//TESTING ADD METHOD
		
		// v1 + v2
		System.out.println("The sum of the vectors "+tv+ " and " +tv2+ " is: "+tv.add(tv2));
		System.out.println();
		
		//TESTING ANGLE METHOD
		
		// between v1 and v2
		System.out.println("The angle between the vectors "+tv+ " and " +tv2+ " is: "+tv.angle(tv2)+" radians");
		// between v1 and v3
		System.out.println("The angle between the vectors "+tv+ " and " +tv3+ " is: "+tv.angle(tv3)+" radians");
		System.out.println();
	}

}
