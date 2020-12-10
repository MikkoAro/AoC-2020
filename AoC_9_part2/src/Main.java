import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<Long> input = new ArrayList<Long>();
	public static ArrayList<Long> inputPartTwo = new ArrayList<Long>();
	public static Long answer;
	
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
		
		splitArrayListForPartTwo();
		findEncryptionWeakness();
		System.out.println("Answer: " + answer);
	}
	
	public static void findEncryptionWeakness() {
		outerloop:
		for (int i = 0; i<input.size(); i++) {
			Long baseVal = inputPartTwo.get(i);
			breaker:
			for (int y = i+1; y<inputPartTwo.size(); y++) {
				baseVal += inputPartTwo.get(y);
				if(baseVal.equals(inputPartTwo.get(inputPartTwo.size()-1))) {
					answer = inputPartTwo.get(i) + inputPartTwo.get(y);
					break outerloop;
				} 
				if (baseVal > inputPartTwo.get(inputPartTwo.size()-1)) {
					baseVal = 0L;
					break breaker;
				}
			}
		}
	}

	public static void splitArrayListForPartTwo() {
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
						inputPartTwo = new ArrayList<Long>(input.subList(0, i+1));
						break stop;
					}
				}
			}
		}
	}
}
