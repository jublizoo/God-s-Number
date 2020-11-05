import java.awt.Color;
import java.util.Arrays;

public class Cube {

	// The state variable stores the position/scramble of the cube (An array of six
	// Cube positioned with the integer value corresponding to the face on the
	// diagram we used, where the top face is yellow, and the front face is green
	Integer[][] state = new Integer[6][8];
	Color[] colors = {Color.YELLOW, Color.RED, Color.GREEN, Color.ORANGE, Color.BLUE, Color.WHITE};

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
			generateSolved();
			break;
		case "random":
			
			break;
		default:
			Main.unrecognized();
		}

	}

	// Unfinished method to generate a random scramble
	private void generateSolved() {
		for(int i = 0; i < 6; i++) {
			for(int b = 0; b < 8; b++) {
				state[i][b] = i;
			}
		}
	}
	
	private void generateRandom() {
		
	}

	// Below is a list of unfinished methods for the different turns

	public void R(boolean prime) {
		//If you do not use the clone method, it will permanently link one array to the other
		Integer[][] temp = state.clone();
		
		state[4][1] = temp.clone()[0][1];
		state[4][5] = temp.clone()[0][5];
		state[4][2] = temp.clone()[0][2];	
		state[0][1] = temp.clone()[2][1];
		state[0][5] = temp.clone()[2][5];
		state[0][2] = temp.clone()[2][2];
		state[2][1] = temp.clone()[5][1];
		state[2][5] = temp.clone()[5][5];
		state[2][2] = temp.clone()[5][2];
		state[5][1] = temp.clone()[4][1];
		state[5][5] = temp.clone()[4][5];
		state[5][2] = temp.clone()[4][2];
		
		state[3][0] = temp.clone()[3][3];
		state[3][1] = temp.clone()[3][0];
		state[3][2] = temp.clone()[3][1];
		state[3][3] = temp.clone()[3][2];
		state[3][4] = temp.clone()[3][7];
		state[3][5] = temp.clone()[3][4];
		state[3][6] = temp.clone()[3][5];
		state[3][7] = temp.clone()[3][6];
		
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
