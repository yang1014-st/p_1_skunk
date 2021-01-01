package myskunk.pl;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkUI {
	
	

	public void println(String string) {
		StdOut.println(string);
		
	}

	public void print(String string) {
		StdOut.print(string);
		
	}


	public void print_paragraph(String turn_result) {
		String[] lines = turn_result.split("\\r?\\n");
		
		  for (String line : lines) {
	            System.out.println(line);
	            StdOut.println("Please press Enter to continue.");
				StdIn.readLine();
	        }
		

		  
	
	}

	public String promptReadAndReturn(String question) {
		
		StdOut.print(question + " => ");
		String result = StdIn.readLine();
		return result;
	}

	public String readLine() {
		
		return StdIn.readLine();
	}

}
