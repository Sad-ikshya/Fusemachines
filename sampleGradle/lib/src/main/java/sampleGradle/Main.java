package sampleGradle;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.random.JDKRandomGenerator;

public class Main {
	public static void main(String[] args) {
		int randomNumber;
		JDKRandomGenerator jdkRandomGenerator =new JDKRandomGenerator();
		randomNumber=jdkRandomGenerator.nextInt();
		System.out.println(randomNumber);
		
		TDistribution t = new TDistribution(29);
		double lowerTail = t.cumulativeProbability(-2.656);     // P(T(29) <= -2.656)
		double upperTail = 1.0 - t.cumulativeProbability(2.75);
		System.out.println(lowerTail+"	"+upperTail);
		
	}
}
