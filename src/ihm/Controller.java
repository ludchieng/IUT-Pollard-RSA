package ihm;
import math.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class Controller implements ActionListener {
	
	private View v;
	private Model m;
	
	public Controller(View v) {
		this.v = v;
		this.m = new Model();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton src = (JButton)arg0.getSource();
		if(v.isBtnFactorize(src)) {
			BigInteger n = new BigInteger(v.getTxtfN());
			//Rajouter le x0 sinon ça marche ap
			BigInteger p = m.factorizeP3(n, x0);
			this.v.setTxtfP(p.toString());
		}
		
	}
	
}
