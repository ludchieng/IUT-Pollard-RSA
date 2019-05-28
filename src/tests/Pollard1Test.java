package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;

import mathclean.Pollard;
import mathclean.Pollard1;

import java.math.BigInteger;

//@TestMethodOrder(OrderAnnotation.class)
public class Pollard1Test extends PollardTest {
	
	private Pollard.algo algo = Pollard.algo.POL1;
	
}
