package DSA.Recursion.SubSetSumI;


import java.util.*;

public class Solution
{
    private static void uniqueSubsetsRecursion(int index, List<Integer> ds, int n, int arr[],  ArrayList<ArrayList<Integer>>  ans){
        ans.add(new ArrayList<>(ds));
        for(int i=index; i<n; i++){
            // super important.
            /*
            Index: its basically like the level. Level-1 will have 2 elements, Level-2 will have 3 elements and so on.
            i - within the same level, we move ahead with other elements.
            So within the same level, we pick the first element, but for subsequent elements, we want to ensure we do not pick the duplicates if they were already picked.
            * */
            if(i!=index && arr[i]==arr[i-1]){
                continue;
            }
            ds.add(arr[i]);
            uniqueSubsetsRecursion(i+1, ds, n,arr,ans);
            ds.remove(ds.size()-1);
        }
    }

    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        Arrays.sort(arr);
        uniqueSubsetsRecursion(0, new ArrayList<>(), n, arr, list);
        return list;

    }

    public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for(int i = ind;i<nums.length;i++) {
            if(i!=ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

    public static void main(String[] arr){
        int nums[] = {1,1,3};

//        ArrayList<Integer> numsList = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        ArrayList<ArrayList<Integer>> finalList = uniqueSubsets(nums.length,nums);
//        Collections.sort(finalList);
        System.out.println(finalList);
        List<List<Integer>> finalList1 = subsetsWithDup(nums);
        System.out.println(finalList1);
    }
}