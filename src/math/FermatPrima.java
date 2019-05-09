package math;
import java.math.BigInteger;
import java.util.Random;

public class FermatPrima {

	public static boolean isPrime(BigInteger n,int nb) {
		for(int i=0; i<nb; i++) {
			//Generate random BigInteger which isn't equals to 0 or 1
			BigInteger rndBi;
			do {
				rndBi = randomBi(n);
			} while(rndBi.equals(bi(0)) || rndBi.equals(bi(1)));
			
			//Fermat's little Theorem test
			BigInteger res = rndBi.modPow(n.subtract(bi(1)), n);
			if(!res.equals(bi(1))) {
				//n is not prime
				//System.out.println("#FERMAPRIMA: n=" + n + "\t" + rndBi + "^n-1=" + res);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Generate random BigInteger between 0 and max
	 * @param max
	 * @return a random BigInteger
	 */
	private static BigInteger randomBi(BigInteger max) {
		BigInteger rnd;
		do {
			rnd = new BigInteger(max.bitLength(), new Random());
		} while (rnd.compareTo(max) >= 0);
		return rnd;
	}
	
	
	private static BigInteger bi(String s) {
		return new BigInteger(s);
	}
	private static BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}

}
