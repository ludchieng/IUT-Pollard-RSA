package math;
import java.math.BigInteger;
import java.util.LinkedList;

public class Pollard1 implements Pollard {
	
	public BigInteger factorizeWith(BigInteger n, BigInteger x0) {
		LinkedList<BigInteger> history = new LinkedList<>();
		int d = 1;
		BigInteger b = bi("1");

		BigInteger x = x0;
		BigInteger u = x0;
		System.out.println("\n## POLLARD 1   n=" + n + "\tx0=" + x);
		while(true) {
			for(int j=d+1; j < 2d; j++) {
				System.out.print(x);

				x = x.modPow(bi(2), n).add(b).mod(n);
				BigInteger pgcd = pgcd(x.subtract(u), n);

				System.out.println("^2+" + b + "=" + x);

				if(history.contains(x)) {
					throw new IllegalStateException("Loop detected: " + x);
				}
				history.add(x);

				if (pgcd.compareTo(bi(1)) > 0 ){
					history = new LinkedList<>();

					System.out.println("\nx-u=" + x + "-" + u + "=" + (x.subtract(u)));
					System.out.println("pgcd(" + x.subtract(u)+","+n+")="+pgcd);
					System.out.println("pgcd("+n+","+pgcd+")="+pgcd);
					System.out.println("p="+pgcd+"\tq="+n.divide(pgcd));

					return pgcd;
				}
			}
			u = x;
			d *= 2;
		}
	}

	public BigInteger factorize(BigInteger n) {
		// Generate random x0
		BigInteger x0 = Numbers.rnd(n);
		BigInteger p;
		try {
			p = this.factorizeWith(n, x0);
		} catch (IllegalStateException e) {
			System.out.println("# LOOP DETECTED: Trying again with a different x0");
			p = this.factorize(n);
		}
		
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

	private BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}

}
