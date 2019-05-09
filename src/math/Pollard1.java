package math;
import java.math.BigInteger;

public class Pollard1 implements Pollard {

	@Override
	public BigInteger factorize(BigInteger n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigInteger pgcd(BigInteger a, BigInteger b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private BigInteger bi(String s) {
		return new BigInteger(s);
	}
	private BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}
	
}