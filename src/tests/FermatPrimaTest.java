package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import math.FermatPrima;

class FermatPrimaTest {
	
	private BigInteger bi(String s) {
		return new BigInteger(s);
	}
	private BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}

	@Test
	void test_isPrime_() {
		assertTrue(FermatPrima.isPrime(bi(11), 500));
		assertTrue(FermatPrima.isPrime(bi(89), 500));
		assertTrue(FermatPrima.isPrime(bi(379), 500));
		assertTrue(FermatPrima.isPrime(bi(773), 500));
		assertTrue(FermatPrima.isPrime(bi(1201), 500));
		assertTrue(FermatPrima.isPrime(bi(5639), 500));
		assertTrue(FermatPrima.isPrime(bi(12781), 500));
		assertTrue(FermatPrima.isPrime(bi(74131), 500));
		assertTrue(FermatPrima.isPrime(bi(601067), 500));
		assertTrue(FermatPrima.isPrime(bi(4540531), 500));
		assertTrue(FermatPrima.isPrime(bi("45399002963"), 500));
		assertTrue(FermatPrima.isPrime(bi("953990030621"), 500));

		assertFalse(FermatPrima.isPrime(bi(26), 10));
		assertFalse(FermatPrima.isPrime(bi(3127), 10));
		assertFalse(FermatPrima.isPrime(bi("1382951"), 10));
		assertFalse(FermatPrima.isPrime(bi("11506409"), 10));
		assertFalse(FermatPrima.isPrime(bi("29278699"), 10));
		assertFalse(FermatPrima.isPrime(bi("162520121"), 10));
		assertFalse(FermatPrima.isPrime(bi("26635538539769"), 10));
		assertFalse(FermatPrima.isPrime(bi("4246049883462817"), 10));
		assertFalse(FermatPrima.isPrime(bi("891017177132332772451613"), 10));
	}
	
}
