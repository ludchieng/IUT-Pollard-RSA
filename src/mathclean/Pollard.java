package mathclean;

import java.math.BigInteger;

public abstract class Pollard {
	
	public enum algo {
		POL1, POL2, POL3
	};
	
	public static PollardResult factorize(BigInteger n, algo algo) {
		switch(algo) {
		case POL1:
			return Pollard1.factorize(n);
		case POL2:
			return Pollard2.factorize(n);
		case POL3:
			return Pollard3.factorize(n);
		}
		return null;
	}

	/**
	 *  Check p
	 */
	public static boolean checkP(BigInteger n, BigInteger p) {
		BigInteger q = n.divide(p);
		if(p.equals(n) || p.equals(bi(1))) {
			return false;
		}
		return q.multiply(p).equals(n);
	}
	
	/**
	 *  GCD of a & b
	 */
	public static BigInteger pgcd(BigInteger a, BigInteger b) {
		if(b.equals(bi(0))) {
			return a;
		} else {
			BigInteger r = a.mod(b);
			return pgcd(b,r);
		}
	}

	/**
	 *  Create BigInteger from String
	 */
	protected static BigInteger bi(String s) {
		return new BigInteger(s);
	}

	/**
	 *  Create BigInteger from int
	 */
	protected static BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}
	
	/**
	 *  Create BigInteger from long
	 */
	protected static BigInteger bi(long i) {
		return new BigInteger(Long.toString(i));
	}
	
	/**
	 *  Create BigInteger from BigInteger
	 */
	protected static BigInteger bi(BigInteger k) {
		return new BigInteger(k.toString());
	}
	
	/**
	 *  Convert Pollard.algo to String
	 */
	public static String algo(Pollard.algo a) {
		switch(a) {
		case POL1:
			return "pol1";
		case POL2:
			return "pol2";
		case POL3:
			return "pol3";
		}
		return null;
	}
	
	/**
	 *  Convert Pollard.algo to String to display
	 */
	public static String algoToDisplay(Pollard.algo a) {
		switch(a) {
		case POL1:
			return "Pollard 1";
		case POL2:
			return "Pollard 2";
		case POL3:
			return "Pollard 3";
		}
		return null;
	}
	
}
