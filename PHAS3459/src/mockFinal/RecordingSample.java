package mockFinal;

import java.util.ArrayList;

public class RecordingSample {
	String filename;
	String instrument; 
	double sampleFreq;
	int N;
	double aMax;
	ArrayList<Double> data;
	double T; // duration to be calculated
	double amp; // amplitude of signal in dBFPS to be calculated
	double aRms; // root mean sq amplitude of signal
	double sumSquares; // used in rms calculation, is sum of squared values from data array
	
	 public RecordingSample (String filename, String instrument, 
			 double sampleFreq, int N, double aMax, ArrayList<Double> data) {
		 this.filename = filename;
		 this.instrument = instrument;
		 this.sampleFreq = sampleFreq;
		 this.N = N;
		 this.aMax = aMax;
		 this.data = data;
		 
		 for (int i = 0; i < N; i++) {
			 sumSquares += data.get(i)*data.get(i);
		 }
		 
		 aRms = Math.sqrt((1/N)*(sumSquares));
		 T = N/sampleFreq;
		 amp = 20*Math.log10(aRms/aMax);
	 }
	 
	 public String toString() {
			String strFirst = "Instrument: " + instrument + "\t" + "File Name: " + filename;
			String strSecond = "Sample Frequency: " +sampleFreq +"\t" +"Number of Samples: " +N +"\t" +"Max. Amplitude: " +aMax;
			String strThird = "Duration: " +T +"s" +"\t" +"Amplitude of Signal: " + amp +"dBFS";

			String strAll = "\n" +"\n" +strFirst + "\n" + strSecond +"\n" + strThird;

			return strAll;
		}
	
}
