package DSA.TwoPointerSlidingWindow.Problem140;


import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] arr){
        int[] nums = new int[]{2,1,3,2,4};
        Solution s = new Solution();
        int goal = 2;
        int count = s.kDistinctSubarrays(nums, nums.length, goal)-s.kDistinctSubarrays(nums, nums.length, goal-1);
        System.out.print(count);
    }
    public static int kDistinctSubarrays(int[] arr, int n, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int right = 0, left = 0, count = 0;

        while(right<n){
            int ele = arr[right];
            int value = mpp.getOrDefault(ele, 0);
            mpp.put(ele, value+1);

            while(mpp.size()>k) {
                ele = arr[left];
                value = mpp.getOrDefault(ele, 0);
                mpp.put(ele, value-1);
                if(value-1 == 0) mpp.remove(ele);
                left++;
            }

            count += (right-left+1);
            right++;
        }
        return count;
    }
}