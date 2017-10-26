package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	
	public static String getStringFromKeyboard() throws IOException{
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(input);
		System.out.println("Please specify the directory where the data is to be stored.");
		String s = b.readLine();
		return s;
	}
	
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		return url;
	}
	
	// method creates file
	static void analysisStart(String dataFile) throws IOException {
		String file = ("N:" + File.separator + "EclipseFiles" + File.separator + dataFile);
		File outputfile = new File(file);
		FileWriter fw = new FileWriter(outputfile);
				
//		private double minValue;
//		private double maxValue;
//		private double nValues;
//		private double sumOfValues;
	}
	
	void analyseData(String line) {
		if (line.isEmpty()) {
			//line.next();
		}
	}
	
	void analysisEnd() {
		
	}
	
	
	public static void main(String[] args) {
		try{ String inputString = getStringFromKeyboard();
		System.out.println("Directory where data is to be stored: "+inputString);
		analysisStart(inputString);
		}
		catch (IOException e) {}
		
		
		
	}

	

}
