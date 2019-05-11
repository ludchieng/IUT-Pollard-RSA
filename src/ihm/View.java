package ihm;
import math.*;
import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
	
	private JButton btnFactorize;
	private JTextField txtfN;
	private JTextField txtfP;
	
	public View() {
		btnFactorize = new JButton("Factoriser");
		txtfN = new JTextField();
		txtfP = new JTextField();
		
		this.setLayout(new BorderLayout());
		Controller cntrl = new Controller(this);
		
		
		JPanel panFields = new JPanel();
		panFields.setLayout(new GridLayout(2,2));
		panFields.add(new JLabel("Entrez n:"));
		panFields.add(txtfN);
		panFields.add(new JLabel("Entrez p:"));
		panFields.add(txtfP);
		this.add(panFields, BorderLayout.CENTER);
		
		
		btnFactorize.addActionListener(cntrl);
		this.add(btnFactorize, BorderLayout.SOUTH);
	}
	
	public boolean isBtnFactorize(JComponent comp) {
		return comp == btnFactorize;
	}
	
	public void setTxtfP(String s) {
		this.txtfP.setText(s);
	}
	
	public String getTxtfN() {
		return this.txtfN.getText();
	}

}
