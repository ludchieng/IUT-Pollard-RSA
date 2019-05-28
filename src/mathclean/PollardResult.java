package mathclean;

import java.math.BigInteger;

public class PollardResult {

	private Pollard.algo algo;
	private BigInteger nBi;
	private BigInteger pBi;
	private boolean success;
	private BigInteger aBi;
	private BigInteger x0Bi;
	private BigInteger xFinalBi;
	private int nbReboot;
	private int i;
	private int time;

	private int n;
	private int p;
	private int a;
	private int x0;
	private int xFinal;
	
	public PollardResult(Pollard.algo algo, BigInteger nBi, BigInteger pBi, boolean success, BigInteger aBi, BigInteger x0Bi,
			BigInteger xFinalBi, int nbReboot, int i, int time) {
		super();
		this.algo = algo;
		this.nBi = nBi;
		this.pBi = pBi;
		this.success = success;
		this.aBi = aBi;
		this.x0Bi = x0Bi;
		this.xFinalBi = xFinalBi;
		this.nbReboot = nbReboot;
		this.i = i;
		this.time = time;
	}

	public Pollard.algo getAlgo() {
		return algo;
	}

	public void setAlgo(Pollard.algo algo) {
		this.algo = algo;
	}

	public BigInteger getnBi() {
		return nBi;
	}

	public void setnBi(BigInteger nBi) {
		this.nBi = nBi;
		if(nBi.compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE))) > 0) {
			this.n = -1;
		} else {
			this.n = nBi.intValue();
		}
	}

	public BigInteger getpBi() {
		return pBi;
	}

	public void setpBi(BigInteger pBi) {
		this.pBi = pBi;
		if(pBi.compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE))) > 0) {
			this.p = -1;
		} else {
			this.p = pBi.intValue();
		}
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public BigInteger getaBi() {
		return aBi;
	}

	public void setaBi(BigInteger aBi) {
		this.aBi = aBi;
		if(aBi.compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE))) > 0) {
			this.a = -1;
		} else {
			this.a = aBi.intValue();
		}
	}

	public BigInteger getX0Bi() {
		return x0Bi;
	}

	public void setX0Bi(BigInteger x0Bi) {
		this.x0Bi = x0Bi;
		if(x0Bi.compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE))) > 0) {
			this.x0 = -1;
		} else {
			this.x0 = x0Bi.intValue();
		}
	}

	public BigInteger getxFinalBi() {
		return xFinalBi;
	}

	public void setxFinalBi(BigInteger xFinalBi) {
		this.xFinalBi = xFinalBi;
		if(xFinalBi.compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE))) > 0) {
			this.xFinal = -1;
		} else {
			this.xFinal = xFinalBi.intValue();
		}
	}

	public int getNbReboot() {
		return nbReboot;
	}

	public void setNbReboot(int nbReboot) {
		this.nbReboot = nbReboot;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getN() {
		/*if(n == -1) {
			throw new IllegalStateException("Out of range number");
		}*/
		return n;
	}

	public int getP() {
		/*if(p == -1) {
			throw new IllegalStateException("Out of range number");
		}*/
		return p;
	}

	public int getA() {
		/*if(a == -1) {
			throw new IllegalStateException("Out of range number");
		}*/
		return a;
	}

	public int getX0() {
		/*if(x0 == -1) {
			throw new IllegalStateException("Out of range number");
		}*/
		return x0;
	}

	public int getxFinal() {
		/*if(xFinal == -1) {
			throw new IllegalStateException("Out of range number");
		}*/
		return xFinal;
	}
	
	

}
