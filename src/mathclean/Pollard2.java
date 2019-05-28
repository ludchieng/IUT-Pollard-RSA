package mathclean;

import java.math.BigInteger;

public class Pollard2 extends Pollard {

	public static Pollard.algo algo = Pollard.algo.POL2;
	
	
	public static PollardResult factorize(BigInteger n) {
		return factorizeWithX0(n, Numbers.rnd(n));
	}

	
	public static PollardResult factorizeWithX0(BigInteger n, BigInteger x0) {
		return factorizeWithX0AndA(n, x0, Numbers.rnd(n));
	}


	public static PollardResult factorizeWithX0AndA(BigInteger n, BigInteger x0, BigInteger a) {
		return factorizeWithX0AndAFromI(n, x0, a, 1);
	}
	
	public static PollardResult factorizeWithX0AndAFromI(BigInteger n, BigInteger x0, BigInteger a, int i) {
		System.out.println("\n## POLLARD 2   n = "+n+"\tx0 = "+x0+"\ta = "+a);
		
		long timeBegin = System.nanoTime();
		
		BigInteger x = bi(x0);
		BigInteger y = bi(x);
		BigInteger p;
		
		while(true) {
			x = (x.pow(2)).add(a).mod(n);
			y = ((((y.pow(2)).add(a).mod(n)).pow(2)).add(a)).mod(n);
			p = pgcd(y.subtract(x), n);
			
			if (p.compareTo(bi(1)) > 0){
				long timeEnd = System.nanoTime();
				int time = (int) ((timeEnd - timeBegin)/1000);
				
				System.out.println("p = " + p);
				
				return new PollardResult(algo, n, p, checkP(n,p), a, x0, x, -1, i, time);
			}
			i++;
		}
	}

}
