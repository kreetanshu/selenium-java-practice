package webui.loginPage;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class RemoveElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] nums = {3,2,2,3};
		int val = 3;
		
		int output []=ArrayUtils.removeAllOccurences(nums, val);
		
		System.out.println(ArrayUtils.toString(output));
		
		List<Integer> ls = new ArrayList<Integer>();

	}

}
