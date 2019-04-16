import java.math.BigInteger;

public class Pollard3 implements Pollard {
	
	private final static int MAX_NB_ITER = 5500;

	@Override
	public BigInteger factorize(BigInteger n) {
		BigInteger b = bi(3);
		System.out.println("\n## POLLARD 3   n=" + n + "\tb=" + b);
		int i = 2;
		while(/*i<MAX_NB_ITER && */pgcd(n,b.subtract(bi(1))).equals(bi(1))) {
			b = b.modPow(bi(i), n);
			//System.out.println("b^" + i + " = " + b);
			if(i%1000 == 0) {
				System.out.println("# Reached i=" + i);
			}
			i++;
		}
		i--;
		System.out.println("b^" + i + " = " + b);
		BigInteger p = pgcd(n,b.subtract(bi(1)));
		System.out.println("pgcd(" + n + "," + (b.subtract(bi(1))) + ") = " + p);
		return p;
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
	
	private BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}
}
