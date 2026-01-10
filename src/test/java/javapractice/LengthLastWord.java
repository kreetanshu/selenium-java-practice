package javapractice;

public class LengthLastWord {

	public static int lengthOfLastWord(String s) {
      String [] strArray = s.split("\\s+");
      return strArray[strArray.length-1].length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = "   fly me   to   the moon  ";
        
       System.out.println(lengthOfLastWord(s));
	}

}
