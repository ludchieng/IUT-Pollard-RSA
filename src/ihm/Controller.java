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
					if(pan.isChecked()) {
						PollardResult polRes = m.compute(algo, pan, n);
						PollardPanel polPan = v.getPolPan(algo);
						polPan.setP(polRes.getpBi());
						polPan.setTime(polRes.getTime());
						polPan.setX0(polRes.getX0Bi());
						if(algo != Pollard.algo.POL3) {
							polPan.setA(polRes.getaBi());
						}
						polPan.setI(polRes.getI());
						polPan.setNbReboot(polRes.getNbReboot());
						polPan.updateAvg(polRes.getTime(), polRes.getI());
					}
				}
			}
		}
		if(src == btnGenerateN) {
			try {
				v.setTxtfN(Numbers.getRndN(v.getNbDigitN()).toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	
}
