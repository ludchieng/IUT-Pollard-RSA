package ihm;
import mathclean.*;
import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
//
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
	
	public PollardResult compute(Pollard.algo algo, PollardPanel pan, BigInteger n) {
		PollardResult polRes = factorize(algo, pan, n);
		int nbReboot = 0;
		int time = polRes.getTime();
		while(!polRes.isSuccess()) {
			polRes = factorize(algo, pan, n);
			nbReboot++;
			time += polRes.getTime();
		}
		polRes.setNbReboot(nbReboot);
		polRes.setTime(time);
		return polRes;
	}
	
	private PollardResult factorize(Pollard.algo algo, PollardPanel pan, BigInteger n) {
		PollardResult polRes = null;
		switch(algo) {
		case POL1:
			if(pan.isFilledX0() && pan.isFilledA()) {
				if(pan.isFilledI()) {
					polRes = Pollard1.factorizeWithX0AndAFromI(n, pan.getX0(), pan.getA(), pan.getI());
				} else {
					polRes = Pollard1.factorizeWithX0AndA(n, pan.getX0(), pan.getA());
				}
			} else {
				if(pan.isFilledX0()) {
					polRes = Pollard1.factorizeWithX0(n, pan.getX0());
				} else {
					polRes = Pollard1.factorize(n);
				}
			}
			break;
		case POL2:
			if(pan.isFilledX0() && pan.isFilledA()) {
				if(pan.isFilledI()) {
					polRes = Pollard2.factorizeWithX0AndAFromI(n, pan.getX0(), pan.getA(), pan.getI());
				} else {
					polRes = Pollard2.factorizeWithX0AndA(n, pan.getX0(), pan.getA());
				}
			} else {
				if(pan.isFilledX0()) {
					polRes = Pollard2.factorizeWithX0(n, pan.getX0());
				} else {
					polRes = Pollard2.factorize(n);
				}
			}
			break;
		case POL3:
			if(pan.isFilledX0() && pan.isFilledI()) {
				polRes = Pollard3.factorizeWithX0FromI(n, pan.getX0(), pan.getI());
			} else if (pan.isFilledX0()) {
				polRes = Pollard3.factorizeWithX0(n, pan.getX0());
			} else {
				polRes = Pollard3.factorize(n);
			}
			break;
		}
		return polRes;
	}
	
}
