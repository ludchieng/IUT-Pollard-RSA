package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import mathclean.Pollard;
import mathclean.Pollard3;

import java.math.BigInteger;

//@TestMethodOrder(OrderAnnotation.class)
public class Pollard3Test extends PollardTest {
	
	private Pollard.algo algo = Pollard.algo.POL3;
	
}
