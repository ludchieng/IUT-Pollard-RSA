package math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Timestamp;

public class DataPerformer {

	private static final String ALGO = "pol3";
	private static Pollard pol = new Pollard3();

	private static PrintWriter writer;
	private static int readCursor = 0;

	private static final String N_LIST_PATH = "./n_list_1-10000.txt";
	private static final int N_LIST_LENGTH = 5000;
	
	public static void main(String[] args) throws IOException {
		//Initialize DataMiner
		long timeInit = System.currentTimeMillis();
		
		writer = new PrintWriter("./log-perf-"
				+ timeInit + "-"+ ALGO + ".csv", "UTF-8");
		
		System.out.println("#### DATA PERFORMER - " + timeInit);
		writer.println("#### DATA PERFORMER" + '\n'
				+ "Timestamp: " + timeInit + '\n'
				+ "Algorithm: " + ALGO + '\n'
				+ "N list: " + N_LIST_PATH + '\n'
				+ "N list length: " + N_LIST_LENGTH + '\n'
				+ "User: " + System.getProperty("user.name") + '\n'
				+ "Available cores: "
				+ Runtime.getRuntime().availableProcessors() + '\n'
				+ "Memory available to JVM: " + 
		        Runtime.getRuntime().totalMemory() + " bytes" + '\n'
		);

		// Print header
		writer.println("\"\",\"n\",\"resP\",\"success\",\"x0\",\"x\",\"nbReboot\",\"i\",\"time (µs)\"");
		
		// Begin iterations
		while(readCursor<N_LIST_LENGTH) {
			//Prepare iteration
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println("\n\n### ITERATION no." + readCursor + '\t' + timestamp);
			
			// Perform factorization
			long timeBegin, timeEnd, time;
			
			// Factorize next n
			BigInteger n = popN();
			System.out.println("n = " + n);
			
			// Factorize
			PollardResult res;
			timeBegin = System.nanoTime();
			res = pol.perform(n);
			timeEnd = System.nanoTime();
			
			BigInteger resP = res.getP();
			
			// Write stats in CSV file
			time = timeEnd - timeBegin;
			
			boolean success;
			BigInteger resQ = n.divide(resP);
			success = (resQ.multiply(resP).equals(n) && !resP.equals(n));
			
			writer.println("\"" + "" + "\",\"" +  n + "\",\"" + resP + "\",\"" + success + "\",\"" + 
					res.getX0() + "\",\"" + res.getXFinal() + "\",\"" + res.getNbReboot() + "\",\"" + res.getI() + "\",\"" + time/1000 + "\"");
			
			readCursor++;
		}
		
		// Close DataMiner
		writer.close();
		long timeFinal = System.currentTimeMillis();
		long timeTotal = timeFinal - timeInit;
		System.out.println("#### DATA PERFORMER - DONE IN " + timeTotal/1000 + '.' + timeTotal%1000 + " s");
	}
	
	public static BigInteger popN() throws IOException {
		// Load prime numbers list text file
		BufferedReader br = new BufferedReader(new FileReader(N_LIST_PATH));
		// Skip lines
		String res = "";
		for(int i=0; i<=readCursor; i++) {
			res = br.readLine();
		}
		return new BigInteger(res);
	}

}
