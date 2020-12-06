import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static int count;

	public static void main(String[] args) {
		
		try {
			FileInputStream fis=new FileInputStream("resources/input.txt");       
			Scanner sc=new Scanner(fis);
			String line = "";
			Map<String, String> stringArray = new HashMap<String, String>();
		    while (sc.hasNext()) {
		        if (!(line = sc.nextLine()).isEmpty()) {
		        	String [] strArray = line.split(":| ");
		        	
		        	int y = 1;
		        	for (int i = 0; i < strArray.length; i+=2) {
		        		stringArray.put(strArray[i], strArray[y]);
		        		y = y+2;
		        	}

		        	if(sc.hasNextLine() == false) {
		        		checkIfValid(stringArray);
		        	}
		        } else {
		        	checkIfValid(stringArray);
		        	stringArray = new HashMap<String, String>();
		        }
		    }
		    sc.close();
		} 
		catch(IOException e) {  
			e.printStackTrace();  
		} 	
		System.out.println("Answer " + Main.count);
	}
	
	public static void checkIfValid(Map<String, String> map) {
		int valid = 0;
		
		if (map.containsKey("byr")) {valid = valid + 1;}
		if (map.containsKey("iyr")) {valid = valid + 1;}
		if (map.containsKey("hgt")) {valid = valid + 1;}
		if (map.containsKey("pid")) {valid = valid + 1;}
		if (map.containsKey("hcl")) {valid = valid + 1;}
		if (map.containsKey("eyr")) {valid = valid + 1;}
		if (map.containsKey("ecl")) {valid = valid + 1;}
		if(valid ==7) {count++;}
	}
}
