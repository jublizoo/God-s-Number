import java.awt.Color;

public class Cube {
	
	Color[][][] state = new Color[6][3][3];
	Color[] colors = {Color.WHITE, Color.ORANGE, Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW};
	
	//TODO: Figure out a way to store the position of a Rubik's cube
	
	public Cube(String setup) {
		switch(setup) {
			case "solved":
				generateSolved();
				break;
			case "random":
				
				break;
			default:
				Main.unrecognized();
		}
		
	}
	
	private void generateSolved() {
		for(int i = 0; i < 6; i++) {
			for(int a = 0; a < 3; a++) {
				for(int b = 0; b < 3; b++) {
					state[i][a][b] = colors[i];
				}
			}
		}
		
	}
	
	public void R(boolean prime) {
		Color[][][] temp = new Color[6][3][3];
	}
	
	public void U(boolean prime) {
		
	}
	
	public void F(boolean prime) {
		
	}
	
	public void L(boolean prime) {
		
	}
	
	public void D(boolean prime) {
		
	}
	
	public void B(boolean prime) {
		
	}
}
