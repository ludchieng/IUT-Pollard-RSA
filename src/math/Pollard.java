package math;
import java.math.BigInteger;

public interface Pollard {
	/**
	 * Compute Pollard's Rho Algorithm
	 * @param n		integer to factorize
	 * @return one of the two divider of n
	 */

	public abstract BigInteger factorizeWith(BigInteger n, BigInteger x0);
	
	public abstract BigInteger factorize(BigInteger n);

	public abstract PollardResult performWith(BigInteger n, BigInteger x0);
	
	public abstract PollardResult perform(BigInteger n);
	
	public BigInteger pgcd(BigInteger a, BigInteger b);
}
