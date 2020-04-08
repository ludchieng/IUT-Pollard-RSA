package pollard;

import java.math.BigInteger;

public abstract class Pollard {

	public enum algo {
		POL1, POL2, POL3
	};

	/**
	 * Apply Pollard's Rho factorization on a given number
	 * @param n Number to factor
	 * @param algo One of the three Pollard's algorithm
	 * @return Object which describes the factorization results
	 */
	public static PollardResult factor(BigInteger n, algo algo) {
		System.out.println(algo);
		switch (algo) {
		case POL1:
			return Pollard1.factor(n);
		case POL2:
			return Pollard2.factor(n);
		case POL3:
			return Pollard3.factor(n);
		}
		return null;
	}

	/**
	 * Check p divides n
	 * @param n Dividend
	 * @param p Divisor
	 * @return True if p divides n, false either
	 */
	public static boolean checkP(BigInteger n, BigInteger p) {
		BigInteger q = n.divide(p);
		if (p.equals(n) || p.equals(bi(1))) {
			return false;
		}
		return q.multiply(p).equals(n);
	}

	/**
	 * Compute greatest common divisor of given integers
	 * @param a
	 * @param b
	 * @return GCD of a and b
	 */
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		if (b.equals(bi(0))) {
			return a;
		} else {
			BigInteger r = a.mod(b);
			return gcd(b, r);
		}
	}

	/**
	 * Create BigInteger from String
	 */
	protected static BigInteger bi(String s) {
		return new BigInteger(s);
	}

	/**
	 * Create BigInteger from int
	 */
	protected static BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}

	/**
	 * Create BigInteger from long
	 */
	protected static BigInteger bi(long i) {
		return new BigInteger(Long.toString(i));
	}

	/**
	 * Create BigInteger from BigInteger
	 */
	protected static BigInteger bi(BigInteger k) {
		return new BigInteger(k.toString());
	}

	/**
	 * Convert Pollard.algo to String
	 */
	public static String algo(Pollard.algo a) {
		switch (a) {
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
	 * Convert given enumeration element to String to display
	 */
	public static String algoToDisplay(Pollard.algo a) {
		switch (a) {
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
