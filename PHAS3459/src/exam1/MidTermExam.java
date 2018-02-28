package exam1;

import java.io.BufferedReader; // import classes
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;
import java.lang.Math;

import mockExam.PlayerRecord;

public class MidTermExam {

	public static ArrayList<IceMonth> readURL(String urlName) throws IOException {

		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory


		String line = ""; 			// initialise line to scan
		String keyMonth = "";		// initialise hash key
		IceMonth monthMeasurement;	// IceMonth object for each measurement
		int i = 0;					// initialise counter

		ArrayList<IceMonth> allMeasurements = new ArrayList<IceMonth>(); // ArrayList to contain all IceMonth objects from URL file

		// while loop reads URL file and adds IceMonth object to this ArrayList for each line
		while ((line = url.readLine()) != null) {

			if (line.contains(".")) {
				// if condition skips any lines without numerical data, and skips months where measurements were not taken: "-9999"
				monthMeasurement = IceMonth.parseLine(line); // returns IceMonth object from line
				allMeasurements.add(monthMeasurement);		 // adds this IceMonth object to ArrayList
			}

		}

		return allMeasurements;
	}


	/*
	 * method returns HashMap containing measurements sorted by month
	 * takes ArrayList input of IceMonth objects representing all measurements
	 * hash key month is a String reading an integer representing number of month
	 * e.g. January - "1" ; February - "2" : December - "12" etc.
	 */
	public static HashMap<String,ArrayList<IceMonth>> sortIntoHashMap(ArrayList<IceMonth> allMeasurements) throws IOException {
		HashMap<String,ArrayList<IceMonth>> measurementsDatabase= new HashMap<String,ArrayList<IceMonth>>(); // instantiate HashMap to sort measurements by month
		String keyMonth = ""; // initialise hash key: month of measurement 

		// Loop over all measurements in ArrayList
		for (IceMonth measurement : allMeasurements) {

			// retrieve month of a certain measurement
			keyMonth = measurement.getMonth();

			// extract list of measurements from HashMap in this month
			ArrayList<IceMonth> monthMeasurements  = measurementsDatabase.get(keyMonth);

			// if this ArrayList is empty, create a new ArrayList of IceMonth objects
			if (monthMeasurements == null) {
				measurementsDatabase.put(keyMonth, new ArrayList<IceMonth>());
			}

			// add current measurement to list of measurements for that month
			measurementsDatabase.get(keyMonth).add(measurement);

		}

		return measurementsDatabase;
	}






	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/N_extent_v3.0.csv";


