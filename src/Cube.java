import java.awt.Color;
import java.util.ArrayList;

public class Cube {

	// The state variable stores the position/scramble of the cube (An array of six
	// Cube positioned with the integer value corresponding to the face on the
	// diagram we used, where the top face is yellow, and the front face is green
	static String minMoves = "                                                                                                      ";
	static String minScramble = "";
	String scramble = "";
	static ArrayList<String> allAlgs = new ArrayList<String>();
	static ArrayList<String> allScrambles = new ArrayList<String>();
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
			generateRandom();
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
		StringBuilder alg = new StringBuilder("");
		String possibleMove = "";
		String possibleMoveChar = "";
		//Give if the previous move was prime, and if the previous move is the same
		boolean sameMove = true;
		
		generateSolved();
		
		
		for(int i = 0; i < 35; i+=possibleMove.length()) {
			sameMove = true;
			
			while(sameMove) {
				possibleMove = chooseRandomMove();
				possibleMoveChar = Character.toString(possibleMove.charAt(0));
				
				try {
					if(Character.toString(alg.charAt(i-1)).equals("'")) {						
						if(Character.toString(alg.charAt(i-2)).equals(possibleMoveChar)) {
							sameMove = true;
						}else {
							sameMove = false;
						}
					}else {						
						if(Character.toString(alg.charAt(i-1)).equals(possibleMoveChar)) {
							sameMove = true;
						}else {
							sameMove = false;
						}
					}
				}catch(Exception e) {
					sameMove = false;
				}
			}
			
			alg.append(possibleMove);
		}
		
