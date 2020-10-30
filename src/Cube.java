import java.awt.Color;

public class Cube {

	// The state variable stores the position/scramble of the cube (An array of six
	// faces, and 3x3 on each face, althought this might be changed), and the colors
	// array stores the colors of the faces in order from face 0-5
	Color[][][] state = new Color[6][3][3];
	Color[] colors = { Color.WHITE, Color.ORANGE, Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW };

	// TODO: Figure out a way to store the position of a Rubik's cube

	/*
	 * Class contructor which will create a new scramble based on the string
	 * parameter. It can create a solved, or random cube, but if the string
	 * parameter is neither "solved" nor "random," then it calls the Main class'
	 * function unrecognized.
	 */
	public Cube(String setup) {
		switch (setup) {
		case "solved":
			generateRandom();
			break;
		case "random":

			break;
		default:
			Main.unrecognized();
		}

	}

	// Unfinished method to generate a random scramble
	private void generateRandom() {
		for (int i = 0; i < 6; i++) {
			for (int a = 0; a < 3; a++) {
				for (int b = 0; b < 3; b++) {
					state[i][a][b] = colors[i];
				}
			}
		}

	}

	// Below is a list of unfinished methods for the different turns

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
