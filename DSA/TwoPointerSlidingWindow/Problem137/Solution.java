package DSA.TwoPointerSlidingWindow.Problem137;


import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] arr){
        String s = "aaabbccd";
        System.out.print(kDistinctChars(2, s));
    }
    public static int kDistinctChars(int k, String str) {
        int left=0; int right=0; int maxLen = 0; int strLen = str.length();
        Map<Character, Integer> mpp = new HashMap<>();
        while(right<strLen) {
            char c = str.charAt(right);
            int value = mpp.getOrDefault(c, 0);
            mpp.put(c,value+1);
            while(mpp.size()>k){
                char c1 = str.charAt(left);
                mpp.computeIfPresent(c1, (key, val) -> val-1);
                if(mpp.get(c1) == 0) mpp.remove(c1);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}