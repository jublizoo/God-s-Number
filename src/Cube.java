import java.awt.Color;
import java.util.Arrays;

public class Cube {

	// The state variable stores the position/scramble of the cube (An array of six
	// Cube positioned with the integer value corresponding to the face on the
	// diagram we used, where the top face is yellow, and the front face is green
	int[][] state = new int[6][8];
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

	public void R() {
		//If you do not use the clone loops, it will permanently link one array to the other
		int[][] temp = new int[6][8];
		
		for(int i = 0; i < 6; i++) {
			for(int b = 0; b < 8; b++) {
				temp[i][b] = state[i][b];
			}
		}

		state[4][1] = temp[0][1];		
		state[4][5] = temp[0][5];
		state[4][2] = temp[0][2];	
		state[0][1] = temp[2][1];
		state[0][5] = temp[2][5];
		state[0][2] = temp[2][2];
		state[2][1] = temp[5][1];
		state[2][5] = temp[5][5];
		state[2][2] = temp[5][2];
		state[5][1] = temp[4][1];
		state[5][5] = temp[4][5];
		state[5][2] = temp[4][2];
	
		state[3][0] = temp[3][3];
		state[3][1] = temp[3][0];
		state[3][2] = temp[3][1];
		state[3][3] = temp[3][2];
		state[3][4] = temp[3][7];
		state[3][5] = temp[3][4];
		state[3][6] = temp[3][5];
		state[3][7] = temp[3][6];
	}

	public void U() {
		int[][] temp = new int[6][8];
		
		for(int i = 0; i < 6; i++) {
			for(int b = 0; b < 8; b++) {
				temp[i][b] = state[i][b];
			}
		}
		
		state[1][0] = temp[2][0];
		state[1][4] = temp[2][4];
		state[1][1] = temp[2][1];
		state[2][0] = temp[3][0];
		state[2][4] = temp[3][4];
		state[2][1] = temp[3][1];
		state[3][0] = temp[4][2];
		state[3][4] = temp[4][6];
		state[3][1] = temp[4][3];
		state[4][2] = temp[1][0];
		state[4][6] = temp[1][4];
		state[4][3] = temp[1][1];
		
		state[0][0] = temp[0][3];
		state[0][1] = temp[0][0];
		state[0][2] = temp[0][1];
		state[0][3] = temp[0][2];
		state[0][4] = temp[0][7];
		state[0][5] = temp[0][4];
		state[0][6] = temp[0][5];
		state[0][7] = temp[0][6];	
		
	}

	public void F() {
		int[][] temp = new int[6][8];
		
		for(int i = 0; i < 6; i++) {
			for(int b = 0; b < 8; b++) {
				temp[i][b] = state[i][b];
			}
		}
		state[0][3] = temp[1][2];
		state[0][6] = temp[1][5];
		state[0][2] = temp[1][1];
		state[1][2] = temp[5][1];
		state[1][5] = temp[5][4];
		state[1][1] = temp[5][0];
		state[5][1] = temp[3][0];
		state[5][4] = temp[3][7];
		state[5][0] = temp[3][3];
		state[3][0] = temp[0][3];
		state[3][7] = temp[0][6];
		state[3][3] = temp[0][2];
				
		state[2][0] = temp[2][3];
		state[2][1] = temp[2][0];
		state[2][2] = temp[2][1];
		state[2][3] = temp[2][2];
		state[2][4] = temp[2][7];
		state[2][5] = temp[2][4];
		state[2][6] = temp[2][5];
		state[2][7] = temp[2][6];

	}

	public void L() {
		int[][] temp = new int[6][8];
		
		for(int i = 0; i < 6; i++) {
			for(int b = 0; b < 8; b++) {
				temp[i][b] = state[i][b];
			}
		}
		state[4][0] = temp[5][0];
		state[4][7] = temp[5][7];
		state[4][3] = temp[5][3];
		state[0][0] = temp[4][0];
		state[0][7] = temp[4][7];
		state[0][3] = temp[4][3];
		state[2][0] = temp[0][0];
		state[2][7] = temp[0][7];
		state[2][3] = temp[0][3];
		state[5][0] = temp[2][0];
		state[5][7] = temp[2][7];
		state[5][3] = temp[2][3];

		state[1][0] = temp[1][3];
		state[1][1] = temp[1][0];
		state[1][2] = temp[1][1];
		state[1][3] = temp[1][2];
		state[1][4] = temp[1][7];
		state[1][5] = temp[1][4];
		state[1][6] = temp[1][5];
		state[1][7] = temp[1][6];
	}

	public void D() {

	}

	public void B() {

	}
}
