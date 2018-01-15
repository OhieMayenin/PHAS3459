package mockFinal1516;

import java.util.ArrayList;
import java.util.HashMap;

public class Mock1516PPt2 {

	public static void main(String[] args) {
		try {
			String urlName = "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2015-16/";
			HashMap<String,ArrayList<PulseData>> database = DataReader.sortData(urlName);
			System.out.println(database);

			double totalSum = 0;
			int numPulses = 0;
			for (ArrayList<PulseData> pulses : database.values()) {
				for (PulseData pulse : pulses) {
					totalSum += pulse.getAmplitude();
					numPulses++;
				}
			}

			ThresholdVoltageCalc tvc = new ThresholdVoltageCalc(1); // set threshold voltage to 1V			
			double dist = 0;
			String printDetector = "";

			for (String detector : database.keySet()) {
				// get detector distance
				ArrayList<Detector> dets = DataReader.detectors;
				for (Detector det : dets) {
					if (det.detectorID.equals(detector)) {
						dist = Double.parseDouble(det.distance);
						printDetector = detector;
						break;
					}
				}

				double arrivalTimeSum = 0;
				ArrayList<PulseData> pulses = database.get(detector);
				for (PulseData pulse : pulses) {
					arrivalTimeSum += tvc.arrivalTime(pulse);
				}
				System.out.println("Speed of the particles for " +printDetector +" using threshold method: " +(dist/arrivalTimeSum));
			}

			
			System.out.println("\n");
			
			
			// PART 3

			MaxVoltageCalc mvcTest = new MaxVoltageCalc(); // initial method
			ThresholdVoltageCalc tvcTest = new ThresholdVoltageCalc(1); // set threshold voltage to 1V			
			double maxDifference = 0;
			String maxDetector = "";
			
			for (String detector : database.keySet()) {

				double arrivalTimeSumTVC = 0;
				double arrivalTimeSumMVC = 0;
				ArrayList<PulseData> pulses = database.get(detector);
				for (PulseData pulse : pulses) {
					arrivalTimeSumTVC += tvcTest.arrivalTime(pulse);
					arrivalTimeSumMVC += mvcTest.arrivalTime(pulse);
				}
//				System.out.println("Average arrival time for max voltage method: " +(arrivalTimeSumMVC/pulses.size()));
//				System.out.println("Average arrival time for threshold voltage method: " +(arrivalTimeSumTVC/pulses.size()) +"\n");
				double difference = Math.abs((arrivalTimeSumMVC/pulses.size())-(arrivalTimeSumTVC/pulses.size()));
				
				if (difference > maxDifference) {
					maxDifference = difference;
					maxDetector = detector;
				}
				
			}
			System.out.println("Largest difference of arrival time calculated to be: " +maxDifference +" ns"
					+" which belongs to the detector: " +maxDetector);
			

		}
		catch (Exception e) {e.printStackTrace();}
	}
}

