package app;
import pollard.*;
import java.math.BigInteger;

public class Model {
	
	public Model() {
	}
	
	public BigInteger factorP1(BigInteger bi, BigInteger x0) {
		return Pollard1.factorWithX0(bi, x0).getpBi();
	}
	
	public BigInteger factorP2(BigInteger bi, BigInteger x0) {
		return Pollard2.factorWithX0(bi, x0).getpBi();
	}
	
	public BigInteger factorP3(BigInteger bi, BigInteger x0) {
		return Pollard3.factorWithX0(bi, x0).getpBi();
	}
	
	public PollardResult compute(Pollard.algo algo, PollardPanel pan, BigInteger n) {
		PollardResult polRes = factor(algo, pan, n);
		int nbReboot = 0;
		int time = polRes.getTime();
		while(!polRes.isSuccess()) {
			polRes = factor(algo, pan, n);
			nbReboot++;
			time += polRes.getTime();
		}
		polRes.setNbReboot(nbReboot);
		polRes.setTime(time);
		return polRes;
	}
	
	private PollardResult factor(Pollard.algo algo, PollardPanel pan, BigInteger n) {
		PollardResult polRes = null;
		switch(algo) {
		case POL1:
			if(pan.isFilledX0() && pan.isFilledA()) {
				if(pan.isFilledI()) {
					polRes = Pollard1.factorWithX0AndAFromI(n, pan.getX0(), pan.getA(), pan.getI());
				} else {
					polRes = Pollard1.factorWithX0AndA(n, pan.getX0(), pan.getA());
				}
			} else {
				if(pan.isFilledX0()) {
					polRes = Pollard1.factorWithX0(n, pan.getX0());
				} else {
					polRes = Pollard1.factor(n);
				}
			}
			break;
		case POL2:
			if(pan.isFilledX0() && pan.isFilledA()) {
				if(pan.isFilledI()) {
					polRes = Pollard2.factorWithX0AndAFromI(n, pan.getX0(), pan.getA(), pan.getI());
				} else {
					polRes = Pollard2.factorWithX0AndA(n, pan.getX0(), pan.getA());
				}
			} else {
				if(pan.isFilledX0()) {
					polRes = Pollard2.factorWithX0(n, pan.getX0());
				} else {
					polRes = Pollard2.factor(n);
				}
			}
			break;
		case POL3:
			if(pan.isFilledX0() && pan.isFilledI()) {
				polRes = Pollard3.factorWithX0FromI(n, pan.getX0(), pan.getI());
			} else if (pan.isFilledX0()) {
				polRes = Pollard3.factorWithX0(n, pan.getX0());
			} else {
				polRes = Pollard3.factor(n);
			}
			break;
		}
		return polRes;
	}
	
}
