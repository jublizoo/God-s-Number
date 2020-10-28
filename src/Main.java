import javax.swing.JFrame;

public class Main {
	
	Scan s;
	JFrame f;
	Display d;
	
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
				default:
					System.out.println("Command Not Recognized");
			}
		}
		
	}
}
