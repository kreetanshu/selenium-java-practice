package javapractice;

import static org.testng.Assert.assertTrue;

public class ArmstrongNumber {
	
	static boolean checkArmstrong(int num) {
		
		int len = String.valueOf(num).length();
		int copyNum = num;
		int sum = 0;
		while(copyNum>=1) {
			int digit = copyNum%10;
			//Math.Pow() returns a double
			sum = sum + (int)Math.pow(digit,len);
			copyNum = copyNum/10;
		}
		
		if(sum == num) {
			System.out.println(num+" is an Armstrong number");
			return true;
		}
		else {
			System.out.println(num+" is not an Armstrong number");
			return false;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 153;
		checkArmstrong(num);
		checkArmstrong(121);
		
		//assertTrue(checkArmstrong(num), "The number is not an Armstrong Number");
        
	}

}
