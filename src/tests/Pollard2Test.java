package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import math.Pollard2;

import java.math.BigInteger;

public class Pollard2Test extends PollardTest {
	@BeforeEach
	void setUp() throws Exception {
		pol = new Pollard2();
	}

	@AfterEach
	void tearDown() throws Exception {
		pol = null;
	}
}
