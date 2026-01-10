package javapractice;

public class BinaryIntegerConversion {
	
	static void changeBits(long num) {
		StringBuilder out= new StringBuilder();
		
		//Long to Binary String
		String binaryString = Long.toBinaryString(num);
		
		out.append(binaryString);
		
		for(int i=1;i<=32-binaryString.length();i++) {
			out.insert(0, 0);
		}
		System.out.println(out);
		
		String newOut=out.toString().replace('1','a');
		newOut=newOut.replace('0','1');
	    newOut=newOut.replace('a', '0');
		
		System.out.println(newOut);
		
		//Binary String to Long
		long newNum= Long.parseLong(newOut, 2);
		System.out.println(newNum);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        long num = 2147483647;
       // System.out.println(Long.toBinaryString(2147483647));
        changeBits(1);
	}

}
