package math;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.sql.Timestamp;

public class DataMiner {

	private static final int NB_DIGITS_P_Q = 5;
	private static final int NB_ITERATIONS = 10000;
	
	public static void main(String[] a) throws FileNotFoundException, UnsupportedEncodingException {
		//Initialize DataMiner
		long i = 1;
		PrintWriter writer = new PrintWriter("./log-"+System.currentTimeMillis()+".csv", "UTF-8");
		long timeInit = System.currentTimeMillis();
		System.out.println("#### DATA MINER - " + timeInit);
		writer.println("#### DATA MINER - " + timeInit);
		writer.println("#### Pollard 3 ");
		Pollard3 p3 = new Pollard3();

		writer.println("\"n\",\"p\",\"q\",\"success\",\"bInit\",\"b\",\"i\",\"time (µs)\"");
		
		while(i<NB_ITERATIONS) {
			//Prepare iteration
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			System.out.println("\n\n### ITERATION no." + i + '\t' + timestamp);
			long timeBegin, timeEnd, time;
			
			//Generate n
			BigInteger p = PrimeNumbers.genP(NB_DIGITS_P_Q);
			BigInteger q = PrimeNumbers.genP(NB_DIGITS_P_Q);
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
			
			writer.println("\""+ n + "\",\"" + p + "\",\"" + q + "\",\"" + success + "\",\"" + 
					res.getBInit() + "\",\"" +  res.getB() + "\",\"" + res.getI() + "\",\"" + time/1000 + "\"");
			i++;
		}
		
		//End DataMiner
		writer.close();
	}
}
