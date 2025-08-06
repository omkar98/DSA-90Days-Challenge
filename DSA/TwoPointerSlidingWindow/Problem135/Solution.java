package DSA.TwoPointerSlidingWindow.Problem135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] arr){
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1,1,1,0,0,0,1,1,1,1,0));
        System.out.print(longestSubSeg(arr1, arr1.size(), 2));
    }
    public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
        int right = 0;
        int left = 0;
        int maxLen = 0;
        int zeroes = 0;
        while(right<n){
            if(arr.get(right)==0) {
                zeroes++;
            }
            if(zeroes<=k) {
                maxLen = Math.max(maxLen, right-left+1);
            }
            if(zeroes>k) {
                if(arr.get(left)==0){
                    zeroes--;
                }
                left++;
            }
            right++;
        }
        return maxLen;
    }


}