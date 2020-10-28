import java.util.Scanner;

public class Scan {
	
	Scanner s;
	
	public void initiate() {
		s = new Scanner(System.in);
		
	}
	
	public String getInput() {
		String input = s.nextLine();
		return(input);
		
	}
}
