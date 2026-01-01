package Neetcode.o2_TwoPointers;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int left = 0; int right = size-1;
        for(int i=0; i<size; i++){
            int sum = numbers[left]+numbers[right];
            if(sum==target) {
                return new int[]{left+1, right+1};
            }
            else{
                if(sum<target) left++;
                else right--;
            }
        }

        return new int[]{left+1, right+1};
    }
}
