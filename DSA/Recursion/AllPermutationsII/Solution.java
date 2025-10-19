package DSA.Recursion.AllPermutationsII;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution
{
    private static String swap(int i, int j, String str) {
        char[] newStr = str.toCharArray();
        char temp = newStr[i];
        newStr[i] = newStr[j];
        newStr[j] = temp;
        str = new String(newStr);
        return str;
    }
    private static void permutations(int n, int index, List<String> ans, String str) {
        for(int i=index; i<n; i++){
            str = swap(i,index, str);
            permutations(n, index+1, ans, str);
        }
        if(index >= n) ans.add(str);
    }

    public static ArrayList<String> generatePermutations(String str) {
        char[] givenString = str.toCharArray();
        Arrays.sort(givenString);
        str = new String(givenString);
        int n = str.length();
        ArrayList<String> finalList = new ArrayList<>();
        permutations(n, 0, finalList, str);
        return finalList;
    }

    public static void main(String[] arr){
        String str = "abc";
        System.out.println(generatePermutations(str));

        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(permutations(l, l.size()));
    }

    public static ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> arr, int size) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        generatePermutations(arr,size, 0, finalList);
        return finalList;
    }

    public static void generatePermutations(ArrayList<Integer> arr, int size, int index, ArrayList<ArrayList<Integer>> finalList) {
        for(int i=index; i<size; i++){
            swap(i,index,arr);
            generatePermutations(arr, size, index+1, finalList);
            swap(i,index,arr); /// <--- [Backtracking] This is something added in int[] so that we get the same array again.
        }
        if(index>=size) finalList.add(new ArrayList<>(arr));
    }

    private static void swap(int i, int j, ArrayList<Integer> arr) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}