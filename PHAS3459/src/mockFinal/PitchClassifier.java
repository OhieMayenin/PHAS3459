package mockFinal;

import java.util.ArrayList;

public class PitchClassifier implements SoundClassification{
	
	public void run(RecordingSample sample) {
		String pitch = "";
		double specDensity = spectralDensity(sample.data, sample.T, 100); // 100Hz
		if (specDensity) {pitch = "low";}
		else if () {pitch = "medium";}
		else if () {pitch = "high";}
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
