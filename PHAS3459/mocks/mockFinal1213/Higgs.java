package mockFinal1213;

public class Higgs {
	String channel;
	String energy;
	
	public Higgs (String channel, String energy) {
		this.channel = channel;
		this.energy = energy;
	}
	
	public String toString () {
		String str1 = "\n" +"Channel: " +channel + "\n" + "Energy: " +energy;
		return str1;
	}
}
