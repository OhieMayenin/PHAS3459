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
			sumTime += p.arrivalTime;
		}
		double meanArrival = sumTime/pulseDatabase.get(key).size();
		double speed = Double.parseDouble(allDetectors.get(key))/(sumTime/pulseDatabase.get(key).size()); 
		System.out.println("The mean arrival time of the pulses: " +meanArrival +" ns");
		System.out.println("Speed of the particles: " +speed +" m/ns");
		}
	}

}
