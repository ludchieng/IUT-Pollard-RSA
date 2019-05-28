package ihm;
import mathclean.*;
import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
	
	private JTextField txtfN;
	private PollardPanel[] panPol;
	
	public View() {
		initPanel();
	}
	
	public void setTxtfN(String s) {
		this.txtfN.setText(s);
	}
	
	public String getTxtfN() {
		return txtfN.getText();
	}
	
	public PollardPanel getPolPan(Pollard.algo a) {
		for(PollardPanel pan : panPol) {
			if(pan.getAlgo() == a) {
				return pan;
			}
		}
		return null;
	}
	
	public void initPanel() {
		this.setLayout(new BorderLayout());
		
		txtfN = new JTextField();
		JButton btnFactorize = new JButton("Factoriser");
		JButton btnGenerateN = new JButton("Générer n");
		Controller cntrl = new Controller(this, btnFactorize, btnGenerateN);
		btnFactorize.addActionListener(cntrl);
		btnGenerateN.addActionListener(cntrl);
		
		
		JPanel panNField = new JPanel();
		panNField.setLayout(new GridLayout(1,2));
		panNField.add(new JLabel("Entrez n:"));
		panNField.add(btnGenerateN);
		
		JPanel panN = new JPanel();
		panN.setLayout(new GridLayout(2,1));
		panN.add(panNField);
		panN.add(txtfN);
		
		JPanel panFactorize = new JPanel();
		panFactorize.setLayout(new GridLayout(1,2));
		panFactorize.add(panN);
		panFactorize.add(btnFactorize);
		this.add(panFactorize, BorderLayout.NORTH);
		
		JPanel panRes = new JPanel();
		panRes.setLayout(new GridLayout(1,3));
		panPol = new PollardPanel[3];
		for(int i=0; i<3; i++) {
			panPol[i] = new PollardPanel(Pollard.algo.values()[i]);
			panRes.add(panPol[i]);
		}
		this.add(panRes, BorderLayout.SOUTH);
	}

}
