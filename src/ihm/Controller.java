package ihm;
import mathclean.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigInteger;

public class Controller implements ActionListener {
	
	private View v;
	private Model m;

	private JButton btnFactorize;
	private JButton btnGenerateN;
	
	public Controller(View v, JButton btnFactorize, JButton btnGenerateN) {
		this.v = v;
		this.m = new Model();
		this.btnFactorize = btnFactorize;
		this.btnGenerateN = btnGenerateN;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton src = (JButton)arg0.getSource();
		if(src == btnFactorize) {
			if(!v.getTxtfN().isEmpty()) {
				BigInteger n = new BigInteger(v.getTxtfN());
				for(Pollard.algo algo : Pollard.algo.values()) {
					PollardPanel pan = v.getPolPan(algo);
					
					PollardResult polRes = compute(algo, pan, n);
					int nbReboot = 0;
					int time = polRes.getTime();
					while(!polRes.isSuccess()) {
						polRes = compute(algo, pan, n);
						nbReboot++;
						time += polRes.getTime();
					}
					polRes.setNbReboot(nbReboot);
					polRes.setTime(time);
					
					PollardPanel polPan = v.getPolPan(algo);
					polPan.setP(polRes.getpBi());
					polPan.setTime(polRes.getTime());
					polPan.setX0(polRes.getX0Bi());
					if(algo == Pollard.algo.POL2) {
						polPan.setA(polRes.getaBi());
					}
					polPan.setI(polRes.getI());
					polPan.setNbReboot(polRes.getNbReboot());
				}
			}
		}
		if(src == btnGenerateN) {
			try {
				v.setTxtfN(Numbers.getRndN().toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public PollardResult compute(Pollard.algo algo, PollardPanel pan, BigInteger n) {
		PollardResult polRes = null;
		switch(algo) {
		case POL1:
			if(pan.isFilledX0() && pan.isFilledI()) {
				polRes = Pollard1.factorizeWithX0FromI(n, pan.getX0(), pan.getI());
			} else if (pan.isFilledX0()) {
				polRes = Pollard1.factorizeWithX0(n, pan.getX0());
			} else {
				polRes = Pollard1.factorize(n);
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
