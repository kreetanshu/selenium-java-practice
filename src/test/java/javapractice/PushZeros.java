package javapractice;

import java.util.Arrays;

public class PushZeros {
	
	/*Approach 1: Use second array and push all non-zeros to end and then add zeros in front
	 * Approach 2: Better in place shifting find the index of last zero, then run a loop from lastZeroIndex -1 and 
	 * use swapping and decrement lastZeroIndex
	 * 
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr [] = {1,0,3,0,4,2};
      
      int lastIndex=-1;
      
      
      
      for(int i=0;i<arr.length;i++) {
    	  if(arr[i]==0) {
    		  lastIndex=i;
    	  }
      }
  
      
      System.out.println(lastIndex);
      
      for(int i=lastIndex-1;i>=0;i--) {
    	  if(arr[i]!=0) {
    	  int temp=arr[i];
    	  arr[i]=arr[lastIndex];
    	  arr[lastIndex]=temp;
    	  lastIndex--;
    	  }
    	  
      }
      System.out.println(Arrays.toString(arr));
	}

}
