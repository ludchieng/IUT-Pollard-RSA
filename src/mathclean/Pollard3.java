package mathclean;

import java.math.BigInteger;

public class Pollard3 extends Pollard {

	public static Pollard.algo algo = Pollard.algo.POL3;

	
	public static PollardResult factorize(BigInteger n) {
		return factorizeWithX0(n, Numbers.rnd(n));
	}

	
	public static PollardResult factorizeWithX0(BigInteger n, BigInteger x0) {
		return factorizeWithX0FromI(n, x0, 2);
	}

	
	public static PollardResult factorizeWithX0FromI(BigInteger n, BigInteger x0, int i) {
		System.out.println("\n## POLLARD 3   n=" + n + "\tx0=" + x0);
		
		long timeBegin = System.nanoTime();
		
		BigInteger x = bi(x0);
		BigInteger p;
		
		while(true) {
			//System.out.print(x);
			x = x.modPow(bi(i), n);
			//System.out.println("^" + i + " = " + x);
			p = pgcd(n,x.subtract(bi(1)));
			//System.out.println("pgcd(" + n + "," + (x.subtract(bi(1))) + ") = " + p);
			
			if(p.compareTo(bi(1)) > 0 && !p.equals(bi(1))) {
				long timeEnd = System.nanoTime();
				int time = (int) ((timeEnd - timeBegin)/1000);
				System.out.println("x^" + i + " = " + x);
				System.out.println("pgcd(" + n + "," + (x.subtract(bi(1))) + ") = " + p);
				return new PollardResult(algo, n, p, checkP(n,p), null, x0, x, -1, i, time);
			}
			i++;
		}
	}

}
