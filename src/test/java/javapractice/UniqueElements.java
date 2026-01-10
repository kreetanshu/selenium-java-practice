package javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueElements {
	
	static void getUniqueUsingHashSet(List<Integer> ls) {
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
		
		System.out.println(out);
	}
	
	static void getUniqueUsingHashMap(List<Integer> ls) {
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for(Integer num:ls) {
			hm.put(num, hm.getOrDefault(num, 0)+1);
		}
		List<Integer> lsOut = new ArrayList<>();

		for(Entry<Integer,Integer> entry: hm.entrySet()) {
			if(entry.getValue()==1) {
				lsOut.add(entry.getKey());
			}
		}
		System.out.println(lsOut);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ls = new ArrayList<Integer>(Arrays.asList(1,1,2,3,4,3,2,1));
		getUniqueUsingHashSet(ls);
		getUniqueUsingHashMap(ls);
	}

}
