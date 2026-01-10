package javapractice;

public class FirstOccurence {

	public static int strStr(String haystack, String needle) {

		return haystack.indexOf(needle);
	}
    
	//Using slicing substring, remember to iterate to haystack.length() - len
	public static int strStrSlicing(String haystack, String needle) {
		int len = needle.length();
		
		//Check the i boundary i <= haystack.length
		for (int i = 0; i <= haystack.length() - len; i++) {
			String substr = haystack.substring(i, i + len);
			if (substr.equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "asadbutsad", needle = "sad";
		System.out.println(strStr(haystack, needle));

		System.out.println(strStrSlicing("leetcode", "leeto"));
	}

}
