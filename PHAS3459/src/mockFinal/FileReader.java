package mockFinal;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
	String urlNameIndex; // url of index.txt
	String recording;	// url of recordings
	String fileName;
	String instrument;
	HashMap<String,String> fileDetails;

	// read index.txt
	public HashMap<String,String> readIndex () throws Exception {
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
	
	public RecordingSample readRecording() throws Exception {
		HashMap<Double,Double> recordingDetails = new HashMap<Double,Double>();
		ArrayList<Double> amplitude = new ArrayList<Double>();
		double sampleFreq  = 0;
		int N = 0 ;
		double aMax = 0;
		RecordingSample sample;
		
		
		URL u = new URL(recording); // convert string to URL
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
		sample = new RecordingSample(recording, fileDetails.get(recording), 
				 sampleFreq, N, aMax, amplitude);
		
		return sample;
		
	}
	
	

}
