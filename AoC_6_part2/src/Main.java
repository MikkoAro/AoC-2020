import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static int count;
	static ArrayList<String> group = new ArrayList<String>();

	public static void main(String[] args) {
		
		try {
			FileInputStream fis=new FileInputStream("resources/input.txt");       
			Scanner sc=new Scanner(fis);
			String line = "";
		    while (sc.hasNext()) {
		        if (!(line = sc.nextLine()).isEmpty()) {
		        	group.add(line);

		        	if(sc.hasNextLine() == false) {
		        		countYesAnswers();
		        	}
		        } else {
		        	countYesAnswers();
		        	Main.group = new ArrayList<String>();

		        }
		    }
		    sc.close();
		} 
		catch(IOException e) {  
			e.printStackTrace();  
		} 	
		System.out.println("Answer " + Main.count);
	}
	public static void countYesAnswers(){
		for (int i = 0; i < group.get(0).length(); i++) {
			int count = 1;
			for (int y = 1; y < group.size(); y++) {
				if (group.get(y).contains(Character.toString(group.get(0).charAt(i)))) {
				count = count + 1;
				}
			}
			if (count == group.size()) {
				Main.count += 1;
			}
		}
	}
}








