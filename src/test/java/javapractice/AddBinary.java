package javapractice;

public class AddBinary {

	public static String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();
      int i = a.length()-1;
      int j = b.length()-1;
      
      int carry =0;
      
    //We need to iterate two string at the same time so use while loop
      
      while(i>=0 || j>=0 || carry > 0) {
    	  int sum = carry;
    	  //Important concept: So, for any digit character, 'X' - '0' yields its integer value. ASCII Value to Integer conversion
    	  //Integer.valueOf(String.valueOf(a.charAt(i)));
    	  if(i>=0) {sum+=a.charAt(i--)-'0';};
    	  if(j>=0) {sum+=b.charAt(j--)-'0';};
    	  sb.append(sum%2);
    	  carry=sum/2; //Note: 1/2==0
      }
      
      
      return sb.reverse().toString();
	}
	
	//Second Approach
	static String addBinary2(String a, String b){
	    StringBuilder sb = new StringBuilder();
	    
	    int i= a.length()-1;
	    int j= b.length()-1;
	    
	    int carry=0;

	    while(carry >0 || i>=0 || j>=0){
	      int sum=carry;
	      if(i>=0 && a.charAt(i)!='0'){sum+=1;}
	      if(j>=0 && b.charAt(j)!='0'){sum+=1;}
	      i--;
	      j--;
	      sb.append(sum%2);
	      carry=sum/2;
	    }
	    return sb.reverse().toString();
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1011";
        String b = "1011";
        //System.out.println(1%2);
        System.out.println("Sum: " + addBinary(a, b)); // Output: 10110
        System.out.println("Sum: " + addBinary2(a, b));
	}

}
