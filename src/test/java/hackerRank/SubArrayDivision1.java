package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayDivision1 {

	public static int birthday(List<Integer> s, int d, int m) {
		// Write your code here 
		//Continuous sub array means array which are in sequence
		int count = 0;
		List<Integer> ls = new ArrayList<>();
		
		//Substring or sub array be careful  with i<=m.size -m
		for (int i = 0; i <= s.size() - m; i++) {
			int sum = 0;
			ls.clear();
			for (int j = 0; j < m; j++) {
				sum += s.get(i+j);
				ls.add(s.get(i+j));
				//System.out.println(s.get(i+j));
				if (sum == d && ls.size()==m) {
					//System.out.println(sum);
					count++;
					break;
				}
				if(sum>d) {
					break;
				}
			}
			//System.out.println();
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       List<Integer> ls = new ArrayList<Integer>(Arrays.asList(2,2,1,3,2));
       System.out.println(birthday(ls,4,2)); //[2,2] [1,3] so 2
       
       List<Integer> ls2 = new ArrayList<Integer>(Arrays.asList(1,4));
       System.out.println(birthday(ls2,4,1)); // [4] so 1
	}

}
