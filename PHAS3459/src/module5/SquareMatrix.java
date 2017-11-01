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
			throw new Exception("ERROR: Not a valid square matrix --> x and y dimensions must be equal.");
		}
	}

	public String toString () {
		int i; // rows
		int j; //columns
		StringBuilder stringBuilder = new StringBuilder();

		// counting rows
		for (i = 0; i < this.numOfRows; i++ ) {

			double[] row_i = new double [numOfColumns];
			row_i = elements[i];
			
			// counting elements in each row
			for (j = 0; j < this.numOfColumns; j++) {
				double doubElement = row_i[j];
				stringBuilder.append(doubElement+", ");
			}
			stringBuilder.append("\n");
			}
		String str = "{"+ stringBuilder.toString() +"}";
		return str;
	}
}
