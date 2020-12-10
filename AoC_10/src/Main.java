import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static int singleJolt;
	static int tripleJolt;

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
		
		Collections.sort(input);
		
		singleJolt = singleJolt+1; //charging outlet
		for (int i = 0; i < input.size(); i++) {
			if(i == input.size()-1) {break;}
			if(input.get(i+1) - input.get(i) == 1){
				singleJolt = singleJolt+1;
			}
			if(input.get(i+1) - input.get(i) == 3){
				tripleJolt = tripleJolt+1;
			}
		}
		tripleJolt = tripleJolt+1; //device's built-in adapter
		
		System.out.println("Answer: " + singleJolt * tripleJolt);
	}
}
