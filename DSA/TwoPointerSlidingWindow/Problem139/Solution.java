package DSA.TwoPointerSlidingWindow.Problem139;


import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] arr){
        int[] nums = new int[]{0,0,0,0,0};
        Solution s = new Solution();
        int goal = 0;
        int count = s.numSubarraysWithSum(nums, goal)-s.numSubarraysWithSum(nums, goal-1);
        System.out.print(count);
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal<0) return 0;
        int right=0,  left=0, count =0, numLen = nums.length, sum=0;
        while(right<numLen){
            sum+=nums[right];
            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
}