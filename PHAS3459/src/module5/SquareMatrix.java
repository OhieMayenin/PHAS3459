package module5;

import java.lang.reflect.Array;

public class SquareMatrix {

	public int numOfRows;
	public int numOfColumns;
	
	double[][] elements;

	public SquareMatrix (double[][] elementsIn) throws Exception {
		elements = elementsIn;
		this.numOfRows =  elements.length;
		this.numOfColumns = Array.getLength(elements[0]);

		if (numOfRows != numOfColumns) {
			throw new Exception("Not a valid square matrix.");
		}
	}

	public String toString () {
		int i;
		StringBuilder stringBuilder = new StringBuilder();
		
		for (i = 0; i < this.numOfRows; i++ ) {
			double[] row_i = elements[i];
			
//		    if(row_i[i] == 0) {
//			row_i[i] = elements[i]; // need to fill rows with elements
//		    }
		    
			stringBuilder.append(row_i);
		}
		String str = "{"+ stringBuilder.toString() +"}";
		return str;
	}
}
