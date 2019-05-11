package math;
import java.math.BigInteger;
import java.util.ArrayList;
import java.lang.Math;

public class PrimeNumbers {
	
	/**
	 * Pick a random prime number from a list
	 * @return BigInteger which is prime
	 */
	public static BigInteger genP() {
		return pNumbers[ (int) (Math.random() * pNumbers.length) ];
	}
	
	/**
	 * Generate random composite number from two known prime numbers
	 * @return BigInteger which is the product of 2 prime numbers
	 */
	public static BigInteger genN() {
		//Generate indexes
		int index1 = (int) (Math.random() * pNumbers.length);
		
		int index2;
		do {
			index2 = (int) (Math.random() * 100 + index1);
		}while(index2 >= pNumbers.length);
		
		//Multiply two random prime numbers
		return pNumbers[index1].multiply(pNumbers[index2]);
	}
	
	/**
	 * Generate prime number with Fermat's Primality Test
	 * @return BigInteger which is probably prime
	 */
	public static BigInteger genP(int nbDigits) {
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
	public static BigInteger genBigN(int nbDigitsN) {
		int nbDigitsP = nbDigitsN/2;
		BigInteger p = genP(nbDigitsP);
		BigInteger q = genP(nbDigitsP);
		System.out.println("\np=" + p);
		System.out.println("q=" + q);
		return p.multiply(q);
	}
	
	private static BigInteger[] pNumbers = {
			new BigInteger("0"),
			new BigInteger("0"),
	};
	
}
