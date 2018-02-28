package mockFinal1213;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Mock1213Main {
	static HashMap<String, ArrayList<EnergyBin>> binDatabase;
	static HashMap<String, ArrayList<Higgs>> higgsDatabase;

	public static void main(String[] args) {
		String GGURL = "backgroundGG.txt";
		String ZZURL = "backgroundZZ.txt";
		String higgsURL = "higgsData.txt";
		DataReader dr = new DataReader("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2011-12/");

		try {
			ArrayList<EnergyBin> GGBins = dr.readURL(GGURL, "GG");
			ArrayList<EnergyBin> ZZBins = dr.readURL(ZZURL, "ZZ");
			//System.out.println(GGBins);
			//System.out.println(ZZBins);

			binDatabase = dr.sort(GGBins, ZZBins);
			//System.out.println(binDatabase);

			ArrayList<Higgs> allHiggs = dr.readHiggs(higgsURL);

			higgsDatabase = dr.sortHiggs(allHiggs, binDatabase);
			//System.out.println(higgsDatabase);

			// ALL UNPACKING DONE JUST WITHIN 1 HOUR
			// PART 1 STILL INCOMPLETE

			eventsInRange(120,140);

			candEventsInRange(120, 240);

			logLikelihood("GG");
			System.out.println("\n");
			logLikelihood("ZZ");


		}
		catch (IOException e) {e.printStackTrace();}
	}

	public static void eventsInRange(int min, int max) {
		int sum = 0;
		Collection<ArrayList<EnergyBin>> values = binDatabase.values();

		for (ArrayList<EnergyBin> array : values) {
			for (EnergyBin bin : array) {
				if (Double.parseDouble(bin.high) < max && Double.parseDouble(bin.low) > min) {
					sum += Double.parseDouble(bin.events);
				}
			}
		}

		System.out.println("\n");
		System.out.println("Total events in range " +min+"-"+max+" GeV is: "+sum);
	} 

	public static void candEventsInRange(int min, int max) {
		int candEvents = 0;
		Collection<String> binRanges = higgsDatabase.keySet();

		for (String binRange : binRanges) {
			if (Double.parseDouble(binRange.substring(0, 3)) > min && 
					Double.parseDouble(binRange.substring(6, 9)) < max) {
				ArrayList<Higgs> bin = higgsDatabase.get(binRange);

				for (Higgs hig : bin) {
					candEvents++;
				}
			}
		}

		System.out.println("Total candidate events in range " +min+"-"+max+" GeV is:  " +candEvents);
	}

	public static void logLikelihood(String key) {
		double loglikelihood = 0;
		for (int i = 0; i < 100; i++) {
			Collection<String> higgsKeys = higgsDatabase.keySet(); // key of hashmap

			for (String higgsKey : higgsKeys) {
				loglikelihood += (Double.parseDouble(binDatabase.get(key).get(i).events) - higgsDatabase.get(higgsKey).size()) +
						(higgsDatabase.get(higgsKey).size()*Math.log((higgsDatabase.get(higgsKey).size()/Double.parseDouble(binDatabase.get(key).get(i).events))));
			}
		}

		System.out.println("Log likelihood: " +loglikelihood);
	}

}
