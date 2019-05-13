package math;
import java.math.BigInteger;

public class Pollard1 implements Pollard {

	public BigInteger factorize(BigInteger n) {
		int d = 1;
		// Must define x0 as Integer -- First value to start testing
		
		// Define b as Integer --
		
		BigInteger x = bi(x0);
		BigInteger u = bi(x0);
		System.out.println("n = "+n+"\tx0 = "+x0);
		while(true) {
			for(int j=d+1; j < 2d; j++) {
				x = (x.pow(2)).add(bi(b)).mod(n);
				BigInteger pgcd = pgcd(x.subtract(u), n);
				if (pgcd.compareTo(bi(1)) > 0 ){
					System.out.println("p = "+pgcd+"\tq = "+n.divide(pgcd));
					return pgcd;
				}
			}
			u = x;
			d *= 2;
		}
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
