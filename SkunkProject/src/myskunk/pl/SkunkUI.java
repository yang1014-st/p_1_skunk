package myskunk.pl;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class SkunkUI {
	
	

	public void println(String string) {
		StdOut.println(string);
		
	}

	public String readLine() {
		return StdIn.readLine();
	}

	public void print_paragraph(String get_turn_result) {
		StdOut.println(get_turn_result);		
	}

}
