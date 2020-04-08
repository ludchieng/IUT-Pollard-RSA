package tests;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import pollard.Pollard;
import pollard.Pollard3;

@TestMethodOrder(OrderAnnotation.class)
public class Pollard3Test {
	
	@Test
	@Order(0)
	void test_gcd() {
		assertEquals(new BigInteger("5"),Pollard.gcd(new BigInteger("15"),new BigInteger("20")));
		assertEquals(new BigInteger("1"),Pollard.gcd(new BigInteger("29"),new BigInteger("7")));
	}
	
	@Test
	@Order(1)
	void test_factor_2_digits() {
		BigInteger n = new BigInteger("55");
		BigInteger p = new BigInteger("11");
		BigInteger q = new BigInteger("5");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	@Order(2)
	void test_factor_3_digits() {
		BigInteger n = new BigInteger("649");
		BigInteger p = new BigInteger("11");
		BigInteger q = new BigInteger("59");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	@Order(3)
	void test_factor_4_digits() {
		BigInteger n = new BigInteger("8557");
		BigInteger p = new BigInteger("43");
		BigInteger q = new BigInteger("199");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	@Order(4)
	void test_factor_5_digits() {
		BigInteger n = new BigInteger("76859");
		BigInteger p = new BigInteger("509");
		BigInteger q = new BigInteger("151");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	@Order(5)
	void test_factor_6_digits() {
		BigInteger n = new BigInteger("572443");
		BigInteger p = new BigInteger("211");
		BigInteger q = new BigInteger("2713");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	@Order(6)
	void test_factor_7_digits() {
		BigInteger n = new BigInteger("2529973");
		BigInteger p = new BigInteger("443");
		BigInteger q = new BigInteger("5711");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	@Order(7)
	void test_factor_8_digits() {
		BigInteger n = new BigInteger("14124041");
		BigInteger p = new BigInteger("5927");
		BigInteger q = new BigInteger("2383");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	@Order(8)
	void test_factor_9_digits() {
		BigInteger n = new BigInteger("894162859");
		BigInteger p = new BigInteger("13627");
		BigInteger q = new BigInteger("65617");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	@Order(9)
	void test_factor_10_digits() {
		BigInteger n = new BigInteger("6298963091");
		BigInteger p = new BigInteger("5647");
		BigInteger q = new BigInteger("1115453");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	@Order(10)
	void test_factor_11_digits() {
		BigInteger n = new BigInteger("54722770873");
		BigInteger p = new BigInteger("64901");
		BigInteger q = new BigInteger("843173");
		BigInteger x0 = new BigInteger("2");
		BigInteger divider = Pollard3.factorWithX0(n, x0).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}
}
