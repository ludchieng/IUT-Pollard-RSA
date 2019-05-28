package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;

import mathclean.Pollard;

import java.math.BigInteger;

public abstract class PollardTest {
	
	private Pollard.algo algo;
	
	private BigInteger bi(String s) {
		return new BigInteger(s);
	}
	
	private BigInteger bi(int i) {
		return new BigInteger(Integer.toString(i));
	}
	
	@Test
	void test_pgcd() {
		assertEquals(bi(5),Pollard.pgcd(bi(15),bi(20)));
		assertEquals(bi(1),Pollard.pgcd(bi(29),bi(7)));
	}
	
	@Test
	//@Order(1)
	void test_factorize_2_digits() {
		BigInteger n = new BigInteger("77");
		BigInteger p = new BigInteger("11");
		BigInteger q = new BigInteger("7");
		BigInteger divider = Pollard.factorize(n, algo).getpBi();
		assertTrue(divider.equals(p) || divider.equals(q));
	}
/*
	@Test
	//@Order(2)
	void test_factorize_3_digits() {
		BigInteger n = new BigInteger("437");
		BigInteger p = new BigInteger("19");
		BigInteger q = new BigInteger("23");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	//@Order(3)
	void test_factorize_4_digits() {
		BigInteger n = new BigInteger("5917");
		BigInteger p = new BigInteger("97");
		BigInteger q = new BigInteger("61");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	//@Order(4)
	void test_factorize_5_digits() {
		BigInteger n = new BigInteger("38021");
		BigInteger p = new BigInteger("197");
		BigInteger q = new BigInteger("193");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	//@Order(5)
	void test_factorize_6_digits() {
		BigInteger n = new BigInteger("145157");
		BigInteger p = new BigInteger("379");
		BigInteger q = new BigInteger("383");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	//@Order(6)
	void test_factorize_7_digits() {
		BigInteger n = new BigInteger("1047847");
		BigInteger p = new BigInteger("997");
		BigInteger q = new BigInteger("1051");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	//@Order(7)
	void test_factorize_8_digits() {
		BigInteger n = new BigInteger("12467957");
		BigInteger p = new BigInteger("3529");
		BigInteger q = new BigInteger("3533");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	//@Order(8)
	void test_factorize_9_digits() {
		BigInteger n = new BigInteger("110103013");
		BigInteger p = new BigInteger("10487");
		BigInteger q = new BigInteger("10499");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}
/*
	@Test
	//@Order(9)
	void test_factorize_20_digits() {
		BigInteger n = new BigInteger("31360014560001377519");
		BigInteger p = new BigInteger("5600000741");
		BigInteger q = new BigInteger("5600001859");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	//@Order(10)
	void test_factorize_21_digits() {
		BigInteger n = new BigInteger("101137273118300999101");
		BigInteger p = new BigInteger("10056702277");
		BigInteger q = new BigInteger("10056703513");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	//@Order(11)
	void test_factorize_22_digits() {
		BigInteger n = new BigInteger("7354212367043346579403");
		BigInteger p = new BigInteger("85756703803");
		BigInteger q = new BigInteger("85756705201");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}

	@Test
	//@Order(12)
	void test_factorize_24_digits() {
		BigInteger n = new BigInteger("735421174897763935603447");
		BigInteger p = new BigInteger("857567007931");
		BigInteger q = new BigInteger("857567010037");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}
*//*
	@Test
	//@Order(13)
	void test_factorize_3_digits_pb_de_ses_morts() {
		BigInteger n = new BigInteger("671");
		BigInteger p = new BigInteger("11");
		BigInteger q = new BigInteger("61");
		BigInteger divider = pol.factorize(n);
		assertTrue(divider.equals(p) || divider.equals(q));
	}
*/
}
