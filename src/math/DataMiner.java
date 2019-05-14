package math;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.sql.Timestamp;

public class DataMiner {

	private static final int NB_ITERATIONS = 10000;
	private static final String ALGO = "pol3";
	
	public static void main(String[] a) throws IOException {
		//Initialize DataMiner
		long i = 1;
		long timeInit = System.currentTimeMillis();
		
		PrintWriter writer = new PrintWriter("./log-"
				+ timeInit + ".csv", "UTF-8");
		
		System.out.println("#### DATA MINER - " + timeInit);
		writer.println("#### DATA MINER" + '\n'
				+ "Timestamp: " + timeInit + '\n'
				+ "Algorithm: " + ALGO + '\n'
				+ "Iterations limit: " + NB_ITERATIONS + '\n'
				+ "User: " + System.getProperty("user.name") + '\n'
				+ "Available cores: "
				+ Runtime.getRuntime().availableProcessors() + '\n'
				+ "Memory available to JVM: " + 
		        Runtime.getRuntime().totalMemory() + " bytes" + '\n'
		);
		Pollard3 p3 = new Pollard3();

		// Print header
		writer.println("\"\",\"n\",\"p\",\"q\",\"success\",\"bInit\",\"b\",\"i\",\"time (µs)\"");
		
		// Begin iterations
		while(i<NB_ITERATIONS) {
			//Prepare iteration
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println("\n\n### ITERATION no." + i + '\t' + timestamp);
			long timeBegin, timeEnd, time;
			
			//Generate n
			BigInteger p = PrimeNumbers.getRnd();
			BigInteger q = PrimeNumbers.getRnd();
			BigInteger n = p.multiply(q);
			System.out.println("p = " + p);
			System.out.println("q = " + q);
			System.out.println("n = " + n);
			
			//Factorize n
			timeBegin = System.nanoTime();
			PollardResult res = p3.perform(n);
			BigInteger resP = res.getP();
			timeEnd = System.nanoTime();
			
			time = timeEnd - timeBegin;
			
			String success;
			if(p.equals(resP) || q.equals(resP)) {
				success = "true";
			} else {
				success = String.valueOf(resP);
			}
			
			writer.println("\"" + "" + "\",\"" +  n + "\",\"" + p + "\",\"" + q + "\",\"" + success + "\",\"" + 
					res.getBInit() + "\",\"" +  res.getB() + "\",\"" + res.getI() + "\",\"" + time/1000 + "\"");
			i++;
		}
		
		// Close DataMiner
		writer.close();
		System.out.println("#### DATA MINER - DONE");
	}
}
