/*
 *  main for part 1 of 2015-16 final paper
 */

package mockFinal1516;

import java.util.ArrayList;
import java.util.HashMap;

public class Mock1516PPt1 {

	public static void main(String[] args) {
		try {
			String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/";
			HashMap<String,ArrayList<PulseData>> database = DataReader.sortData(urlName);
			//System.out.println(database);

			double totalSum = 0;
			int numPulses = 0;
			for (ArrayList<PulseData> pulses : database.values()) {
				for (PulseData pulse : pulses) {
					totalSum += pulse.getAmplitude();
					numPulses++;
				}
			}
			//System.out.println(database.values());
			
			System.out.println("The total number of pulses: " +numPulses);
			System.out.println("The mean amplitude of all the pulses: " +(totalSum/numPulses));
			
			for (String detector : database.keySet()) {
				System.out.println("\n" +"The detector " +detector +" has " +database.get(detector).size() +" pulses.");
				
				int sumArrivTime = 0;
				numPulses = 0;
				for (PulseData pulse : database.get(detector)) {
					totalSum += pulse.getAmplitude();
					numPulses++;
					sumArrivTime += pulse.arrivalTime;
				}
				double meanAmp = totalSum/numPulses;
				double meanArrivTime = sumArrivTime/numPulses;
				System.out.println("The mean amplitude from this detector: " +meanAmp);
				System.out.println("The mean arrival time: " +meanArrivTime +" ns");
				
				double distance = 0;
				for (Detector detect : DataReader.detectors) {
					if (detect.detectorID.equals(detector)) {
					distance = Double.parseDouble(detect.distance);
				}
				}
				double particleSpeed = distance/meanArrivTime;
				System.out.println("The speed of the particles: " +particleSpeed + " m/ns");
				//System.out.println(DataReader.detectors);
				
				
			}
		}
		catch (Exception e) {e.printStackTrace();}
	}

}
