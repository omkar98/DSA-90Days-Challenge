package Neetcode.o1_ArraysAndHashing;



import java.util.*;
import java.util.stream.Collectors;


public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int setSize = set.size();
        int counter = 0;
        for(int ele : set){
            if(!set.contains(ele-1)){ // This is my starting node
                int innerCounter = 0;
                while(set.contains(ele++)){ // Check until the last element
                    innerCounter++;
                }
                counter = Math.max(counter, innerCounter);
            }
        }
        System.out.println(counter);
        return counter;
    }
}
