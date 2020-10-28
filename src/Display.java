import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Display extends JPanel{
	
	Graphics2D g2d;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g2d = (Graphics2D) g;
		g2d.setFont(new Font("Arial", Font.BOLD, 50));
		g2d.drawString("Temporary Display", 10, 60);
		
	}
}
