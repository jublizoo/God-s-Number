import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	static JFrame f;
	static Cube c;
	static Scan s;
	static Display d;
	
	// Just initializes the scanner, creates a new JFrame (Java Display Window) and
	// lets the display class use that JFrame for graphics, and then starts the run
	// function
	public Main() {
		s = new Scan();
		s.initiate();
		d = new Display();
		f = new JFrame();
		f.setVisible(false);
		f.setSize(500, 500);
		f.add(d);
		run();
		
	}

	// Creates a new main object, which will run the code within the constructor,
	// but will not cast the instance to an object
	public static void main(String args[]) {
		// You cannot define a non-static variable in a static context, so you create a
		// instance (not static) of the class to do so
		Main m = new Main();
	}

	private void run() {
		String input;
		// This just loops infinitely, and will perform different functions based on the
		// user input. The switch framework takes a variable, in this case the user
		// input, and runs the code within the section for whatever "case" the variable
		// is. For example, if the user typed "terminate," it would run the code in the
		// terminate section, just before the break. The default is what it does if none
		// of the cases apply.
		while (true) {
			input = s.getInput();

			switch (input) {
			case "terminate":
				System.exit(0);
				break;
			case "display":
				f.setVisible(true);
				break;
			case "cube":
				cubeSetup();
				break;
			case "r":
				c.R();
				d.repaint();
				break;
			case "rp":
				c.R();
				c.R();
				c.R();
				d.repaint();
				break;
			case "u":
				c.U();
				d.repaint();
				break;
			case "up":
				c.U();
				c.U();
				c.U();
				d.repaint();
				break;
			case "f":
				c.F();
				d.repaint();
				break;
			case "fp":
				c.F();
				c.F();
				c.F();
				d.repaint();
				break;
			default:
				if(checkMoves(input)) {
					moveSequence(input);
					d.repaint();
				} else {
					unrecognized();
				}	
			}
		}

	}

	// Asks the user if they want a solved or random cube, and feeds their response
	// into the constructor for the cube class
	private void cubeSetup() {
		String input1;
		System.out.println("Would you like a solved or random cube?");
		input1 = s.getInput();
		c = new Cube(input1);
		d.repaint();
		System.out.println("Done");
		
	}
	
	private boolean checkMoves(String input) {
		for(int i = 0; i < input.length(); i++) {
			String s = Character.toString(input.charAt(i));
			
			if(! (s.equals("'") || s.equals("r") ||s.equals("u") || s.equals("f") || s.equals("l") || s.equals("d") || s.equals("b"))){
				return false;				
			}
		}
		
		return true;
		
	}
	
	private void moveSequence(String input) {
		boolean prime;
		
		for(int i = 0; i < input.length(); i++) {
			prime = false;
			
			try {
				if(Character.toString(input.charAt(i+1)).equals("'")) {
					prime = true;
				}
			} catch(Exception e) {}
			
			switch(Character.toString(input.charAt(i))) {
			case "r":
				if(prime) {
					c.R();
					c.R();
					c.R();
				}else {
					c.R();
				}
				break;
			case "u":
				if(prime) {
					c.U();
					c.U();
					c.U();
				}else {
					c.U();
				}
				break;
			case "f":
				if(prime) {
					c.F();
					c.F();
					c.F();
				}else {
					c.F();
				}
				break;
			case "l":
				if(prime) {
					c.L();
					c.L();
					c.L();
				}else {
					c.L();
				}
				break;
			case "d":
				if(prime) {
					
				}else {
					
				}
				break;
			case "b":
				if(prime) {
					
				}else {
					
				}
				break;
			case "'":
				break;
			default:
				unrecognized();
			}
		}
	}

	// Tells the user that the command is not recognized.
	public static void unrecognized() {
		System.out.println("Command not recognized.");

	}
	
}
