package javapractice;

import java.util.Map;
import java.util.TreeMap;

public class CountChars {
	
	static void printCount(String str){
		String [] strArray = str.replaceAll("\\s+", "").toLowerCase().trim().split("");
		
		Map<String, Integer> map = new TreeMap<>();
		
		for(int i=0;i<strArray.length;i++) {
			String letter = strArray[i];
//			if(!map.containsKey(letter)) {
//				map.put(letter, 1);
//			}
//			else {
//				map.put(letter, map.get(letter)+1);
//			}
			map.put(letter, map.getOrDefault(letter, 0)+1);
		}
		
		System.out.println(map);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str = "Apple is a fruit";
        printCount(str);
	}

}
