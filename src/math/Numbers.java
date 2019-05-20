package math;

import java.math.BigInteger;

public class Numbers {
	
	/**
	 * Generate random BigInteger between 2 and n-1
	 * @param n
	 * @return BigInteger random value
	 */
	public static BigInteger rnd(BigInteger n) {
		long nLength = n.toString().length();
		String resString;
		BigInteger res;
		do {
			resString = "";
			for(int i=0; i<nLength; i++) {
				int randomDigit = Character.getNumericValue(Double.toString(Math.random()).charAt(2));
				resString += randomDigit;
			}
			res = new BigInteger(resString);
		} while(res.compareTo(n) >= 0 || res.compareTo(new BigInteger("1")) <= 0);
		
		return res;
	}
	
}
