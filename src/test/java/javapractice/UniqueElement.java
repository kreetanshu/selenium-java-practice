package javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueElement {
	
	private static void main(String [] args) {
		List<Integer> ls = new ArrayList<Integer>(Arrays.asList(1,2,3,4,3,2,1));
		
		int [] arr = {1,2,3,4,3,2,1};
		System.out.println("Hello Stream");
		Arrays.stream(arr).distinct().forEach(System.out::println);
		
		HashSet<Integer> hs= new HashSet<Integer>();
		List<Integer> out = new ArrayList<>();
		for(Integer num: ls) {
			if(hs.add(num)) {
				out.add(num);
			}
			else {
				out.remove(num);
			}
		}
		
		//System.out.println(ls);
	    
		//ls.stream().distinct().forEach(System.out::println);
	}
	

}
