package javapractice;

public class CompressString {
    //3. Provide a functionality to compress a string according to the counts of repeated characters.
    // For example, the string "aabcccccaaa" would become "a2b1c5a3".
    // If the compressed string would not become smaller than the original string, return the original string.
    static String compressString(String str){
        StringBuilder sb = new StringBuilder();

        char [] arr =  str.toCharArray();

        int count=1;
        for(int i=0;i<arr.length-1;i++){
            if(count==1){
                sb.append(arr[i]);
            }
            if(arr[i]==arr[i+1]){
               count++;
            }
            else{
              sb.append(count);
              count=1;
            }
        }
        sb.append(count);

        System.out.println(sb.toString());
        if(sb.toString().length()>str.length()){
            return str;
        }
        else {
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        String str = "aabcccccaaa";
        compressString(str);
  
    }

}
