package math;

import java.math.BigInteger;

public class PollardResult {
	
	private BigInteger n;
	private BigInteger p;
	private BigInteger bInit;
	private BigInteger b;
	private long i;
	
	public PollardResult(BigInteger n, BigInteger p, BigInteger bInit, BigInteger b, long i) {
		this.n = n;
		this.p = p;
		this.bInit = bInit;
		this.b = b;
		this.i = i;
	}

	public BigInteger getN() {
		return n;
	}

	public BigInteger getP() {
		return p;
	}

	public BigInteger getBInit() {
		return bInit;
	}

	public BigInteger getB() {
		return b;
	}

	public long getI() {
		return i;
	}
}
