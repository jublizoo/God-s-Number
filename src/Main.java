import javax.swing.JFrame;

public class Main {
	
	Scan s;
	JFrame f;
	Display d;
	Cube c;
	
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
	
	public static void main(String args[]) {
		new Main();
		
	}
	
	private void run() {
		String input;
		
		while(true) {
			input = s.getInput();
			
			switch(input) {
				case "terminate":
					System.exit(0);
					break;
				case "display":
					f.setVisible(true);
					break;
				case "cube":
					cubeSetup();
					break;
				default:
					unrecognized();
			}
		}
		
	}
	
	private void cubeSetup() {
		String input1;
		System.out.println("Would you like a solved or random cube?");
		input1 = s.getInput();
		c = new Cube(input1);
		System.out.println(c.state);
		
		for(int i = 0; i < 6; i++) {
			for(int a = 0; a < 3; a++) {
				for(int b = 0; b < 3; b++) {
					System.out.println(c.state[i][a][b]);
				}
			}
		}
	}
	
	public static void unrecognized() {
		System.out.println("Command not recognized.");
	}
}
