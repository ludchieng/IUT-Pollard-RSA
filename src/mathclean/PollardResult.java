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
	
	public PollardResult(Pollard.algo algo, BigInteger nBi, BigInteger pBi, boolean success, BigInteger aBi, BigInteger x0Bi,
			BigInteger xFinalBi, int nbReboot, int i, int time) {
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
	}

	public BigInteger getpBi() {
		return pBi;
	}

	public void setpBi(BigInteger pBi) {
		this.pBi = pBi;
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
	}

	public BigInteger getX0Bi() {
		return x0Bi;
	}

	public void setX0Bi(BigInteger x0Bi) {
		this.x0Bi = x0Bi;
	}

	public BigInteger getxFinalBi() {
		return xFinalBi;
	}

	public void setxFinalBi(BigInteger xFinalBi) {
		this.xFinalBi = xFinalBi;
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
		return toInt(nBi);
	}

	public int getP() {
		return toInt(pBi);
	}

	public int getA() {
		return toInt(aBi);
	}

	public int getX0() {
		return toInt(x0Bi);
	}

	public int getxFinal() {
		return toInt(xFinalBi);
	}
	
	private int toInt(BigInteger bi) {
		if(bi == null) {
			throw new NullPointerException("Expected BigInteger but was null");
		}
		if(bi.compareTo(new BigInteger(Integer.toString(Integer.MAX_VALUE))) > 0) {
			throw new IllegalArgumentException("Cannot cast safely BigInteger into int");
		}
		return bi.intValue();
	}
	
	public String toString() {
		return getnBi() + "\t" + getpBi() + "\t"
				+ isSuccess() + "\t" + getX0Bi() + "\t"
				+ getxFinalBi() + "\t" + getNbReboot() + "\t"
				+ getI()+ "\t"	+ getTime();
	}

}
