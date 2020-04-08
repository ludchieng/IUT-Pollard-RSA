package app;
import pollard.*;
import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtfN;
	private JSpinner nbDigitsN;
	private PollardPanel[] panPol;
	
	public View() {
		initPanel();
	}
	
	public void setTxtfN(String s) {
		this.txtfN.setText(s);
	}
	
	public int getNbDigitN() {
		return Integer.parseInt(nbDigitsN.getValue().toString());
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
		JButton btnfactor = new JButton("Factor");
		JButton btnGenerateN = new JButton("Get n value");
		Controller cntrl = new Controller(this, btnfactor, btnGenerateN);
		btnfactor.addActionListener(cntrl);
		btnGenerateN.addActionListener(cntrl);
		
		
		JPanel panNField = new JPanel();
		panNField.setLayout(new GridLayout(1,3));
		panNField.add(new JLabel("Input n:"));
		SpinnerNumberModel nbDigitsNModel = new SpinnerNumberModel(8,2,13,1);
		nbDigitsN = new JSpinner(nbDigitsNModel);
		panNField.add(nbDigitsN);
		panNField.add(btnGenerateN);
		
		JPanel panN = new JPanel();
		panN.setLayout(new GridLayout(2,1));
		panN.add(panNField);
		panN.add(txtfN);
		
		JPanel panfactor = new JPanel();
		panfactor.setLayout(new GridLayout(1,2));
		panfactor.add(panN);
		panfactor.add(btnfactor);
		this.add(panfactor, BorderLayout.NORTH);
		
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
