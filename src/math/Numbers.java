package math;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
	
	/**
	 * Generate random BigInteger between 2 and n-1
	 * @param n
	 * @return BigInteger random value
	 */
	public static BigInteger rnd(BigInteger n) {
		long nLength = n.toString().length();
		String resString;
		BigInteger res;
		do {
			resString = "";
			for(int i=0; i<nLength; i++) {
				int randomDigit = Character.getNumericValue(Double.toString(Math.random()).charAt(2));
				resString += randomDigit;
			}
			res = new BigInteger(resString);
		} while(res.compareTo(n) >= 0 || res.compareTo(new BigInteger("1")) <= 0);
		
		return res;
	}
	
	
	
	private static final int MAX_INDEX_PRIME = 100000;
	private static final String N_LIST_PATH = "./n_list_1-100000.txt";
	/**
	 * Generate list of n=p*q numbers as a txt file
	 * @param a
	 * @throws IOException
	 */
	public static void main(String[] a) throws IOException {
		System.out.println("## GENERATE N LIST");
		
		ArrayList<BigInteger> nValues = new ArrayList<>();
		PrintWriter w = new PrintWriter(N_LIST_PATH);
		
		System.out.println("## Generating n values");
		
		for(int i=0; i<5000; i++) {
			BigInteger p;
			BigInteger q;
			BigInteger n;
			do {
				p = PrimeNumbers.getRndUpTo(MAX_INDEX_PRIME);
				do {
					q = PrimeNumbers.getRndUpTo(MAX_INDEX_PRIME);
				} while (q.equals(p));
				n = p.multiply(q);
			} while(nValues.contains(n));
			
			nValues.add(n);
			
			if(i%500 == 0) {
				System.out.println("# reached i="+i);
			}
		}
		
		System.out.println("## Sorting");
		
		Collections.sort(nValues);
		
		for(BigInteger n : nValues) {
			w.println(n);
		}
		w.close();
	}
}
