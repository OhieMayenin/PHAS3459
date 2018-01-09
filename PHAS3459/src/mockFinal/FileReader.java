package mockFinal;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
	//String urlNameIndex; // url of index.txt
	//String recording;	// url of recordings
	//String fileName;
	//String instrument;
	//HashMap<String,String> fileDetails;

	// read index.txt
	public static HashMap<String,String> readIndex (String urlNameIndex) throws Exception {
		HashMap<String,String> fileDetails = new HashMap<String,String>();

		URL u = new URL(urlNameIndex); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);

		for(int i = 0; i < 7; i++) {
			String fileName = s.next();
			String instrument = s.next();
			fileDetails.put(fileName,instrument);}

		return fileDetails;
	}
	
	public static RecordingSample readRecording(String filename, 
			HashMap<String,String> fileDetails) throws Exception {
		ArrayList<Double> amplitude = new ArrayList<Double>();
		double sampleFreq  = 0;
		int N = 0 ;
		double aMax = 0;
		RecordingSample sample;
		String urlRecording = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/"+filename;
		
		URL u = new URL(urlRecording); // convert string to URL
		InputStream is_url = u.openStream(); // inputs URL as bytes
		InputStreamReader isr_url = new InputStreamReader(is_url); // wrap input stream
		BufferedReader url = new BufferedReader(isr_url); // reads large chunk of data into memory
		Scanner s = new Scanner(url);
		
		while (s.hasNext()) {
			sampleFreq = Double.parseDouble(s.next());
			N = Integer.parseInt(s.next());
			aMax = Double.parseDouble(s.next());
			for (int i = 0; i < N; i++) {
			amplitude.add(Double.parseDouble(s.next()));
		}
		}
		sample = new RecordingSample(filename, fileDetails.get(filename), 
				 sampleFreq, N, aMax, amplitude);
		
		return sample;
		
	}
	
	

}
