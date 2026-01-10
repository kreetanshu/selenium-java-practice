package javapractice;

import java.util.Arrays;

public class Anagram {
	
	public static boolean checkAnagram(String str1, String str2) {
		
		// If lengths differ, not anagrams
        if (str1.length() != str2.length()) {
        	System.out.println("Not Anagram");
        	return false;
        }
		
		String [] arr1 = str1.replaceAll("\\s+","").toLowerCase().split("");
		String [] arr2 = str2.replaceAll("\\s+","").toLowerCase().split("");
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if(Arrays.equals(arr1,arr2)){
			System.out.println("Anangram");
			return true;
		}
		else {
			System.out.println("Not Anangram");
			return false;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "Mother In Law";
		String str2 = "Hitler Woman";
		checkAnagram(str1, str2);
		checkAnagram("geeks", "kseeg");
	
	}

}
