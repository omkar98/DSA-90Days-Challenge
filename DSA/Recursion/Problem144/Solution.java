package DSA.Recursion.Problem144;

/* 1. Reverse an Array
   2. Check if a String in Palindrome
   3. Fibonnaci (multiple recursion calls)
* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution
{
    final static int MOD = 1000000007;
    public static int findWaysCounter(int index, List<Integer> currArr, int currSum, int n, int[] nums, int tar){
        if(index==n){
            if(currSum==tar) return 1;
            return 0;
        }
        // pick the index
        currArr.add(nums[index]);
        currSum+=nums[index]%MOD;
        int leftCount = findWaysCounter(index+1, currArr, currSum, n, nums, tar);
        // not pick the index
        currArr.remove(currArr.size()-1);
        currSum-=nums[index]%MOD;
        int rightCount = findWaysCounter(index+1, currArr, currSum, n, nums, tar);
        return (leftCount+rightCount)%MOD;
    }

    public static int findWays(int num[], int tar) {
        int n = num.length;
//        List<Integer> l = Arrays.stream(num).boxed().collect(Collectors.toList());
        int total = findWaysCounter(0, new ArrayList<>(), 0, n, num, tar);
        System.out.print(total);
        return total;
    }

    public static boolean findWaysCounterTorF(int index, List<Integer> currArr, int currSum, int n, int[] nums, int tar){
        if(index==n){
            if(currSum==tar) return true;
            else return false;
        }
        // pick the index
        currArr.add(nums[index]);
        currSum+=nums[index]%MOD;
        boolean leftCountResult = findWaysCounterTorF(index+1, currArr, currSum, n, nums, tar);
        if(leftCountResult==true) return true;
        // not pick the index
        currArr.remove(currArr.size()-1);
        currSum-=nums[index]%MOD;
        boolean rightCountResult = findWaysCounterTorF(index+1, currArr, currSum, n, nums, tar);
        if(rightCountResult==true) return true;
        return false;
    }

    public static boolean findWaysTorF(int num[], int tar) {
        int n = num.length;
//        List<Integer> l = Arrays.stream(num).boxed().collect(Collectors.toList());
        boolean finalResult = findWaysCounterTorF(0, new ArrayList<>(), 0, n, num, tar);
        System.out.print(finalResult);
        return finalResult;
    }

    public static void main(String[] arr){
        int[] nums = {1,2,1};
        int tar = 10;
        findWays(nums, tar);
        findWaysTorF(nums, tar);
    }




}