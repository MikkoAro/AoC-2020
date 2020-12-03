import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static int countTrees;

	public static void main(String[] args) {
		
		ArrayList<String> input = new ArrayList<String>();
		
		try {
			String row = "";
			int rowCount = countTotalRows();

			FileInputStream fis=new FileInputStream("resources/input.txt");       
			Scanner sc=new Scanner(fis); 
			while(sc.hasNextLine()) {  
				row  = sc.nextLine();
				while(row.length() < rowCount * 3 +1) {
					row = row.concat(row);
				}
				input.add(row);
			} 
			sc.close();
		} 
		catch(IOException e) {  
			e.printStackTrace();  
		} 

		int y = 3;
		for(int i = 1; i < input.size(); i++) {
			String row = input.get(i);
			String value = Character.toString(row.charAt(y));
			if (value.equals("#")) {
				Main.countTrees++;
			}
			y = y + 3;
		}
		System.out.println("Answer: " + countTrees);
	}

	private static int countTotalRows() {
		FileInputStream fis;
		int count = 0;
		try {
			fis = new FileInputStream("resources/input.txt");
			Scanner sc=new Scanner(fis); 
			
			while (sc.hasNextLine()) {
			    count++;
			    sc.nextLine();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}       
		return count;
	}
}
