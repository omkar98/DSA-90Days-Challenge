package DSA.Problem128;


import java.util.ArrayList;
import java.util.Objects;

public class Solution
{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        arr.sort((a,b)-> a-b);
        for(int i=0; i<n-1; i++){
            if(Objects.equals(arr.get(i), arr.get(i + 1))) return arr.get(i);
        }
        return -1;
    }

    public static void main(String[] arr){
        ArrayList<Integer> arr1  = new ArrayList<>();
        arr1.add(4);
        arr1.add(1);
        arr1.add(6);
        arr1.add(1);
        System.out.print(findDuplicate(arr1, arr1.size()));


    }
}