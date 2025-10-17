package DSA.Recursion.SubSetSumII;


import java.util.ArrayList;
import java.util.List;

public class Solution
{
    private static void subsetSumRecursion(int index, int num[], int sum, List<Integer> ans) {
        if(index>=num.length) {
            ans.add(sum);
            return;
        }

        // pick the element
        subsetSumRecursion(index+1, num, sum+num[index],ans);
        // dont pick the element
        subsetSumRecursion(index+1, num, sum,ans);

    }

    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSumRecursion(0, num, 0, ans);
        return ans;
    }

    public static void main(String[] arr){
        int nums[] = {3,1,2};
//        ArrayList<Integer> numsList = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        ArrayList<Integer> finalList = subsetSum(nums);
//        Collections.sort(finalList);
        System.out.print(finalList);
    }
}