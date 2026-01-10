package javapractice;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberConversion {
	
	
	
	/**
	 * Three points to keep in mind
	 * 1. char < nextChar then append minus char and add to result
	 * 2. char > nextChar then plus char to result
	 * 3. char is the last bit then add char to result 
	 * @param roman
	 * @return
	 */
	private static int convertRoman(String roman){
		
		Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int result=0;
		
		for(int i=0;i<roman.length();i++) {
			char ch = roman.charAt(i);
			//Very good logic where we need to exclude checking the last char
			if(i+1<roman.length()&& romanMap.get(ch)<romanMap.get(roman.charAt(i+1))) {
				result-=romanMap.get(ch);
			}
			else {
				result+=romanMap.get(ch);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String roman = "IX"; //9
		System.out.println(convertRoman(roman));
		roman = "XI"; //11
		System.out.println(convertRoman(roman));
		roman = "MCMXCIV"; //1994
		System.out.println(convertRoman(roman));
		

	}

}
