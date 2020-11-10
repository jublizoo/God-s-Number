import java.awt.Color;
import java.util.Arrays;

public class Cube {

	// The state variable stores the position/scramble of the cube (An array of six
	// Cube positioned with the integer value corresponding to the face on the
	// diagram we used, where the top face is yellow, and the front face is green
	int minMoves;
	int[][] state = new int[6][8];
	int[][] corrected = new int[6][8];
	Color[] colors = { Color.YELLOW, Color.RED, Color.GREEN, Color.ORANGE, Color.BLUE, Color.WHITE };
	
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
		for (int i = 0; i < 6; i++) {
			for (int b = 0; b < 8; b++) {
				state[i][b] = i;
			}
		}
	}

	private void generateRandom() {

	}

	public void alg() {
		executeAlg("rur'u'r'frru'r'u'rur'f'");
	}

	public void R() {
		// If you do not use the clone loops, it will permanently link one array to the
		// other
		int[][] temp = new int[6][8];

		for (int i = 0; i < 6; i++) {
			for (int b = 0; b < 8; b++) {
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

		for (int i = 0; i < 6; i++) {
			for (int b = 0; b < 8; b++) {
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

		for (int i = 0; i < 6; i++) {
			for (int b = 0; b < 8; b++) {
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

		for (int i = 0; i < 6; i++) {
			for (int b = 0; b < 8; b++) {
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
		int[][] temp = new int[6][8];

		for (int i = 0; i < 6; i++) {
			for (int b = 0; b < 8; b++) {
				temp[i][b] = state[i][b];
			}
		}

		state[1][3] = temp[4][1];
		state[1][6] = temp[4][4];
		state[1][2] = temp[4][0];
		state[2][3] = temp[1][3];
		state[2][6] = temp[1][6];
		state[2][2] = temp[1][2];
		state[3][3] = temp[2][3];
		state[3][6] = temp[2][6];
		state[3][2] = temp[2][2];
		state[4][1] = temp[3][3];
		state[4][4] = temp[3][6];
		state[4][0] = temp[3][2];

		state[5][0] = temp[5][3];
		state[5][1] = temp[5][0];
		state[5][2] = temp[5][1];
		state[5][3] = temp[5][2];
		state[5][4] = temp[5][7];
		state[5][5] = temp[5][4];
		state[5][6] = temp[5][5];
		state[5][7] = temp[5][6];

	}

	public void B() {
		int[][] temp = new int[6][8];

		for (int i = 0; i < 6; i++) {
			for (int b = 0; b < 8; b++) {
				temp[i][b] = state[i][b];
			}
		}

		state[0][0] = temp[3][1];
		state[0][4] = temp[3][5];
		state[0][1] = temp[3][2];
		state[3][1] = temp[5][2];
		state[3][5] = temp[5][6];
		state[3][2] = temp[5][3];
		state[5][2] = temp[1][3];
		state[5][6] = temp[1][7];
		state[5][3] = temp[1][0];
		state[1][3] = temp[0][0];
		state[1][7] = temp[0][4];
		state[1][0] = temp[0][1];

		state[4][0] = temp[4][3];
		state[4][1] = temp[4][0];
		state[4][2] = temp[4][1];
		state[4][3] = temp[4][2];
		state[4][4] = temp[4][7];
		state[4][5] = temp[4][4];
		state[4][6] = temp[4][5];
		state[4][7] = temp[4][6];
	}

	public void cross(boolean incremental) {
		int moves = 0;
		int[][] one = new int[6][8];
		int[][] two = new int[6][8];
		int[][] three = new int[6][8];
		
		for (int i = 0; i < 6; i++) {
			for (int b = 0; b < 8; b++) {
				one[i][b] = state[i][b];
				two[i][b] = state[i][b];
				three[i][b] = state[i][b];
			}
		}
		
		if(incremental == true) {
			
		}else {
			for (int i = 0; i < 4; i++) {
				//Set state to number one
				//Find first piece
				//Move up first piece
				//Set number one to state
				for (int b = 0; b < 3; b++) {
					//Set state to number two
					// Find second piece (2)
					// Move up second piece
					//Set number two to state
					for (int c = 0; c < 2; c++) {
						//Set state to number three
						// Find 3rd piece (3)
						// Move up third piece
						// Find 4th piece
						//Move up 4th piece
						//Move down each piece
						//Set number three to state
						secondLayer(/* current state */);
						// After this is complete, the move count will have already been recorded, so we
						// will not need more variables to store the states
					}
				}
			}
		}

	}
	
	public String algTransfer(String alg, int face) {
		return "";
		
	}
	
	public String crossAlg(int face, int piece) {
		
		String sideTop = "ffdrf'r'";
		String sideBottom = "drf'r'";
		String sideLeft = "ul'u'";
		String sideRight;
		
		return "";
		
		//if face is 0, do nothing
		//if face is 1-4, move piece to 
		
	}
	
	public void executeAlg(String alg) {
		boolean prime;
		
		for(int i = 0; i < alg.length(); i++) {
			prime = false;
			
			try {
				if(Character.toString(alg.charAt(i+1)).equals("'")) {
					prime = true;
				}
			} catch(Exception e) {}
			
			switch(Character.toString(alg.charAt(i))) {
			case "r":
				if(prime) {
					R();
					R();
					R();
				}else {
					R();
				}
				break;
			case "u":
				if(prime) {
					U();
					U();
					U();
				}else {
					U();
				}
				break;
			case "f":
				if(prime) {
					F();
					F();
					F();
				}else {
					F();
				}
				break;
			case "l":
				if(prime) {
					L();
					L();
					L();
				}else {
					L();
				}
				break;
			case "d":
				if(prime) {
					D();
					D();
					D();
				}else {
					D();
				}
				break;
			case "b":
				if(prime) {
					B();
					B();
					B();
				}else {
					B();
				}
				break;
			case "'":
				break;

			}
		}
	}

	public void secondLayer() {

	}

	public void OLL() {

	}

	public void PLL() {

	}

}
