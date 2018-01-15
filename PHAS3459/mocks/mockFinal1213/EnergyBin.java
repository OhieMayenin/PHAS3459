package mockFinal1213;

public class EnergyBin {
	String low;
	String high;
	String events;
	String channel;
	
	public EnergyBin (String channel, String low, String high, String events) {
		this.low = low;
		this.high = high;
		this.events = events;
		this.channel = channel;
	}
	
	public String toString () {
		String finalStr;
		
		String str1 = "Channel: " +channel;
		String str2 = "Bin Range: " +low +"-" +high +" GeV";
		String str3 = "Expected Events: " +events;
		finalStr = "\n"+"\n" +str1 + "\n" +str2 + "\n" +str3;
		return finalStr;
		
	}
}
