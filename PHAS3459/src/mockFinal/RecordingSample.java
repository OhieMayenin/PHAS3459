package mockFinal;

import java.util.ArrayList;

public class RecordingSample {
	String filename;
	String instrument; 
	double sampleFreq;
	int N;
	double aMax;
	ArrayList<Double> data;
	
	 public RecordingSample (String filename, String instrument, 
			 double sampleFreq, int N, double aMax, ArrayList<Double> data) {
		 filename = this.filename;
		 instrument = this.instrument;
		 sampleFreq = this.sampleFreq;
		 N = this.N;
		 aMax = this.aMax;
		 data = this.data;
	 }
	
}
