import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static int count;
	private static ArrayList<String> input = new ArrayList<String>();

	public static void main(String[] args) {
		countTotalRows();
		readInput(1);
		long val1 = countTrees(1,1);
		readInput(3);
		long val2 = countTrees(3,1);
		readInput(5);
		long val3 = countTrees(5,1);
		readInput(1);
		long val4 = countTrees(1,2);
		readInput(7);
		long val5 = countTrees(7,1);
		long ans = (val1*val2*val3*val4*val5);
		System.out.println("Answer: " + ans);
	}
	
	private static long countTrees(int xSlope, int ySlope) {
		long count = 0;
		int x = xSlope;
		for(int i = ySlope; i < input.size(); i+=ySlope) {
			String row = input.get(i);
			String value = Character.toString(row.charAt(x));
			if (value.equals("#")) {
				count++;
			}
			x = x + xSlope;
		}
		return count;
	}
	
	private static void readInput(int length) {
		try {
			input = new ArrayList<String>();
			String row = "";
			int rowCount = Main.count;

			FileInputStream fis=new FileInputStream("resources/input.txt");       
			Scanner sc=new Scanner(fis); 
			while(sc.hasNextLine()) {  
				row  = sc.nextLine();
				while(row.length() < rowCount * length +1) {
					row = row.concat(row);
				}
				Main.input.add(row);
			} 
			sc.close();
		} 
		catch(IOException e) {  
			e.printStackTrace();  
		} 
	}

	private static void countTotalRows() {
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
		Main.count = count;
	}
}