		scramble = alg.toString();
		System.out.println(alg.toString());
		executeAlg(alg.toString());
		
	}
	
	private String chooseRandomMove(){
		double random = Math.random();
		
		if(random < 0.1666) {
			random = Math.random();
			if(random < 0.3333) {
				return "r";
			}else if(random < 0.6666) {
				return "r'";
			}else {
				return "rr";
			}
		}else if(random < 0.3333) {
			random = Math.random();
			if(random < 0.3333) {
				return "u";
			}else if(random < 0.6666) {
				return "u'";
			}else {
				return "uu";
			}
		}else if(random < 0.5) {
			random = Math.random();
			if(random < 0.3333) {
				return "f";
			}else if(random < 0.6666) {
				return "f'";
			}else {
				return "ff";
			}
		}else if(random < 0.6666) {
			random = Math.random();
			if(random < 0.3333) {
				return "l";
			}else if(random < 0.6666) {
				return "l'";
			}else {
				return "ll";
			}
		}else if(random < 0.8333) {
			random = Math.random();
			if(random < 0.3333) {
				return "d";
			}else if(random < 0.6666) {
				return "d'";
			}else {
				return "dd";
			}
		}else if(random < 1) {
			random = Math.random();
			if(random < 0.3333) {
				return "b";
			}else if(random < 0.6666) {
				return "b'";
			}else {
				return "bb";
			}
		}else {
			return null;
		}
	
	}

	public void alg(String alg) {
		executeAlg(alg);
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

	public void cross() {
		StringBuilder alg;
		StringBuilder alg2;
		StringBuilder alg3;
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
			
		for (int i = 0; i < 4; i++) {
			
			
			//Set state to one
			for (int c = 0; c < 6; c++) {
				for (int d = 0; d < 8; d++) {
					state[c][d] = one[c][d];
				}
			}
			alg = new StringBuilder("");
			
			alg.append(crossAlg(findPiece(i)[0], findPiece(i)[1]));
			executeAlg(crossAlg(findPiece(i)[0], findPiece(i)[1]));
			
			//Set two to state
			for (int c = 0; c < 6; c++) {
				for (int d = 0; d < 8; d++) {
					two[c][d] = state[c][d];
				}
			}
			
			for (int b = 0; b < 3; b++) {
				
				//Set state to two
				for (int c = 0; c < 6; c++) {
					for (int d = 0; d < 8; d++) {
						state[c][d] = two[c][d];
					}
				}
				alg2 = new StringBuilder(alg.toString());
				
				alg2.append(crossAlg(findPiece(b)[0], findPiece(b)[1]));
				executeAlg(crossAlg(findPiece(b)[0], findPiece(b)[1]));
				
				//Set three to state
				for (int c = 0; c < 6; c++) {
					for (int d = 0; d < 8; d++) {
						three[c][d] = state[c][d];
					}
				}
				
				for (int c = 0; c < 2; c++) {
					//Set state to three
					for (int d = 0; d < 6; d++) {
						for (int e = 0; e < 8; e++) {
							state[d][e] = three[d][e];
						}
					}
					alg3 = new StringBuilder(alg2.toString());;
					
					alg3.append(crossAlg(findPiece(c)[0], findPiece(c)[1]));
					executeAlg(crossAlg(findPiece(c)[0], findPiece(c)[1]));
					alg3.append(crossAlg(findPiece(0)[0], findPiece(0)[1]));
					executeAlg(crossAlg(findPiece(0)[0], findPiece(0)[1]));
					
					alg3.append(pullDaisy());
					// After this is complete, the move count will have already been recorded, so we
					// will not need more variables to store the states	
					
					alg3 = new StringBuilder(condenseAlg(condenseAlg(alg3.toString())));
					allAlgs.add(alg3.toString());
					allScrambles.add(scramble);
					System.out.println("alg: " + alg3);

					if(alg3.length() < minMoves.length()) {
						minMoves = alg3.toString();
						minScramble = scramble;
					}
				}
			}	
		}

	}
	
	public int[] findPiece(int iterationGoal) {
		int[] piece = new int[2];
		boolean contLoop = true;
		int iteration = 0;
		
		for(int i = 1; i < 6; i++) {
			for(int b = 4; b < 8; b++) {
				if(contLoop) {
					if(state[i][b] == 5) {
						piece[0] = i;
						piece[1] = b;
						if(iteration == iterationGoal) {
							contLoop = false;
						}		
						iteration++;
					}
				}
			}
		}

		return piece;
	}
	
	public String crossAlg(int face, int piece) {
		StringBuilder alg = new StringBuilder("");
		StringBuilder adAlg = new StringBuilder("");
		int adBottom = 0;
		int transferNum = 0;
		
		//change back face
		if(face == 4) {
			switch(piece) {
			case 4:
				piece = 6;
				break;
			case 5:
				piece = 7;
				break;
			case 6:
				piece = 4;
				break;
			case 7:
				piece = 5;
				break;
			}
		}
		
		
		
		if(0 < face && face < 5) {
			
			
			switch(face) {
			case 1:
				transferNum = 3;
				break;
			case 2:
				transferNum = 0;
				break;
			case 3:
				transferNum = 1;
				break;
			case 4:
				transferNum = 2;
				break;
			}
			
			switch(piece) {
			case 4:
				alg.append(algTransfer("f", transferNum));
				for(int i = 0; i < getAdjustedTurns(face) - 1; i++){
					alg.append("u");
				}
				alg.append(algTransfer("r", transferNum));
				break;
			case 5:
				for(int i = 0; i < getAdjustedTurns(face) - 1; i++){
					alg.append("u");
				}
				alg.append(algTransfer("r", transferNum));
				break;
			case 6:
				for(int i = 0; i < getAdjustedTurns(face) - 1; i++){
					alg.append("u");
				}
				alg.append(algTransfer("f'rf", transferNum));
				break;
			case 7:
				for(int i = 0; i < getAdjustedTurns(face) + 1; i++){
					alg.append("u");
				}
				alg.append(algTransfer("l'", transferNum)); 
				break;
			}
			
		}else if(face == 5) {
			switch(piece) {
			case 6:
				adBottom = 4;
				break;
			case 5:
				adBottom = 3;
				break;
			case 4:
				adBottom = 2;
				break;
			case 7:
				adBottom = 1;
				break;
			}

			for(int i = 0; i < getAdjustedTurns(adBottom); i++){
				alg.append("u");
			}
			transferNum = piece - 4;
			alg.append(algTransfer("ff", transferNum));
		}
		
		return alg.toString();
		
	}
	
	public String pullDaisy(){
		
		StringBuilder alg = new StringBuilder("");
		int transferNum = 0;
		boolean anyLeft;
		
		for(int i = 0; i < 4; i++) {
			for(int b = 1; b < 5; b++) {
				switch(b) {
				case 1:
					transferNum = 3;
					break;
				case 2:
					transferNum = 0;
					break;
				case 3:
					transferNum = 1;
					break;
				case 4:
					transferNum = 2;
					break;
				}
				
				if(b == 4) {
					if(state[b][6] == b && state[0][8 - b] == 5) {
						alg.append(algTransfer("ff", transferNum));
						executeAlg(algTransfer("ff", transferNum));
					}
				}else {
					if(state[b][4] == b && state[0][8 - b] == 5) {
						alg.append(algTransfer("ff", transferNum));	
						executeAlg(algTransfer("ff", transferNum));
					}
				}	
			}
			
			anyLeft = false;
			
			for(int b = 4; b < 8; b++) {
				if(state[0][b] == 5) {
					anyLeft = true;
					break;
				}
			}
			
			if(anyLeft) {
				alg.append("u");	
				executeAlg("u");
			}else {
				break;
			}
		}
		
		return(alg.toString());
				
	}
	
	private int getAdjustedTurns(int face){
		boolean contLoop = true;
		int counter = 0;
		
		for(int i = 4; i < 8; i++) {
			if(contLoop == true) {
				if(state[0][i] != 5) {
					//8 - i is turns for i to get to piece 4
					//4 - face is turns for piece 4 to get to the face
					//-1 is because you want the open space on the right, not in front
					for(int b = 0; b < 8 - i + 4 - face; b++) {
						counter++;
					}
					
					contLoop = false;
				}	
			}
		}
		
		return counter;
	}

	public String algTransfer(String alg, int num) {
		StringBuilder newAlg = new StringBuilder("");
		
		switch(num) {
		case 1:
			for(int i = 0; i < alg.length(); i++) {
				switch(Character.toString(alg.charAt(i))){
					case "r":
						newAlg.append("b");
						break;
					case "f":
						newAlg.append("r");
						break;
					case "l":
						newAlg.append("f");
						break;
					case "b":
						newAlg.append("l");
						break;
					default:
						newAlg.append(Character.toString(alg.charAt(i)));
				}
			}
			break;
		case 2:
			for(int i = 0; i < alg.length(); i++) {
				switch(Character.toString(alg.charAt(i))){
					case "r":
						newAlg.append("l");
						break;
					case "f":
						newAlg.append("b");
						break;
					case "l":
						newAlg.append("r");
						break;
					case "b":
						newAlg.append("f");
						break;
					default:
						newAlg.append(Character.toString(alg.charAt(i)));
				}
			}
			break;
		case 3:
			for(int i = 0; i < alg.length(); i++) {
				switch(Character.toString(alg.charAt(i))){
					case "r":
						newAlg.append("f");
						break;
					case "f":
						newAlg.append("l");
						break;
					case "l":
						newAlg.append("b");
						break;
					case "b":
						newAlg.append("r");
						break;
					default:
						newAlg.append(Character.toString(alg.charAt(i)));
				}
			}
			//replace("r","f").replace("f", "l").replace("l", "b").replace("b", "r");
			break;
		default:
			newAlg.append(alg);
		}
		
		return(newAlg.toString());
		
	}
	
	public static String reverseAlg(String alg){
		StringBuilder rAlg = new StringBuilder("");
		String c;
		boolean prime;
		
		for(int i = alg.length() - 1; i >= 0; i--) {
			c = Character.toString(alg.charAt(i));
			prime = false;
			
			try {
				if(Character.toString(alg.charAt(i+1)).equals("'")) {
					prime = true;
				}
			}catch(Exception e) {}
			
			if(prime) {
				switch(c) {
				case "r":
					rAlg.append("r");
					break;
				case "u":
					rAlg.append("u");
					break;
				case "f":
					rAlg.append("f");
					break;
				case "l":
					rAlg.append("l");
					break;
				case "d":
					rAlg.append("d");
					break;
				case "b":
					rAlg.append("b");
					break;
				}
			}else {
				switch(c) {
				case "r":
					rAlg.append("r'");
					break;
				case "u":
					rAlg.append("u'");
					break;
				case "f":
					rAlg.append("f'");
					break;
				case "l":
					rAlg.append("l'");
					break;
				case "d":
					rAlg.append("d'");
					break;
				case "b":
					rAlg.append("b'");
					break;
				}
			}
				
		}
		
		return rAlg.toString();
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

	public static String condenseAlg(String alg) {
		StringBuilder sAlg = new StringBuilder("");
		String c = "";
		boolean three;
		boolean four;
		
		for(int i = 0; i < alg.length(); i++) {
			three = true;
			four = true;
			c = "";
			try {c = Character.toString(alg.charAt(i+1));} catch(Exception e) {}
			if(c.equals("'")) {
				for(int b = 1; b < 4; b++) {
					try {
						c = Character.toString(alg.charAt(i + 2 * b + 1));
						if(!c.equals("'")) {
							if(b < 3) {
								three = false;
								four = false;
							} else {
								four = false;
							}
							
							break;
						}
					} catch(Exception e) {
						if(b < 3) {
							three = false;
							four = false;
						} else {
							four = false;
						}
						
						break;
					}
				}
				for(int b = 1; b < 4; b++) {
					try {
						c = Character.toString(alg.charAt(i + 2 * b));
						if(!c.equals(Character.toString(alg.charAt(i)))) {
							if(b < 3) {
								three = false;
								four = false;
							} else {
								four = false;
							}
							
							break;
						}
					} catch(Exception e) {
						if(b < 3) {
							three = false;
							four = false;
						} else {
							four = false;
						}
						
						break;
					}
					
				}	
				try {c = Character.toString(alg.charAt(i));} catch(Exception e) {}
				if(three) {
					if(four) {
						//Append Nothing
						i += 8 - 1;
					}else {
						sAlg.append(c);
						i += 6 - 1;
					}
				}else {
					sAlg.append(c + "'");
					i++;
				}
				
			}else {
				for(int b = 1; b < 4; b++) {
					try {
						c = Character.toString(alg.charAt(i +  b));
						if(!c.equals(Character.toString(alg.charAt(i)))) {
							if(b < 3) {
								three = false;
								four = false;
							} else {
								four = false;
							}
							
							break;
						}
					} catch(Exception e) {
						if(b < 3) {
							three = false;
							four = false;
						} else {
							four = false;
						}
						
						break;
					}
					
				}	
				
				try {c = Character.toString(alg.charAt(i));} catch(Exception e) {}
				if(three) {
					if(four) {
						//Append Nothing
						i += 4 - 1;
					}else {
						sAlg.append(c + "'");
						i += 3 - 1;
					}
				}else {
					sAlg.append(c);
				}
			}
		}
		return(sAlg.toString());
		
	}
	
	public void secondLayer() {
		
	}

	public void OLL() {

	}

	public void PLL() {

	}

}