		try {
			ArrayList<IceMonth> allMeasurements = readURL(urlName);
			//System.out.println(allMeasurements);
			HashMap<String, ArrayList<IceMonth>> measurementsDatabase = sortIntoHashMap(allMeasurements); 
			//System.out.println(teamDatabase.get("1"));


			// finding total number of measurements
			System.out.println("Total number of measurements: " +allMeasurements.size()); // total number of players



			/*
			 * the following code will perform data analysis in order to obtain the following information:
			 *  - measurements of the months with the lowest total ice extent out of the entire period
			 *  - measurements of the months with the lowest total ice area out of the entire period
			 *  - for each calendar month, the year with the lowest ice extent in this month
			 *  - the difference in extent between each year and the previous year
			 *  - the five years with the largest drop in ice extent in this month
			 *  - average ice extent across all years for this calendar month
			 */

			// finding month with lowest total ice extent

			double lowestTotalExtent = Double.MAX_VALUE; // initialise lowest total ice extent
			double lowestTotalArea = Double.MAX_VALUE;	// initialise lowest total ice area

			double lowestExtent = Double.MAX_VALUE;
			String lowestExtentYear = "";
			double yearlyExtentDifference = 0;

			double totalExtent = 0;	// initialise total ice extent of all measurements for each month
			double totalArea = 0;	// initialise total ice area of all measurements for each month

			ArrayList <IceMonth> lowestExtentMonths = null; // initialise list to contain measurements of the month with lowest total *extent*
			ArrayList <IceMonth> lowestAreaMonths = null;	// initialise list to contain measurements of the month with lowest total *area*

			// for loop creates ArrayList and sorts measurements into them by month
			for (String month: measurementsDatabase.keySet()) {
				ArrayList<IceMonth> measurementsInMonth = new ArrayList<IceMonth>(); // ArrayList will hold all measurements made in a certain month
				measurementsInMonth = measurementsDatabase.get(month); // get all players in team
				//System.out.println(measurementsInMonth);

				// this loop ensures that all iceMonths in a list have been summed before setting lowestTotalExtent


				// loops through all IceMonth objects in ArrayList
				for (IceMonth iceMonth : measurementsInMonth) {
					totalExtent = totalExtent + Double.parseDouble(iceMonth.getExtent());

					// if totalExtent is lowest, sets as value for lowest total extent
					// and sets ArrayList of IceMonths as the lowestExtentMonths to be printed
					if (totalExtent < lowestTotalExtent) {
						lowestTotalExtent = totalExtent;
						lowestExtentMonths = measurementsInMonth;
					}

				}
				totalExtent = 0; // reset totalExtent for 

				// finding month with lowest total ice area

				// loops through all IceMonth objects in ArrayList
				for (IceMonth iceMonth : measurementsInMonth) {
					totalArea = totalArea + Double.parseDouble(iceMonth.getArea());

					// if totalArea is lowest, sets as value for lowest total are
					// and sets ArrayList of IceMonths as the lowestAreaMonths to be printed
					if (totalArea < lowestTotalArea) {
						lowestTotalArea= totalArea;
						lowestAreaMonths = measurementsInMonth;
					}

				}

				// finding year with the lowest ice extent for each month

				for (IceMonth iceMonth : measurementsInMonth) {
					if (lowestExtent > Double.parseDouble(iceMonth.getExtent())) {
						lowestExtent = Double.parseDouble(iceMonth.getExtent());
						lowestExtentYear = iceMonth.getYear();
					}


				}

				// print year with lowest ice extent for each calendar month
				System.out.println("\n" +"The year with the lowest ice extent for the month " +measurementsInMonth.get(0).getMonth() +": " +lowestExtentYear);


				// finding difference in extent between two consecutive years for each calendar month
				for (IceMonth iceMonth : measurementsInMonth) {
					for (IceMonth iceMonth2 : measurementsInMonth) {

						// if loop checks the IceMonth objects are one year apart
						if (Math.abs((Integer.parseInt(iceMonth.getYear()) - Integer.parseInt(iceMonth2.getYear()))) == 1) {
							yearlyExtentDifference = Math.abs(Double.parseDouble(iceMonth.getExtent())- Double.parseDouble(iceMonth2.getExtent()));
							// if loop ensures the same difference isn't printed twice
							if(Integer.parseInt(iceMonth.getYear()) < Integer.parseInt(iceMonth2.getYear())) {
							System.out.println("The difference in extent between the years " +iceMonth.getYear() +" and " +iceMonth2.getYear() +" for calendar month " +iceMonth.getMonth() +" is: " +yearlyExtentDifference);		
							}
						}
					}

				}

				// finding average ice extent across all years for this calendar month
				double sumExtent = 0; // initialise sum of extents
				
				// loop sums ice extents for all years of a particular calendar month
				for (IceMonth iceMonth : measurementsInMonth) {
					sumExtent = sumExtent + Double.parseDouble(iceMonth.getExtent());
					}
				
				// print average extent by dividing sumExtent by number of years
				System.out.println("\n" + "The average extent across all years for the calendar month " +measurementsInMonth.get(0).getMonth() +" is " + sumExtent/measurementsInMonth.size());




			}




			System.out.println("\n" +"The measurements for the month with the lowest total ice extent over the whole period are: " +lowestExtentMonths);
			System.out.println("\n" +"The measurements for the month with the lowest total ice area over the whole period are: " +lowestAreaMonths);



		}

		catch (Exception e) {e.printStackTrace();}
	}

}
