package Neetcode.o1_ArraysAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static boolean hasDuplicate(int[] nums) {
        // Approach - 1: Compare the size of input array after removing duplicates.
        List<Integer> collect = Arrays.stream(nums)// O(n)
                .boxed() //O(n)
                .distinct() // Hashset -> O(n)
                .collect(
                        Collectors.toList() // O(n)
                );
        System.out.println(!(collect.size() == nums.length));
//        return !(collect.size() == nums.length);

        // Approach - 2: Sort the array. Check if the current one is same as previous.
        boolean duplicateExist = false;
        HashSet<Integer> seen = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            if(!seen.add(nums[i])) {
                duplicateExist = true;
            }
        }
        System.out.println(duplicateExist);
        return false;
    }
}
