package math;
import java.math.BigInteger;

public class Pollard3 implements Pollard {

	@Override
	public BigInteger factorize(BigInteger n) {
		BigInteger b = bi(3);
		System.out.println("\n## POLLARD 3   n=" + n + "\tb=" + b);
		long i = 2;
		while(pgcd(n,b.subtract(bi(1))).equals(bi(1))) {
			b = b.modPow(bi(i), n);
			System.out.println(b + "^" + i + " = " + b);
			if(i%100000 == 0) {
				System.out.println("# Reached i=" + i + "\tvalue=" + b);
			}
			i++;
		}
		i--;
		System.out.println("b^" + i + " = " + b);
		BigInteger p = pgcd(n,b.subtract(bi(1)));
		System.out.println("pgcd(" + n + "," + (b.subtract(bi(1))) + ") = " + p);
		return p;
	}
	
	
	/**
	 * Compute Pollard's Rho Algorithm and give some details about the calculation
	 * @param n
	 * @return PollardResult
	 */
	public PollardResult perform(BigInteger n) {
		BigInteger bInit = bi(3);
		BigInteger b = bi(bInit.toString());
		System.out.println("\n## POLLARD 3   n=" + n + "\tb=" + b);
		long i = 2;
		while(pgcd(n,b.subtract(bi(1))).equals(bi(1))) {
			b = b.modPow(bi(i), n);
			//System.out.println(b + "^" + i + " = " + b);
			if(i%100000 == 0) {
				System.out.println("# Reached i=" + i + "\tvalue=" + b);
			}
			i++;
		}
		i--;
		System.out.println("b^" + i + " = " + b);
		BigInteger p = pgcd(n,b.subtract(bi(1)));
		System.out.println("pgcd(" + n + "," + (b.subtract(bi(1))) + ") = " + p);
		return new PollardResult(n, p, bInit, b, i);
	}
	
	
	public BigInteger pgcd(BigInteger a, BigInteger b) {
		if(b.equals(bi(0))) {
			return a;
		} else {
			BigInteger r = a.mod(b);
			return pgcd(b,r);
		}
	}
	
	
	
	private BigInteger bi(String s) {
		return new BigInteger(s);
	}
	private BigInteger bi(long i) {
		return new BigInteger(Long.toString(i));
	}
}
