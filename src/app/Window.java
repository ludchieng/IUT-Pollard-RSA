package app;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Window() {
		this.add(new View());
		this.setPreferredSize(new Dimension(900, 420));
		this.pack();
		this.setVisible(true);
	}
}
