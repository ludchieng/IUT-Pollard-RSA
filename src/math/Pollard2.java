package math;
import java.math.BigInteger;

public class Pollard2 implements Pollard {

	private long nbReboot = 0;
	
	@Override
	public BigInteger factorizeWith(BigInteger n, BigInteger x0) {
		
		// Nombres random
		BigInteger a = Numbers.rnd(n);
		BigInteger x = x0;
		
		BigInteger y = x;
		System.out.println("\n## POLLARD 2   n = "+n+"\ta = "+a+"\tx0 = "+x);
		BigInteger pgcd;
		while(true) {
			x = (x.pow(2)).add(a).mod(n);
			y = ((((y.pow(2)).add(a).mod(n)).pow(2)).add(a)).mod(n);
			pgcd = pgcd(y.subtract(x), n);
			
			if(pgcd.equals(bi(1))) {
				throw new IllegalStateException("Illegal x value");
			}
			
			if (pgcd.compareTo(bi(1)) > 0){
				System.out.println("p = "+pgcd+"\tq = "+n.divide(pgcd));
				return pgcd;
			}
		}
	}

	@Override
	public BigInteger factorize(BigInteger n) {
		// Generate random x0
		BigInteger x0 = Numbers.rnd(n);
		BigInteger p;
		try {
			p = this.factorizeWith(n, x0);
		} catch (IllegalStateException e) {
			System.out.println("# ILLEGAL X VALUE: Trying again with a different x0");
			p = this.factorize(n);
		}
		
		return p;
	}
	
	
	@Override
	public PollardResult performWith(BigInteger n, BigInteger x0) {
		// TODO
		return null;
	}
	
	@Override
	public PollardResult perform(BigInteger n) {
		// TODO
		return null;
	}
	
	@Override
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