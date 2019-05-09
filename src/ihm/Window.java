package ihm;
import math.*;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
	
	public Window() {
		this.add(new View());
		this.pack();
		this.setVisible(true);
	}
}
