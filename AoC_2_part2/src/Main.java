import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static int validPasswordCount;

	public static void main(String[] args) {
		
		ArrayList<String> input = new ArrayList<String>();
		
		try {
			FileInputStream fis=new FileInputStream("resources/input.txt");       
			Scanner sc=new Scanner(fis); 
			while(sc.hasNextLine()) {  
				input.add((sc.nextLine()));
			}  
			sc.close();
		} 
		catch(IOException e) {  
			e.printStackTrace();  
		} 

		for (String row : input) {
			String pattern = "(\\d+)-(\\d+) (.*): (.*)"; //:D
		      Pattern r = Pattern.compile(pattern);
		      Matcher m = r.matcher(row);

		      if (m.find( )) {
			     int lowPosition = Integer.parseInt(m.group(1));
			     int highPosition = Integer.parseInt(m.group(2));
			     String searchChar = m.group(3);
			     String password = m.group(4);
			     
			     checkChar(lowPosition-1, highPosition-1, searchChar, password);
			     
		      } else {
		         System.out.println("No match");
		      }
		}
		System.out.println(validPasswordCount);
	}
	
	public static void checkChar(int lowPosition, int highPosition, String searchChar, String password) {
		String low = Character.toString(password.charAt(lowPosition));
		String high = Character.toString(password.charAt(highPosition));

		if ((low.equals(searchChar)) ^ (high.equals(searchChar))) {
			validPasswordCount++;
		}
	}
}
