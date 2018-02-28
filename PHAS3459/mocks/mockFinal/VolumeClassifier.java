package mockFinal;

public class VolumeClassifier implements SoundClassification{

	public void run(RecordingSample sample) {
		String volume = "";
		if (Math.abs(sample.amp) > 20) {volume = "loud";}
		else {volume = "quiet";}
		System.out.println("This sample is: " +volume);
	}

}
