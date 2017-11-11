/**	This class will read URLs and extract the data they contain
 *  defines DataPoints based on data
 *  compares DataPoints to theoretical data
 *  uses X squared test to find best fit for data
 */

package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DataAnalysis {

	/* method takes argument as URL name String
	 * scans URL and extracts data as DataPoint objects
	 * returns ArrayList of DataPoints
	 */
	public static ArrayList<DataPoint> dataFromURL(String urlName) throws IOException {
		
		ArrayList<Double> data = new ArrayList<Double>(); // instantiate ArrayList for each line of data
		ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>(); // instantiate ArrayList for DataPoints
		
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url); // scan URL

		
		// while loop will return a DataPoint for each line of data
		while (s.hasNext()) {
			double num = Double.parseDouble(s.next()); // parse string from resource as double
			data.add(num); // append to data ArrayList
			
			
			// if loop will convert Double ArrayList to DataPoint once it contains three doubles, and reset Double ArrayList
			if (data.size() >=3) {
				DataPoint point = new DataPoint(data.get(0),data.get(1),data.get(2)); // instantiate new DataPoint using doubles from URL
				dataPoints.add(point); // append this DataPoint to ArrayList dataPoints
				data = new ArrayList<Double>(); // reset data ArrayList for next dataPoint
			}
		}
		
		return dataPoints;
	}
	
	/*	method will perform goodnessOfFit test by calculating X Squared
	 * takes arguments:
	 * - Theory: theoretical data 
	 * - ArrayList of DataPoints: experimental data from URL
	 */
	public static double goodnessOfFit(Theory theoretical, ArrayList<DataPoint> dataPoints){
		
		int i;
		double sum_chiSq = 0; // initialise chiSq value
		
		// for loop will sum together the X squared value from all dataPoints
		for (i = 0; i < dataPoints.size(); i++ ){
			DataPoint element = dataPoints.get(i); // extract each DataPoint from ArrayList input
			double chiSqPoint = (element.getY() - theoretical.y(element.getX()))*(element.getY() - theoretical.y(element.getX()))/ (element.getEy()*element.getEy());
			// calculate X squared for the DataPoint
			sum_chiSq = sum_chiSq + chiSqPoint; // add value to running sum
		}

		return sum_chiSq;

	}

	// main method
	public static void main(String[] args) {
		
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt"; // URL to be read
		
		try {
			ArrayList<DataPoint> dataPoints = dataFromURL(urlName); // read data from URL
			System.out.println("The dataPoints from the URL: "+dataPoints); // print ArrayList of DataPoints to console

			Theory squaredFit = new Theory(2); // set n = 2 for x^2 theoretical curve
			Theory power4Fit = new Theory(4); // set n = 4 for x^4 theoretical curve

			double chiSqx2 = goodnessOfFit(squaredFit,dataPoints); // perform goodnessOfFit test using x^2 curve
			System.out.println("Chi Sq for x^2: "+chiSqx2); // print value of X squared

			double chiSqx4 = goodnessOfFit(power4Fit, dataPoints); // perform goodnessOfFit test using x^4 curve
			System.out.println("Chi Sq for x^4: "+chiSqx4); // print value of X squared
			
			
			System.out.println(""); // leave blank line
			
			// prints conclusion of the X squared test to console
			if (chiSqx2 < chiSqx4) {
				System.out.println("The data fits better with the curve y = x^2");
			} 
			if ( chiSqx2 > chiSqx4){
				System.out.println("The data fits better with the curve y = x^4");
			}
			
		}

		catch(IOException e){e.printStackTrace();}
	}

}
