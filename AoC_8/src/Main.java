import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<Integer> visitedValues = new ArrayList<Integer>();
		Integer accumulator = 0;
		
		try {
			FileInputStream fis=new FileInputStream("resources/input.txt");       
			Scanner sc=new Scanner(fis); 
			while(sc.hasNextLine()) {  
				input.add(sc.nextLine());
			}  
			sc.close();
		} 
		catch(IOException e) {  
			e.printStackTrace();  
		} 
		
		breakloop:
		for(int i = 0;;) {
			String[] instruction = input.get(i).split(" ");
			
			if(visitedValues.contains(i)){
				break breakloop;
			}
			
			switch(instruction[0]) {
			  case "acc":
				  Integer value = Integer.parseInt(instruction[1]);
				  accumulator += value;
				  visitedValues.add(i);
				  i++;
			    break;
			  case "jmp":
				  visitedValues.add(i);
				  i = i + Integer.parseInt(instruction[1]);
			    break;
			  default:
				  visitedValues.add(i);
			    i++;
			}
		}
		System.out.println(accumulator);
	}
}
