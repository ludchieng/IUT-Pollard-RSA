package math;

import java.io.Serializable;
import java.math.BigInteger;

public class PollardResult implements Serializable {
	
	private BigInteger n;
	private BigInteger p;
	private boolean success;
	private BigInteger x0;
	private BigInteger xFinal;
	private long nbReboot;
	private long i;
	private long time;
	
	public PollardResult(BigInteger n, BigInteger p, BigInteger x0, BigInteger xFinal, long nbReboot, long i) {
		this.n = n;
		this.p = p;
		if(this.n != null && this.p != null) {
			updateSuccess();
		}
		this.x0 = x0;
		this.xFinal = xFinal;
		this.nbReboot = nbReboot;
		this.i = i;
		this.time = '\0';
	}

	public BigInteger getN() {
		return n;
	}

	public BigInteger getP() {
		return p;
	}

	public boolean getSuccess() {
		return success;
	}
	
	public void updateSuccess() {
		BigInteger q = n.divide(p);
		if((!q.equals(new BigInteger("1")) || !q.equals(n)) && p.multiply(q).equals(n)) {
			this.success = true;
		}
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

	public void setTime(long time) {
		this.time = time;
	}

	public long getTime() {
		return this.time;
	}
}
