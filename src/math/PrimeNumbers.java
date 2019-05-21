package math;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;

public class PrimeNumbers {

	private static final int NB = 100008;

	/**
	 * Get a prime number from a list
	 * @param index
	 * @return BigInteger which is prime
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static BigInteger get(int index) throws FileNotFoundException, IOException {
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
	public static BigInteger getRnd() throws FileNotFoundException, IOException {
		int rnd = (int) (Math.random()*NB);
		return PrimeNumbers.get(rnd);
	}
	

	public static BigInteger getRndUpTo(int maxIndex) throws FileNotFoundException, IOException {
		int rnd = (int) (Math.random()*maxIndex);
		return PrimeNumbers.get(rnd);
	}
	
	/**
	 * Generate random composite number from two known prime numbers
	 * @return BigInteger which is the product of 2 prime numbers
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static BigInteger genN() throws FileNotFoundException, IOException {
		return getRnd().multiply(getRnd());
	}
	
	/**
	 * Generate prime number with Fermat's Primality Test
	 * @return BigInteger which is probably prime
	 */
	public static BigInteger genFermatP(int nbDigits) {
		final int[] lastDigit = {1, 3, 7, 9};
		String pStr;
		BigInteger p;
		do {
			pStr = String.valueOf((int)(Math.random()*9+1));
			for(int i=0; i<nbDigits-2; i++) {
				pStr += String.valueOf(Math.random()).charAt(2);
			}
			pStr += lastDigit[ (int) (Math.random()*4) ];
			p = new BigInteger(pStr);
		}while(!FermatPrima.isPrime(p, 100));
		return p;
	}
	
	/**
	 * Generate random composite number from two probably prime numbers
	 * @return BigInteger which is the product of 2 probably prime numbers
	 */
	public static BigInteger genFermatN(int nbDigitsN) {
		int nbDigitsP = nbDigitsN/2;
		BigInteger p = genFermatP(nbDigitsP);
		BigInteger q = genFermatP(nbDigitsP);
		System.out.println("\np=" + p);
		System.out.println("q=" + q);
		return p.multiply(q);
	}
}