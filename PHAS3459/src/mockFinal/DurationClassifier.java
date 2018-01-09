package mockFinal;

public class DurationClassifier implements SoundClassification{
	
	public void run(RecordingSample sample) {
		String length = "";
		if (sample.T <=1) {length = "short";}
		else {length = "long";}
		System.out.println("This sample is: " + length);
	}
}