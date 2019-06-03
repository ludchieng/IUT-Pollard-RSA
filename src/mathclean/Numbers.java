package mathclean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Numbers {
	
	/**
	 * Generate random int value
	 */
	public static int random(int min, int max) {
		return (int) (Math.random() * (max-min+1)) + min;
	}
	
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
	//private static final String N_LIST_PATH = "./n_list_1-" + MAX_INDEX_PRIME + ".txt";
	private static final String N_LIST_PATH = ""/* "./n_list_distrib.txt"*/;
	/**
	 * Generate list of n=p*q numbers as a txt file
	 * @param a
	 * @throws IOException
	 */
	public static void main(String[] a) throws IOException {
		System.out.println("## GENERATE N LIST");
		HashSet<BigInteger> nSet = new HashSet<>();
		
		// Generate n values
		System.out.println("## Generating n values");
		for(int i=0; i<200; i++) {
			BigInteger p;
			BigInteger q;
			BigInteger n;
			do {
				// Prevent from duplicates or squared values
				p = getPrimeRndUpTo(MAX_INDEX_PRIME-1);
				do {
					q = getPrimeRndUpTo(MAX_INDEX_PRIME-1);
				} while (q.equals(p));
				n = p.multiply(q);
			} while(nSet.contains(n) /*|| n.toString().length() != 14*/);
			
			nSet.add(n);
			
			if(i%10 == 0) {
				System.out.println("# reached i="+i);
			}
		}
		
		// Retrieve previously generated n value
		BufferedReader br = new BufferedReader(new FileReader(N_LIST_PATH));
		String nString = br.readLine();
		int nbLinesBefore = 0;
		while(nString != null) {
			nSet.add(new BigInteger(nString));
			nString = br.readLine();
			nbLinesBefore++;
		}
		
		// Sort list
		System.out.println("## Sorting");
		LinkedList<BigInteger> nValues = new LinkedList<>(nSet);
		Collections.sort(nValues);
		
		
		PrintWriter w = new PrintWriter(N_LIST_PATH);
		for(BigInteger n : nValues) {
			w.println(n);
		}
		w.close();
		
		System.out.println("## END - Added " + (nValues.size() - nbLinesBefore) + " lines");
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
		return getPrime(random(0,NB));
	}
	

	public static BigInteger getPrimeRndUpTo(int maxIndex) throws FileNotFoundException, IOException {
		return getPrime(random(0,maxIndex));
	}
	
	
	/**
	 * Pick a random n from list with a given number of digit
	 */
	public static BigInteger getRndN(int nbDigits) throws IOException {
		// Count number of lines of the list of n values
		int nbLines = 0;
		BufferedReader br = new BufferedReader(new FileReader("./n_list.txt"));
		while(br.readLine() != null) {
			nbLines++;
		}
		
		// Pick n value
		String res = "";
		System.out.println(res);
		int readCursor = random(0,nbLines-1);
		do {
			br = new BufferedReader(new FileReader("./n_list.txt"));
			res = br.readLine();
			for(int i=0; i<readCursor; i++) {
				res = br.readLine();
			}
			if(res.length() > nbDigits) {
				readCursor = random(0,readCursor);
			} else {
				readCursor = random(readCursor,nbLines-1);
			}
		} while(res.length() != nbDigits);
		return new BigInteger(res);
	}
	/**
	 * Pick a random n from list
	 */
	public static BigInteger getRndN() throws IOException {
		return getRndN((int) (Math.random() * 11) + 2);
	}
	
}
