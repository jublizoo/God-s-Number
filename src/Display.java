import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JPanel {

	// This class just displays the graphics, you don't need to totally understand
	// this, and I'm not sure if you know enough to understand it yet. Just lmk if
	// you want me to call you on discord and explain it though

	Graphics2D g2d;
	int faceSize;
	int pieceSize;
	//The X and Y positions of the faces 0 - 5 and pieces 0 -7
	int[][] facePos = {{1, 0, 1, 2, 1, 1}, {1, 1, 2, 1, 0, 3}};
	int[][] piecePos = {{0, 2, 2, 0, 1, 2, 1, 0}, {0, 0, 2, 2, 0, 1, 2, 1}};
	
	@Override
	protected void paintComponent(Graphics g) {
		faceSize = Main.f.getContentPane().getHeight() / 4;
		pieceSize = faceSize / 3;
		
		try {
			for(int i = 0; i < 6; i++) {
				g.setColor(Main.c.colors[i]);
				g.fillRect(facePos[0][i] * faceSize+ pieceSize, 
				facePos[1][i] * faceSize + pieceSize, pieceSize, pieceSize);
				
				for(int b = 0; b < 8; b++) {
					g.setColor(Main.c.colors[Main.c.state[i][b]]);
					g.fillRect(faceSize * facePos[0][i] + pieceSize * piecePos[0][b], 
					faceSize * facePos[1][i] + pieceSize * piecePos[1][b], pieceSize, pieceSize);
					
					g.setColor(Color.BLACK);
					g.drawRect(faceSize * facePos[0][i] + pieceSize * piecePos[0][b], 
					faceSize * facePos[1][i] + pieceSize * piecePos[1][b], pieceSize, pieceSize);
				}
			}
		} catch(Exception e) {}
		
		g.setColor(Color.BLACK);
		g2d = (Graphics2D) g;
		/*
		g2d.setFont(new Font("Arial", Font.BOLD, 50));
		g2d.drawString("Temporary Display", 10, 60);
		//Put any drawing stuff below
		*/
	}
}
