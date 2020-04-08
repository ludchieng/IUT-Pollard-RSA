package pollard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Numbers {
	
	/**
	 * Generate random integer between min and max
	 * @param min
	 * @param max
	 * @return generated integer
	 */
	public static int random(int min, int max) {
		return (int) (Math.random() * (max-min+1)) + min;
	}
	
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
	
	
	/**
	 * Pick a random n from list with a given number of digit
	 */
	public static BigInteger getRndN(int nbDigits) throws IOException {
		// Count number of lines of the list of n values
		int nbLines = 0;
		BufferedReader br = new BufferedReader(new FileReader("./data/list_n.txt"));
		while(br.readLine() != null) {
			nbLines++;
		}
		
		// Pick n value
		String res = "";
		System.out.println(res);
		int readCursor = random(0,nbLines-1);
		do {
			br = new BufferedReader(new FileReader("./data/list_n.txt"));
			res = br.readLine();
			for(int i=0; i<readCursor; i++) {
				res = br.readLine();
			}
			if(res.length() > nbDigits) {
				readCursor = random(0,readCursor);
			} else {
				readCursor = random(readCursor,nbLines-1);
			}
		} while(res.length() != nbDigits);
		br.close();
		return new BigInteger(res);
	}
	
	
	/**
	 * Pick a random n from list
	 */
	public static BigInteger getRndN() throws IOException {
		return getRndN((int) (Math.random() * 11) + 2);
	}
	
}
