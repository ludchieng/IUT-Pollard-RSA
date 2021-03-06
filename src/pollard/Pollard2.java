package pollard;

import java.math.BigInteger;

public class Pollard2 extends Pollard {

	public static Pollard.algo algo = Pollard.algo.POL2;
	
	
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
		System.out.println("\n## POLLARD 2   n="+n+"\tx0="+x0+"\ta="+a);
		
		long timeBegin = System.nanoTime();
		
		BigInteger x = bi(x0);
		BigInteger y = bi(x);
		BigInteger p;
		
		while(true) {
			//System.out.print(x);
			x = (x.pow(2)).add(a).mod(n);
			//System.out.println("^2+a=" + x);

			//System.out.print("("+y);
			y = ((((y.pow(2)).add(a).mod(n)).pow(2)).add(a)).mod(n);
			//System.out.println("^2+a)^2+a=" + y);
			
			p = gcd(y.subtract(x), n);
			//System.out.println("gcd(" + n + "," + y.subtract(x).mod(n) + ")=" + p);
			
			if (p.compareTo(bi(1)) > 0){
				long timeEnd = System.nanoTime();
				int time = (int) ((timeEnd - timeBegin)/1000);

				System.out.println("gcd(" + n + "," + y + "-" + x + ")=" + p);
				
				return new PollardResult(algo, n, p, checkP(n,p), a, x0, x, -1, i, time);
			}
			i++;
		}
	}

}
