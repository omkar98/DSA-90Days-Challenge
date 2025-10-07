package DSA.Rapid7DSAPractice.Practice2.LC3_LongestSubStringWORepeatingChars;


import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] arr){
//        int[] nums = new int[]{1,2,3,4,3,2,1,7};
        Solution s = new Solution();
        String string = "pwwkew";
        int len = s.lengthOfLongestSubstring(string);
        System.out.print(len);
    }

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        int left = 0, maxLen = 0;
        int len = s.length();
        for(int right=0; right<len; right++){ // you confused between right and i.
            int index = mpp.getOrDefault(s.charAt(right), -1);
            if(index!=-1 && mpp.get(s.charAt(right)) >= left) { // you kept solving for what if the index is present rather this was easier approach
                left = mpp.get(s.charAt(right)) + 1;
                // if you do left++, this testcase fails : "pwwkew". Do a dry run to understand this.
                // if you dont add this check: mpp.get(s.charAt(right)) >= left: this will fail: "abba".
            }
            mpp.put(s.charAt(right), right);
            maxLen = Math.max(right-left+1, maxLen); // you didnt add +1 in the result and kept solving for this edge case
        }
        return maxLen;
    }
}