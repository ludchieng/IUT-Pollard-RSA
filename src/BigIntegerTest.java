import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BigIntegerTest {
	
	private BigInteger bi(String s) {
		return new BigInteger(s);
	}
	
	@Test
	void test_mod() {
		assertEquals(bi("3"), bi("26262629").mod(bi("2626")));
	}

}
