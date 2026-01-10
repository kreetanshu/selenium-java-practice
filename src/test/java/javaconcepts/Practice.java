package javaconcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

	static Integer subArray(List<Integer> ls, int target, int freq) {
		List<Integer> result = new ArrayList<Integer>();
		int sum = 0;
		int count = 0;
		for (int i = 0; i <= ls.size() - freq; i++) {
			result.clear();
			sum = ls.get(i);
			result.add(ls.get(i));
			int j = 1;

			while (j <= freq) {
				sum += ls.get(i + j);
				result.add(ls.get(j));
				if (sum == target && result.size() == freq) {
					count++;
					break;
				} else if (sum > target) {
					break;
				} else if (result.size() > freq) {
					break;
				}

				j++;

			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ls = new ArrayList<Integer>(Arrays.asList(2, 2, 1, 3, 2));
		System.out.println(subArray(ls,4,2)); //[2,2] [1,3] so 2
	}

}
