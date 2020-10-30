import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Display extends JPanel {

	// This class just displays the graphics, you don't need to totally understand
	// this, and I'm not sure if you know enough to understand it yet. Just lmk if
	// you want me to call you on discord and explain it though

	Graphics2D g2d;

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g2d = (Graphics2D) g;
		g2d.setFont(new Font("Arial", Font.BOLD, 50));
		g2d.drawString("Temporary Display", 10, 60);

	}
}
