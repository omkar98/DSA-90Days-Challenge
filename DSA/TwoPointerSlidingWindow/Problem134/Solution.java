package DSA.TwoPointerSlidingWindow.Problem134;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] arr){
        String s = "cadbzabcd";
        System.out.print(uniqueSubstrings(s));
    }

    public static int uniqueSubstrings(String input)
    {
        char[] charArr = input.toCharArray();
        int l = 0;
        int r = 0;
        int maxLen = r-l+1;
        Map<Character, Integer> mpp = new HashMap<Character,Integer>();
        int len = charArr.length;
        while(l<=r && r<len) {
            Integer currIndex =  mpp.get(charArr[r]);
            if(!indexWithinRange(currIndex, l,r)) {
                mpp.put(charArr[r], r);
                maxLen = Math.max(r-l+1, maxLen);
                r++;
            } else {
                int index = mpp.get(charArr[r]);
                l = index+1;
                mpp.put(charArr[r],r);
                maxLen = Math.max(r-l+1, maxLen);
                r++;
            }
        }
        return maxLen;
    }

    public static boolean indexWithinRange(Integer index, int small, int large) {
        return index!=null && small<=index && index<=large;
    }

}