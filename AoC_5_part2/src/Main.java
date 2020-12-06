import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<Double> seatIds = new ArrayList<Double>();
		
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
		for(int i = 0; i < input.size(); i++) {
			double maxRow = 127;
			double minRow = 0;
			double columnLeft = 0;
			double columnRight = 7;
			for(int y = 0; y < input.get(y).length(); y++) {
			   char c = input.get(i).charAt(y);
			   switch(c) {
			   case 'B':
				 minRow = Math.round((maxRow + minRow) / 2); 
			     break;
			   case 'F':
				 maxRow = Math.round((maxRow + minRow) / 2);
			     break;
			   case 'R':
				 columnLeft = Math.round((columnRight + columnLeft) / 2);
				 break;
			   case 'L':
				 columnRight = Math.round((columnRight + columnLeft) / 2);
				 break;
			 }
			}
			seatIds.add(minRow * 8 + columnLeft);
		}
		
		//part 2
		Collections.sort(seatIds);
		ArrayList<Double> values = new ArrayList<Double>();
		
		for (int i = 1; i < seatIds.size() -1; i++) {
			if (!(seatIds.get(i-1) + 1 == seatIds.get(i) && seatIds.get(i) == seatIds.get(i+1)-1)) {
				values.add(seatIds.get(i));
			}
		}
		System.out.println("Answer: " + (values.get(0)+1));
	}
}
