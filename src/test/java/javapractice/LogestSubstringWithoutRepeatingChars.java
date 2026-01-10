package javapractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LogestSubstringWithoutRepeatingChars {
	
	static int longestSubStr(String s) {
		Set<Character> out = new HashSet();
		int end=0;
		int start=0;
		for(int i=0;i< s.length();i++) {
			char ch=s.charAt(i);
			while(out.contains(ch)) {
				
				out.remove(Character.valueOf(s.charAt(start)));
				start++;
				System.out.println("Inside loop start "+start+" end "+ end);
				System.out.println("Inside Set "+out.toString());
			}
		
				out.add(ch);
				System.out.println("Outside Set "+out.toString());
				
			end++;
			
		}
		
		return (end-start)+1;
		
	}
	
	//This is better approach
	public static int lengthOfLongestSubstring(String s) {
	    Map<Character, Integer> map = new HashMap<>();
	    int maxLen = 0;
	    int left = 0;

	    for (int right = 0; right < s.length(); right++) {
	        char c = s.charAt(right);
	        if (map.containsKey(c)) {
	        	
	        	//System.out.println("Index "+right+" Map "+map.toString());
	            left = Math.max(left, map.get(c) + 1);
	        }
	        map.put(c, right);
	        System.out.println("Index "+right +" MaxLen "+maxLen+" left "+left+" right "+right);
	        maxLen = Math.max(maxLen, right - left + 1);
	    }

	    return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "abcabcbb"; //abc
        System.out.println(lengthOfLongestSubstring(s));
        //System.out.println(longestSubStr(s));
        
        //String s1= "pwwkew"; //wke
        //System.out.println(longestSubStr(s1));
        
        //s = "abba"
        System.out.println("");
        System.out.println(lengthOfLongestSubstring("abba"));
        
        
	}

}
