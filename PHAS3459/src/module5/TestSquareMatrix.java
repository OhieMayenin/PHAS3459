package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		 double [][] a = { {1 , 2 , 0},
		 		   		   {0 , 2 , 0},
		 		   		   {-2 , 0 , 1} } ;
		
		 double [][] b = { {2 , 1 , 0},
		 		   		   {0 , 1 , 0},
		 		   		   {-1 , 0 , 1} } ;
		 
		 double [][] c = { {4 , 3},
		 		   		   {3 , 2} } ;
		 
		 double [][] d = { {-2 , 3},
		 		   		   {3 , -4} } ;
		 
		try { SquareMatrix A = new SquareMatrix (a);
		System.out.println("Square Matrix A: \n " +A + "\n");
		}
		catch (Exception e) {}
		
		try { SquareMatrix B = new SquareMatrix (b);
		System.out.println("Square Matrix B: \n " +B+ "\n");
		}
		catch (Exception e) {}
		
		try { SquareMatrix C = new SquareMatrix (c);
		System.out.println("Square Matrix C: \n " +C+ "\n");
		}
		catch (Exception e) {}
		
		try { SquareMatrix D = new SquareMatrix (d);
		System.out.println("Square Matrix D: \n " +D+ "\n");
		}
		catch (Exception e) {}
		
	}

}
