package math;
import java.math.BigInteger;

public interface Pollard {
	/**
	 * Compute Pollard's Rho Algorithm
	 * @param n		integer to factorize
	 * @return one of the two divider of n
	 */
	public abstract BigInteger factorize(BigInteger n);
	
	public BigInteger pgcd(BigInteger a, BigInteger b);
}
