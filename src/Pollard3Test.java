import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class Pollard3Test {
	
	private Pollard pol;
	
	private BigInteger bi(String s) {
		return new BigInteger(s);
	}
	
	private BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}

	@BeforeEach
	void setUp() throws Exception {
		pol = new Pollard3();
	}

	@AfterEach
	void tearDown() throws Exception {
		pol = null;
	}
	
	@Test
	void test_pgcd() {
		assertEquals(bi(5),pol.pgcd(bi(15),bi(20)));
		assertEquals(bi(1),pol.pgcd(bi(29),bi(7)));
	}

	@Test
	void test_factorize_2_digits() {
		BigInteger n = new BigInteger("55");
		BigInteger p = new BigInteger("11");
		BigInteger q = new BigInteger("5");
		assertTrue(pol.factorize(n).equals(p) || pol.factorize(n).equals(q));
	}

	@Test
	void test_factorize_20_digits() {
		BigInteger n = new BigInteger("31360014560001377519");
		BigInteger p = new BigInteger("5600000741");
		BigInteger q = new BigInteger("5600001859");
		assertTrue(pol.factorize(n).equals(p) || pol.factorize(n).equals(q));
	}

}
