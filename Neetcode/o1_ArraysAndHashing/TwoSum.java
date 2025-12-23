package Neetcode.o1_ArraysAndHashing;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int output[] = new int[2];
        Map<Integer, Integer> mpp = new HashMap<Integer, Integer>();
        int size = nums.length;
        for(int i=0; i<size; i++){
            int complement = target - nums[i];
            if(mpp.containsKey(complement)) {
                output[0] = i; output[1]=mpp.get(complement);
                break;
            } else {
                mpp.put(nums[i], i);
            }
        }
        Arrays.sort(output);
        System.out.println(String.format("%s %s", output[0], output[1]));
        return output;
    }
}
