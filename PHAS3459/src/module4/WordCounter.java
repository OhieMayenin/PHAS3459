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
	
	//public static int countWordsInResource(BufferedReader dataAsBR) {}
	
	
	public static void main(String[] args) {
		try {
			brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
		}
		catch (Exception e) {
		}
		 }
	
	
}


