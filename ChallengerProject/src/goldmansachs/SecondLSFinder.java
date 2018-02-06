package goldmansachs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * find second largest/smallest
 * element in array
 * @author Ohie Mayenin
 *
 */
public class SecondLSFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> array1 = new ArrayList<Double>() {{
			add(3.5);
			add(8.3);
			add(40.);
			add(0.);
			add(-4.3);
			add(-60.);
		}};

		System.out.println(secondSmallest(array1));
		System.out.println(secondLargest(array1));
	}

	private static double secondSmallest(ArrayList<Double> input) {
		double smallest = Double.MAX_VALUE;
		double secondSmallest = Double.MAX_VALUE;

		for (double d : input) {
			if (d < smallest) {
				secondSmallest = smallest;
				smallest = d;
			}
		}
		return secondSmallest;
	}

	private static double secondLargest(ArrayList<Double> input) {
		double largest = -Double.MIN_VALUE;
		double secondLargest = -Double.MIN_VALUE;

		for (double d : input) {
			if (d > largest) {
				secondLargest = largest;
				largest = d;
			}
		}
		return secondLargest;
	}

}
