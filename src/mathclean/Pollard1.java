package mathclean;

import java.math.BigInteger;
import java.util.LinkedList;

public class Pollard1 extends Pollard {
	
	public static Pollard.algo algo = Pollard.algo.POL1;

	
	public static PollardResult factorize(BigInteger n) {
		return factorizeWithX0(n, Numbers.rnd(n));
	}

	
	public static PollardResult factorizeWithX0(BigInteger n, BigInteger x0) {
		return factorizeWithX0FromI(n, x0, 1);
	}

	
	public static PollardResult factorizeWithX0FromI(BigInteger n, BigInteger x0, int i) {
		System.out.println("\n## POLLARD 1   n=" + n + "\tx0=" + x0);

		long timeBegin = System.nanoTime();
		
		LinkedList<BigInteger> history = new LinkedList<>();
		int d = 1;
		BigInteger b = bi(1);
		BigInteger x = x0;
		BigInteger u = x0;
		BigInteger p;
		
		while(true) {
			for(int j=d+1; j < 2d; j++) {
				//System.out.print(x);

				x = x.modPow(bi(2), n).add(b).mod(n);
				p = pgcd(x.subtract(u), n);

				//System.out.println("^2+" + b + "=" + x);

				if(history.contains(x)) {
					long timeEnd = System.nanoTime();
					int time = (int) ((timeEnd - timeBegin)/1000);
					System.out.println("# LOOP DETECTED");
					return new PollardResult(algo, n, p, checkP(n,p), null, x0, x, -1, i, time);
				}
				history.add(x);

				if (p.compareTo(bi(1)) > 0 && !p.equals(n)){
					long timeEnd = System.nanoTime();
					int time = (int) ((timeEnd - timeBegin)/1000);
					
					history = new LinkedList<>();
					
					System.out.println("\nx-u=" + x + "-" + u + "=" + (x.subtract(u)));
					System.out.println("p(" + x.subtract(u)+","+n+")="+p);
					System.out.println("p("+n+","+p+")="+p);
					System.out.println("p="+p+"\tq="+n.divide(p));
					
					return new PollardResult(algo, n, p, checkP(n,p), null, x0, x, -1, i, time);
				}
				i++;
			}
			u = x;
			d *= 2;
		}
	}

}
