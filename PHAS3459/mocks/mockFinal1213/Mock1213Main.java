package mockFinal1213;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Mock1213Main {

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
		
		HashMap<String, ArrayList<EnergyBin>> binDatabase = dr.sort(GGBins, ZZBins);
		System.out.println(binDatabase);
		
		ArrayList<Higgs> allHiggs = dr.readHiggs(higgsURL);
		
		HashMap<String, ArrayList<Higgs>> higgsDatabase = dr.sortHiggs(allHiggs, binDatabase);
		//System.out.println(higgsDatabase);
		
		// ALL UNPACKING DONE JUST WITHIN 1 HOUR
		// PART 1 STILL INCOMPLETE
		}
		catch (IOException e) {e.printStackTrace();}
	}

}
