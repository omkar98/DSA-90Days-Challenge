package DSA.Problem109;

import java.util.Arrays;

public class Solution
{
    public static void main(String[] arr){
        int[] arrInt = new int[]{1,2,3,2,1,4,4};
        System.out.println(findUnique(arrInt));
    }
    public static int findUnique(int[] arr){
        if(arr.length==1) return arr[0] ;
        if(arr.length%2==0) return -1 ;
        Arrays.sort(arr);

        for(int i=0; i<arr.length-1; i+=2){
            if(arr[i]!=arr[i+1]) {
                return arr[i];
            }
        }
        return arr[arr.length-1];
    }

}