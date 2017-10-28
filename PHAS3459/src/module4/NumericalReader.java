package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class NumericalReader {
	double minValue;
	double maxValue;
	double sumOfValues;
	int nValues;
	File outputfile;

	public static String getStringFromKeyboard() throws IOException{
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader b = new BufferedReader(input);
		System.out.println("Please specify the directory where the data is to be stored.");
		String s_default = System.getProperty("user.home");

		try {
			String s = b.readLine();

			if (s.isEmpty()) {
				s = s_default;
			}
			return s;
		}
		catch (IOException e) {
			System.out.println("No directory specified, user's home directory will be used to save file.");
			String s = s_default;
			return s;
		}
	}

	public BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		return url;
	}

	// method creates file
	// initialises minValue, maxValue, nValues & sumOfValues
	void analysisStart(String fileName) throws IOException {
		String directory = getStringFromKeyboard();
		String file = ("N:" + File.separator + directory + File.separator + fileName);
		outputfile = new File(fileName);

		// deleting exisiting file, creating new file
		if (outputfile.exists()) {
			outputfile.delete();
			outputfile.createNewFile();
		}


		// initialise variables
		double minValue = Double.MIN_VALUE;
		double maxValue = Double.MAX_VALUE;
		int nValues = 0;
		double sumOfValues = 0;

	}

	void analyseData(String line) throws IOException{
		if (line.isEmpty() || Character.isLetter(line.charAt(0))) {
			return; 
		}

		Scanner s = new Scanner(line);
		FileWriter fw = new FileWriter(outputfile,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		while (s.hasNext()) {
			if (line.isEmpty() ==false || Character.isLetter(line.charAt(0))==false) {

				double num = Double.parseDouble(s.next());
				System.out.println(num);
				pw.println(num);
				nValues++;
				sumOfValues = sumOfValues + num;
				if (minValue > num) {
					minValue = num;
				}

				if (maxValue < num) {
					maxValue = num;
				}			
			}
		}
		pw.close();
		s.close();
	}

	void analysisEnd() {
		System.out.println("The minimum value is: "+minValue);
		System.out.println("The maximum value is: "+maxValue);
		System.out.println("The average value is: "+sumOfValues/nValues);
		System.out.println("The total number of values read: "+nValues);
	}


	public static void main(String[] args) {

		// creating and storing data into numbers1.txt file
		String line = "";

		// set directory that both files will be saved in
		try{ String directory = getStringFromKeyboard(); // user input directory
		System.out.println("Directory where data is to be stored: "+directory);
		}

		catch (IOException e) {}

		// First URL

		// trying conversion of first URL
		try { 
			String URL1 = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt";
			NumericalReader nr =  new NumericalReader();
			String file1 = "numbers1.txt";
			nr.analysisStart(file1); // creating file1 in specified directory	

			// wrapping URL in BufferedReader
			BufferedReader br1 = nr.brFromURL(URL1);

			// analysing each line of URL file at a time
			while ((line = br1.readLine()) != null) {
				nr.analyseData(line); // analyse line
			}

			nr.analyseData(line);


			nr.analysisEnd(); // end analysis and print values
			System.out.println("URL 1 has been successfully analysed.");

			// end of URL 1 analysis

		}

		catch (IOException e) {
			e.printStackTrace();
		}

		// Second URL

		// trying conversion of second URL
		try { 
			String URL2 = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt";
			NumericalReader nr =  new NumericalReader();
			String file2 = "numbers2.txt";
			nr.analysisStart(file2); // creating file1 in specified directory	

			// wrapping URL in BufferedReader
			BufferedReader br2 = nr.brFromURL(URL2);

			// analysing each line of URL file at a time
			while ((line = br2.readLine()) != null) {
				nr.analyseData(line); // analyse line
			}

			nr.analyseData(line);


			nr.analysisEnd(); // end analysis and print values
			System.out.println("URL 2 has been successfully analysed.");

			// end of URL 1 analysis

		}

		catch (IOException e) {
			e.printStackTrace();
		}






	}
}

