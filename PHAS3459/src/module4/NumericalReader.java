/** This code will read URLs and analyse the data they contain
 * It will find numerical data in the source and print these data to the screen
 * as well as writing them to a newly created file in a directory specified by user input
 */

package module4;
import java.io.*; // importing modules
import java.net.*;
import java.util.*;

public class NumericalReader {

	// the following variables concern a data source to be read by this code
	private double minValue; 	// smallest value read
	private double maxValue; 	// greatest value read
	private double sumOfValues; // sum of all values read
	private int nValues; 		// number of values read	
	File outputfile; 	// file to be created

	// allows user to input directory where file is to be saved
	public static String getStringFromKeyboard() {
		InputStreamReader input = new InputStreamReader(System.in); // input stream from keyboard
		BufferedReader b = new BufferedReader(input); // converts InputStreamReader to BufferedReader
		System.out.println("Please specify the directory where the data is to be stored.");

		// sets default directory as user's home directory
		String s_default = System.getProperty("user.home");

		try {
			String s = b.readLine(); // read input and convert to string

			// loop sets directory to default home directory if directory not specified by user input
			if (s.isEmpty()) {
				s = s_default;
			}
			return s;
		}
		catch (IOException e) {
			System.out.println("No directory specified, user's home directory will be used to save file.");
			String s = s_default; // set directory to default home directory
			return s;
		}
	}

	// converts URL name string to BufferedReader
	public BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		return url;
	}

	/* method creates file
	 *  initialises minValue, maxValue, nValues & sumOfValues
	 * @param fileName
	 * @throws IOException
	 */
	void analysisStart(String fileName) throws IOException {
		outputfile = new File(fileName);

		// deleting existing file, creating new file
		if (outputfile.exists()) {
			outputfile.delete();
			outputfile.createNewFile();
		}

		// initialise/reset variables
		this.minValue = Double.MAX_VALUE; 
		this.maxValue = Double.MIN_VALUE;
		this.nValues = 0;
		this.sumOfValues = 0;

	}

	/* Analyses data in URL line by line and extracts numerical data
	 * ignores comment lines and blank lines
	 * updates minValue, maxValue, nValues and sumOfValues
	 * @param line
	 * @throws IOException
	 */
	void analyseData(String line) throws IOException{	
		// instantiating objects in order to write numbers to file
		Scanner s = new Scanner(line); 
		FileWriter fw = new FileWriter(outputfile,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		// while loop processes each line
		while (s.hasNext()) {

			if (line.isEmpty() || Character.isLetter(line.charAt(0))) {
				s.nextLine();
			}
			else { double num = Double.parseDouble(s.next()); // parse string from resource as double
			System.out.println(num); // print this double
			pw.println(num); // write this double to file
			nValues++; // increment number of values read
			sumOfValues = sumOfValues + num; // sum values

			// check if minValue and maxValue need to be updated
			// if yes, value will be updated
			if (num < minValue) {
				minValue = num;

			}

			if (num > maxValue) {
				maxValue = num;
			}			
			}
		}

		// avoid resource leaks
		s.close();
		pw.close();
	}

	// prints all final values calculated to console
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
		String directory = getStringFromKeyboard(); // user input directory
		System.out.println("Directory where data is to be stored: "+directory);

		try {
			// First URL

			// trying conversion of first URL

			// First URL to be read, and first file to be written
			String URL1 = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt";
			String file1 = "numbers1.txt";

			NumericalReader nr =  new NumericalReader(); // instantiate first NumericalReader
			String fileName = ("N:" + File.separator + directory + File.separator + file1);
			System.out.println("Analysing URL 1");
			nr.analysisStart(fileName); // creating file1 in specified directory	
			// wrapping URL in BufferedReader
			BufferedReader br1 = nr.brFromURL(URL1);

			// analysing each line of URL file at a time
			while ((line = br1.readLine()) != null) {
				nr.analyseData(line); // analyse line
			}

			nr.analysisEnd(); // end analysis and print values
			System.out.println("URL 1 has been successfully analysed. Numerical data can be found at: "+fileName);
			System.out.println();
			// end of URL 1 analysis
		}

		// catch exception
		catch (IOException e) {
			e.printStackTrace();
		}

		// Second URL

		// trying conversion of second URL
		try { 
			// Second URL to be read, and second file to be written
			String URL2 = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt";
			String file2 = "numbers2.txt";

			NumericalReader nr2 =  new NumericalReader(); // instantiate second NumericalReader
			String fileName2 = ("N:" + File.separator + directory + File.separator + file2);
			System.out.println("Analysing URL 2");
			nr2.analysisStart(fileName2); // creating file1 in specified directory	

			// wrapping URL in BufferedReader
			BufferedReader br2 = nr2.brFromURL(URL2);

			// analysing each line of URL file at a time
			while ((line = br2.readLine()) != null) {
				nr2.analyseData(line); // analyse line
			}

			nr2.analysisEnd(); // end analysis and print values
			System.out.println("URL 2 has been successfully analysed. Numerical data can be found at "+fileName2);

			// end of URL 2 analysis

		}

		// catch exceptions
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}

