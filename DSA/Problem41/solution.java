package DSA.Problem41;

import java.util.ArrayList;
import java.util.Arrays;

public class  solution {
    public static void main(String[] args) {
//        int[] arr = {1, 9, 3, 10, 4, 20, 2};
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,3));
        int k = 3;
        System.out.println(maxSubSumKConcat(arr, arr.size(), k));
    }

    public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
        long sumOfArray = arr.stream().mapToInt(Integer::intValue).sum();
        if(k==1) {
            return simpleKadaneAlgorithm(arr, n);
        } else if (sumOfArray<0) {
            return kadaneAlgorithmOnTwoArrays(arr, n);
        } else {
            return kadaneAlgorithmOnTwoArrays(arr, n) + (k-2) * sumOfArray;
        }
    }

    // similar to circular array. Can be used in place of finding max subarray sum in a circular array
    public static long simpleKadaneAlgorithm(ArrayList<Integer> arr, int n) {
        long maxSubArraySum = arr.get(0); // instead of 0, use the first value. Reason is if all the numbers are -ve in a array, it will be capable of handling it.
        long runningSum = arr.get(0);
        for(int i=1; i<n; i++) { // start from 1, because we already picked the 0th element
            if(runningSum>=0) runningSum+=arr.get(i);
            else runningSum = arr.get(i);
            if(maxSubArraySum<runningSum) maxSubArraySum=runningSum;
        }
        return maxSubArraySum;
    }
    public static long kadaneAlgorithmOnTwoArrays(ArrayList<Integer> arr, int n) {
        arr.addAll(arr);
        return simpleKadaneAlgorithm(arr, arr.size());
    }
}





