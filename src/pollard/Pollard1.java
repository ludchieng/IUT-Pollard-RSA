package pollard;

import java.math.BigInteger;
import java.util.HashSet;

public class Pollard1 extends Pollard {
	
	public static Pollard.algo algo = Pollard.algo.POL1;

	
	public static PollardResult factor(BigInteger n) {
		return factorWithX0(n, Numbers.rnd(n));
	}

	
	public static PollardResult factorWithX0(BigInteger n, BigInteger x0) {
		return factorWithX0AndA(n, x0, Numbers.rnd(n));
	}

	
	public static PollardResult factorWithX0AndA(BigInteger n, BigInteger x0, BigInteger a) {
		return factorWithX0AndAFromI(n, x0, a, 1);
	}

	
	public static PollardResult factorWithX0AndAFromI(BigInteger n, BigInteger x0, BigInteger a, int i) {
		System.out.println("\n## POLLARD 1   n=" + n + "\tx0=" + x0 + "\ta=" + a);

		long timeBegin = System.nanoTime();
		
		HashSet<BigInteger> history = new HashSet<>();
		int d = 1;
		BigInteger x = x0;
		BigInteger u = x0;
		BigInteger p;
		
		while(true) {
			for(int j=d+1; j < 2*d; j++) {
				//System.out.println("j="+j+"\t2d="+(2*d));
				
				//System.out.print(x);
				x = x.modPow(bi(2), n).add(a).mod(n);
				//System.out.println("^2+" + a + "=" + x);

				p = gcd(x.subtract(u).mod(n), n);
				//System.out.println("gcd(" + n +","+ x.subtract(u).mod(n) +")="+p);
				
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
					System.out.println("gcd(" + n +","+ x.subtract(u).mod(n) +")="+p);
					System.out.println("p="+p+"\tq="+n.divide(p));
					
					return new PollardResult(algo, n, p, checkP(n,p), a, x0, x, -1, i, time);
				}
				i++;
			}
			history.clear();
			u = x;
			d *= 2;
			//System.out.println("# Update u="+u);
			//System.out.println("# Update d="+d+" ----------------------------------------------");
		}
	}

}
