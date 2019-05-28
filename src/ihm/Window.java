package ihm;
import mathclean.*;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
	
	public Window() {
		this.add(new View());
		this.setPreferredSize(new Dimension(500, 380));
		this.pack();
		this.setVisible(true);
	}
}
