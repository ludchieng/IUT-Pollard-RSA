package ihm;
import math.*;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
	
	public Window() {
		this.add(new View());
		this.setPreferredSize(new Dimension(400, 120));
		this.pack();
		this.setVisible(true);
	}
}
