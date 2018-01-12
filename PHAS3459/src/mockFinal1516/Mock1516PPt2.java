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

			for (String detector : database.keySet()) {
				ArrayList<PulseData> pulses = database.get(detector);
				for (PulseData pulse : pulses) {
					System.out.println(tvc.arrivalTime(pulse));
				}
			}
		}
		catch (Exception e) {e.printStackTrace();}
	}
}

