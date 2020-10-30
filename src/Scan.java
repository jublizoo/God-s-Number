import java.util.Scanner;

public class Scan {
	
	Scanner s;
	
	//This creates a scanner object, which allows you to get user input from the response
	public void initiate() {
		s = new Scanner(System.in);
		
	}
	
	//This method returns the next string that the user types in the console
	public String getInput() {
		String input = s.nextLine();
		return(input);
		
	}
}
