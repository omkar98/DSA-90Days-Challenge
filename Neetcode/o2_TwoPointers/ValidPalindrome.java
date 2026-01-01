package Neetcode.o2_TwoPointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s= s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        /* Streams API:
        boolean flag = new StringBuilder(s).reverse().toString().equals(s);
        System.out.println(flag);
        return flag;*/

        int lenString = s.length();

        for(int i=0; i<lenString/2; i++){
            if(s.charAt(i)!=s.charAt(lenString-i-1)) return false;
        }
        System.out.println(true);
        return true;
    }
}
