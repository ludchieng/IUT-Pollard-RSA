package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import math.Pollard3;

import java.math.BigInteger;

public class Pollard3Test extends PollardTest {
	@BeforeEach
	void setUp() throws Exception {
		pol = new Pollard3();
	}

	@AfterEach
	void tearDown() throws Exception {
		pol = null;
	}
}
