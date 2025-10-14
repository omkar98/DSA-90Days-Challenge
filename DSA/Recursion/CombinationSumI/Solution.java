package DSA.Recursion.CombinationSumI;

/* 1. Reverse an Array
   2. Check if a String in Palindrome
   3. Fibonnaci (multiple recursion calls)
* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static List<List<Integer>> finalList = new ArrayList<>();
    public static void combSum(int index, int target, List<Integer> ds, int[] originalArray) {
        if(target==0) {
            finalList.add(List.copyOf(ds));
            return;
        }
        if(target<0) return ;
        if(index>=originalArray.length) return ;
        // pick the index
        ds.add(originalArray[index]);
        combSum(index, target-originalArray[index], ds, originalArray);
        // remove the index
        ds.remove(ds.size()-1);
        combSum(index+1, target, ds, originalArray);
    }


    public static List<List<Integer>> combSum(int []ARR, int B) {
        Arrays.sort(ARR);
        combSum(0, B, new ArrayList<>(), ARR);
        return finalList;
    }



    public static void main(String[] arr){
        int nums[] = {13,3,2,17};
        int target = 14;
        combSum(nums, target);
        System.out.print(finalList);
    }




}