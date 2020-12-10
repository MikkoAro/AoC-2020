import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	static long singleJolt = 1L;

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
		System.out.println(input);
		
		//charging outlet
		if(input.contains(1)) {
			singleJolt = singleJolt * 2;
		}
		if(input.contains(3)) {
			singleJolt = singleJolt * 2;
		}
		
		for (int i = 0; i < input.size(); i++) {
			if(i == input.size()-1) {break;}
			for (int y = i+1; y<i+4; y++) {
				if(y == input.size()-1) {break;}
				if(input.get(y) - input.get(i) == 1){
					singleJolt = singleJolt*2;
				}
				if(input.get(y) - input.get(i) == 3){
					singleJolt = singleJolt*2;
				}
				//System.out.println("Value i: " + input.get(i) + " index: " +  i + " value y: " + input.get(y) + " index: " + y);
			}
		}
		singleJolt = singleJolt*2; //device's built-in adapter
		
		System.out.println("Answer: " + singleJolt);
		//too low 3264
	}
}
