package mathclean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	private static final String N_LIST_PATH = "./n_list_1-" + MAX_INDEX_PRIME + ".txt";
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
				p = getPrimeRndUpTo(MAX_INDEX_PRIME);
				do {
					q = getPrimeRndUpTo(MAX_INDEX_PRIME);
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
	
	
	
	
	private static final int NB = 100008;
	/**
	 * Get a prime number from a list
	 * @param index
	 * @return BigInteger which is prime
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static BigInteger getPrime(int index) throws FileNotFoundException, IOException {
		// Check argument validity
		if(index < 0 || index > NB) {
			throw new IllegalArgumentException();
		}
		
		// Load prime numbers list text file
		BufferedReader br = new BufferedReader(new FileReader("./prime_numbers_list.txt"));
		// Skip lines
		for(int i=0; i<index; i++) {
			br.readLine();
		}
		
		return new BigInteger(br.readLine());
	}
	
	/**
	 * Pick a random prime number from a list
	 * @return BigInteger which is prime
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static BigInteger getPrimeRnd() throws FileNotFoundException, IOException {
		int rnd = (int) (Math.random()*NB);
		return getPrime(rnd);
	}
	

	public static BigInteger getPrimeRndUpTo(int maxIndex) throws FileNotFoundException, IOException {
		int rnd = (int) (Math.random()*maxIndex);
		return getPrime(rnd);
	}
	
	
	/**
	 * Pick a random n from list
	 */
	public static BigInteger getRndN() throws IOException {
		int readCursor = (int) (Math.random() * 5000);
		// Load prime numbers list text file
		BufferedReader br = new BufferedReader(new FileReader("./n_list_1-2000.txt"));
		// Skip lines
		String res = "";
		for(int i=0; i<=readCursor; i++) {
			res = br.readLine();
		}
		return new BigInteger(res);
	}
}
