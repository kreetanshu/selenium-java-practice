package javapractice;

public class Palindrome {
	
	  public static boolean isPalindrome(int x) {
	      int copyX=x;
	      int sum=0;
	      if(x<0){
	        return false;
	        }
	      else if(x==0){
	        return true;
	      }
	      else{
	       while(copyX>0){
	        int digit= copyX%10;
	        sum = sum*10+digit;
	        copyX=copyX/10;
	       }
	       return sum == x;
	      }
	          
	      }    
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(221));

	}

}
