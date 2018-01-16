package mockFinal1516Take2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Mock1516T2Pt1 {
	static HashMap<String,String> allDetectors;
	static HashMap<String,ArrayList<Pulse>> pulseDatabase;

	public static void main(String[] args) {
		String signals = "signals.txt";
		String detectors = "detectors.txt";
		DataReader dr = new DataReader("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/");


		try {
			ArrayList<Pulse> allPulses = dr.readURL(signals);
			//System.out.println(allPulses);

			allDetectors = dr.readDetectors(detectors);
			System.out.println(allDetectors);

			pulseDatabase = sortByDetector(allPulses);
			//System.out.println(pulseDatabase);

			presentData();

			// implementations of ArrivalTimeCalculator
			//			maxVoltageCalc(allPulses.get(2));
			//			presentThresholdVoltageCalc(allPulses.get(2));

			try {
				recalculateSpeed(); 
			}
			catch (Exception e) {e.printStackTrace();}
		}
		catch (IOException e) {e.printStackTrace();}
	}


	public static HashMap<String, ArrayList<Pulse>> sortByDetector(ArrayList<Pulse> allPulses) {
		HashMap<String,ArrayList<Pulse>> pulsesByDetector = new HashMap<String,ArrayList<Pulse>>();
		ArrayList<Pulse> pulses;

		for (String detector: allDetectors.keySet()) {
			pulses = new ArrayList<Pulse>();
			for (Pulse p : allPulses) {
				if (p.detector.equals(detector)) {
					pulses.add(p);
				}
			}
			pulsesByDetector.put(detector, pulses);
		}

		return pulsesByDetector;
	}

	public static void presentData() {

		for (String key : pulseDatabase.keySet()) {
			System.out.println("\n");
			System.out.println("Detector ID: " +key +"\t" +"Distance: " +allDetectors.get(key) +" m");
			System.out.println("Total number of pulses: " +pulseDatabase.get(key).size());

			//calculate mean amplitude
			double sum = 0;
			for (Pulse p : pulseDatabase.get(key)) {
				sum += p.amplitude;
			}
			System.out.println("The mean amplitude of the pulses: " +sum/pulseDatabase.get(key).size() +" V");

			// calculate mean arrival time
			double sumTime = 0;
			for (Pulse p : pulseDatabase.get(key)) {
				sumTime += maxVoltageCalc(p);
			}
			double meanArrival = sumTime/pulseDatabase.get(key).size();
			double speed = Double.parseDouble(allDetectors.get(key))/(sumTime/pulseDatabase.get(key).size()); 
			System.out.println("The mean arrival time of the pulses: " +meanArrival +" ns");
			System.out.println("Speed of the particles: " +speed +" m/ns");
		}
	}

	public static double maxVoltageCalc(Pulse p) {
		MaxVoltageTimeCalc mvCalc = new MaxVoltageTimeCalc();

		return mvCalc.run(p);
	}

	public static void presentThresholdVoltageCalc(Pulse p) throws Exception {
		ThresholdTimeCalc ttCalc = new ThresholdTimeCalc(1);

		System.out.println("Arrival Time (threshold): " +ttCalc.run(p));
	}

	public static double thresholdVoltageCalc(Pulse p) throws Exception {
		ThresholdTimeCalc ttCalc = new ThresholdTimeCalc(1);

		return ttCalc.run(p);
	}

	public static void recalculateSpeed() throws Exception {
		System.out.println("--- Stats from using ArrivalTimeCalculator implementations ---");
		for (String key : pulseDatabase.keySet()) {
			// calculate mean arrival time
			double sumTime = 0;
			for (Pulse p : pulseDatabase.get(key)) {
				sumTime += thresholdVoltageCalc(p);
			}
			double sumTime2 = 0;
			for (Pulse p : pulseDatabase.get(key)) {
				sumTime2 += maxVoltageCalc(p);
			}
			double meanArrival = sumTime/pulseDatabase.get(key).size();
			double meanArrival2 = sumTime2/pulseDatabase.get(key).size();
			double speed = Double.parseDouble(allDetectors.get(key))/(sumTime/pulseDatabase.get(key).size()); 
			System.out.println("\n");
			System.out.println("--- " +key +" ---");
			System.out.println("The mean arrival time of the pulses (max voltage): " +meanArrival +" ns");
			System.out.println("The mean arrival time of the pulses (threshold): " +meanArrival2 +" ns");
			System.out.println("Difference between arrival times: " +Math.abs(meanArrival-meanArrival2) +" ns");
			System.out.println("Speed of the particles (max voltage): " +speed +" m/ns");
		}
	}
}
