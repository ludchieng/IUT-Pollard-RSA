package math;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.sql.Timestamp;

public class DataMiner {

	private static final int NB_ITERATIONS = 100000;
	private static final int MAX_P_INDEX = 500;
	private static final String ALGO = "pol3";
	private static Pollard pol = new Pollard3();

	private static long iteration = 1;
	private static PrintWriter writer;
	
	public static void main(String[] a) throws IOException {
		//Initialize DataMiner
		long timeInit = System.currentTimeMillis();
		
		writer = new PrintWriter("./log-"
				+ timeInit + ".csv", "UTF-8");
		
		System.out.println("#### DATA MINER - " + timeInit);
		writer.println("#### DATA MINER" + '\n'
				+ "Timestamp: " + timeInit + '\n'
				+ "Algorithm: " + ALGO + '\n'
				+ "Max index for prime numbers picking: " + MAX_P_INDEX + '\n'
				+ "Iterations limit: " + NB_ITERATIONS + '\n'
				+ "User: " + System.getProperty("user.name") + '\n'
				+ "Available cores: "
				+ Runtime.getRuntime().availableProcessors() + '\n'
				+ "Memory available to JVM: " + 
		        Runtime.getRuntime().totalMemory() + " bytes" + '\n'
		);

		// Print header
		writer.println("\"\",\"n\",\"p\",\"q\",\"success\",\"x0\",\"x\",\"nbReboot\",\"i\",\"time (µs)\"");
		
		// Begin iterations
		while(iteration<NB_ITERATIONS) {
			//Prepare iteration
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println("\n\n### ITERATION no." + iteration + '\t' + timestamp);
			
			// Perform factorization
			long timeBegin, timeEnd, time;
			
			// Generate n
			BigInteger p = PrimeNumbers.getRndUpTo(MAX_P_INDEX);
			BigInteger q = PrimeNumbers.getRndUpTo(MAX_P_INDEX);
			BigInteger n = p.multiply(q);
			System.out.println("p = " + p);
			System.out.println("q = " + q);
			System.out.println("n = " + n);
			
			// Factorize
			PollardResult res;
			timeBegin = System.nanoTime();
			res = pol.perform(n);
			timeEnd = System.nanoTime();
			
			BigInteger resP = res.getP();
			
			// Write stats in CSV file
			time = timeEnd - timeBegin;
			
			String success;
			if(p.equals(resP) || q.equals(resP)) {
				success = "true";
			} else {
				success = String.valueOf(resP);
			}
			
			writer.println("\"" + "" + "\",\"" +  n + "\",\"" + p + "\",\"" + q + "\",\"" + success + "\",\"" + 
					res.getX0() + "\",\"" + res.getXFinal() + "\",\"" + res.getNbReboot() + "\",\"" + res.getI() + "\",\"" + time/1000 + "\"");
			
			iteration++;
		}
		
		// Close DataMiner
		writer.close();
		System.out.println("#### DATA MINER - DONE");
	}
}
