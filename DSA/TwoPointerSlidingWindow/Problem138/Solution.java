package DSA.TwoPointerSlidingWindow.Problem138;


import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] arr){
        String s = "AAAABCC";
        System.out.print(longestRepeatingSubstring(s, 2));
    }
    public static int longestRepeatingSubstring(String str, int k) {
        int maxLen = 0; int maxFreq = 0; int right = 0; int left = 0; int strLen = str.length();
        Map<Character, Integer> mpp = new HashMap<>();
        while(right<strLen){
            int currentValue = mpp.getOrDefault(str.charAt(right), 0);
            mpp.put(str.charAt(right), currentValue+1);
            maxFreq = Math.max(maxFreq, currentValue+1);
            int changes = (right-left+1) - maxFreq;
            if(changes<=k){
                maxLen = Math.max(maxLen, (right-left+1));
                right++;
            } else {
                mpp.put(str.charAt(left), mpp.get(str.charAt(left))-1);
                left++;
                right++;
            }
        }
        return maxLen;
    }
}