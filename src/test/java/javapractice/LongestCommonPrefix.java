package javapractice;

import java.util.Arrays;

public class LongestCommonPrefix {
	
	//Sorting the array then only compare first and last as those will only differ max
	private static String findPrefix(String [] strs) {
		
		if(strs.length < 1) {
			return "";
		}
		else if(strs.length == 1){
			return strs[0];
		}
		else {
			Arrays.sort(strs);
			String first = strs[0];
			String last = strs[strs.length-1];
			
			//int endLoop = Math.min(first.length(), last.length());
			
			int i=0;
			while(i < first.length() && i<last.length() && first.charAt(i)==last.charAt(i)) {
				i++;
			}
			return first.substring(0,i);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strs = {"flower","flow","flight"};
        System.out.println(findPrefix(strs));
        String [] strs2 = {"dog","racecar","car"};
        System.out.println(findPrefix(strs2));
	}

}
