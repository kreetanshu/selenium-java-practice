package hackerRank;

import java.util.Arrays;

public class DrawingBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n=8,p=3;
        //In Java int right = (n-p)/2 and int right = n/2 - p/2 can produce different results for certain values of n and p due to integer division's rounding toward zero (truncation) behavior.
        
        
        int right = n/2-p/2;
        int left = p/2;
        System.out.println((n-p)/2);
        System.out.println("Left "+left +" Right " +right);
        System.out.println(Math.min(left, right));
	}

}
