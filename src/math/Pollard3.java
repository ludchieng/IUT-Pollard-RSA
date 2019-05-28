package math;
import java.math.BigInteger;

public class Pollard3 implements Pollard {
	
	private long nbReboot = 0;

	@Override
	public BigInteger factorizeWith(BigInteger n, BigInteger x0) {
		BigInteger x = bi(x0.toString());
		System.out.println("\n## POLLARD 3   n=" + n + "\tx0=" + x);
		long i = 2;
		while(pgcd(n,x.subtract(bi(1))).equals(bi(1))) {
			System.out.print(x + "^" + i + " = ");
			x = x.modPow(bi(i), n);
			System.out.println(x);
			
			if(i%100000 == 0) {
				System.out.println("# Reached i=" + i + "\tvalue=" + x);
			}
			i++;
		}
		i--;
		System.out.println("x^" + i + " = " + x);
		BigInteger p = pgcd(n,x.subtract(bi(1)));
		
		if(p.equals(n)) {
			throw new IllegalStateException("Illegal x value");
		}
		
		System.out.println("pgcd(" + n + "," + (x.subtract(bi(1))) + ") = " + p);
		return p;
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
	/**
	 * Compute Pollard's Rho Algorithm and give some details about the calculation
	 * @param n
	 * @return PollardResult
	 */
	public PollardResult performWith(BigInteger n, BigInteger x0) {
		BigInteger x = bi(x0.toString());
		//System.out.println("\n## POLLARD 3   n=" + n + "\tx0=" + x0);
		long i = 2;
		while(pgcd(n,x.subtract(bi(1))).equals(bi(1))) {
			x = x.modPow(bi(i), n);
			/*
			System.out.println(b + "^" + i + " = " + b);
			if(i%100000 == 0) {
				System.out.println("# Reached i=" + i + "\tvalue=" + x);
			}
			*/
			i++;
		}
		i--;
		//System.out.println("x^" + i + " = " + x);
		BigInteger p = pgcd(n,x.subtract(bi(1)));
		
		if(p.equals(n)) {
			//System.out.println("# ILLEGAL X VALUE");
			throw new IllegalStateException("Illegal x value");
		}
		
		//System.out.println("pgcd(" + n + "," + (x.subtract(bi(1))) + ") = " + p);
		return new PollardResult(n, p, x0, x, '\0', i);
	}
	
	@Override
	public PollardResult perform(BigInteger n) {
		this.nbReboot = 0;
		// Generate random x0
		BigInteger x0 = Numbers.rnd(n);
		PollardResult p;
		try {
			p = this.performWith(n, x0);
		} catch (IllegalStateException e) {
			System.out.println("# ILLEGAL X VALUE: Trying again with a different x0");
			p = this.perform(n);
			nbReboot++;
		}
		p.setNbReboot(nbReboot);
		
		return p;
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
	private BigInteger bi(long i) {
		return new BigInteger(Long.toString(i));
	}
}
