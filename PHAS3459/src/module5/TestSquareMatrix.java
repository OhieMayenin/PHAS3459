package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		 double [][] x = { {1.1,2.2,3.3,4.4},
		 		   {5.5,6.6,7.7,8.8},
		 		   {9.9,8.8,7.7,6.6},
		 		   {5.5,4.4,3.3,2.2} } ;
		try{ SquareMatrix A = new SquareMatrix (x);
		System.out.println(A);
		}
		catch (Exception e) {}
		
//		SquareMatrix B = new SquareMatrix ();
//		
//		SquareMatrix C = new SquareMatrix ();
//		
//		SquareMatrix D = new SquareMatrix ();
		
	
	 
	 System.out.println(x);

	}

}
