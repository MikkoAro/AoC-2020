import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	//This is horrible
	public static void checkIfValid(Map<String, String> map) {
		int valid = 0;
		if (map.containsKey("byr")) {
			valid = valid + yearValidation(1920,Integer.parseInt(map.get("byr")),2002);
		}
		if (map.containsKey("iyr")) {
			valid = valid + yearValidation(2010,Integer.parseInt(map.get("iyr")),2020);
		}
		if (map.containsKey("eyr")) {
			valid = valid + yearValidation(2020,Integer.parseInt(map.get("eyr")),2030);
		}
		if (map.containsKey("pid")) {
			String pid = map.get("pid");
			if(pid.length() == 9) {
				valid = valid + 1;
			}
		}
		if (map.containsKey("hcl")) {
			String hcl = map.get("hcl");
			if(hcl.matches("^#[a-f0-9{7}]*$")) {
				valid = valid + 1;
			}
		}
		if (map.containsKey("hgt")) {
			String hgt = map.get("hgt");
			String lastTwo = hgt.substring(Math.max(hgt.length() - 2, 0));
			if(lastTwo.equals("in")) {
				int height = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
				if (59 <= height && height <= 76) {
					valid = valid + 1;
				}
			}
			if(lastTwo.equals("cm")){
				int height = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
				if (150 <= height && height <= 193) {
					valid = valid + 1;
				}
			}	
		}
		if (map.containsKey("ecl")) {
			String ecl = map.get("ecl");
			ArrayList<String> list = new ArrayList<String>(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));
			if(list.contains(ecl)) {
				valid = valid + 1;
			}
		}
		if(valid == 7) {count++;}
	}
	
	public static int yearValidation(int minVal, int val, int maxVal) {
		if (minVal <= val && val <= maxVal) {
			return 1;
		} else {
			return 0;
		}
	}
}
