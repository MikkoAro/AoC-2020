import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	private static Integer accumulator; 

	public static void main(String[] args) {
	
		ArrayList<String> input = new ArrayList<String>();
		
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
		for(int i = 0; i < input.size(); i++) {
			
			String[] instruction = input.get(i).split(" ");
			
			if(instruction[0].equals("jmp")) {
				ArrayList<String> modifiedInput = new ArrayList<>(input);
				modifiedInput.set(i, "nop " + instruction[1]);
				Boolean result = loopIt(modifiedInput);
				if(result) {break breakloop;}
			}
			
			if(instruction[0].equals("nop")) {
				ArrayList<String> modifiedInput = new ArrayList<>(input);
				modifiedInput.set(i, "jmp " + instruction[1]);
				Boolean result = loopIt(modifiedInput);
				if(result) {break breakloop;}
			}
		}
		System.out.println("Answer: " + accumulator);
	}

	
	public static boolean loopIt(ArrayList<String> modifiedInput) {
		ArrayList<Integer> visitedValues = new ArrayList<Integer>();
		accumulator = 0;
			breakloop:
			for(int i = 0;;) {
				String[] instruction = modifiedInput.get(i).split(" ");

				if(i == modifiedInput.size() -1 ){
					return true;
				}
				
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
		return false;
	}
}
