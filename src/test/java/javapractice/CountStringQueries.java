package javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CountStringQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = new ArrayList<String>(Arrays.asList("ab", "ab", "abc"));
		List<String> queries = new ArrayList<String>(Arrays.asList("ab", "abc", "bc"));

		// 2,1,0
		LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();

		for (String string : strings) {
			hm.put(string, hm.getOrDefault(string, 0) + 1);
		}
		System.out.println(hm);
		List<Integer> out = new ArrayList<>();
		for (String query : queries) {
			if (hm.containsKey(query)) {
				out.add(hm.get(query));
			} else {
				out.add(0);
			}

		}

		System.out.println(out);
	}

}
