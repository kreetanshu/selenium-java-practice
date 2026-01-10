package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Panagram {
	
	static Boolean checkPanagram(String s){
		s=s.replaceAll("\\s+", "").toLowerCase().trim();
		List<Character> ls = new ArrayList<>();
		for(char ch='a';ch<='z';ch++) {
			ls.add(ch);
		}
		System.out.println("Before "+ls);
		
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ls.contains(ch)) {
				ls.remove(Character.valueOf(ch));
			}
			if (ls.size()==0) return true;
		}
		System.out.println("After "+ls);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s= "We promptly judged antique ivory buckles for the next prize";
        System.out.println(checkPanagram(s));
	}

}
