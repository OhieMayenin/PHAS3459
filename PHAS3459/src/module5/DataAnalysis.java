package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DataAnalysis {

	// converts URL name string to BufferedReader
	public static ArrayList<Double> dataFromURL(String urlName) throws IOException {
		ArrayList<Double> data = new ArrayList<Double>();
		
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);
		
		while (s.hasNext()) {
			double num = Double.parseDouble(s.next()); // parse string from resource as double
			data.add(num);
			System.out.println(num); // print this double
		}
		return data;
	}
	
	public static double goodnessOfFit(Theory nVal, ArrayList<DataPoint> dataPoints){
		
		
		double chiSq;
		return chiSq;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt";
		try {
			ArrayList<Double> dataList = dataFromURL(urlName);
			System.out.println(dataList);
		}
		catch(IOException e){System.out.println("ERROR: IOException caught.");}
	
	}

}
