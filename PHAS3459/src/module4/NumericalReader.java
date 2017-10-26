package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	PrintWriter pw;
	double minValue, maxValue, sumOfValues;
	int nValues;
	
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
	static void analysisStart(String dataFile, String directory) throws IOException {
		String file = ("N:" + File.separator + directory + File.separator + dataFile);
		File outputfile = new File(file);
		FileWriter fw = new FileWriter(outputfile); //N:\\numbers1.txt

		double minValue = Double.MIN_VALUE;
		double maxValue = Double.MAX_VALUE;
		int nValues = 0;
		double sumOfValues = 0;
		
	}

	void analyseData(String line) throws IOException{
		if (line.isEmpty() || Character.isLetter(line.charAt(0))) {
			return; 
		}
			PrintWriter pw = new PrintWriter("numbers1.txt");
			Scanner s = new Scanner(line);
			while (s.hasNext()) {
				
			}
			System.out.println(pw);
			pw.close();
	}

		
		
	void analysisEnd() {

	}


	public static void main(String[] args) {
		
		// creating and storing data into numbers1.txt file
		String line = "";
		NumericalReader nr =  new NumericalReader();
		
		try{ String directory = getStringFromKeyboard();
		System.out.println("Directory where data is to be stored: "+directory);
		analysisStart("numbers1.txt", directory); // (fileName, directory)	
		}	
		
		catch (IOException e) {}
		
		// trying conversion of first URL
		try { BufferedReader reader = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
		while ((line = reader.readLine()) != null) {
			analyseData(line); // analyse lines, check for comments etc.
		}
		}
		
		catch (IOException e) {}
		
		
	




}
}

