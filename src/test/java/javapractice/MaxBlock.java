package javapractice;

public class MaxBlock {

    //maxBlock("abbCCCddBBBxx") → 3 
    // here we will solve using simple iteration.
    public static int maxBlock(String str) {
        int count=1;
        int max=0;
        if(str.length()==0 ){
            return 0;
        }
        else if(str.length()==1 || str.length()==2){
            return 1;
        }
        else{
            for(int i=0;i<str.length()-1;i++){
                if (str.charAt(i)==str.charAt(i+1)){
                    count++;
                    max = Math.max(max,count);
                }
                else{
                    max = Math.max(max,count);
                    count=1;
                }
            }
        }
       return max;
    }
    public static void main(String[] args) {

        //Given a string, return the length of the largest "block" in the string. 
        // A block is a run of adjacent chars that are the same.
        String str = "abbCCCddBBBxx";
        System.out.println(maxBlock(str));
        System.out.println(maxBlock("xyzz"));
    }
    
}
