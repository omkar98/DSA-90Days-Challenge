package Neetcode.o2_TwoPointers;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int numsSize = nums.length;
        HashSet<List<Integer>> outputArray = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<numsSize; i++){
            int target = -nums[i];
            List<List<Integer>> threeSum = twoSum(nums, target, i, numsSize);
            if(!threeSum.isEmpty()) {
                outputArray.addAll(threeSum);
            }
        }
        System.out.println(outputArray);
        return outputArray.stream().toList();
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int currIndex, int size){
        // also include the currIndex element, then sort everything before returning
        int leftPtr = currIndex==0 ? 1 : 0; // check if leftPtr is not the currIndex, else move 1 step ahead
        int rightPtr = currIndex==size-1 ? size-2: size-1; // check if rightPtr is not the currIndex, else move 1 step behind
        List<List<Integer>> outputList = new ArrayList<>();
        for(int i=0; i<size; i++){
            int currSum = nums[leftPtr]+nums[rightPtr];
            if(rightPtr==currIndex) {
                rightPtr++; continue;
            }
            if(leftPtr==currIndex) {
                leftPtr++; continue;
            }
            if(currSum==target) {
                List<Integer> output = new ArrayList<>();
                output.add(nums[rightPtr]);
                output.add(nums[leftPtr]);
                output.add(nums[currIndex]);
                Collections.sort(output);
                outputList.add(output);
                leftPtr++; rightPtr--;
            }
            if(currSum>target) rightPtr--;
            if(currSum<target) leftPtr++;
            if(rightPtr<=leftPtr) break;
        }
        return outputList;
    }
}
