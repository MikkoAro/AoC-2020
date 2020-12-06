import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static int count;

	public static void main(String[] args) {
		
		try {
			FileInputStream fis=new FileInputStream("resources/input.txt");       
			Scanner sc=new Scanner(fis);
			String line = "";
			String concatGroup = "";
		    while (sc.hasNext()) {
		        if (!(line = sc.nextLine()).isEmpty()) {
		        	concatGroup = concatGroup.concat(line);

		        	if(sc.hasNextLine() == false) {
		        		countYesAnswers(concatGroup);
		        	}
		        } else {
		        	countYesAnswers(concatGroup);
		        	concatGroup = "";
		        }
		    }
		    sc.close();
		} 
		catch(IOException e) {  
			e.printStackTrace();  
		} 	
		System.out.println("Answer " + Main.count);
	}
	public static void countYesAnswers(String groupInput) {
		System.out.println(groupInput);
		count += groupInput.chars().distinct().count();
	}
}