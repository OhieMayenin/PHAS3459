package goldmansachs;

public class ClockAngle {

	public static void main(String[] args) {
		System.out.println(findAngle(12, 30));
		System.out.println(findAngle(9, 00));
		System.out.println(findAngle(3, 20));

	}
	
	/**
	 * finds angle between hourHand and minuteHand
	 * @param hourHand - position of hour hand
	 * @param minuteHand - position of minute hand
	 * @return
	 */
	private static double findAngle(int hourHand, int minuteHand) {
		double hourHandAngle = hourHand*(360/12) + minuteHand*(0.5);
		double minuteHandAngle = minuteHand*(360/60);
		
		double angle = Math.abs(hourHandAngle - minuteHandAngle);
		
		if (angle >= 360) {
			angle = angle -360;
		}
		return angle;
	}

}
