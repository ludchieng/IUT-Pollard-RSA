package math;
import java.math.BigInteger;

public class Pollard2 implements Pollard {

	@Override
	public BigInteger factorize(BigInteger n, int x0) {
		
		// Nombres random
		int a = ((int) Math.random() * 98 + 2);
		BigInteger x = bi(x0);
		
		BigInteger y = x;
		System.out.println("n = "+n+"\ta = "+a+"\tx0 = "+x);
		BigInteger pgcd;
		while(true) {
			x = (x.pow(2)).add(bi(a)).mod(n);
			y = ((((y.pow(2)).add(bi(a)).mod(n)).pow(2)).add(bi(a))).mod(n);
			pgcd = pgcd(y.subtract(x), n);
			if (pgcd.compareTo(bi(1)) == 0){
				System.out.println("p = "+pgcd+"\tq = "+n.divide(pgcd));
				return pgcd;
			}
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
	
	
	@SuppressWarnings("unused")
	private BigInteger bi(String s) {
		return new BigInteger(s);
	}
	
	private BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}
	
}