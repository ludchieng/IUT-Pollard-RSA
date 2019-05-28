package ihm;
import mathclean.*;
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
	
	public BigInteger factorizeP1(BigInteger bi, BigInteger x0) {
		return p1.factorizeWithX0(bi, x0).getpBi();
	}
	
	public BigInteger factorizeP2(BigInteger bi, BigInteger x0) {
		return p2.factorizeWithX0(bi, x0).getpBi();
	}
	
	public BigInteger factorizeP3(BigInteger bi, BigInteger x0) {
		return p3.factorizeWithX0(bi, x0).getpBi();
	}
	
}
