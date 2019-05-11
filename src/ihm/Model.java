package ihm;
import math.*;
import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

public class Model {

	private Pollard1 p1;
	private Pollard2 p2;
	private Pollard3 p3;
	
	public Model() {
		p1 = new Pollard1();
		p2 = new Pollard2();
		p3 = new Pollard3();
	}
	
	public BigInteger factorizeP1(BigInteger bi) {
		return p1.factorize(bi);
	}
	
	public BigInteger factorizeP2(BigInteger bi) {
		return p2.factorize(bi);
	}
	
	public BigInteger factorizeP3(BigInteger bi) {
		return p3.factorize(bi);
	}
	
}
