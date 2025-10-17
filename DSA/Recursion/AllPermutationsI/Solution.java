package DSA.Recursion.AllPermutationsI;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution
{
    private static void permutations(List<Character> permString, int n, int[] takenArray, List<String> ans, String str){
        for(int i=0; i<n; i++){
            if(takenArray[i]==0){
                permString.add(str.charAt(i));
                takenArray[i]=1;
                permutations(permString, n, takenArray, ans, str);
                permString.remove(permString.size()-1);
                takenArray[i] = 0;
            }
        }
        if(permString.size() == n) ans.add(permString.stream().map(String::valueOf).collect(Collectors.joining()));
    }

    public static ArrayList<String> generatePermutations(String str) {
        char[] givenString = str.toCharArray();
        Arrays.sort(givenString);
        str = new String(givenString);
        int n = str.length();
        int[] takenArray = new int[n];
        ArrayList<String> finalList = new ArrayList<>();
        List<Character> permString = new ArrayList<>();
        permutations(permString, n, takenArray, finalList, str);
        return finalList;
    }

    public static void main(String[] arr){
        String str = "qwer";
        System.out.print(generatePermutations(str));
    }
}