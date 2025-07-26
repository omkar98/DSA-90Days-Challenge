package DSA.Problem123;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution
{

    public static void main(String[] arr){
        String s = "(())*)*((*(((*((()(*))))";
        boolean minPlatforms = checkValidString(s);
        System.out.print(minPlatforms);
    }

    public static boolean checkValidString(String s) {
        char[] allChars = s.toCharArray();
        int sLen = allChars.length;
        int min=0;
        int max = 0;
        for(int i=0; i<sLen; i++){
            if(allChars[i]=='(') {
                min++;
                max++;
            }
            if(allChars[i]==')') {
                min--;
                max--;
                if(max<0) return false;
            }
            if(allChars[i]=='*') {
                min--;
                max++;
            }
            if(min<0) min=0;
        }
        if(min<=0) return true;
        return false;
    }

    // This failed for "**((()*"
//    public static boolean checkValidString(String s) {
//        int strLength = s.length();
//        char[] allChars = s.toCharArray();
//        if(allChars[strLength-1]=='(') return false;
//
//        int count = 0;
//        int astrisk = 0;
//        for(int i=0; i<strLength; i++){
//            if(allChars[i]=='(') count++;
//            if(allChars[i]==')') count--;
//            if(allChars[i]=='*') astrisk++;
//        }
//
//        int required = Math.abs(count);
//        if(required>astrisk) return false;
//        return true;
//    }
}