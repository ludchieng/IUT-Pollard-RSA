package math;

import java.math.BigInteger;

public class PollardResult {
	
	private BigInteger n;
	private BigInteger p;
	private BigInteger x0;
	private BigInteger xFinal;
	private long nbReboot;
	private long i;
	
	public PollardResult(BigInteger n, BigInteger p, BigInteger x0, BigInteger xFinal, long nbReboot, long i) {
		this.n = n;
		this.p = p;
		this.x0 = x0;
		this.xFinal = xFinal;
		this.nbReboot = nbReboot;
		this.i = i;
	}

	public BigInteger getN() {
		return n;
	}

	public BigInteger getP() {
		return p;
	}

	public BigInteger getX0() {
		return x0;
	}

	public BigInteger getXFinal() {
		return xFinal;
	}

	public long setNbReboot(long v) {
		return nbReboot = v;
	}

	public long getNbReboot() {
		return nbReboot;
	}

	public long getI() {
		return i;
	}
}
