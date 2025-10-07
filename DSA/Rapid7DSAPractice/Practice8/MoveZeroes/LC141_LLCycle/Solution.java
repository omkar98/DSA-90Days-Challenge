package DSA.Rapid7DSAPractice.Practice8.MoveZeroes.LC141_LLCycle;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args){
        String s = "ababc";
        int len = s.length();
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> mpp = new HashMap<>();

        for(int right =0 ; right<len; right++){
            char c = s.charAt(right);
            if(mpp.containsKey(c)){
                left=mpp.get(c)+1;
            }
            mpp.put(c, right);
            maxLen = Math.max(right-left+1, maxLen);
        }
        System.out.print(maxLen);
    }

}


