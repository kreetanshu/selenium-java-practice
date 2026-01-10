package javapractice;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class StringPermutations {

	static String swap(String s, int left, int right) {
		char[] ch = s.toCharArray();
		char temp = ch[left];
		ch[left] = ch[right];
		ch[right] = temp;

		// Char [] to String Conversion
		return String.valueOf(ch);

	}

	static void permute(String s, int left, int right) {

		if (left == right) {
			System.out.println(s);
		} else {
			for (int i = left; i <=right; i++) {
				s=swap(s,left,i);
				permute(s, left+1, right);
				s=swap(s,left,i); // backtrack
			}
		}

	}
	
	static void backtracking(List<Character> ls, String s) {
		if(ls.size()==s.length()) {
			System.out.println(ls);
		}
		for(char ch: s.toCharArray()) {
			if(ls.contains(ch)) {
				continue;
			}
			ls.add(ch);
			backtracking(ls, s);
			ls.remove(ls.size()-1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABC";
		//permute(s, 0, s.length() - 1);
		//System.out.println(swap(s, 0, s.length() - 1));
		//System.out.println(s.substring(0));
		//System.out.println(s.substring(0, 1));
		
		backtracking(new ArrayList<Character>(), s);
	}

}
