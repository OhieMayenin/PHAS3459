package module4;
import java.io.*;
import java.net.*;
import java.util.*;

public class WordCounter {
	public static BufferedReader brFromURL(String urlName) throws IOException {
		URL u = new URL(urlName); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		//		String line;
		//		while ((line = url.readLine()) != null) {
		//			 System.out.println(line);
		//			 } 
		return url;
	}

	public static BufferedReader brFromFile(String fileName) throws IOException {
		FileReader file = new FileReader(fileName);
		BufferedReader buffer_file = new BufferedReader(file); 
		return buffer_file;
	}

	public static int countWordsInResource(BufferedReader dataAsBR) {
		Scanner s = new Scanner(dataAsBR);
		int sum = 0;
		while (s.hasNext()) {
			sum = sum + 1;	
		}

		return sum;

	}


	public static void main(String[] args) {
		try {
			BufferedReader br_passage = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
			System.out.println("Number of words in passage: "+countWordsInResource(br_passage));
		}
		catch (Exception e) {
		}
	}


}


