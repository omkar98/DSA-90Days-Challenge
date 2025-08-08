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
            if(mpp.size()<=k) {
                char c = str.charAt(right);
                int value = mpp.getOrDefault(c, 0);
                mpp.put(c,value+1);
                if(mpp.size()<=k) maxLen = Math.max(maxLen, right-left+1);
                right++;
            } else {
                while(mpp.size()>k){
                    char c = str.charAt(left);
                    mpp.computeIfPresent(c, (key, value) -> value-1);
                    if(mpp.get(c) == 0) mpp.remove(c);
                    left++;
                }
            }
        }
        return maxLen;
    }
}