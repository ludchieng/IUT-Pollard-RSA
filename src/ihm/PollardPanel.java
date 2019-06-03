package ihm;
import mathclean.Pollard;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class PollardPanel extends JPanel {

	private Pollard.algo algo;
	
	private JCheckBox chk;
	private JTextField x0Input;
	private JTextField aInput;
	private JTextField iInput;

	private JTextField p;
	private JTextField time;
	private JTextField x0;
	private JTextField a;
	private JTextField i;
	private JTextField nbReboot;
	
	private int nbAvg;
	private JButton resetAvg;
	private JTextField timeAvg;
	private JTextField iAvg;
	
	
	public PollardPanel(Pollard.algo algo) {
		chk = new JCheckBox("", true);
		x0Input = new JTextField();
		aInput = new JTextField();
		iInput = new JTextField();
		p = new JTextField();
		time = new JTextField();
		x0 = new JTextField();
		a = new JTextField();
		i = new JTextField();
		nbReboot = new JTextField();

		nbAvg = 0;
		resetAvg = new JButton("Reset moy");
		timeAvg = new JTextField("0");
		iAvg = new JTextField("0");
		
		this.algo = algo;
		
		if(this.algo == Pollard.algo.POL3) {
			this.aInput.setVisible(false);
			this.a.setVisible(false);
		}
		
		initPanel();
	}

	
	public boolean isChecked() {
		return chk.isSelected();
	}
	
	public boolean isFilledX0() {
		return !x0Input.getText().equals("");
	}
	
	public boolean isFilledA() {
		return !aInput.getText().equals("");
	}
	
	public boolean isFilledI() {
		return !iInput.getText().equals("");
	}
	
	
	public Pollard.algo getAlgo() {
		return algo;
	}
	
	public BigInteger getX0() {
		return new BigInteger(x0Input.getText());
	}
	
	public BigInteger getA() {
		return new BigInteger(aInput.getText());
	}

	public int getI() {
		return Integer.parseInt(iInput.getText());
	}
	

	
	
	public int getTime() {
		return Integer.parseInt(time.getText());
	}
	
	public int getTimeAvg() {
		return Integer.parseInt(timeAvg.getText());
	}

	public int getIAvg() {
		return Integer.parseInt(iAvg.getText());
	}


	public void setP(BigInteger p) {
		this.p.setText(p.toString());
	}
	public void setP(String p) {
		this.p.setText(p);
	}

	public void setTime(int time) {
		this.time.setText(Integer.toString(time));
	}
	
	public void setTimeAvg(int time) {
		this.timeAvg.setText(Integer.toString(time));
	}

	public void setX0(BigInteger x0) {
		this.x0.setText(x0.toString());
	}
	public void setX0(String x0) {
		this.x0.setText(x0);
	}

	public void setA(BigInteger a) {
		this.a.setText(a.toString());
	}
	public void setA(String a) {
		this.a.setText(a);
	}
	
	public void setI(int i) {
		this.i.setText(Integer.toString(i));
	}
	
	public void setIAvg(int i) {
		this.iAvg.setText(Integer.toString(i));
	}
	
	public void setNbReboot(int nbR) {
		this.nbReboot.setText(Integer.toString(nbR));
	}
	
	
	public void updateAvg(int time, int i) {
		int timeAvg = getTimeAvg();
		int iAvg = getIAvg();
		timeAvg *= nbAvg;
		iAvg *= nbAvg;
		timeAvg += time;
		iAvg += i;
		nbAvg++;
		timeAvg /= nbAvg;
		iAvg /= nbAvg;
		setTimeAvg(timeAvg);
		setIAvg(iAvg);
	}
	
	
	public void initPanel() {
		this.setLayout(new BorderLayout());
		this.add(new JLabel(Pollard.algoToDisplay(algo), SwingConstants.CENTER), BorderLayout.NORTH);

		Border bord = x0Input.getBorder();
		Border marg = new EmptyBorder(4,4,4,4);
		x0Input.setBorder(new CompoundBorder(marg, bord));
		aInput.setBorder(new CompoundBorder(marg, bord));
		iInput.setBorder(new CompoundBorder(marg, bord));
		p.setBorder(new CompoundBorder(marg, bord));
		time.setBorder(new CompoundBorder(marg, bord));
		x0.setBorder(new CompoundBorder(marg, bord));
		a.setBorder(new CompoundBorder(marg, bord));
		i.setBorder(new CompoundBorder(marg, bord));
		nbReboot.setBorder(new CompoundBorder(marg, bord));

		p.setEditable(false);
		time.setEditable(false);
		x0.setEditable(false);
		a.setEditable(false);
		i.setEditable(false);
		nbReboot.setEditable(false);
		
		AvgController cntrlAvg = new AvgController();
		resetAvg.addActionListener(cntrlAvg);
		timeAvg.setBorder(new CompoundBorder(marg, bord));
		iAvg.setBorder(new CompoundBorder(marg, bord));
		timeAvg.setEditable(false);
		iAvg.setEditable(false);
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(10,3));
		
		pan.add(new JLabel(Pollard.algoToDisplay(algo), SwingConstants.RIGHT));
		pan.add(chk);
		pan.add(new JLabel(""));
		
		pan.add(new JLabel("x0 ", SwingConstants.RIGHT));
		pan.add(x0Input);
		pan.add(new JLabel(""));
		
		pan.add(createALabel());
		pan.add(aInput);
		pan.add(new JLabel(""));
		
		pan.add(new JLabel(""/*"i"*/, SwingConstants.RIGHT));
		pan.add(iInput);
		iInput.setVisible(false);
		pan.add(resetAvg);
		
		pan.add(new JLabel("p ", SwingConstants.RIGHT));
		pan.add(p);
		pan.add(new JLabel(""));
		
		pan.add(new JLabel("time (µs) ", SwingConstants.RIGHT));
		pan.add(time);
		pan.add(timeAvg);
		
		pan.add(new JLabel("x0 ", SwingConstants.RIGHT));
		pan.add(x0);
		pan.add(new JLabel(""));
		
		pan.add(createALabel());
		pan.add(a);
		pan.add(new JLabel(""));
		
		pan.add(new JLabel("i ", SwingConstants.RIGHT));
		pan.add(i);
		pan.add(iAvg);
		
		pan.add(new JLabel("Nb Reboot ", SwingConstants.RIGHT));
		pan.add(nbReboot);
		pan.add(new JLabel(""));
		
		this.add(pan, BorderLayout.SOUTH);
	}
	
	private JLabel createALabel() {
		if(this.algo == Pollard.algo.POL3) {
			return new JLabel("");
		} else {
			return new JLabel("a", SwingConstants.RIGHT);
		}
	}
	
	private class AvgController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton src = (JButton) e.getSource();
			if(src == resetAvg) {
				nbAvg = 0;
				setTimeAvg(0);
				setIAvg(0);
			}
		}
		
	}
	
}
