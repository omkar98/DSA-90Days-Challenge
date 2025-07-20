package DSA.Problem116;


import java.util.Arrays;

public class Solution
{

    public static void main(String[] arr){
        int [] jump = new int[]{1,2,3,1,1,0,2,5};
        System.out.print(jump_search(jump, 8));
    }

    public static boolean jump_search(int []arr, int n) {
        boolean isZero = false;
        for(int i=0; i<n;i++){
            if(arr[i]==0) isZero = true;
        }
        if(!isZero) return true;

        int maxIndex = 0;
        int currentIndex = 0;
        int nthPosition = n;
        while(currentIndex<=maxIndex && maxIndex<nthPosition){
            maxIndex = Math.max(maxIndex, arr[currentIndex]+currentIndex);
            currentIndex++;
        }
        return maxIndex>=nthPosition;
    }
}