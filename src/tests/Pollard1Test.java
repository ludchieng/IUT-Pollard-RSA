package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;

import math.Pollard1;

import java.math.BigInteger;

//@TestMethodOrder(OrderAnnotation.class)
public class Pollard1Test extends PollardTest {
	@BeforeEach
	void setUp() throws Exception {
		pol = new Pollard1();
	}

	@AfterEach
	void tearDown() throws Exception {
		pol = null;
	}
}
