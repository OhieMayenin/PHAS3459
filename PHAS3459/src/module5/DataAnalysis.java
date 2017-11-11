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

	// converts URL name string to BufferedReader
	public static ArrayList<DataPoint> dataFromURL(String urlName) throws IOException {
		ArrayList<Double> data = new ArrayList<Double>();
		ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);

		while (s.hasNext()) {
			double num = Double.parseDouble(s.next()); // parse string from resource as double
			data.add(num);
			if (data.size() >=3) {
				DataPoint point = new DataPoint(data.get(0),data.get(1),data.get(2));
				dataPoints.add(point);
				data = new ArrayList<Double>(); // reset double list for next dataPoint
			}
		}
		return dataPoints;
	}

	public static double goodnessOfFit(Theory theoretical, ArrayList<DataPoint> dataPoints){
		int i;
		double sum_chiSq = 0;
		for (i = 0; i < dataPoints.size(); i++ ){
			DataPoint element = dataPoints.get(i);
			double chiSqPoint = (element.getY() - theoretical.y(element.getX()))*(element.getY() - theoretical.y(element.getX()))/ (element.getEy()*element.getEy());
			sum_chiSq = sum_chiSq + chiSqPoint;
		}

		return sum_chiSq;

	}





	public static void main(String[] args) {
		String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt";
		try {
			ArrayList<DataPoint> dataPoints = dataFromURL(urlName);
			System.out.println(dataPoints);

			Theory squaredFit = new Theory(2);
			Theory power4Fit = new Theory(4);

			double chiSqx2 = goodnessOfFit(squaredFit,dataPoints);
			System.out.println("Chi Sq for x^2: "+chiSqx2);

			double chiSqx4 = goodnessOfFit(power4Fit, dataPoints);
			System.out.println("Chi Sq for x^4: "+chiSqx4);
		}

		catch(IOException e){e.printStackTrace();}
	}

}
