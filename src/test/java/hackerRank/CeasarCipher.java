package hackerRank;

public class CeasarCipher {
    
    //Approach one\ōl̥
    static String getCipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        k = k % 26;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // For uppercase letters
                int shifted = c + k;
                if (shifted > 'Z') {
                    shifted -= 26;
                }
                sb.append((char) shifted);
            } else if (Character.isLowerCase(c)) {
                // For lowercase letters
                int shifted = c + k;
                if (shifted > 'z') {
                    shifted -= 26;
                }
                sb.append((char) shifted);
            } else {
                // Non-alphabetic characters stay the same
                sb.append(c);

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Character ch = 'a'; // a-z 97-122, A-Z 65-90

        // Imp: char ch=(char)(((c+k-'a')%26)+'a');

        String str = "abc-defghijklmnopqrstuvw-xyz";
        // System.out.println((int)'A');
        // System.out.println((int)ch);
        System.out.println((char) 97);
        int k = 2;
        StringBuilder sb = new StringBuilder();
        k = k % 26; // For K greater than 26 K can vary from 0 to 100

        for (Character c : str.toCharArray()) {

            if (Character.isLowerCase(c)) {
                char ch = (char) (((c + k - 'a') % 26) + 'a');
                sb.append(ch);
            } else if (Character.isUpperCase(c)) {
                char ch = (char) (((c + k - 'A') % 26) + 'A');
                sb.append(ch);
            } else {
                sb.append(c);
            }

        }
        System.out.println(sb.toString());

    }

}
