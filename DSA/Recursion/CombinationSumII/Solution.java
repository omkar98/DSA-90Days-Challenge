package DSA.Recursion.CombinationSumII;

/* 1. Reverse an Array
   2. Check if a String in Palindrome
   3. Fibonnaci (multiple recursion calls)
* */


import java.util.*;

public class Solution
{
    private static void combSum2(int index, ArrayList<Integer> arr, int n, int target, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> finalList){
        if(target == 0) {
            finalList.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<n; i++){
            if(i>index && Objects.equals(arr.get(i), arr.get(i - 1))) continue;
            if(arr.get(i)>target) break;

            ds.add(arr.get(i));
            combSum2(i+1, arr, n, target-arr.get(i), ds, finalList);
            ds.remove(ds.size()-1);
        }

    }
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        Collections.sort(arr);
        combSum2(0, arr,n, target, new ArrayList<>(), finalList);
        return finalList;
    }

    public static void main(String[] arr){
        int nums[] = {1,1,1,2,2};
        ArrayList<Integer> numsList = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        int target = 4;
        ArrayList<ArrayList<Integer>> finalList = combinationSum2(numsList, nums.length, target);
        System.out.print(finalList);
    }
}