package javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.ArrayUtils;

public class RemoveDupsInPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        int [] copyNums = Arrays.copyOf(nums, nums.length);
        
        //Make sure array is sorted
        
        // {0,1,2,3,4}
        /*Two Approaches
         * 1. TreeSet
         * 2. Replace in place
         * 3. Stream API
         * */
        
        //Approach 1: Treeset Can't convert Primitive int [] to List directly hence need to use ArrayUtils
        Set<Integer> ts = new HashSet<Integer>(Arrays.asList(ArrayUtils.toObject(nums)));
        
        List<Integer> intList = new ArrayList<>(ts);
        int [] result = ArrayUtils.toPrimitive(intList.toArray(new Integer[0]));
        System.out.println("First Approach "+Arrays.toString(result));
        
        //Approach 2 remove in place
        int count=1;
        //Start iterating at i==1 so no need to add any condition for the first element
        for(int i=0;i<nums.length-1;i++) {
        	//When i and i+1 doesn't match then use the i+1 value no need to then add any additional conditions for handling the last element
        	if(nums[i]!=nums[i+1]) {
        		nums[count++] = nums[i+1];
        	}
        }
        
        //Count here is exclusive
        int outPut [] = Arrays.copyOfRange(nums, 0,count);
        System.out.println("Second Approach "+Arrays.toString(outPut));
        
        //Approach 3: Use Java Stream API
        int streamOut [] = Arrays.stream(copyNums).distinct().toArray();
        System.out.println("Third approach "+Arrays.toString(streamOut));
        
	}

}
