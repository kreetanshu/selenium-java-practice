package javapractice;

import java.util.Stack;

public class ValidParentheses {
	
	private static boolean checkParentheses(String str) {
		if(str.length()<=1) {
			return false;
		}
		else {
			Stack<Character> st = new Stack<Character>();
			
			for(int i=0;i<str.length();i++) {
				char ch = str.charAt(i);
				if(ch=='(' || ch == '[' || ch == '{') {
					st.push(ch);
				}
				else {
					if(st.size()==0) {
						return false; //More closing braces
					}
					else if(ch==')' && st.peek()=='(') {
						st.pop();
					}
					else if(ch=='}' && st.peek()=='{') {
						st.pop();
					}
					else if(ch==']' && st.peek()=='[') {
						st.pop();
					}
					else {
						return false;// Unbalanced braces
					}
				}
			}
			
			if(st.size()==0) {
				return true;
			}
			else {
				return false; //More opening braces
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s1 = "()[]{}"; //true
        String s2 = "(]"; //false
        String s3 = "([])"; //true
        String s4 = "([)]"; // false
        
        System.out.println(checkParentheses(s1));
        System.out.println(checkParentheses(s2));
        System.out.println(checkParentheses(s3));
        System.out.println(checkParentheses(s4));
        
	}

}
