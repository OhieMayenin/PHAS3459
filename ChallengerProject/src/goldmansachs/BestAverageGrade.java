package goldmansachs;

import java.util.ArrayList;
import java.util.HashMap;

public class BestAverageGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Complete the function below.
	 */

	static int bestAverageGrade(String[][] scores) {
		
		if (scores == null) {
			return 0;
		}
		
		int element = 0;
		String name = "";
		double score = 0;
		int highestScore;
		ArrayList<Double> studentScores;

		HashMap<String,ArrayList<Double>> sumScores = new HashMap<String,ArrayList<Double>>();
		
		for (int i = 0; i < scores.length; i++) {
			name = scores[i][element];
			
				if (sumScores.get(name) == null) {
					studentScores = new ArrayList<Double>();
					studentScores.add(Double.parseDouble(scores[i][element+1]));
					sumScores.put(name, studentScores);
				}
				else {
					studentScores = sumScores.get(name);
					studentScores.add(Double.parseDouble(scores[i][element+1]));
					sumScores.put(name, studentScores);
				}
			}
		
		int maxScore = 0;
		for (String student : sumScores.keySet()) {
			ArrayList<Double> studentData = sumScores.get(student);
			double sum = 0;
			for (int i = 0; i < studentData.size(); i ++) {
				sum += studentData.get(i);
			}
			int average = (int) Math.floor(sum/studentData.size());
			
			if (average > maxScore) {
				maxScore = average;
			}
		}

		return maxScore;
	}
}
