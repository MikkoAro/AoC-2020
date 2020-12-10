import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<Long> input = new ArrayList<Long>();
	public static Long value;
	
	public static void main(String[] args) {
		
		try {
			FileInputStream fis=new FileInputStream("resources/input.txt");       
			Scanner sc=new Scanner(fis); 
			while(sc.hasNextLine()) {  
				input.add(Long.parseLong(sc.nextLine()));
			}  
			sc.close();
		} 
		catch(IOException e) {  
			e.printStackTrace();  
		} 
		
		count();
		System.out.println("Answer: " + value);
	}
	
	public static void count() {
		stop:
		for (int i=25; i<input.size(); i++) {
			breaker:
			for (int y = i-25; y<i-1; y++){
				long firstVal = input.get(y);
				for (int z = y; z<i; z++) {
					long secVal = input.get(z);
					if(firstVal + secVal == input.get(i) & y != z) {
						break breaker;
					}
					if ((y==i-2) & (z==i-1) & !(firstVal + secVal == input.get(i))){
						value = input.get(i);
						break stop;
					}
				}
			}
		}
	}
}
