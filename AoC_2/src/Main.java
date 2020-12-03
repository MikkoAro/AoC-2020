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
		      String pattern = "(\\d+)-(\\d+) (.*): (.*)";
		      Pattern r = Pattern.compile(pattern);
		      Matcher m = r.matcher(row);

		      if (m.find( )) {
			     int lowValue = Integer.parseInt(m.group(1));
			     int highValue = Integer.parseInt(m.group(2));
			     String searchChar = m.group(3);
			     String password = m.group(4);
			     
			     int count = password.length() - password.replaceAll(searchChar,"").length();
			     
			     if (lowValue <= count && count <= highValue) {
			    	 validPasswordCount++;
			     }
			     
		      } else {
		         System.out.println("NO MATCH");
		      }
		}
		System.out.println(validPasswordCount);
	}
}
