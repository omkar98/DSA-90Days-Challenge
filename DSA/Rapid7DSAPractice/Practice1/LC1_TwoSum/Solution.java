package DSA.Rapid7DSAPractice.Practice1.LC1_TwoSum;


import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] arr){
        int[] nums = new int[]{1,2,3,4,3,2,1,7};
        Solution s = new Solution();
        int target = 9;
        int[] indices = s.twoSum(nums, target);
        System.out.print(indices);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mpp = new HashMap();
        int len = nums.length;
        for(int i=0; i<len; i++){
            int value = mpp.getOrDefault(target-nums[i], -1);
            if(value!=-1) {
                return new int[]{i, value};
            }
            mpp.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}