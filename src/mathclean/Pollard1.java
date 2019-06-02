package mathclean;

import java.math.BigInteger;
import java.util.HashSet;

public class Pollard1 extends Pollard {
	
	public static Pollard.algo algo = Pollard.algo.POL1;

	
	public static PollardResult factorize(BigInteger n) {
		return factorizeWithX0(n, Numbers.rnd(n));
	}

	
	public static PollardResult factorizeWithX0(BigInteger n, BigInteger x0) {
		return factorizeWithX0FromI(n, x0, 1);
	}

	
	public static PollardResult factorizeWithX0FromI(BigInteger n, BigInteger x0, int i) {
		return factorizeWithX0AndAFromI(n, x0, Numbers.rnd(n), i);
	}

	
	public static PollardResult factorizeWithX0AndAFromI(BigInteger n, BigInteger x0, BigInteger a, int i) {
		System.out.println("\n## POLLARD 1   n=" + n + "\tx0=" + x0 + "\ta=" + a);

		long timeBegin = System.nanoTime();
		
		HashSet<BigInteger> history = new HashSet<>();
		int d = 1;
		BigInteger x = x0;
		BigInteger u = x0;
		BigInteger p;
		
		while(true) {
			for(int j=d+1; j < 2*d; j++) {
				//System.out.print(x);

				x = x.modPow(bi(2), n).add(a).mod(n);
				p = pgcd(x.subtract(u).mod(n), n);

				//System.out.println("^2+" + a + "=" + x);
				if(!history.add(x)) {
					long timeEnd = System.nanoTime();
					int time = (int) ((timeEnd - timeBegin)/1000);
					System.out.println("# LOOP DETECTED");
					return new PollardResult(algo, n, p, checkP(n,p), a, x0, x, -1, i, time);
				}
				

				if (p.compareTo(bi(1)) > 0 && !p.equals(n)){
					long timeEnd = System.nanoTime();
					int time = (int) ((timeEnd - timeBegin)/1000);
					
					System.out.println("\nx-u=" + x + "-" + u + "=" + (x.subtract(u).mod(n)));
					System.out.println("p(" + x.subtract(u).mod(n)+","+n+")="+p);
					System.out.println("p("+n+","+p+")="+p);
					System.out.println("p="+p+"\tq="+n.divide(p));
					
					return new PollardResult(algo, n, p, checkP(n,p), a, x0, x, -1, i, time);
				}
				i++;
				//System.out.println("j=" + j + "\t2d=" + (2*d));
			}
			history.clear();
			//System.out.println("# Update u ----------------------------------------------");
			u = x;
			d *= 2;
		}
	}

}
