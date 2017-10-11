package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		ThreeVector tv = new ThreeVector(1,1,1);
		
		// Testing methods
		
		//testing magnitude method
		double mag_ans = tv.magnitude();
	    // testing unit vector method
		ThreeVector uvec = tv.unitvector();
		
		// Now printing all answers, where java will use the toString method
		// to print the answers in the required format
		System.out.println("The input vector is: "+tv);
		System.out.println("The magnitude is: "+mag_ans);
		System.out.println("The unit vector is: "+uvec);
		
		
		

	}

}
