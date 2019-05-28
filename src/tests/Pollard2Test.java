package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mathclean.Pollard;
import mathclean.Pollard2;

import java.math.BigInteger;

//@TestMethodOrder(OrderAnnotation.class)
public class Pollard2Test extends PollardTest {
	
	private Pollard.algo algo = Pollard.algo.POL2;
	
}
