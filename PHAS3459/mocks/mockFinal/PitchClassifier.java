package mockFinal;

import java.util.ArrayList;

public class PitchClassifier implements SoundClassification{
	
	public void run(RecordingSample sample) {
		String pitch = "";
		// calculate spectral densities for 3 different frequencies
		double specDensity100 = Math.abs(spectralDensity(sample.data, sample.T, 100)); // 100Hz
		double specDensity400 = Math.abs(spectralDensity(sample.data, sample.T, 400)); // 400Hz
		double specDensity1000 = Math.abs(spectralDensity(sample.data, sample.T, 1000)); // 1000Hz
		// classify pitch based on spectral density
		if (specDensity100 > specDensity400 && specDensity100 > specDensity1000) {pitch = "low";}
		else if (specDensity400 > specDensity100 && specDensity400 > specDensity1000) {pitch = "medium";}
		else if (specDensity1000 > specDensity100 && specDensity1000 > specDensity400) {pitch = "high";}
		System.out.println(specDensity100);
		System.out.println(specDensity400);
		System.out.println(specDensity1000);
		
		System.out.println("This sound is: " +pitch);
	}
	
	
	
	private double spectralDensity(ArrayList<Double> data, double t, double f) {
		int bigN = data.size();
		double z = 2 * Math.PI * f * t / bigN;
		double sumCos = 0;
		double sumSin = 0;
		for (int n = 0; n < bigN; ++n) {
		sumCos += data.get(n)* Math.cos(z*n);
		sumSin += data.get(n)* Math.sin(z*n);
		}
		double norm = t / (bigN*bigN);
		return norm * (sumCos*sumCos + sumSin*sumSin);
		}
}
