package DSA.Rapid7DSAPractice.Practice4.LC53_Max_SubArray_Kadanes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution
{
    public static void main(String[] arr){
       int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution s = new Solution();
        int total = s.maxSubArray(nums);
        System.out.print(total);

    }

    // https://leetcode.com/problems/maximum-subarray/
    public int maxSubArrayOn2(int[] nums) {
        int len = nums.length;
        int maxSum = nums[0];
        for(int i=0; i<len; i++){
            int currentSum = nums[i];
            for(int j=i+1; j<len; j++){
                maxSum = Math.max(maxSum, currentSum);
                currentSum+=nums[j];
//                System.out.println(String.format("%s", maxSum));
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int currSum = nums[0];
        int maxSum = currSum;
        for(int i=1; i<len; i++){
            // Kadane Algorithm
            currSum = Math.max(nums[i],currSum+nums[i]);
            maxSum = Math.max(currSum,maxSum);
//            System.out.print(currSum);
        }
        return maxSum;
    }
}