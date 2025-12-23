package Neetcode.o1_ArraysAndHashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ProductOfArraysExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        int prefix = 1;
        for(int i=0; i<size; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for(int i=size-1; i>=0; i--){
            result[i] *= postfix;
            postfix *= nums[i];
        }

        Arrays.stream(result).boxed().peek(System.out::print).collect(Collectors.toList());

        return result;
    }
}
