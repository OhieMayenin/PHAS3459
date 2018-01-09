package mockFinal;

import java.io.BufferedReader; // import classes
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

public class MockPart1 {

	public static void main(String[] args) {
		String urlIndex = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt"; // url of index.txt
		String recording1 = "recording01.txt";	
		String recording2 = "recording02.txt";
		String recording3 = "recording03.txt";
		String recording4 = "recording04.txt";
		String genA = "genA.txt";
		String genB = "genB.txt";
		String genC = "genC.txt";

		try {
			HashMap<String,String> indexData = FileReader.readIndex(urlIndex);
			System.out.println(indexData);
		
			RecordingSample sample1 = FileReader.readRecording(recording1, indexData);
			RecordingSample sample2 = FileReader.readRecording(recording2, indexData);
			RecordingSample sample3 = FileReader.readRecording(recording3, indexData);
			RecordingSample sample4 = FileReader.readRecording(recording4, indexData);
			RecordingSample sampleA = FileReader.readRecording(genA, indexData);
			RecordingSample sampleB = FileReader.readRecording(genB, indexData);
			RecordingSample sampleC = FileReader.readRecording(genC, indexData);
			HashMap<String,RecordingSample> samples = sort(sample1,sample2,sample3,sample4, sampleA, sampleB, sampleC);
			System.out.println(samples.values());
		}
		catch (Exception e) {e.printStackTrace();}
	}


	public static HashMap<String,RecordingSample> sort(RecordingSample sample1,
			RecordingSample sample2, RecordingSample sample3, RecordingSample sample4, 
			RecordingSample sampleA, RecordingSample sampleB, RecordingSample sampleC) {
		HashMap<String,RecordingSample> samples = new HashMap<String,RecordingSample>();
		samples.put(sample1.instrument, sample1);
		samples.put(sample2.instrument, sample2);
		samples.put(sample3.instrument, sample3);
		samples.put(sample4.instrument, sample4);
		samples.put(sampleA.instrument, sampleA);
		samples.put(sampleB.instrument, sampleB);
		samples.put(sampleC.instrument, sampleC);

		return samples;
	}
}



