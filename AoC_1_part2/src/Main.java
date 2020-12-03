import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> input = new ArrayList<Integer>();
		
		try {
			FileInputStream fis=new FileInputStream("resources/input.txt");       
			Scanner sc=new Scanner(fis); 
			while(sc.hasNextLine()) {  
				input.add(Integer.parseInt(sc.nextLine()));
			}  
			sc.close();
		} 
		catch(IOException e) {  
			e.printStackTrace();  
		} 
		
		outerloop:
		for (int value : input) {
			for (int secValue : input) {
				for (int thirdValue : input) {
					if ((value + secValue + thirdValue == 2020)) {
						System.out.println("Answer: " + value * secValue * thirdValue);
						break outerloop;
					}
				}
			}
		}
	}
}
