/** This class will take a string input linking to a data source
 * e.g URL link or file name
 * and will count the number of words in the resource.
 */

package module4;
import java.io.*;	// importing modules
import java.net.*;
import java.util.*;


public class WordCounter {

	// converts URL string input to BufferedReader
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory

		return url;
	}

	// converts fileName string to BufferedReader
	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader file = new FileReader(fileName); // convert string to FileReader
		BufferedReader buffer_file = new BufferedReader(file);  // convert FileReader to BufferedReader
		return buffer_file;
	}

	// counts number of words in resource file/URL
	public static int countWordsInResource(BufferedReader dataAsBR) {
		Scanner s = new Scanner(dataAsBR); // instantiate scanner
		int sum = 0; // initialise sum (i.e. number of words)

		// while loop increments sum for each word counted
		while (s.hasNext()) {
			s.next();
			sum = sum + 1;	
		}

		return sum;
	}


	public static void main(String[] args) {
		// counting number of words in string contained in URL

		try {
			// convert URL string to BufferedReader
			BufferedReader br_passage = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");

			// print number of words counted
			System.out.println("Number of words in passage: "+countWordsInResource(br_passage));
		}
		catch (Exception e) {
		}
	}


}


